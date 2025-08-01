package com.wimobile.android.test

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]  // el viewModel se debe crear una vez que la vista ha sido inflada o  creada

        textView = findViewById(R.id.textView)

        registerReceiver(myReceiver, IntentFilter(Intent.ACTION_BATTERY_CHANGED)).let { result ->
            if (result != null) {
                val level = result.getIntExtra("level", 0)
                val scale = result.getIntExtra("scale", 100)
                val batteryPct = level * 100 / scale
                viewModel.setData("Battery level: $batteryPct%")
            } else {
                viewModel.setData("Battery level: Unknown")
            }
        }

        viewModel.data.observe(this) {
            textView.text = it
        }

        Thread {
            textView.text = "Actualizando..."
        }.start()

    }

    //Para las fugas de memoria, es importante asegurarse de que el receptor se registre y se anule correctamente,\
    // en este caso implementé los cambios del ciclo de vida para parar la lectura de bateria cuando la aplicacion se encutre en segundo plano
    // y se anule cuando se cierre la actividad o la app

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity ", "onPause called, unregistering receiver")
        Thread {
            textView.text = "STOPPED"
        }.interrupt()
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity ", "onResume called, registering receiver")
        registerReceiver(myReceiver, IntentFilter(Intent.ACTION_BATTERY_CHANGED))
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy called, unregistering receiver")
        unregisterReceiver(myReceiver)
    }

    companion object {
        var myReceiver = BatteryReceiver()
    }
}
