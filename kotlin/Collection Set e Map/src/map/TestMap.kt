fun testMap(){
    //chave 1 preço 29.75
//    mapOf<Int,Double>(Pair(1, 29.75))
//    mapOf<Int,Double>(1 to 29.75) é comum o uso do infix porem para muitos valores tem perda de perfomace
    val pedidos = mapOf<Int, Double>(1 to 29.75, 2 to 30.10, 3 to 45.50)
    println(pedidos)
    val pedido = pedidos[0]//Nõ vai dar, não é posição e sim a key que ele pede ou seja n tem a key 0
    pedido?.let { println("Pedido $pedido") }

    for (pedido: Map.Entry<Int,Double> in pedidos){
        println("Numero do pedido: ${pedido.key} Valor do pedido: ${pedido.value} ")
        //println(pedido)
    }
}