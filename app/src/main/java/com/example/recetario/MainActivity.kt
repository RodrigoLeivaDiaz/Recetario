package com.example.recetario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var  adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.rvreceta)
        recyclerView.layoutManager = LinearLayoutManager(this)
        
        adapter = Adapter(this)
        recyclerView.adapter = adapter
        adapter.submitList(getListadoRecetas())

        adapter.onItemClickListener = {
            navegarDetalle(it)
        }
    }

    private fun navegarDetalle(receta: Receta) {
            val intent = Intent(this,DetailActivity::class.java)
            //Para mandar datos de forma parcial.
            //val bundle = Bundle()
            //bundle.putParcelable("receta",receta)
            intent.putExtra("receta", receta)
            startActivity(intent)
    }

    private fun getListadoRecetas(): MutableList<Receta>? {
        return mutableListOf(
            Receta(1,
                "Locro",
                9,
                Pais.ARGENTINA,
                "https://lasrecetasdelchef.net/wp-content/uploads/2020/03/receta-de-locro-criollo.jpg"
            ),
            Receta(2,
                "Cazuela Chilena",
                8,
                Pais.CHILE,
                "https://images-gmi-pmc.edge-generalmills.com/5722b9dc-deaa-497b-8581-a79af9cf1002.jpg"
            ),
            Receta(3,
                "Aji de Fideos",
                7,
                Pais.BOLIVIA,
                "https://otrareceta.com/wp-content/uploads/2017/03/aji-de-fideo-1.png"
            ),
            Receta(4,
                "Sandwich Olimpico",
                5,
                Pais.URUGUAY,
                "https://i.ytimg.com/vi/anVc_yv1JSA/maxresdefault.jpg"
            ),
            Receta(5,
                "Vori Vori",
                7,
                Pais.PARAGUAY,
                "https://www.cronica.com.ar/export/sites/cronica/img/2021/07/21/01.jpg_717526657.jpg"
            ),
            Receta(6,
                "Arepa",
                5,
            Pais.VENEZUELA,
                "https://i.blogs.es/8ad4da/arepas/1366_2000.jpg"
            ),
            Receta(7,
                "Feijoada",
                3,
                Pais.BRASIL,
                "https://www.lavanguardia.com/files/image_344_168/files/fp/uploads/2021/03/18/60534473eda1f.r_d.1062-756-1721.jpeg"
            ),
            Receta(8,
                "Ajiaco Colombiano",
                3,
                Pais.COLOMBIA,
                "https://img-global.cpcdn.com/recipes/7e9561ebcd80ac0b/1200x630cq70/photo.jpg"
            ),
            Receta(8,
                "Ajiaco Colombiano",
                3,
                Pais.COLOMBIA,
                "https://img-global.cpcdn.com/recipes/7e9561ebcd80ac0b/1200x630cq70/photo.jpg"
            ),
            Receta(8,
                "Ajiaco Colombiano",
                3,
                Pais.COLOMBIA,
                "https://img-global.cpcdn.com/recipes/7e9561ebcd80ac0b/1200x630cq70/photo.jpg"
            ),
            Receta(8,
                "Ajiaco Colombiano",
                3,
                Pais.COLOMBIA,
                "https://img-global.cpcdn.com/recipes/7e9561ebcd80ac0b/1200x630cq70/photo.jpg"
            )
        )
    }
}