package com.example.senddatabetweenfragmentusingrxjava

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import com.example.senddatabetweenfragmentusingrxjava.databinding.FragmentReceiveBinding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable

class ReceiveFragment : BaseFragment<FragmentReceiveBinding>() {
    override val LOG_TAG: String="RECEIVE"
    var receivedValue=""
    override val bindingInflater: (LayoutInflater) -> FragmentReceiveBinding =
        FragmentReceiveBinding::inflate




    override fun addCallBack() {

        receivedValue = arguments?.getString(Constant.KEY).toString()

                Log.i(LOG_TAG,receivedValue)
                binding?.receive?.text = receivedValue



    }


}