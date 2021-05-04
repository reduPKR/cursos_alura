import br.com.alura.model.Cliente
import br.com.alura.model.ContaCorrente
import br.com.alura.model.ContaPoupanca

fun testeComportamento() {
    val rafael = Cliente("rafael", "111", 1234)
    val contaCorrente = ContaCorrente(rafael, 10000)
    contaCorrente.depositar(1000.0)

    println(contaCorrente.titular.nome)
    println(contaCorrente.numero)
    println(contaCorrente.saldo)

    val sara = Cliente("Sara", "222", 1234)
    val contaPoupanca = ContaPoupanca(numero = 10001, titular = sara)
    contaPoupanca.depositar(2000.0)

    println(contaPoupanca.titular.nome)
    println(contaPoupanca.numero)
    println(contaPoupanca.saldo)

    testeDepositar(contaCorrente)
    testeSaque(contaCorrente, 750.0)
    testeTransferencia(contaCorrente, contaPoupanca, 500.0, 1234)
}