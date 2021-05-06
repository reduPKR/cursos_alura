import java.math.RoundingMode

fun testScopeFunction() {
    //Tem o let, mas ja foi bastante usado entao pulou ele

    with(Endereco()) {
        "Rua Carolina dassan"
        295
        "Oiveiras"
        "Sao paulo"
        "Sp"
        "01283-123"
        completo()
    }.let { enderecoCompleto: String -> println(enderecoCompleto) }

    //Nao fui atras do projeto porem no exemplo usa o bytebank
    val taxaAnual = 0.05
    val taxaMensal = taxaAnual / 12

    val cliente = Cliente("Rafael", "11111")
    //.let { cliente -> Conta(cliente, 1000) }

    val conta = Conta(cliente, 1000)
    conta
        .run {
            deposita(1000.00)
            (saldo * taxaMensal.toBigDecimal()).setScale(2, RoundingMode.UP)
        }
        .let { rendimentoMensal -> println(rendimentoMensal) }

    val rendimentoAnual = run {
        var saldo = conta.saldo
        repeat(12) { indice ->
            saldo += (saldo * taxaMensal.toBigDecimal()).setScale(2, RoundingMode.UP)
        }
        saldo
    }
    println(rendimentoAnual)

    //Modifiquei para poder criar um cliente nulo para poder testar
    val cliente2 = Cliente()
        .also{ println("Cadstrando cliente")}
        .apply { titular = "Eduardo"
            cpf = "123123"
        }

}
