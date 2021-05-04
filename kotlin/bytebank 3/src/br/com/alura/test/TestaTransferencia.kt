import br.com.alura.model.Conta

fun testeTransferencia(conta: Conta, destino: Conta, valor: Double) {
    println("Transferencia de $valor")
    conta.transferir(destino, valor)
    println(conta.saldo)
    println(destino.saldo)
}
