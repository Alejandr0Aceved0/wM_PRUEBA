package com.wimobile.android.test

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    val viewModel = ViewModelProvider(this)[MainViewModel::class.java] // ❌ Mal uso del ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        textView = findViewById(R.id.textView) // ❌ findViewById antes de setContentView
        setContentView(R.layout.activity_main)

        viewModel.data.observe(this) {
            textView.text = it // ❌ Posible acceso nulo si `data` no se inicializó
        }

        Thread {
            textView.text = "Actualizando..." // ❌ Modificación de UI en hilo secundario
        }.start()

        registerReceiver(myReceiver, IntentFilter(Intent.ACTION_BATTERY_CHANGED)) // ❌ Memory Leak: No se remueve el receiver
    }

    override fun onDestroy() {
        super.onDestroy()
        // ❌ Falta unregisterReceiver(myReceiver), esto provocará un memory leak
    }

    companion object {
        var myReceiver = BatteryReceiver() // ❌ Uso de companion object para un Receiver (puede causar fugas de memoria)
    }
}
