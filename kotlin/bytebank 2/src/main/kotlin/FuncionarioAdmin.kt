abstract class FuncionarioAdmin(
    nome: String,
    cpf: String,
    salario: Double,
    protected val senha: Int
) : Funcionario(nome, cpf, salario), Autenticavel{//Se for aqui o Autenticavel n precisa por no gerente nem no diretor
    override fun autenticacao(senha: Int): Boolean {
        if (this.senha == senha)
            return true
        return false
    }

    override val bonificacao: Double
        get() {
            return super.bonificacao + salario
        }
}