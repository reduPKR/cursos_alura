class Endereco(
    var logradouro: String = "",
    var numero: Int = 0,
    var bairro: String = "",
    var cidade: String = "",
    var estado: String = "",
    var cep: String = "",
    var compelento: String = "",
) {
    fun completo(): String {
        return """$logradouro - $numero, $bairro, $cidade. $estado
            $cep
            $compelento
        """.trimIndent()
    }

}
