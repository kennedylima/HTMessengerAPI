package com.htmessenger.Usuario;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.jayway.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioRestTest {

    Usuario usuario ;
    private static int USUARIO_ID = 0;

    @Test
    public void deve_salvar_um_usuario(){
        salvarUsuario();
    }


    @Test
    public void deve_buscar_usuario_pelo_id(){
        salvarUsuario();

        Usuario usuarioRetornado =
            given().
                accept(MediaType.APPLICATION_JSON_VALUE).
            expect().
                statusCode(200).
            when().
                get("http://localhost:8080/usuario/"+USUARIO_ID).as(Usuario.class);

        assertEquals(USUARIO_ID, usuarioRetornado.getId());
    }

    @Test
    public void deve_buscar_todos_os_usuarios(){
        Usuario[] usuarios =
            given().
                accept(MediaType.APPLICATION_JSON_VALUE).
            expect().
                statusCode(200).
            when().
                get("http://localhost:8080/usuario").as(Usuario[].class);

        assertNotNull(usuarios);
    }


    @Test
    public void deve_remover_um_usuario(){
        salvarUsuario();
            given().
                accept(MediaType.APPLICATION_JSON_VALUE).
            expect().
                statusCode(200).
            when().
                delete("http://localhost:8080/usuario/"+USUARIO_ID);
    }

    private void salvarUsuario(){
        usuario = new Usuario( "Kennedy", "kennedy", "123" );

        USUARIO_ID = Integer.parseInt(
            given().
                contentType(MediaType.APPLICATION_JSON_VALUE).
            body(usuario).
            expect().
                statusCode(200).
            when().
                post("http://localhost:8080/usuario").asString()
        );
    }
}
