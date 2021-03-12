package br.com.alura.rh.model.funcionarios;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Cargo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Funcionario {
    private DadosPessoais dadosPessoais;
    private BigDecimal salario;
    private LocalDate dataUltimoReajuste;

    public Funcionario(DadosPessoais dadosPessoais, BigDecimal salario, LocalDate dataUltimoReajuste) {
        this.dadosPessoais = dadosPessoais;
        this.salario = salario;
        this.dataUltimoReajuste = dataUltimoReajuste;
    }

    /*Foi chamado pelo metodo do Reajuste service*/
    public void setSalario(BigDecimal salario) {
        this.salario = salario;
        this.dataUltimoReajuste = LocalDate.now();
    }

    public DadosPessoais getDadosPessoais() {
        return dadosPessoais;
    }

    public void setDadosPessoais(DadosPessoais dadosPessoais) {
        this.dadosPessoais = dadosPessoais;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public LocalDate getDataUltimoReajuste() {
        return dataUltimoReajuste;
    }

    public void setDataUltimoReajuste(LocalDate dataUltimoReajuste) {
        this.dataUltimoReajuste = dataUltimoReajuste;
    }
}
