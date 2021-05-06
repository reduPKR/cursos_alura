package map.associacao

fun testAssociacao(){
    //Associação -> Permite associar um elemento a outro e gerar um mapeamento
    val pedidos = listOf(
        Pedido(1, 345.90),
        Pedido(2, 4356.31),
        Pedido(3, 54.65),
        Pedido(4, 41.32),
        Pedido(5, 875.55),
        Pedido(6, 2345.37)
    )
    //Faz a associação do pedido com uma chave, nesse caso o proprio numero do pedido vai ser a chave
//    val pedidosMapedos = pedidos.associate { pedido ->
//        Pair(pedido.numero, pedido)
//    }
    //Faz a mesma ação de forma reduzida
    //Caso 2 valores correspondam ao a operação (poderia ser logica) ele mantem sempre a ultima
    val pedidosMapedos = pedidos.associateBy { pedido ->
        pedido.numero
    }
    println(pedidosMapedos)

    //saida dessa operacao vai ser pair(pedido,boolen)
    //Se usar o associateBy, para esse exemplo ele só retorna dois valores, true e false
    val freteGratis = pedidos.associateWith { pedido -> pedido.valor > 100 }
    println(freteGratis)
    println(freteGratis[Pedido(numero=2, valor=4356.31)])//deve dar true

    //Agrupa de maneira mais eficiente, dessa maneira consigo ver
    //todos que tenha frete grats ou não
    val freteGratisAgrupado = pedidos.groupBy { pedido -> pedido.valor > 100 }
    println(freteGratisAgrupado)
}