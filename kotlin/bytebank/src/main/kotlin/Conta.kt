//class Conta {
//    var titular = ""
//    var numero = 0
//    var saldo = 0.0
//        private set
//
//    constructor(titular: String, numero: Int) {
//        this.titular = titular
//        this.numero = numero
//    }
//Equivale
//Caso tenha valor padrao exemplo saldo -> var saldo: Double = 0.0
class Conta(val titular: String, val numero: Int) {
    var saldo = 0.0
        private set

    fun depositar(valor: Double) {
        saldo += valor
    }

    fun sacar(valor: Double) {
        if (saldo >= valor)
            saldo -= valor
    }

    fun transferir(destino: Conta, valor: Double): Boolean {
        if (saldo >= valor) {
            this.sacar(valor)
            destino.depositar(valor)
            return true
        }
        return false
    }
}