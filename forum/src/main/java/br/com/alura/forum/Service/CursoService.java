package br.com.alura.forum.service;

import br.com.alura.forum.model.Curso;
import br.com.alura.forum.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {
    @Autowired
    private CursoRepository repository;

    public Curso findByNome(String nomeCurso) {
        return repository.findByNome(nomeCurso);
    }
}
