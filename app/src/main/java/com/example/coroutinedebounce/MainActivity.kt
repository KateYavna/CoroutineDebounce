package com.example.coroutinedebounce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {
    private  val job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       var odersCounter = 0
        btToOrder.setOnClickListener {
            btToOrder.isEnabled = false
        async {
                delay(500)
                odersCounter = odersCounter + 1
                tvOdersCounter.text = odersCounter.toString()
                btToOrder.isEnabled = true
            }

        }

    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }

}