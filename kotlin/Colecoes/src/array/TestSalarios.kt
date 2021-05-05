package array

fun testSalarios() {
    val salarios = doubleArrayOf(
        2500.0,
        10500.90,
        3900.0,
        4590.78,
        7890.10
    )
    println(salarios.contentToString())

    val aumento = 1.1

    calculoAumentoFor(salarios, aumento)
    calculoForComIndice(salarios, aumento)
    calculoForEachIndexed(salarios, aumento)
}

private fun calculoForEachIndexed(salarios: DoubleArray, aumento: Double) {
    salarios.forEachIndexed { indice, salario ->
        salarios[indice] = salario * aumento
    }
    println(salarios.contentToString())
}

fun calculoForComIndice(salarios: DoubleArray, aumento: Double) {
    //Vantagem diminui a chances de erros
    for (indice in salarios.indices) {
        salarios[indice] = salarios[indice] * aumento
    }
    println(salarios.contentToString())
}

fun calculoAumentoFor(salarios: DoubleArray, aumento: Double) {
    var indice = 0
    //Esse salario é imutavel ou seja não posso fazer salario = salario * ...
    for (salario in salarios) {
        salarios[indice++] = salario * aumento
    }
    println(salarios.contentToString())
}