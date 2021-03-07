package br.com.alura.forum.service;

import br.com.alura.forum.repository.TopicoRepository;
import br.com.alura.forum.model.Topico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository repository;

    public List<Topico> findAll() {
        return repository.findAll();
    }

    public List<Topico> findByCursoNome(String cursoNome) {
        return repository.findByCursoNome(cursoNome);
    }

    public void save(Topico topico) {
        repository.save(topico);
    }
}
