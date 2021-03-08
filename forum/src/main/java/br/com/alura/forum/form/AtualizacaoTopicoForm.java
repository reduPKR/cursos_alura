package br.com.alura.forum.form;

import br.com.alura.forum.model.Topico;
import br.com.alura.forum.service.TopicoService;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AtualizacaoTopicoForm {
    /*Nescessaria pois nem tudo pode ser atualizado.*/
    @NotNull
    @NotEmpty
    @Size(min = 5)
    private String titulo;
    @NotNull
    @NotEmpty
    @Size(min = 5)
    private String mensagem;

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

    public Topico atualizar(long id, TopicoService topicoService) {
        Topico topico = topicoService.findById(id);

        topico.setTitulo(titulo);
        topico.setMensagem(mensagem);

        return topico;
    }
}
