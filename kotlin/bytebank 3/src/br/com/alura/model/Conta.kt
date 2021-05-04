package br.com.alura.model

//Variavel global que apenas essa classe pode alterar o valor
//var totalContas: Int = 0
//    private set

abstract class Conta(val titular: Cliente,
                     val numero: Int) {
    var saldo = 0.0
        protected set
    companion object Contador{
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

    fun transferir(destino: Conta, valor: Double): Boolean {
        if (saldo >= valor) {
            this.sacar(valor)
            destino.depositar(valor)
            return true
        }
        return false
    }
}