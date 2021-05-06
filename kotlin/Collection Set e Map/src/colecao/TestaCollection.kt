import colecao.BancoNomes

fun testaCollection() {

//    val numeros = setOf(1, 2, 3)
//    println(numeros.map { it * 2 })

    val bancoNomes = BancoNomes()
    bancoNomes.adicionarNome("Rafael")
    println(bancoNomes.nomes)

    //Não permite pois retornei uma copia de lista
    //val nomeSalvo = bancoNomes.nomes as MutableCollection<String>
}