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
                "https://lasrecetasdelchef.net/wp-content/uploads/2020/03/receta-de-locro-criollo.jpg",
                "https://www.lavoz.com.ar/resizer/TjuWBjBYw5imsArxf5gRD7bLj8I=/980x640/smart/filters:quality(75):format(webp)/cloudfront-us-east-1.images.arcpublishing.com/grupoclarin/RZ23WR3Y6JBTZKQLPSJBSAXADU.jpg"
            ),
            Receta(2,
                "Cazuela Chilena",
                8,
                Pais.CHILE,
                "https://images-gmi-pmc.edge-generalmills.com/5722b9dc-deaa-497b-8581-a79af9cf1002.jpg",
                "https://img-global.cpcdn.com/recipes/fadaee2fd7c899a6/1200x630cq70/photo.jpg"
            ),
            Receta(3,
                "Aji de Fideos",
                7,
                Pais.BOLIVIA,
                "https://otrareceta.com/wp-content/uploads/2017/03/aji-de-fideo-1.png",
                "https://i.ytimg.com/vi/SeBxsvn_qbw/maxresdefault.jpg"
            ),
            Receta(4,
                "Sandwich Olimpico",
                5,
                Pais.URUGUAY,
                "https://i.ytimg.com/vi/anVc_yv1JSA/maxresdefault.jpg",
                "https://cocinacaseradeluruguay.files.wordpress.com/2022/09/sandwich-olimpico-copetin-confiteria-online-tienda-lion-dor-montevideo-uruguay-comprar-comida-online-rotiseria-dulces-saladitos-bocaditos-calientes.jpg"
            ),
            Receta(5,
                "Vori Vori",
                7,
                Pais.PARAGUAY,
                "https://www.cronica.com.ar/export/sites/cronica/img/2021/07/21/01.jpg_717526657.jpg",
                "https://cdn7.kiwilimon.com/recetaimagen/39749/52192.jpg"
            ),
            Receta(6,
                "Arepa",
                5,
            Pais.VENEZUELA,
                "https://i.blogs.es/8ad4da/arepas/1366_2000.jpg",
                "https://cdn.nutritionstudies.org/wp-content/uploads/2020/11/arepa-rellena-con-jaca-mechada-1.jpg"
            ),
            Receta(7,
                "Feijoada",
                3,
                Pais.BRASIL,
                "https://www.lavanguardia.com/files/image_344_168/files/fp/uploads/2021/03/18/60534473eda1f.r_d.1062-756-1721.jpeg",
                "https://www.gourmet.cl/wp-content/uploads/2013/09/feijoada.jpg"
            ),
            Receta(8,
                "Ajiaco Colombiano",
                3,
                Pais.COLOMBIA,
                "https://img-global.cpcdn.com/recipes/7e9561ebcd80ac0b/1200x630cq70/photo.jpg",
                "https://img-global.cpcdn.com/recipes/recipes_100_v1393305311_foto_foto_00001555/400x400cq70/photo.jpg"
            ),
            Receta(7,
                "Llapingachos",
                3,
                Pais.ECUADOR,
                "https://www.thespruceeats.com/thmb/S4HNbiqs65f9yKFa8HxtcZCfjnE=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/llapingachos-56a8a5353df78cf7729f60dc.jpg",
                "https://www.comedera.com/wp-content/uploads/2022/09/Llapingachos-shutterstock_2127567404.jpg"
            ),
            Receta(4,
                "Tacos",
                3,
                Pais.MEXICO,
                "https://www.paulinacocina.net/wp-content/uploads/2020/01/tacos-meat-food-mexican-lunch-dinner.jpg",
                "https://img-global.cpcdn.com/recipes/cb53be8630367058/400x400cq70/photo.jpg"
            ),
            Receta(8,
                "Ceviche",
                7,
                Pais.PERU,
                "https://imag.bonviveur.com/ceviche-peruano-de-pescado.jpg",
                "https://www.expogourmetmagazine.com/uploads/fotos_noticias/2018/03/w500px_17327-140204-recetas-originales-ceviche-peruano-de-pescado.jpg"
            )
        )
    }
}