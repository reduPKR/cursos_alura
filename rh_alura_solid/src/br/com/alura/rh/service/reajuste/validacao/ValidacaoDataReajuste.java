package br.com.alura.rh.service.reajuste.validacao;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.funcionarios.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ValidacaoDataReajuste implements ValidacaoReajuste {
    public void validar(Funcionario funcionario, BigDecimal aumento){
        LocalDate ultimoReajuste = funcionario.getDataUltimoReajuste();
        LocalDate dataAtual = LocalDate.now();
        long meses = ChronoUnit.MONTHS.between(ultimoReajuste,dataAtual);

        if(meses < 6 ){
            throw new ValidacaoException("Ultimo reajuste foi a menos de 6 meses");
        }
    }
}
