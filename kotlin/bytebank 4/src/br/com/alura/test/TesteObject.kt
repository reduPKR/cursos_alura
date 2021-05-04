package br.com.alura.test

import br.com.alura.model.Autenticavel
import br.com.alura.model.SistemaInterno


fun testeObject(){
    //val rafael = Cliente("rafael", "111", 1234)
    val rafael = object : Autenticavel{
        val nome: String = "Rafael"
        val cpf: String = "111"
        private val senha: Int = 1234

        override fun autenticacao(senha: Int) = this.senha == senha
    }

    val sistemaInterno = SistemaInterno()
    sistemaInterno.entra(rafael, 1234)
}