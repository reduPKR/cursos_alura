fun testeContas() {
    val contaCorrente = ContaCorrente("Rafael", 123)
    val contaPoupanca = ContaPoupanca("Eduardo", 234)

    contaCorrente.depositar(1000.0)
    contaPoupanca.depositar(1000.0)

    println("Saldo inicial conta corrente ${contaCorrente.saldo}")
    println("Saldo inicial conta poupança ${contaPoupanca.saldo}")

    contaCorrente.sacar(100.0)
    contaPoupanca.sacar(100.0)

    println("Saldo apos saque conta corrente ${contaCorrente.saldo}")
    println("Saldo apos saque conta poupança ${contaPoupanca.saldo}")

    contaCorrente.transferir(contaPoupanca, 500.0)

    println("Saldo apos transferir de conta corrente para poupança ${contaCorrente.saldo}")
    println("Saldo transferir de conta corrente para poupança ${contaPoupanca.saldo}")

    contaPoupanca.transferir(contaCorrente, 500.0)

    println("Saldo apos transferir de conta poupança para corrente ${contaCorrente.saldo}")
    println("Saldo transferir de conta poupança para corrente ${contaPoupanca.saldo}")
}