import br.com.alura.model.Endereco

//variavel global
//var totalContas: Int = 0

//Object declaration -> singlethon
//object Contador{
//    var total = 0
//}

fun main() {
    println("Bem vindo ao bytebank!");

//    testeComportamento()
//    testaFuncionarios()
//    testeContas()
//    testeAutenticacao()
//    testeObject()
    //testeContador()
    // testeAny()
    //testeString()
    //testeTryCatch()
    testeNull()
}

fun testeNull(){
    val endereco: Endereco? = null
    println(endereco?.cidade)

    var endereco2: Endereco? = Endereco(cidade = "Presidente Prudente")
    println(endereco2?.cidade)
    endereco2?.let { item: Endereco ->
        println(item.cidade.length)
    }

    //Elvis
    val cidade: String? = null
    val tamanho: Int = cidade?.length ?: 0
    println(tamanho)
}
