package agregacao

import java.math.BigDecimal
import java.math.RoundingMode

fun testSalarioBigDecimal() {
//    val salarios = Array<BigDecimal>(5) { BigDecimal.ZERO }
//    salarios[0] = "1500.55".toBigDecimal()
//    salarios[1] = "2398.12".toBigDecimal()
//    salarios[2] = "2300.45".toBigDecimal()
//    salarios[3] = "9265.38".toBigDecimal()
//    salarios[4] = "4475.49".toBigDecimal()
//    println(salarios.contentToString())

    val salarios = minhaCriacaoDeArray("1234.55", "7912.12", "2300.45", "8392.74", "3123.29")
    println(salarios.contentToString())

    val aumento = "1.1".toBigDecimal()
    //Ele retorna lista por isso converti para array
//  val novoSalario = salarios.map { salario -> (salario * aumento).setScale(2, RoundingMode.UP) }.toTypedArray()

    val novoSalario = salarios.map { salario ->
        calculaSalarioRelativo(salario, aumento)
    }.toTypedArray()

    println(novoSalario.contentToString())

    val gastoMes = novoSalario.somatoria()
    println(gastoMes)

    val meses = 6.toBigDecimal()
    val gastoTotal = novoSalario.fold(gastoMes) { acumulador, salario ->
        acumulador + (salario * meses).setScale(2, RoundingMode.UP)
    }
    println(gastoTotal)

//    val salarioOrdenado = novoSalario.sorted()
//    val top3Maiores = salarioOrdenado.takeLast(3).toTypedArray()
//    val media = top3Maiores.media()
//    println(top3Maiores.contentToString())

    //Mesma coisa porem utilizando tecnica de encadeamento
    //vantagem nao cria variaveis que só existem para manter o valor usado uma vez
    val mediaMaior = novoSalario
        .sorted()
        .takeLast(3)
        .toTypedArray()
        .media()
    println("Media dos tres maiores salarios $mediaMaior")

    val mediaMenor = novoSalario
        .sorted()
        .take(3)
        .toTypedArray()
        .media()
    println("Media dos tres menores salarios $mediaMenor")
}

fun minhaCriacaoDeArray(vararg valores: String): Array<BigDecimal> {
    return Array(valores.size) { indice ->
        valores[indice].toBigDecimal()
    }
}

private fun calculaSalarioRelativo(
    salario: BigDecimal,
    aumento: BigDecimal
) = if (salario >= "5000".toBigDecimal()) {
    (salario * aumento).setScale(2, RoundingMode.UP)
} else {
    salario + "500".toBigDecimal()
}

private fun Array<BigDecimal>.somatoria(): BigDecimal {
    return this.reduce { acumulador, valor -> acumulador + valor }
}

private fun Array<BigDecimal>.media(): BigDecimal {
    if (this.isEmpty())
        return BigDecimal.ZERO

    return (this.somatoria() / this.size.toBigDecimal()).setScale(2, RoundingMode.UP)
}