package br.com.alura.jpa.testes;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

import javax.persistence.*;
import java.util.List;

public class TesteJPQL {
    public static void main(String[] args) {
        // 1 String sql = "select * from movimentacao where conta_id = 2";
        // 2 String jpql = "select m from Movimentacao m where m.conta.id = 2";
        //Abstração total do sql
        Conta conta = new Conta();
        conta.setId(2L);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        String jpql = "select m from Movimentacao m where m.conta = :pConta order by m.valor";

        //Assim funciona mas fica aparecendo warning
//        Query query = em.createQuery(jpql);
//        query.setParameter("pConta", conta);
//        List<Movimentacao> result = query.getResultList();

        TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class);
        query.setParameter("pConta", conta);
        List<Movimentacao> result = query.getResultList();

        System.out.println("-------------------");
        for (Movimentacao item: result) {
            System.out.println("Descrição: "+item.getDescricao());
            System.out.println("T. movimentação: "+item.getTipoMovimentacao());
        }
    }
}
