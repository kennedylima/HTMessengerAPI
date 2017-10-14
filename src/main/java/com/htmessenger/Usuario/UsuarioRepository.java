package com.htmessenger.Usuario;


import java.util.Collection;

public interface UsuarioRepository {
    void salvar(Usuario usuario);
    Usuario get(int id);

    Collection<Usuario> buscarTodos();
}
