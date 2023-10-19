package com.example.recetario

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Receta(
    val id:Int,
    val nombre:String,
    val dificultad:Int,
    val pais:Pais,
    val logo:String
): Parcelable

enum class Pais {
    ARGENTINA,
    BRASIL,
    CHILE,
    URUGUAY,
    PARAGUAY,
    COLOMBIA,
    ECUADOR,
    MEXICO,
    VENEZUELA,
    BOLIVIA,
    PERU
}