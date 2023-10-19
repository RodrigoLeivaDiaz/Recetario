package com.example.recetario

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.accessibility.AccessibilityManager.AccessibilityServicesStateChangeListener
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adapter(val context: Context) : ListAdapter<Receta, Adapter.ViewHolder>(DiffCallBack) {

    lateinit var onItemClickListener: (Receta) -> Unit
        inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val nombre: TextView = view.findViewById(R.id.t_nombre)
        private val dificultad: TextView = view.findViewById(R.id.t_dificultad)
        private val pais: TextView = view.findViewById(R.id.t_pais)
        private val logo: ImageView = view.findViewById(R.id.t_plato)
        private val bandera: ImageView = view.findViewById(R.id.t_bandera)

        fun bind (receta: Receta) {

            nombre.text = receta.nombre
            dificultad.text = "Dificultad: "+receta.dificultad.toString()
            pais.text = receta.pais.toString()

            val imagen = when (receta.pais) {
                Pais.ARGENTINA -> R.drawable.arg
                Pais.BRASIL -> R.drawable.br
                Pais.CHILE -> R.drawable.ch
                Pais.COLOMBIA -> R.drawable.col
                Pais.URUGUAY -> R.drawable.uru
                Pais.PARAGUAY -> R.drawable.pa
                Pais.ECUADOR -> R.drawable.ecu
                Pais.MEXICO -> R.drawable.mex
                Pais.VENEZUELA -> R.drawable.ven
                Pais.BOLIVIA -> R.drawable.bol
                Pais.PERU -> R.drawable.pe
            }

            bandera.setImageResource(imagen)

            Glide.with(context).load(receta.logo).into(logo)

            view.setOnClickListener{
                onItemClickListener(receta)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val equipo = getItem(position)
        holder.bind(equipo)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Receta>() {
        override fun areItemsTheSame(oldItem: Receta, newItem: Receta): Boolean {
            return  oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Receta, newItem: Receta): Boolean {
            return oldItem == newItem
        }
    }
}
