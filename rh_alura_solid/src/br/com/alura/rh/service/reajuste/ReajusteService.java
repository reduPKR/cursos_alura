package br.com.alura.rh.service.reajuste;

import br.com.alura.rh.model.funcionarios.Funcionario;
import br.com.alura.rh.service.reajuste.validacao.ValidacaoReajuste;

import java.math.BigDecimal;
import java.util.List;

public class ReajusteService {
    /*Dessa maneira nao preciso conhecer cada validação, é só uma lista*/
    private List<ValidacaoReajuste> validacoes;
    public ReajusteService(List<ValidacaoReajuste> validacoes) {
        this.validacoes = validacoes;
    }

    public void reajustarSalarioFuncionario(Funcionario funcionario, BigDecimal aumento){
        validacoes.forEach(validacao -> validacao.validar(funcionario,aumento));
        funcionario.setSalario(funcionario.getSalario().add(aumento));
    }
}
