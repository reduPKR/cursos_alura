package br.com.alura.model

abstract class Funcionario(
    val nome: String,
    val cpf: String,
    var salario: Double
) {

    //    open fun bonificacao(): Double {
//        return salario * 0.1
//    }
    //Ou seguindo padrao kotlin
    open val bonificacao: Double
        get() {
            return salario * 0.1
        }
    //Caso usar abstract é igual o filho escreve a função
    //abstract val bonificacao: Double
}