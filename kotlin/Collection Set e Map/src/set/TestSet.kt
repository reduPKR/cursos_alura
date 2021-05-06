package set

fun testSet() {
    val listaCursoA = listOf<String>("Rafael", "Eduardo", "Sara", "Ana", "Matheus")
    val listaCursoB = listOf<String>("Rafael", "Carlos", "Sara", "Daniel", "Maria")

//    val listaAmbos = listaCursoA + listaCursoB
//    listaAmbos.forEach { println(it) }
//    println(listaAmbos.distinct())

    //+ e .plus() tem o mesmo efeito
    //val uniao: Set<String> = (listaCursoA + listaCursoB).toSet()
    val uniao: Set<String> = (listaCursoA union listaCursoB).toSet()
    println(uniao)

    //val uniao: Set<String> = (listaCursoA - listaCursoB).toSet()
    val subtracao: Set<String> = (listaCursoA subtract listaCursoB).toSet()
    println(subtracao)

    val intersecao: Set<String> = (listaCursoA intersect listaCursoB).toSet()
    println(intersecao)
}