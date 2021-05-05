package agregacao

fun testOperacoesAgregadoras(){
    val idades = intArrayOf(14,56,17,19,22)
    val maiorIdade = idades.max()
    val menorIdade = idades.min()
    val media: Double = idades.average()

    println("Maior idade $maiorIdade")
    println("Menor idade $menorIdade")
    println("Media de idades $media")

    val todosMaiores = idades.all { it >= 18 }
    println("Todos sao maiores: $todosMaiores")

    val existeMaiorDeIdade = idades.any{ it >= 18}
    println("Existe pelo menos um maior de idade: $existeMaiorDeIdade")

    val  maiores = idades.filter { it >= 18 }
    println("Lista dos maiores de 18: $maiores")

    //Busca pelo primeiro elemento que satisfaz a condição
    val valor = idades.find { it == 19 }
    println("Busca do retornou $valor")
}