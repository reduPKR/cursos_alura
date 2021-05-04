package br.com.alura.test

import br.com.alura.model.Cliente
import br.com.alura.model.Conta
import br.com.alura.model.ContaCorrente
import br.com.alura.model.ContaPoupanca

fun testeContador() {

    val rafael = Cliente("rafael", "111", 1234)
    val edu = Cliente("edu", "333", 1234)
    val contaCorrente = ContaCorrente(rafael, 123)
    val contaPoupanca = ContaPoupanca(edu, 234)

    //println("Total de contas criadas ${totalContas}")
    //println("Total de contas ${Conta.Contador.total}")
    println("Total de contas ${Conta.total}")
}