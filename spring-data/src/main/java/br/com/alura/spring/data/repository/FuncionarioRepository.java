package br.com.alura.spring.data.repository;

import br.com.alura.spring.data.orm.Funcionario;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Long>, JpaSpecificationExecutor<Funcionario> {
    List<Funcionario> findByNome(String nome);//derived query

    @Query("select f from Funcionario f where f.nome = :nome AND" +
            "f.salario >= : salario AND f.dataContatacao = :data")
    List<Funcionario> findByJPQL(String nome, double salario, LocalDateTime data);

    @Query(value = "Select * from funcionarios f where f.data_contratacao >= :data")
    List<Funcionario> findDataContatacaoMaior(LocalDateTime data);//native query ou sql comum
}
