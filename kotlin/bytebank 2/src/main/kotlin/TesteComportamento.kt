fun testeComportamento() {
    val contaCorrente = ContaCorrente("Rafael", 10000)
    contaCorrente.depositar(1000.0)

    println(contaCorrente.titular)
    println(contaCorrente.numero)
    println(contaCorrente.saldo)

    val contaPoupanca = ContaPoupanca(numero = 10001, titular = "Sara")
    contaPoupanca.depositar(2000.0)

    println(contaPoupanca.titular)
    println(contaPoupanca.numero)
    println(contaPoupanca.saldo)

    testeDepositar(contaCorrente)
    testeSaque(contaCorrente, 750.0)
    testeTransferencia(contaCorrente, contaPoupanca, 500.0)
}