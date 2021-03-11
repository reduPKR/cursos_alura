package br.com.alura.forum.repository;

import br.com.alura.forum.model.Curso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class CursoRepositoryTest {
    @Autowired
    private CursoRepository repository;

    @Test
    public void findByNomeVaiPassar() {
        String nome = "HTML 5";

        Curso novoCurso = new Curso();
        novoCurso.setNome(nome);
        novoCurso.setCategoria("Programção web");
        repository.save(novoCurso);

        Curso curso = repository.findByNome(nome);

        /*Assert nao deu certo*/
        Assertions.assertNotNull(curso);
        Assertions.assertEquals(nome,curso.getNome());
    }

    @Test
    public void findByNomeVaiFalhar() {
        String nome = "HTML 5";
        Curso curso = repository.findByNome(nome);

        /*Assert nao deu certo*/
        Assertions.assertNull(curso);
    }
}