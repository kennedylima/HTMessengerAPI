package com.htmessenger.Conversa;

import com.htmessenger.Usuario.Usuario;
import com.htmessenger.Usuario.UsuarioRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConversaTest {


    @Autowired
    private ConversaRepository conversaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    public void deve_salvar_uma_conversa(){
        Usuario usuarioOrigem = usuarioRepository.buscarPor(1);
        Usuario usuarioDestino = usuarioRepository.buscarPor(2);

        Conversa conversa = new Conversa("Olá !", usuarioOrigem, usuarioDestino);

        conversaRepository.salvar(conversa);

        assertNotNull(conversa.getId());
    }


    @Test
    public void deve_salvar_uma_conversa_atraves_da_api(){
        Usuario usuarioOrigem = usuarioRepository.buscarPor(1);
        Usuario usuarioDestino = usuarioRepository.buscarPor(2);

        Conversa conversa = new Conversa("Olá !", usuarioOrigem, usuarioDestino);

        given().
            contentType(MediaType.APPLICATION_JSON_VALUE).
            body(conversa).
            expect().
                statusCode(200).
            when().
                post("http://localhost:8080/conversa");

    }
}
