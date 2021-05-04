package br.com.alura.model

import br.com.alura.model.Conta

class ContaPoupanca(
    titular: Cliente,
    numero: Int
) : Conta(
    titular,
    numero
) {
    override fun sacar(valor: Double) {
        if (saldo >= valor)
            saldo -= valor
    }
}