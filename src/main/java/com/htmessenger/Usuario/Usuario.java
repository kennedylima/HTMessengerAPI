package com.htmessenger.Usuario;

import com.fasterxml.jackson.annotation.JsonView;
import com.htmessenger.EntidadeBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Usuario extends EntidadeBase implements Serializable {

    @Column
    @JsonView
    private  String nome;

    @Column
    @JsonView
    private  String login;

    @Column
    @JsonView
    private  String senha;

    public Usuario(String nome, String usuario, String senha) {
        this.nome = nome;
        this.login = usuario;
        this.senha = senha;
    }

    public Usuario() {
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }
}
