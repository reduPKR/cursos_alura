package br.com.alura.spring.data.specification;

import br.com.alura.spring.data.orm.Funcionario;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public class FuncionarioSpecification {
    public static Specification<Funcionario> likeNome(String nome){
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(root.get("nome"), "%"+nome+"%");
                //Equivale a funcionario.getNome()

    }
    public static Specification<Funcionario> equalCpf(String cpf){
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("cpf"), cpf);
    }

    public static Specification<Funcionario> greaterThanSalario(Double salario){
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.greaterThan(root.get("salario"),salario);
    }

    public static Specification<Funcionario> greaterThanData(LocalDateTime data){
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.greaterThan(root.get("dataContratacao"),data);
    }
}
