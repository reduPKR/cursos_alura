package lista

fun main(){
    val livro1 = Livro("livro 1", "rafael", 2020, "Editora 1")
    val livro2 = Livro("livro 2", "eduardo", 2018, "Editora 2")
    val livro3 = Livro("livro 3", "sara", 2017, "Editora 1")

    val lista: MutableList<Livro> = mutableListOf(livro1, livro2, livro3)
    lista.add(Livro("livro do futuro", "dante", 2040))

    val prateleira = Prateleira("Literatura", lista)

    prateleira.organizarLivrosPorAutor().imprimeComMarcador()
}