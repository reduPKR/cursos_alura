import java.math.BigDecimal
import java.math.RoundingMode

class Conta(val titula: Cliente, val numero: Int) {
    var saldo: BigDecimal = BigDecimal.ZERO
        private set

    fun deposita(valor: Double){
        if(valor > 0){
            println("Depositando")
            saldo += valor.toBigDecimal()
            println("Novo saldo: $saldo")
        }
    }
}