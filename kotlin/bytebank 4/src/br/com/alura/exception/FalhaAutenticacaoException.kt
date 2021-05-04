package br.com.alura.exception

class FalhaAutenticacaoException(mensagem: String = "Erro ao se autenticar"): Exception(mensagem) {
}