package com.htmessenger.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(method = RequestMethod.POST, value = "/autenticar")
    public ResponseEntity<Usuario> autenticar(@RequestBody Usuario usuario) {
        return ResponseEntity.status(200).body(usuarioRepository.autenticar(usuario));
    }

    @RequestMapping(method = RequestMethod.GET)
    private Collection<Usuario> buscarTodos(){
        return usuarioRepository.buscarTodos();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Usuario> buscarPor(@PathVariable("id") int id) {
        return ResponseEntity.status(200).body(usuarioRepository.buscarPor(id));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity remover(@PathVariable("id") int id) {
        usuarioRepository.remover(id);
        return ResponseEntity.status(200).body("Removido com Sucesso!");
    }
}
