package com.htmessenger.Usuario;


import java.util.Collection;

public interface UsuarioRepository {
    void salvar(Usuario usuario);
    Usuario buscarPor(int id);

    Collection<Usuario> buscarTodos();

    void remover(int id);

    Usuario autenticar(Usuario usuario);
}
