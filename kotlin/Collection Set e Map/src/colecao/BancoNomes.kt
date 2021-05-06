package colecao

class BancoNomes {
    //Funciona normal, porem vou usar companion
    // private val dados = mutableListOf<String>()
    val nomes: Collection<String> get() = dados.toList()//Evita bugs de referencia

    fun adicionarNome(nome: String){
        dados.add(nome)
    }

    companion object {
        private val dados = mutableListOf<String>()
    }
}