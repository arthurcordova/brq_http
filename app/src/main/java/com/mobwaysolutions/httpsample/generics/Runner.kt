package com.mobwaysolutions.httpsample.generics

fun main() {

    val cozinhar = Cozinhar<Alimento>()

    cozinhar.assar(Pizza())
    cozinhar.assar(Alimento())

    val listaDeStrings = listOf<String>("aaa", "aaa")
    val listaDeALimentos = listOf<Alimento>(Pizza(), Alimento())
    val listaDeInteiros = listOf<Int>(1, 3, 4)

}