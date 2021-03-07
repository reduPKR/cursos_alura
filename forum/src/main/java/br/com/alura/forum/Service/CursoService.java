package br.com.alura.forum.service;

import br.com.alura.forum.model.Curso;
import br.com.alura.forum.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CursoService {
    @Autowired
    private CursoRepository repository;

    public Curso findByName(String nomeCurso) {
        return repository.findByName(nomeCurso);
    }
}
