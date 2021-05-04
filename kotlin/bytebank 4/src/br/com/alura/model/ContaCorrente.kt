package br.com.alura.model

import br.com.alura.model.Conta

class ContaCorrente (
    titular: Cliente,
    numero: Int
) : Conta(
    titular,
    numero
) {
    override fun sacar(valor: Double) {
        val valorComTaxa = valor + 0.1;
//        super.sacar(valorComTaxa)
        if (saldo >= valorComTaxa)
            saldo -= valorComTaxa
    }
}