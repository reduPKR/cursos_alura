package br.com.alura.model

import br.com.alura.model.FuncionarioAdmin

open class Gerente (nome: String,
                    cpf: String,
                    salario: Double,
                    senha: Int) : FuncionarioAdmin(nome, cpf, salario, senha){
//Caso tivese mais de uma implementação
//    override fun autenticacao(senha: Int): Boolean {
//        return super<model.FuncionarioAdmin>.autenticacao(senha)
//    }
}