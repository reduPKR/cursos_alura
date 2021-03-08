package br.com.alura.forum.service;

import br.com.alura.forum.dto.DetalhesTopicoDTO;
import br.com.alura.forum.dto.TopicoDTO;
import br.com.alura.forum.repository.TopicoRepository;
import br.com.alura.forum.model.Topico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository repository;

    public Page<Topico> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Page<Topico> findByCursoNome(String cursoNome, Pageable pageable) {
        return repository.findByCursoNome(cursoNome, pageable);
    }

    public void save(Topico topico) {
        repository.save(topico);
    }

    public ResponseEntity<DetalhesTopicoDTO> findDetailById(Long id) {
        Optional<Topico> topico = repository.findById(id);
        if(topico.isPresent())
            return ResponseEntity.ok(new DetalhesTopicoDTO(topico.get()));
        return ResponseEntity.notFound().build();
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
