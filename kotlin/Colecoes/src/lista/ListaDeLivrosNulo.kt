package lista

fun main(){
    val livro1 = Livro("livro 1", "rafael", 2020, "Editora 1")
    val livro2 = Livro("livro 2", "eduardo", 2018, "Editora 1")
    val livro3 = Livro("livro 3", "sara", 2017, "Editora 1")

    val livros: MutableList<Livro?> = mutableListOf(livro1, null, null, livro2, null, livro3)
    livros.add(Livro("livro do futuro", "dante", 2040))

    livros.imprimeComMarcador()
}

fun List<Livro?>.imprimeComMarcador() {
    val texto = this
        .filterNotNull()//.filter { it != null }
        .joinToString(separator = "\n") {
        "- ${it?.titulo} de ${it?.autor}"
    }
    println("########Lista de livros com nulo###########\n$texto")
}