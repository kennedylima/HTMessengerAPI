package com.htmessenger.Usuario;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository
@Transactional
public class UsuarioDAO implements UsuarioRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void salvar(Usuario usuario) {
        entityManager.persist(usuario);
    }

    @Override
    public Usuario get(int id) {
        return entityManager.find(Usuario.class, id);
    }

    @Override
    public Collection<Usuario> buscarTodos() {
        return entityManager.createQuery("FROM Usuario u").getResultList();
    }
}
