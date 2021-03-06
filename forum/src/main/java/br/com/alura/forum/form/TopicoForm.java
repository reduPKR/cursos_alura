package br.com.alura.forum.form;

import br.com.alura.forum.model.Curso;
import br.com.alura.forum.model.Topico;
import br.com.alura.forum.service.CursoService;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TopicoForm {
    @NotNull
    @NotEmpty
    @Size(min = 5)
    private String titulo;
    @NotNull
    @NotEmpty
    @Size(min = 5)
    private String mensagem;
    @NotNull
    @NotEmpty
    private String nomeCurso;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public Topico conveter(CursoService cursoService) {
        Curso curso = cursoService.findByNome(nomeCurso);
        return new Topico(titulo, mensagem, curso);
    }
}
