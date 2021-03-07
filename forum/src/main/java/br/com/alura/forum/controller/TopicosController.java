package br.com.alura.forum.controller;

import br.com.alura.forum.DTO.TopicoDTO;
import br.com.alura.forum.Service.TopicoService;
import br.com.alura.forum.model.Curso;
import br.com.alura.forum.model.Topico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicosController {
    @Autowired
    private TopicoService service;

    @GetMapping
    public List<TopicoDTO> lista(String cursoNome){
        if(cursoNome == null)
            return TopicoDTO.converter(service.findAll());
        else
            return TopicoDTO.converter(service.findByCursoNome(cursoNome));
    }
}
