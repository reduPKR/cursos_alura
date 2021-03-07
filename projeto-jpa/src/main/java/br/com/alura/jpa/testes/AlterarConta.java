package br.com.alura.jpa.testes;

import br.com.alura.jpa.modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlterarConta {
    public static void main(String[] args){
        alterar(1L);
    }

    private static void alterar(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();
        Conta conta = em.find(Conta.class, id);

        conta.setNumero(9876);
        conta.setSaldo(150.00);

        em.getTransaction().begin();
        em.persist(conta);
        em.getTransaction().commit();
        em.close();
    }
}
