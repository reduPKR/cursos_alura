package array


fun exibeMaiorIdadeForEach(idades: IntArray) {
    println("Exibindo com forEach")
    var maior = Int.MIN_VALUE
    idades.forEach { idade ->
        if (idade > maior) {
            maior = idade
        }
    }
    println(maior)
}

fun exibeMaiorIdadeFor(idades: IntArray) {
    println("Exibindo com for")
    var maior = Int.MIN_VALUE
    for (idade in idades) {
        if (idade > maior) {
            maior = idade
        }
    }

    println(maior)
}

fun testIntArrayOf() {
    val idades: IntArray = intArrayOf(25, 19, 33, 27)
    exibeMaiorIdadeFor(idades)
    exibeMaiorIdadeForEach(idades)
}

fun testIntArray() {
    val idades = IntArray(4)
    idades[0] = 25
    idades[1] = 19
    idades[2] = 33
    idades[3] = 27
    exibeMaiorIdadeFor(idades)
    exibeMaiorIdadeForEach(idades)
}