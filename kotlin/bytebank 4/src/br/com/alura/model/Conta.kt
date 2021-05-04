package br.com.alura.model

import br.com.alura.exception.FalhaAutenticacaoException
import br.com.alura.exception.SaldoInsuficienteException
import br.com.alura.model.Autenticavel as Autenticavel

//Variavel global que apenas essa classe pode alterar o valor
//var totalContas: Int = 0
//    private set

abstract class Conta(
    val titular: Cliente,
    val numero: Int
): Autenticavel {
    var saldo = 0.0
        protected set

    companion object Contador {
        var total = 0
            private set
    }

    fun depositar(valor: Double) {
        saldo += valor
    }

    init {
        //totalContas++
        Contador.total++
    }

//    open fun sacar(valor: Double) {
//        if (saldo >= valor)
//            saldo -= valor
//    }

    abstract fun sacar(valor: Double)

    fun transferir(destino: Conta, valor: Double, senha: Int) {
        if (saldo < valor) {
            throw SaldoInsuficienteException("Saldo insuficiente, saldo atual: $saldo")
        }

        if(!autenticacao(senha)){
            throw FalhaAutenticacaoException()
        }

        this.sacar(valor)
        destino.depositar(valor)
    }

    override fun autenticacao(senha: Int): Boolean {
        return titular.autenticacao(senha)
    }
}