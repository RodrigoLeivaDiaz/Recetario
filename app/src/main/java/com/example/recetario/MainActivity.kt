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
                "https://www.lavoz.com.ar/resizer/TjuWBjBYw5imsArxf5gRD7bLj8I=/980x640/smart/filters:quality(75):format(webp)/cloudfront-us-east-1.images.arcpublishing.com/grupoclarin/RZ23WR3Y6JBTZKQLPSJBSAXADU.jpg",
                "Rinde para: 6-8 personas\n" +
                        "\n" +
                        "250g. de porotos blancos\n" +
                        "250g. de maíz blanco partido\n" +
                        "1 chorizo colorado\n" +
                        "1 chorizo criollo\n" +
                        "Cuerito de cerdo\n" +
                        "Pechito de cerdo\n" +
                        "Falda\n" +
                        "200g. de panceta\n" +
                        "3 cebollas\n" +
                        "2 cebollas de verdeo\n" +
                        "1 puerro\n" +
                        "1/2 calabaza\n" +
                        "1/2 morrón rojo (para la salsita)\n" +
                        "Condimentos: sal, pimienta, comino, pimentón, ají molido, orégano"
            ),
            Receta(2,
                "Cazuela Chilena",
                8,
                Pais.CHILE,
                "https://images-gmi-pmc.edge-generalmills.com/5722b9dc-deaa-497b-8581-a79af9cf1002.jpg",
                "https://img-global.cpcdn.com/recipes/fadaee2fd7c899a6/1200x630cq70/photo.jpg",
                "Rinde para: 4-5 personas\n" +
                        "\n" +
                        "1 lb de brisket (tapapecho)\n" +
                        "2 cucharadas de aceite vegetal\n" +
                        "1 cebolla cortada en 4 pedazos\n" +
                        "1 pimiento morrón cortado en 4 pedazos, sin semillas\n" +
                        "1 cucharadita de orégano\n" +
                        "1 cucharadita de comino\n" +
                        "sal y pimienta,\n" +
                        "ramita de apio\n" +
                        "2 elotes cortados en 3\n" +
                        "2 zanahorias peladas y cortadas en 3\n" +
                        "6 papas rojas pequeñas peladas\n" +
                        "4 puñados de arroz\n" +
                        "6 trozos de calabaza naranja\n" +
                        "1 puñado de ejotes cortados a la francesa\n" +
                        "5-6 tazas de agua hirviendo"
            ),
            Receta(3,
                "Aji de Fideos",
                7,
                Pais.BOLIVIA,
                "https://otrareceta.com/wp-content/uploads/2017/03/aji-de-fideo-1.png",
                "https://i.ytimg.com/vi/SeBxsvn_qbw/maxresdefault.jpg",
                "Rinde para: 3-5 personas\n" +
                        "\n" +
                        "3 cucharillas de Ají amarillo molido (en pasta o en polvo)\n" +
                        "2 Dientes de ajo picado\n" +
                        "2 Pastillas de caldo de res\n" +
                        "4 Papas peladas y picadas en cubos\n" +
                        "1 Zanahoria picada en cubos\n" +
                        "Amarro de perejil fresco picado\n" +
                        "½ taza de Arvejas\n" +
                        "3 tazas de Fideos\n" +
                        "6 cucharas de Aceite\n" +
                        "¼ kilogramo de Carne molida\n" +
                        "2 Cebollas grandes\n" +
                        "2 Tomates medianos\n" +
                        "1 pizca de Sal\n" +
                        "1 pizca de Pimienta\n" +
                        "4 tazas de Agua"
            ),
            Receta(4,
                "Sandwich Olimpico",
                5,
                Pais.URUGUAY,
                "https://i.ytimg.com/vi/anVc_yv1JSA/maxresdefault.jpg",
                "https://cocinacaseradeluruguay.files.wordpress.com/2022/09/sandwich-olimpico-copetin-confiteria-online-tienda-lion-dor-montevideo-uruguay-comprar-comida-online-rotiseria-dulces-saladitos-bocaditos-calientes.jpg",
                "Rinde para: 2 personas\n" +
                        "\n" +
                        "3 rebanadas pan de molde tierno\n" +
                        "2 lonchas finas del tamaño del pan de jamón cocido\n" +
                        "2 lonchas finas del tamaño del pan de queso gouda o de sándwich\n" +
                        "8 rodajas huevo duro\n" +
                        "2 rodajas grandes finas de tomate\n" +
                        "Mayonesa\n" +
                        "Sal"
            ),
            Receta(5,
                "Vori Vori",
                7,
                Pais.PARAGUAY,
                "https://www.cronica.com.ar/export/sites/cronica/img/2021/07/21/01.jpg_717526657.jpg",
                "https://cdn7.kiwilimon.com/recetaimagen/39749/52192.jpg",
                "Rinde para: 5 personas\n" +
                        "\n" +
                        "1 Pollo cortado en trozos\n" +
                        "1 Locote rojo\n" +
                        "2 Tomates\n" +
                        "1 Cebolla\n" +
                        "1 Cebolla de verdeo\n" +
                        "2 tazas de Harina de maíz\n" +
                        "150 gramos de Queso paraguay\n" +
                        "1 cuchara de Orégano\n" +
                        "2 ½ litros de Agua\n" +
                        "1 pizca de Sal\n" +
                        "1 pizca de Pimienta"
            ),
            Receta(6,
                "Arepa",
                5,
            Pais.VENEZUELA,
                "https://i.blogs.es/8ad4da/arepas/1366_2000.jpg",
                "https://cdn.nutritionstudies.org/wp-content/uploads/2020/11/arepa-rellena-con-jaca-mechada-1.jpg",
                "Rinde para: 3 personas\n" +
                        "\n" +
                        "3 tazas agua tibia o caliente\n" +
                        "2 tazas de harina precocida de Maíz\n" +
                        "1 cdita. de Sal\n" +
                        "Relleno a Gusto\n" +
                        "1 cdita. de Aceite de oliva"
            ),
            Receta(7,
                "Feijoada",
                3,
                Pais.BRASIL,
                "https://www.lavanguardia.com/files/image_344_168/files/fp/uploads/2021/03/18/60534473eda1f.r_d.1062-756-1721.jpeg",
                "https://www.gourmet.cl/wp-content/uploads/2013/09/feijoada.jpg",
                "Rinde para: 5 personas\n" +
                        "\n" +
                        "250 gr de frijoles negros\n" +
                        "110 gr de costillas de cerdo\n" +
                        "90 gr de tocino o panceta ahumada\n" +
                        "50 gr de longaniza ahumada\n" +
                        "\n" +
                        "Condimento:\n" +
                        "\n" +
                        "1 Cebolla mediana picada\n" +
                        "Cebolla de verdeo picada\n" +
                        "2 hojas de laurel\n" +
                        "1 ½ dientes de ajo picados\n" +
                        "Comino\n" +
                        "Aceite de oliva\n" +
                        "Sal "
            ),
            Receta(8,
                "Ajiaco Colombiano",
                3,
                Pais.COLOMBIA,
                "https://img-global.cpcdn.com/recipes/7e9561ebcd80ac0b/1200x630cq70/photo.jpg",
                "https://img-global.cpcdn.com/recipes/recipes_100_v1393305311_foto_foto_00001555/400x400cq70/photo.jpg",
                "Rinde para: 6 personas\n" +
                        "\n" +
                        "2 Pechugas de pollo (o pollo troceado)\n" +
                        "1 Kg. de papas de diferentes tipos\n" +
                        "1 Ramito de perejil\n" +
                        "1 Ramito de cilantro\n" +
                        "1 Cdita. de estragón\n" +
                        "1 Choclo (maiz)\n" +
                        "Alcaparras\n" +
                        "Crema de leche\n" +
                        "Sal\n" +
                        "\n" +
                        "Para acompañar\n" +
                        "\n" +
                        "1 Palta (aguacate)\n" +
                        "4 Pocillos de arroz blanco cocido"
            ),
            Receta(7,
                "Llapingachos",
                3,
                Pais.ECUADOR,
                "https://www.thespruceeats.com/thmb/S4HNbiqs65f9yKFa8HxtcZCfjnE=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/llapingachos-56a8a5353df78cf7729f60dc.jpg",
                "https://www.comedera.com/wp-content/uploads/2022/09/Llapingachos-shutterstock_2127567404.jpg",
                "Rinde para: 4 personas\n" +
                        "\n" +
                        "5-6 papas grandes (tipo Russet en EEUU) peladas y cortadas en trozos medianos\n" +
                        "2 cucharadas de aceite\n" +
                        "½ taza de cebolla blanca picada finamente\n" +
                        "2 cucharaditas de achiote molido\n" +
                        "1 taza de queso o quesillo desmenuzado/rallado puede usar mozzarella o oaxaca\n" +
                        "Sal al gusto\n" +
                        "\n" +
                        "Para acompañar:\n" +
                                "Salsa de maní\n" +
                                "Curtido de tomate y cebolla\n" +
                                "Rodajas o tajas de aguacate\n" +
                                "Lechuga"
            ),
            Receta(4,
                "Tacos",
                3,
                Pais.MEXICO,
                "https://www.paulinacocina.net/wp-content/uploads/2020/01/tacos-meat-food-mexican-lunch-dinner.jpg",
                "https://img-global.cpcdn.com/recipes/cb53be8630367058/400x400cq70/photo.jpg",
                "Rinde para: 5 personas\n" +
                        "\n" +
                        "250 grs de carne: puede ser peceto, nalga, la que más te guste\n" +
                        "1 cebolla morada mediana\n" +
                        "2 dientes de ajo\n" +
                        "1 chile fresco (opcional)\n" +
                        "1/2 pimiento o morrón rojo\n" +
                        "1/2 pimiento o morrón verde\n" +
                        "Jugo de 1 lima o limón\n" +
                        "1 tomate mediano\n" +
                        "Orégano\n" +
                        "Chile seco (a gusto)\n" +
                        "Sal y pimienta\n" +
                        "Cilantro\n" +
                        "Aceite neutro"
            ),
            Receta(8,
                "Ceviche",
                7,
                Pais.PERU,
                "https://imag.bonviveur.com/ceviche-peruano-de-pescado.jpg",
                "https://www.expogourmetmagazine.com/uploads/fotos_noticias/2018/03/w500px_17327-140204-recetas-originales-ceviche-peruano-de-pescado.jpg",
                "Rinde para: 6-8 personas\n" +
                        "\n" +
                        "1kg. de merluza fresca\n" +
                        "1 tallo de apio\n" +
                        "2 limones\n" +
                        "1 lima\n" +
                        "1 cebolla morada\n" +
                        "1 ramo de cilantro\n" +
                        "1/2 caldito de pescado o verduras* \n" +
                        "Sal y pimienta"
            )
        )
    }
}