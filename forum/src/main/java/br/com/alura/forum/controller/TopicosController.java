package br.com.alura.forum.controller;

import br.com.alura.forum.dto.TopicoDTO;
import br.com.alura.forum.model.Curso;
import br.com.alura.forum.model.Topico;
import br.com.alura.forum.service.CursoService;
import br.com.alura.forum.service.TopicoService;
import br.com.alura.forum.form.TopicoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicosController {
    @Autowired
    private TopicoService topicoService;

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<TopicoDTO> lista(String cursoNome){
        if(cursoNome == null)
            return TopicoDTO.converter(topicoService.findAll());
        else
            return TopicoDTO.converter(topicoService.findByCursoNome(cursoNome));
    }

    @PostMapping
    public void cadastrar(@RequestBody TopicoForm topicoForm){
        Curso curso = cursoService.findByName(topicoForm.getNomeCurso());
        Topico topico = topicoForm.conveter(curso);
        topicoService.save(topico);
    }
}
