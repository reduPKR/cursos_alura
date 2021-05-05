package agregacao

fun testRange(){
    val series: IntRange = 1.rangeTo(10)
    for(s in series){
        print("$s ")
    }

    //sintaxe sugar
    println()
    val sugar = 0..100
    for(s in sugar){
        print("$s ")
    }

    println()
    val numerosPares = 0..100 step 2
    for(numero in numerosPares){
        print("$numero ")
    }

    println()
    val numerosPares2 = 0.until(100) step 2
    for(numero in numerosPares2){
        print("$numero ")
    }

    println()
    val reverso= 100 downTo 0 step 2
    reverso.forEach{ print("$it ")}

    println()
    val lista = 1000..5000
    val valor = 3000
    //in no for faz um interador
    //in no if faz uma verificação
    if(valor in lista){
        println("$valor esta presente na lista")
    }else{
        println("$valor não esta presente na lista")
    }

    val alfabeto = 'a'..'z'
    val letra = 'k'
    println(letra in alfabeto)
    println('K' in alfabeto)//Apenas letras minusculas estao no alfabetos
}