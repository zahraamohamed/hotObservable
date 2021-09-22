package com.example.senddatabetweenfragmentusingrxjava

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.core.widget.doOnTextChanged
import com.example.senddatabetweenfragmentusingrxjava.databinding.FragmentSendBinding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject
import java.util.concurrent.TimeUnit


class SendFragment : BaseFragment<FragmentSendBinding>() {
    override val LOG_TAG: String = "SEND"
    lateinit var connection: Connection
    override val bindingInflater: (LayoutInflater) -> FragmentSendBinding =
        FragmentSendBinding::inflate


    override fun addCallBack() {
        setData()
    }


    private fun setData() {
        val hotObservable = PublishSubject.create<String> {
            binding?.send?.doOnTextChanged { text, _, _, _ ->
                it.onNext(text.toString())
            }
        }.debounce(1500, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread()).publish()

        hotObservable.connect()
        hotObservable.subscribe(
            {onNext->
                connection.passData(onNext)
            },
            {onError->

                Log.i(LOG_TAG,onError.toString())

            }
        )
    }




}





