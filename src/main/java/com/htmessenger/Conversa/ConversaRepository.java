package com.htmessenger.Conversa;

import java.util.Collection;

public interface ConversaRepository {
    void salvar(Conversa conversa);

    Collection<Conversa> buscarTodos();

    Conversa buscarPor(int id);

    void remover(int id);
}
