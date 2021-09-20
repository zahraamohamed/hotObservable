package com.example.senddatabetweenfragmentusingrxjava

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import com.example.senddatabetweenfragmentusingrxjava.databinding.FragmentReceiveBinding
import com.example.senddatabetweenfragmentusingrxjava.databinding.FragmentSendBinding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject
import java.util.concurrent.TimeUnit


class SendFragment : BaseFragment<FragmentSendBinding>() {
    override val LOG_TAG: String="SEND"
    override val bindingInflater: (LayoutInflater) -> FragmentSendBinding =
        FragmentSendBinding::inflate


    override fun addCallBack() {
        setData()
    }


     private  fun setData() {
        val x= Observable.create<String> {
             binding?.send?.doOnTextChanged { text, _, _, _ ->
                 it.onNext(text.toString())
             }
         }.debounce(1, TimeUnit.SECONDS).publish()

         x.connect()
         x.subscribeOn(AndroidSchedulers.mainThread())
             .subscribe(::onNext, ::onError)
     }

    private fun onNext(value: String)
      =ReceiveFragment().apply {
            arguments=Bundle().apply {
                putString(Constant.KEY,value)

            }
        Log.i(LOG_TAG,value)
            binding?.receive?.text=value
        }

    private fun onError(e:Throwable){
      Log.i(LOG_TAG,e.message.toString())
    }


}





