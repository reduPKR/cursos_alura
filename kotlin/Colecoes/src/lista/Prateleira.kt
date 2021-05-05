package lista

/*
* O list é imutavel, ou seja quando eu reordeno, ele gera uma nova lista
* isso evita o problema de fazer duas ordenações diferentes e uma afetar a outra
* */
data class Prateleira(
    val genero:String,
    val livros:List<Livro>
    ) {

    fun organizarLivrosPorAutor(): List<Livro> {
        return livros.sortedBy { it.autor }
    }

    fun organizarPorAno(): List<Livro> {
        livros.sortedBy { it.anoPublicacao }
        return livros
    }
}
