package com.htmessenger.Conversa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/conversa")
@CrossOrigin(origins = "*")
public class ConversaController {

    @Autowired
    ConversaRepository conversaRepository;

    @RequestMapping(method = RequestMethod.POST)
    private ResponseEntity salvar(@RequestBody Conversa conversa){
        conversaRepository.salvar(conversa);
        return ResponseEntity.status(200).body(conversa.getId());
    }

    @RequestMapping(method = RequestMethod.GET)
    private Collection<Conversa> buscarTodos(){
        return conversaRepository.buscarTodos();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{usuarioOrigem}/{usuarioDestino}")
    public Collection<Conversa>  buscarPor(@PathVariable("usuarioOrigem") int usuarioOrigem, @PathVariable("usuarioDestino") int usuarioDestino) {
        return conversaRepository.buscarConversaEntre(usuarioOrigem, usuarioDestino);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity remover(@PathVariable("id") int id) {
        conversaRepository.remover(id);
        return ResponseEntity.status(200).body("Removido com Sucesso!");
    }
}
