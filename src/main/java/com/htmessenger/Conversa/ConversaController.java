package com.htmessenger.Conversa;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Conversa> buscarPor(@PathVariable("id") int id) {
        return ResponseEntity.status(200).body(conversaRepository.buscarPor(id));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity remover(@PathVariable("id") int id) {
        conversaRepository.remover(id);
        return ResponseEntity.status(200).body("Removido com Sucesso!");
    }
}
