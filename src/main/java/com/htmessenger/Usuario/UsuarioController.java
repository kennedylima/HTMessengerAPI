package com.htmessenger.Usuario;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @RequestMapping(method = RequestMethod.POST)
    private ResponseEntity salvar(@RequestBody Usuario usuario){
        usuarioRepository.salvar(usuario);
        return ResponseEntity.status(200).body(usuario.getId());
    }

    @RequestMapping(method = RequestMethod.GET)
    private Collection<Usuario> buscarTodos(){
        return usuarioRepository.buscarTodos();
    }

}
