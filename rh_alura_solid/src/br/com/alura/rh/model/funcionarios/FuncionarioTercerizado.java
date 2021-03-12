package br.com.alura.rh.model.funcionarios;

import java.math.BigDecimal;

public class FuncionarioTercerizado{
    private DadosPessoais dadosPessoais;
    private String empresa;

    public FuncionarioTercerizado(DadosPessoais dadosPessoais, String empresa) {
        this.dadosPessoais = dadosPessoais;
        this.empresa = empresa;
    }

    public DadosPessoais getDadosPessoais() {
        return dadosPessoais;
    }

    public void setDadosPessoais(DadosPessoais dadosPessoais) {
        this.dadosPessoais = dadosPessoais;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
}
