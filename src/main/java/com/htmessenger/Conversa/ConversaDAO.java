package com.htmessenger.Conversa;

import com.htmessenger.Usuario.Usuario;
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
    @Transactional
    public void salvar(Conversa conversa) {
        entityManager.persist(conversa);
        entityManager.close();
    }

    @Override
    public Collection<Conversa> buscarConversaEntre(int usuarioOrigem, int usuarioDestino) {
         return entityManager.createQuery("" +
                 "FROM Conversa c " +
                 "WHERE c.usuarioOrigem.id ="+usuarioOrigem+" AND c.usuarioDestino="+usuarioDestino+" " +
                 "OR c.usuarioDestino.id="+usuarioOrigem+" AND c.usuarioOrigem.id ="+usuarioDestino+" " +
                 "ORDER BY c.id" ).getResultList();
    }

    @Override
    public Collection<Conversa> buscarTodos() {
        return entityManager.createQuery("FROM Conversa c").getResultList();
    }


    @Override
    public void remover(int id) {
        entityManager.remove(entityManager.getReference(Conversa.class, id));
    }

}
