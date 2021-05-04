package br.com.alura.test

import br.com.alura.model.Cliente

fun testeString() {
    val rafael = Cliente("rafael", "111", 1234)
    println(rafael.toString())
    println(rafael.toStringRaw())
}