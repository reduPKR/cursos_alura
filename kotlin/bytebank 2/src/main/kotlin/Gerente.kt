open class Gerente (nome: String,
                    cpf: String,
                    salario: Double,
                    senha: Int) : FuncionarioAdmin(nome, cpf, salario, senha){
//Caso tivese mais de uma implementação
//    override fun autenticacao(senha: Int): Boolean {
//        return super<FuncionarioAdmin>.autenticacao(senha)
//    }
}