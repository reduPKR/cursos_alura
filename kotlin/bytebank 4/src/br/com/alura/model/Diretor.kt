package br.com.alura.model

class Diretor(
    nome: String,
    cpf: String,
    salario: Double,
    senha: Int,
    val plr: Double
) : FuncionarioAdmin(nome, cpf, salario, senha) {

    override val bonificacao: Double
        get() {
            return super.bonificacao + plr
        }
}