package br.com.alura.jpa.testes;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentcao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TesteRelacionamento {
    public static void main(String[] args){
        Conta conta = new Conta();
        conta.setNumero(123);
        conta.setAgencia(4312);
        conta.setTitular("Rafael");
        conta.setSaldo(200.);

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setConta(conta);
        movimentacao.setData(LocalDateTime.now());
        movimentacao.setDescricao("Freelance");
        movimentacao.setValor(new BigDecimal(200.39));
        movimentacao.setTipoMovimentacao(TipoMovimentcao.ENTRADA);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(conta);//pois esta conta não existe
        em.persist(movimentacao);
        em.getTransaction().commit();
    }
}
