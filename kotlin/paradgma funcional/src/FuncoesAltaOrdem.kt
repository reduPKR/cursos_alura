fun testFuncaoAltaOrdem() {
    //val endereco = Endereco("Brasilia", 295)
    //val enderecoMaiusculo = "${endereco.logradouro}, ${endereco.numero} ".toUpperCase()

    //Reduz o uso de uma variavel, transformei em string e modifique para toUpper
    Endereco("Brasilia", 295)
        .let { endereco -> "${endereco.logradouro}, ${endereco.numero} ".toUpperCase()}
        .let(::println) //.let { enderecoMaiusculo -> println(enderecoMaiusculo) }

    soma(5, 4){
        println(it)
    }
    soma(5, 4, resultado = {valor -> println(valor)})
    somaReceiver(5, 4, resultado = { println(this)})
}

fun soma(a: Int, b:Int, resultado: (Int)->Unit){
    println("Soma sendo executada")
    resultado(a+b)
}

fun somaReceiver(a: Int, b:Int, resultado: Int.()->Unit){
    println("Soma receiver sendo executada")
    val total = a+b
    total.resultado()
    //total.resultado(1) no arg teria Int.(int)->Unit
}