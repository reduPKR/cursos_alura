import br.com.alura.model.Conta

fun testeTransferencia(conta: Conta, destino: Conta, valor: Double, senha: Int) {
    println("Transferencia de $valor")
    conta.transferir(destino, valor, senha)
    println(conta.saldo)
    println(destino.saldo)
}
