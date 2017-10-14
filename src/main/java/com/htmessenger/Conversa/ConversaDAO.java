package com.htmessenger.Conversa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository
@Transactional
public class ConversaDAO  implements ConversaRepository{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void salvar(Conversa conversa) {
        entityManager.persist(conversa);
    }

    @Override
    public Collection<Conversa> buscarTodos() {
        return entityManager.createQuery("FROM Conversa c").getResultList();
    }
}
