package com.example.recetario

data class Receta(
    val id:Int,
    val nombre:String,
    val dificultad:Int,
    val pais:Pais,
    val logo:String
)

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