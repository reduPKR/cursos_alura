import lista.Livro

fun main() {
    val livro1 = Livro("livro 1", "rafael", 2020, "Editora 1")
    val livro2 = Livro("livro 2", "eduardo", 2018, "Editora 2")
    val livro3 = Livro("livro 3", "sara", 2017, "Editora 1")

    val livros: MutableList<Livro> = mutableListOf(livro1, livro2, livro3)
    livros.add(Livro("livro do futuro", "dante", 2040))

    livros.imprimeComMarcador()
    livros.remove(livro1)
    livros.imprimeComMarcador()

    //Criei o comparable, ele é uma função de comparação natural
    //Ou seja só da para ordenar por ano com o sorted agora
    val ordenado = livros.sorted()
    ordenado.imprimeComMarcador();

    //Para ordenar por qualquer atributo
    val ordenadoPorTitulo = livros.sortedBy { it.titulo }

    val filtrado = livros.filter { it.autor == "eduardo" }
    filtrado.imprimeComMarcador()

    val filtrado2 = livros
        .filter { it.autor.startsWith("dante") }
        .sortedBy { it.anoPublicacao }
        .imprimeComMarcador()

    val titulos = livros
        .filter { it.autor.startsWith("dante") }
        .sortedBy { it.anoPublicacao }
        .map { it.titulo }
    println(titulos)

    println("Agrupamento")
    livros
        //.groupBy { it.editora }//agrupar pela editora
        .groupBy { it.editora ?: "Editora desconhecida" }
        .forEach{(editora,livros) ->
            println("$editora: ${livros.joinToString { it.titulo }}")
        }
}

//fun MutableList<lista.Livro>.imprimeComMarcador(){
//Usei lista que é mais generico funciona para o mutabllist e para o list
fun List<Livro>.imprimeComMarcador() {
    val texto = this.joinToString(separator = "\n") {
        "- ${it.titulo} de ${it.autor}"
    }
    println("########Lista de livros###########\n$texto")
}