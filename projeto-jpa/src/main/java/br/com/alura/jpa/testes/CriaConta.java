package br.com.alura.jpa.testes;

import br.com.alura.jpa.modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriaConta {
    public static void main(String[] args){
        Conta conta = new Conta();
        conta.setTitular("Eduardo");
        conta.setAgencia(4321);
        conta.setNumero(1234);
        conta.setSaldo(1000.59);
        persistirConta(conta);
    }

    private static void persistirConta(Conta conta) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(conta);
        em.getTransaction().commit();
    }
}
