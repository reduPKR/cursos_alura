fun testLambdaAnonima() {
//    val minhaFuncaoLambda: () -> Unit = {
//        println("Executa como lambda")
//    }
//    println(minhaFuncaoLambda)
    //Caso tenha um caso que a declaracao tem mais args, posso usar o _ ex: a, b, _ isso fala que nao vou usar
    val minhaFuncaoLambda: (Int, Int) -> Int = { a, b ->
        a + b
    }
    println(minhaFuncaoLambda(10, 9))

//    val minhaFuncaoAnonima: () -> Unit = fun() {
//        println("Executa função anonima")
//    }
//    println(minhaFuncaoAnonima)
    val minhaFuncaoAnonima = fun(a: Int, b: Int): Int {
        return a + b
    }
    println(minhaFuncaoAnonima(5, 7))

    //Caso tenha que retornar um valor que nao seja o ultimo
    //Da para adicionar um marcador (salario: Double) ou (Double)
    //Para retornar algo que n seja o ultimo nomeVariavel@
    val calculaBonificacao: (salario: Double) -> Double = retorno@{ salario ->
        if (salario > 1000.0)
            return@retorno salario + 100
        salario + 200
    }
    println(calculaBonificacao(1100.0))

    val calculaBonificacaoAnonima: (salario: Double) -> Double = fun (salario): Double{ salario
        if (salario > 1000.0)
            return salario + 100
        return salario + 200
    }
    println(calculaBonificacaoAnonima(1100.0))
}