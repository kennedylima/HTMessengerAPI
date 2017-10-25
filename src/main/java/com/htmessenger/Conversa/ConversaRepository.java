package com.htmessenger.Conversa;

import java.util.Collection;

public interface ConversaRepository {
    void salvar(Conversa conversa);

    Collection<Conversa> buscarTodos();

    Collection<Conversa>  buscarConversaEntre(int usuarioOrigem, int usuarioDestino);

    void remover(int id);
}
