fun main() {
    println("Bem vindo ao bytebank!");

    val conta = Conta("Rafael", 10000)
    conta.depositar(1000.0)

    println(conta.titular)
    println(conta.numero)
    println(conta.saldo)

    //Se passar as labels no construtor(ou funçoes) nao precisa seguir a ordem
    val destino = Conta(numero = 10001, titular = "Sara")
    destino.depositar(2000.0)

    println(conta.titular)
    println(conta.numero)
    println(conta.saldo)

    testeDepositar(conta)
    testeSaque(conta, 750.0)
//    testeSaque(conta, 850.0)
    testeTransferencia(conta, destino, 500.0)
}

fun testeTransferencia(conta: Conta, destino: Conta, valor: Double) {
    println("Transferencia de $valor")
    conta.transferir(destino, valor)
    println(conta.saldo)
    println(destino.saldo)
}

fun testeSaque(conta: Conta, valor: Double) {
    println("Sacando")
    println("Saldo anterior ${conta.saldo}")
    conta.sacar(valor)
    println("Saldo atual ${conta.saldo}")
}

fun testeDepositar(conta: Conta) {
    println("Depositando")
    println("Saldo anterior ${conta.saldo}")
    conta.depositar(500.0)
    println("Saldo atual ${conta.saldo}")
}

fun testaSaldo(saldo: Double) {
    when {
        saldo > 0.0 -> println("Saldo positivo")
        saldo == 0.0 -> println("Conta neutra")
        else -> println("Saldo negativo")
    }
}