package com.example.recetario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class SplashActivity : AppCompatActivity() {

    private lateinit var t_recetario: TextView
    private lateinit var t_inicio: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        t_recetario = findViewById(R.id.t_recetario)
        t_inicio = findViewById(R.id.t_inicio)

        t_recetario.text = "Recetas de Latinoamerica"
        Glide.with(this).load("https://cdn.kiwilimon.com/menu/2099/2099.jpg").into(t_inicio)

        val delayMillis = 3000 // 3 segundos
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish() // Cierra la actividad de presentación
        }, delayMillis.toLong())
    }
}