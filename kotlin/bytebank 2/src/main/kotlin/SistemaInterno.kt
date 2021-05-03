class SistemaInterno {
    fun entra(admin: Autenticavel, senha: Int){
        if(admin.autenticacao(senha))
            println("Autenticado")
        else
            println("Erro na autenticação")
    }
}