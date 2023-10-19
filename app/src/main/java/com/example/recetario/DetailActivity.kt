package com.example.recetario

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    private lateinit var t_pais2: TextView
    private lateinit var t_nombre2: TextView
    private lateinit var t_plato2: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val receta = intent.getParcelableExtra<Receta>("receta")

        t_pais2 = findViewById(R.id.t_pais2)
        t_nombre2 = findViewById(R.id.t_nombre2)
        t_plato2 = findViewById(R.id.t_plato2)

        t_pais2.text = receta?.pais.toString()
        t_nombre2.text = receta?.nombre


        Glide.with(this).load(receta?.logo).into(t_plato2)
    }
}