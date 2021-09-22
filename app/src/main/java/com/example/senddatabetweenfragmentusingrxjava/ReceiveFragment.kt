package com.example.senddatabetweenfragmentusingrxjava

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import com.example.senddatabetweenfragmentusingrxjava.databinding.FragmentReceiveBinding

class ReceiveFragment : BaseFragment<FragmentReceiveBinding>() {
    override val LOG_TAG: String="RECEIVE"
    var receivedValue=""
    override val bindingInflater: (LayoutInflater) -> FragmentReceiveBinding

        get() = FragmentReceiveBinding::inflate


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.receive?.text = arguments?.getString("text")

    }

    override fun addCallBack() {

    }


}