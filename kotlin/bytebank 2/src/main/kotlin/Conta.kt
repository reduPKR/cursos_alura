abstract class Conta(val titular: String, val numero: Int) {
    var saldo = 0.0
        protected set

    fun depositar(valor: Double) {
        saldo += valor
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