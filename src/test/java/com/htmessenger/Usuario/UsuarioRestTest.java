package com.htmessenger.Usuario;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import static com.jayway.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioRestTest {

    Usuario usuario ;
    private static int USUARIO_ID = 0;
    private static String URL = "http://localhost:8080/usuario/";

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
                get( URL + USUARIO_ID ).as(Usuario.class);

        assertEquals( USUARIO_ID, usuarioRetornado.getId() );
    }

    @Test
    public void deve_buscar_todos_os_usuarios(){
        Usuario[] usuarios =
            given().
                accept(MediaType.APPLICATION_JSON_VALUE).
            expect().
                statusCode(200).
            when().
                get( URL ).as(Usuario[].class);

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
                delete( URL +USUARIO_ID );
    }

    @Test
    public void deve_autenticar_um_usuario(){
        usuario = new Usuario( "Capitao America", "c.america", "123" );

        given().
                contentType(MediaType.APPLICATION_JSON_VALUE).
                body( usuario ).
                expect().
                statusCode(200).
                when().
                post( URL+"autenticar" );
    }

    private void salvarUsuario(){
        usuario = new Usuario( "Capitao America", "c.america", "123" );

        USUARIO_ID = Integer.parseInt(
            given().
                contentType(MediaType.APPLICATION_JSON_VALUE).
            body( usuario ).
            expect().
                statusCode(200).
            when().
                post( URL ).asString()
        );
    }
}
