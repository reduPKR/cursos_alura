package br.com.alura.rh.service.reajuste.validacao;

import br.com.alura.rh.model.funcionarios.Funcionario;

import java.math.BigDecimal;

public interface ValidacaoReajuste {
    void validar(Funcionario funcionario,  BigDecimal aumento);
}
