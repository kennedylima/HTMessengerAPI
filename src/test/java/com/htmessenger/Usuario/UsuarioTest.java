package com.htmessenger.Usuario;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

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
    public void deve_salvar_um_usuario_atraves_da_api(){
        Usuario usuario = new Usuario("Snow", "snow","123");

        given().
            contentType(MediaType.APPLICATION_JSON_VALUE).
            body(usuario).
            expect().
                statusCode(200).
            when().
                post("http://htmessenger.herokuapp.com:8080/usuario");

    }
}
