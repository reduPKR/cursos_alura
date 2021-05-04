import br.com.alura.exception.FalhaAutenticacaoException
import br.com.alura.exception.SaldoInsuficienteException
import br.com.alura.model.Cliente
import br.com.alura.model.ContaCorrente
import br.com.alura.model.ContaPoupanca
import java.lang.Exception

fun testeContas() {
    val rafael = Cliente("rafael", "111", 1234)
    val edu = Cliente("edu", "333", 1234)
    val contaCorrente = ContaCorrente(rafael, 123)
    val contaPoupanca = ContaPoupanca(edu, 234)

    contaCorrente.depositar(1000.0)
    contaPoupanca.depositar(1000.0)

    println("Saldo inicial conta corrente ${contaCorrente.saldo}")
    println("Saldo inicial conta poupança ${contaPoupanca.saldo}")

    contaCorrente.sacar(100.0)
    contaPoupanca.sacar(100.0)

    println("Saldo apos saque conta corrente ${contaCorrente.saldo}")
    println("Saldo apos saque conta poupança ${contaPoupanca.saldo}")

    try {
        contaCorrente.transferir(contaPoupanca, 500.0, 1234)
        println("Transferencia ok")
    }catch (e: SaldoInsuficienteException){
        println("Falha na transferencia, Saldo insuficiante")
    }catch (e: FalhaAutenticacaoException){
        println(e.message)
    }catch (e: Exception){
        println("Erro desconhecido")
    }


    println("Saldo apos transferir de conta corrente para poupança ${contaCorrente.saldo}")
    println("Saldo transferir de conta corrente para poupança ${contaPoupanca.saldo}")

    try {
        contaPoupanca.transferir(contaCorrente, 500.0, 234)
        println("Transferencia ok")
    }catch (e: SaldoInsuficienteException){
        println("Falha na transferencia, Saldo insuficiante")
    }catch (e: FalhaAutenticacaoException){
        println(e.message)
    }catch (e: Exception){
        println("Erro desconhecido")
    }

    println("Saldo apos transferir de conta poupança para corrente ${contaCorrente.saldo}")
    println("Saldo transferir de conta poupança para corrente ${contaPoupanca.saldo}")
}