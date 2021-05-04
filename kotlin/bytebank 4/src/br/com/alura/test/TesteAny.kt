package br.com.alura.test

import br.com.alura.model.Cliente
import br.com.alura.model.ContaCorrente
import br.com.alura.model.Endereco

fun testeAny() {
    val rafael = Cliente("rafael", "111", 1234)
    val conta = ContaCorrente(rafael, 123)
    val endereco = Endereco(
        "",
        618,
        "JD. das greevilhas",
        "Maringa",
        "PR",
        "1234-45",
        ""
    )

    imprimir(rafael)
    imprimir(conta)
    imprimir(endereco)
}

fun imprimir(dado: Any): Boolean{
    println(dado)
    return dado != null
}