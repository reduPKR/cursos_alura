package map

fun testMutableMap() {
    val pedidos = mutableMapOf<Int, Double>(
        Pair(1, 63.83),
        Pair(2, 402.75),
        Pair(3, 929.38),
        Pair(4, 49.36),
        5 to 30.10,
        6 to 45.50
    )
    println(pedidos)
    val pedido = pedidos[0]//Nõ vai dar, não é posição e sim a key que ele pede ou seja n tem a key 0
    pedido?.let { println("Pedido $pedido") }

    for (item: Map.Entry<Int, Double> in pedidos) {
        println("Numero do pedido: ${item.key} Valor do pedido: ${item.value} ")
    }

    pedidos[7] = 70.0//esta adicionando o pair(7, 70) ou 4 to 70
    pedidos.put(8, 90.0)// pair(8, 90)

    pedidos[3] = 100.0//ele atualiza quem tem a chave 3
    pedidos.putIfAbsent(9, 50.95)//Não atualiza, so adiciona se a key não existir

    //pedidos.remove(4)

    println(pedidos)

    var item = pedidos.get(4)
    println(item)
    item = pedidos.getValue(4)//Tem mais segurança q o get, porem se a chave n existe ele da exception
    println(item)

    println(pedidos.getOrElse(1, { "Não existe esse pedido" }))
    println(pedidos.getOrElse(10, { "Não existe esse pedido" }))

    //O defalt retorna um valor padrao, o else era uma ação
    println(pedidos.getOrDefault(10, -1.0))

    println(pedidos.keys)
    println(pedidos.values)

    val filtro = pedidos.filter { (numero, valor) ->
        numero != 0 && valor > 50.0
    }
    val filtroValor = pedidos.filterValues { valor -> valor > 60.0 }
    val filtroKey = pedidos.filterKeys { chave -> chave % 2 == 0 }

    println(filtro)
    println(filtroValor)
    println(filtroKey)

    //Adiçoes
    println(pedidos + Pair(10, 45.69))
    println(pedidos + mapOf(10 to 45.69, 11 to 65.79,))
    //Nao funciona
   // println(pedidos + 10 to 33.90)

    //Remoção
    println(pedidos - 6)//somente remove por chave
    println(pedidos - listOf(3,5,6,8))
    pedidos -= 6
    println(pedidos)

    pedidos.values.remove(402.75)//Remove o primeiro elemento com esse valor
    println(pedidos)
    pedidos.keys.remove(8)
    println(pedidos)
}