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
    public Usuario buscarPor(int id) {
        return entityManager.find(Usuario.class, id);
    }

    @Override
    public Collection<Usuario> buscarTodos() {
        return entityManager.createQuery("FROM Usuario u").getResultList();
    }

    @Override
    public void remover(int id) {
        entityManager.remove(entityManager.getReference(Usuario.class, id));
    }

    @Override
    public Usuario autenticar(Usuario usuario) {
        return (Usuario) entityManager.createQuery("FROM Usuario u WHERE u.login ='"+usuario.getLogin()+"' AND u.senha ='"+usuario.getSenha()+"'").getSingleResult();
    }
}
