package br.com.alura.exception

import java.lang.Exception

//class SaldoInsuficienteException: Throwable() {
class SaldoInsuficienteException(mensagem: String = "O Saldo é insuficiente"): Exception(mensagem){
}