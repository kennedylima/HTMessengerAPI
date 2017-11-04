package com.htmessenger.Conversa;

import com.fasterxml.jackson.annotation.JsonView;
import com.htmessenger.EntidadeBase;
import com.htmessenger.Usuario.Usuario;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Conversa extends EntidadeBase {

    @Column
    @JsonView
    private  String mensagem;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonView
    private  Usuario usuarioOrigem;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonView
    private  Usuario usuarioDestino;

    public Conversa(String mensagem, Usuario usuarioOrigem, Usuario usuarioDestino) {
        this.mensagem = mensagem;
        this.usuarioOrigem = usuarioOrigem;
        this.usuarioDestino = usuarioDestino;
    }

    public Conversa() {
    }
}
