package br.com.alura.jpa.testes;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentcao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

public class TestaRelacionamentoMovimentacaoCategoria {
    public static void main(String[] args) {
        Categoria categoria1 = new Categoria("Viagem");
        Categoria categoria2 = new Categoria("Ferias");

        Conta conta = new Conta();
        conta.setId(1L);

        Movimentacao movimentacao1 = new Movimentacao();
        movimentacao1.setConta(conta);
        movimentacao1.setData(LocalDateTime.now());
        movimentacao1.setDescricao("Viagem gramado");
        movimentacao1.setValor(new BigDecimal(700.));
        movimentacao1.setTipoMovimentacao(TipoMovimentcao.SAIDA);
        movimentacao1.setCategorias(Arrays.asList(categoria1,categoria2));

        Movimentacao movimentacao2 = new Movimentacao();
        movimentacao2.setConta(conta);
        movimentacao2.setData(LocalDateTime.now());
        movimentacao2.setDescricao("Volta de gramado");
        movimentacao2.setValor(new BigDecimal(700.));
        movimentacao2.setTipoMovimentacao(TipoMovimentcao.SAIDA);
        movimentacao2.setCategorias(Arrays.asList(categoria1,categoria2));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.persist(categoria1);
        em.persist(categoria2);
        em.persist(movimentacao1);
        em.persist(movimentacao2);

        em.getTransaction().commit();;
    }
}
