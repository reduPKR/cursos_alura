package br.com.alura.forum.controller;

import br.com.alura.forum.form.AtualizacaoTopicoForm;
import br.com.alura.forum.dto.DetalhesTopicoDTO;
import br.com.alura.forum.dto.TopicoDTO;
import br.com.alura.forum.form.TopicoForm;
import br.com.alura.forum.model.Topico;
import br.com.alura.forum.service.CursoService;
import br.com.alura.forum.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicosController {
    @Autowired
    private TopicoService topicoService;

    @Autowired
    private CursoService cursoService;

//    @GetMapping
//    public List<TopicoDTO> lista(String cursoNome){
//        if(cursoNome == null)
//            return TopicoDTO.converter(topicoService.findAll());
//        else
//            return TopicoDTO.converter(topicoService.findByCursoNome(cursoNome));
//    }

//    @GetMapping paginação 1
//    public Page<TopicoDTO> lista(@RequestParam(required = false) String cursoNome,
//                                 @RequestParam int pagina,
//                                 @RequestParam int qtde,
//                                 @RequestParam String ordem) {
//        Pageable pageable = PageRequest.of(pagina, qtde, Sort.Direction.ASC, ordem);
//
//        if (cursoNome == null)
//            return TopicoDTO.converter(topicoService.findAll(pageable));
//        else
//            return TopicoDTO.converter(topicoService.findByCursoNome(cursoNome, pageable));
//    }

    @GetMapping
    @Cacheable(value = "listaDeTopicos")
    public Page<TopicoDTO> lista(@RequestParam(required = false) String cursoNome,
                                 @PageableDefault(sort = "id", direction = Sort.Direction.DESC)  Pageable pageable) {

        if (cursoNome == null)
            return TopicoDTO.converter(topicoService.findAll(pageable));
        else
            return TopicoDTO.converter(topicoService.findByCursoNome(cursoNome, pageable));
    }


    @GetMapping("/{id}")
    public ResponseEntity<DetalhesTopicoDTO> detalhar(@PathVariable Long id){
        return topicoService.findDetailById(id);
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = "listaDeTopicos")//Apaga o cache das listas
    public ResponseEntity<TopicoDTO> cadastrar(@Valid @RequestBody TopicoForm topicoForm, UriComponentsBuilder uriComponentsBuilder){
        Topico topico = topicoForm.conveter(cursoService);
        topicoService.save(topico);

        URI uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDTO(topico));
    }

    @PutMapping("/{id}")
    @Transactional
    @CacheEvict(value = "listaDeTopicos")//Apaga o cache das listas
    public ResponseEntity<TopicoDTO> atualizar(@PathVariable long id, @RequestBody @Valid AtualizacaoTopicoForm topicoForm){
        Topico topico = topicoForm.atualizar(id, topicoService);
        return ResponseEntity.ok(new TopicoDTO(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    @CacheEvict(value = "listaDeTopicos")//Apaga o cache das listas
    public ResponseEntity<?> delete(@PathVariable long id){
        topicoService.deleteByid(id);
        return ResponseEntity.ok().build();
    }
}
