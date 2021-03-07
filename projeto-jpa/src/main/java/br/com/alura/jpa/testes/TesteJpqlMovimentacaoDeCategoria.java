package br.com.alura.jpa.testes;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Movimentacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class TesteJpqlMovimentacaoDeCategoria {
    public static void main(String[] args) {
        Categoria categoria = new Categoria();
        categoria.setId(2L);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        String jpql = "select m from Movimentacao m join m.categorias c where c = :pCategoria";

        TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class);
        query.setParameter("pCategoria", categoria);
        List<Movimentacao> result = query.getResultList();

        System.out.println("-------------------");
        for (Movimentacao item: result) {
            System.out.println("Categoria: "+item.getCategoriasTexto());
            System.out.println("Descrição: "+item.getDescricao());
            System.out.println("T. movimentação: "+item.getTipoMovimentacao());
        }
    }
}
