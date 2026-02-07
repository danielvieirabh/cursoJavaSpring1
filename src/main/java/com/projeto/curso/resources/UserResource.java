package com.projeto.curso.resources;

import com.projeto.curso.entities.User;

import com.projeto.curso.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired
    private UserService userservice;

            //Generics
    @GetMapping // Lista de usuarios :
    public ResponseEntity<List<User>> findAll() {
        List<User> list = userservice.findall();
        return ResponseEntity.ok().body(list); //Responde no caminho users
    }

    @GetMapping(value = "/{id}") //Requisao do tipo get , e aceita id
    public ResponseEntity<User> findById(@PathVariable Long id) { //SO user pois vai retornar apenas um Usuario
        User user = userservice.findById(id);
        return ResponseEntity.ok().body(user);
    }

    //Endpoint para inserir:
    @PostMapping //Vai ser POST DO http
    public ResponseEntity<User> insert(@RequestBody User user) {
        user = userservice.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri(); //COnverte em uri para colocar em baixo, ai fica com 201 quando inserir algo
        return ResponseEntity.created(uri).body(user);
      //  return ResponseEntity.ok().body(user); //Retorna a resposta Ok com o corpo passando o usuario
    }

    //Endpoint Deletar usuario: /Nao pode apagar usuarios vinculados a pedidos
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) { //Tem que ser void , pois nao ira retornar nenhum body
        userservice.delete(id);
        return ResponseEntity.noContent().build(); //Aqui e o 204 para apagar
    }

    //Endpoint Atualizar usuario:
    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id,@RequestBody User dados) {
        dados = userservice.update(id, dados);
        return ResponseEntity.ok().body(dados);
    }
}
