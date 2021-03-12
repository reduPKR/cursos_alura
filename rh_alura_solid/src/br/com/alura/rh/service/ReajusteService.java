package br.com.alura.rh.service;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

public class ReajusteService {
    public void reajustarSalarioFuncionario(Funcionario funcionario, BigDecimal aumento){
        BigDecimal salarioAtual = funcionario.getSalario();
        BigDecimal percentualReajuste = aumento.divide(salarioAtual, RoundingMode.HALF_UP);

        if(percentualReajuste.compareTo(new BigDecimal("0.4")) > 0){
            throw new ValidacaoException("Reajuste nao pode ser acima de 40%");
        }
        funcionario.setSalario(funcionario.getSalario().add(aumento));
    }
}
