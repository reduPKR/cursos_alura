import br.com.alura.model.Cliente
import br.com.alura.model.Diretor
import br.com.alura.model.Gerente
import br.com.alura.model.SistemaInterno

fun testeAutenticacao() {
    val sistemaInterno = SistemaInterno()

    val cliente = Cliente("cliente", "111.111.111-11", 1234)
    println(cliente.nome)
    sistemaInterno.entra(cliente, 1234)
    println("*******************************")

    val gerente = Gerente("gerente", "111.111.111-11", 3000.0, 1234)
    println(gerente.nome)
    sistemaInterno.entra(gerente, 1234)
    println("*******************************")

    val diretor = Diretor("diretor", "111.111.111-11", 4000.0, 1234, 1000.0)
    println(diretor.nome)
    sistemaInterno.entra(diretor, 1234)
    println("*******************************")
}