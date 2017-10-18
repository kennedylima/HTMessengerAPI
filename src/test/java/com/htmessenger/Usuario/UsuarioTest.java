package com.htmessenger.Usuario;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

import static org.junit.Assert.*;
import static com.jayway.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    public void deve_salvar_um_usuario(){
        Usuario usuario = new Usuario( "Kennedy", "kennedy", "123" );
        usuarioRepository.salvar(usuario);

        assertNotNull(usuario.getId());
    }


    @Test
    public void deve_buscar_um_usuario_pelo_id(){
        int ID_DO_USUARIO = 1;
        Usuario usuarioEncontrado = usuarioRepository.buscarPor(ID_DO_USUARIO);

        assertNotNull(usuarioEncontrado);
    }

    @Test
    public void deve_buscar_todos_os_usuarios(){
        Collection<Usuario> usuarios = usuarioRepository.buscarTodos();
        assertTrue(usuarios.size() > 0);
    }


    @Test
    public void deve_remover_um_usuario(){
        Usuario usuario = new Usuario( "Remover", "remover", "remover" );
        usuarioRepository.salvar(usuario);

        usuarioRepository.remover(usuario.getId());
        usuario = usuarioRepository.buscarPor(usuario.getId());

        assertNull(usuario);
    }



}
