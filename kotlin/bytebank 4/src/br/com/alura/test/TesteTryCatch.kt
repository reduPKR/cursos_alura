package br.com.alura.test

import br.com.alura.model.Endereco

fun testeTryCatch() {
    val endereco = Any()
    try {
        endereco as Endereco
    } catch (e: ClassCastException) {
        e.printStackTrace()
        println("Deu ruim")
    }

    val valor = "1.2"
    val resposta: Int? = try {
        valor.toInt()
    } catch (e: NumberFormatException) {
        e.printStackTrace()
        null
    }

    if (resposta != null) {
        println("Valor aceito")
    } else {
        println("Valor invalido")
    }
}
