package com.projeto.curso.resources;

import com.projeto.curso.entities.Order;
import com.projeto.curso.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
    @Autowired
    private OrderService orderService;

            //Generics
    @GetMapping // Lista de usuarios :
    public ResponseEntity<List<Order>> findAll() {
        List<Order> list = orderService.findall();
        return ResponseEntity.ok().body(list); //Responde no caminho users
    }

    @GetMapping(value = "/{id}") //Requisao do tipo get , e aceita id
    public ResponseEntity<Order> findById(@PathVariable Long id) { //SO order pois vai retornar apenas um Usuario
        Order order = orderService.findById(id);
        return ResponseEntity.ok().body(order);
    }
}
