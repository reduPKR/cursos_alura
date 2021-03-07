package br.com.alura.forum.Service;

import br.com.alura.forum.TopicoRepository;
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
}
