package com.htmessenger.Conversa;

import com.htmessenger.Usuario.Usuario;
import org.junit.Test;
import org.springframework.http.MediaType;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ConversaRestTest {


    private static int CONVERSA_ID = 0;
    private static String URL = "http://htmessenger.herokuapp.com/conversa/";
    private static String URL_USUARIO = "http://htmessenger.herokuapp.com/usuario/";

    @Test
    public void deve_salvar_um_usuario(){
        salvarConversa();
    }


    @Test
    public void deve_buscar_conversa_pelo_id(){
        salvarConversa();

        Conversa conversaRetornada =
                given().
                        accept(MediaType.APPLICATION_JSON_VALUE).
                        expect().
                        statusCode(200).
                        when().
                        get( URL + CONVERSA_ID).as(Conversa.class);

        assertEquals(CONVERSA_ID, conversaRetornada.getId() );
    }

    @Test
    public void deve_buscar_todos_as_conversas(){
        Conversa[] conversas =
                given().
                        accept(MediaType.APPLICATION_JSON_VALUE).
                        expect().
                        statusCode(200).
                        when().
                        get( URL ).as(Conversa[].class);

        assertNotNull(conversas);
    }


    @Test
    public void deve_remover_um_usuario(){
        salvarConversa();
        given().
                accept(MediaType.APPLICATION_JSON_VALUE).
                expect().
                statusCode(200).
                when().
                delete( URL + CONVERSA_ID);
    }

    private void salvarConversa(){
        int ID = 1;
        Usuario usuarioOrigem = buscarUsuarioPor(ID);

        ID = 2;
        Usuario usuarioDestino = buscarUsuarioPor(ID);

        Conversa conversa = new Conversa("Olá !", usuarioOrigem, usuarioDestino);

        CONVERSA_ID = Integer.parseInt(
                given().
                        contentType(MediaType.APPLICATION_JSON_VALUE).
                        body( conversa ).
                        expect().
                        statusCode(200).
                        when().
                        post( URL ).asString()
        );
    }

    private Usuario buscarUsuarioPor(int id){
        return given().
                accept(MediaType.APPLICATION_JSON_VALUE).
                expect().
                statusCode(200).
                when().
                get( URL_USUARIO + id ).as(Usuario.class);
    }
}
