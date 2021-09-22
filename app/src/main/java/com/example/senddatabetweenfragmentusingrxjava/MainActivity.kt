package com.example.senddatabetweenfragmentusingrxjava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.senddatabetweenfragmentusingrxjava.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),Connection{
    lateinit var binding: ActivityMainBinding
    private lateinit var receiveFragment:ReceiveFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    override fun passData(text: String) {
    receiveFragment=ReceiveFragment()
        val bundle=Bundle()
        bundle.putString(Constant.KEY,text)
        receiveFragment.arguments=bundle
        this.supportFragmentManager.beginTransaction()
            .replace(R.id.receive_fragment,receiveFragment).commit()


    }

}