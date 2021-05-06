fun testFunctionType() {
    val minhaFuncao: (Int, Int) -> Double = ::divisao
    println(minhaFuncao(30, 5))

    val minhaClasse: (Int, Int) -> Int = Soma()
    println(minhaClasse(3, 9))
}

fun divisao(numerator: Int, denominador: Int): Double{
    if(denominador == 0)
        return 0.0
    return numerator.toDouble()/denominador
}

class Soma: (Int, Int) -> Int{
    override fun invoke(a: Int, b: Int): Int {
        return a + b
    }

}