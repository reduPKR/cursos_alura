package br.com.alura.rh.service.promocao;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Cargo;
import br.com.alura.rh.model.funcionarios.Funcionario;

public class PromocaoService {
    public void promover(Funcionario funcionario, boolean metaBatida){
        Cargo cargoAtual = funcionario.getCargo();

        if(Cargo.GERENTE == cargoAtual){
            throw new ValidacaoException("Gerente nao pode ser promovido");
        }

        if(!metaBatida){
            throw new ValidacaoException("Funcionario não pode ser promovido por nao cumprir a meta");
        }

        Cargo novoCargo = cargoAtual.getProximoCargo();
        funcionario.setCargo(novoCargo);
    }
}
