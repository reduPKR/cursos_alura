import br.com.alura.model.Conta

fun testeSaque(conta: Conta, valor: Double) {
    println("Sacando")
    println("Saldo anterior ${conta.saldo}")
    conta.sacar(valor)
    println("Saldo atual ${conta.saldo}")
}