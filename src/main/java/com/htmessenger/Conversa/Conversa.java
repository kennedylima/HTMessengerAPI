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

    @OneToOne
    @JsonView
    private  Usuario usuarioOrigem;

    @OneToOne
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
