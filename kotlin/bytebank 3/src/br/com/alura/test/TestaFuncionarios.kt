import br.com.alura.model.Analista
import br.com.alura.model.Diretor
import br.com.alura.model.Gerente
import br.com.alura.model.SistemaInterno

fun testaFuncionarios() {
    val sistemaInterno = SistemaInterno()

    val analista = Analista("analista", "111.111.111-11", 2000.0)
    println(analista.nome)
    println(analista.cpf)
    println(analista.salario)
    println(analista.bonificacao)
    println("*******************************")

    val gerente = Gerente("gerente", "111.111.111-11", 3000.0, 1234)
    println(gerente.nome)
    println(gerente.cpf)
    println(gerente.salario)
    println(gerente.bonificacao)
    sistemaInterno.entra(gerente,1234)
    println("*******************************")

    val diretor = Diretor("diretor", "111.111.111-11", 4000.0, 1234, 1000.0)
    println(diretor.nome)
    println(diretor.cpf)
    println(diretor.salario)
    println(diretor.bonificacao)
    sistemaInterno.entra(diretor,2345)
    println("*******************************")
}