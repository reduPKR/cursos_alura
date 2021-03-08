package br.com.alura.forum.service;

import br.com.alura.forum.dto.DetalhesTopicoDTO;
import br.com.alura.forum.dto.TopicoDTO;
import br.com.alura.forum.repository.TopicoRepository;
import br.com.alura.forum.model.Topico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public DetalhesTopicoDTO findDetailById(Long id) {
        Optional<Topico> topico = repository.findById(id);
        if(topico.isPresent())
            return new DetalhesTopicoDTO(topico.get());
        return null;
    }

    public Topico findById(Long id) {
        Optional<Topico> topico = repository.findById(id);
        if(topico.isPresent())
            return topico.get();
        return null;
    }

    public void deleteByid(long id) {
        repository.deleteById(id);
    }
}
