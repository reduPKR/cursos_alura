import br.com.alura.model.Conta

fun testeDepositar(conta: Conta) {
    println("Depositando")
    println("Saldo anterior ${conta.saldo}")
    conta.depositar(500.0)
    println("Saldo atual ${conta.saldo}")
}