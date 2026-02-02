package com.projeto.curso.resources;

import com.projeto.curso.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
            //Generics

    @GetMapping
    public ResponseEntity<User> findAll() {
        User u = new User(1L, "Maria", "maria@gmail.com", "3199999", "123"); //colocar L na frente pois e long
        return ResponseEntity.ok().body(u); //Responde no caminho users
    }
}
