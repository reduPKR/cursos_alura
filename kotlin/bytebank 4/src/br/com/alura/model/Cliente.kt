package br.com.alura.model

class Cliente(
    val nome: String,
    val cpf: String,
    private val senha: Int,
    var endereco: Endereco = Endereco()
) : Autenticavel {
    override fun autenticacao(senha: Int): Boolean {
        if (this.senha == senha)
            return true
        return false
    }

    override fun toString(): String {
        return "Cliente(nome='$nome', cpf='$cpf', senha=$senha)"
    }

    fun toStringRaw(): String {
        return """Cliente(
            |nome='$nome', 
            |cpf='$cpf', 
            |senha=$senha)""".trimMargin()
    }

    override fun equals(other: Any?): Boolean {
        if(other != null && other is Endereco){
            return this.endereco.cep == other.cep
        }
        return false
    }

}