interface Autenticavel {
    // Poderia implementar assim, porem n tem como proteger a senha dentro da interface
//    val senha: Int
//
//    fun autenticacao(senha: Int): Boolean {
//        if (this.senha == senha)
//            return true
//        return false
//    }
    fun autenticacao(senha: Int): Boolean
}