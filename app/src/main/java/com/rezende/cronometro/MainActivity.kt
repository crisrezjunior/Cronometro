package com.rezende.cronometro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.LayoutInflater
import com.rezende.cronometro.databinding.ActivityMainBinding

private lateinit var biding: ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var running = false
    var pause: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(biding.root)

        biding.pause.setOnClickListener {
            PausarCronometro()
        }
        biding.start.setOnClickListener {

            IniciarCronometro()

        }
        biding.restart.setOnClickListener {

            ZerarCronometro()
        }
    }
    private fun IniciarCronometro(){

        if (!running){
            biding.cronometro.base =SystemClock.elapsedRealtime() - pause
            biding.cronometro.start()
            running = true
        }
    }

    private fun PausarCronometro(){
        if(running){

            pause = SystemClock.elapsedRealtime() - biding.cronometro.base
            biding.cronometro.stop()
            running = false

        }

    }

    private fun ZerarCronometro(){


          biding.cronometro.base = SystemClock.elapsedRealtime()
            pause = 0


    }
}