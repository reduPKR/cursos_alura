import map.associacao.testAssociacao
import map.testMutableMap

fun main(){
    testAssociacao()
    testGroupBy()
}

fun testGroupBy(){
    val nomes = listOf(
        "Rafael",
        "Sara",
        "Eduardo",
        "Andreia",
        "Ana",
        "Maria",
        "Bruna",
        "Marcos",
        "Samuel",
        "Thiago",
        "Matheus",
        "Renata",
    )

    val agrupado = nomes.groupBy { nome -> nome.first() }//Agrupa pela 1 letra do nome
    println(agrupado)
    println(agrupado['A'])
}


