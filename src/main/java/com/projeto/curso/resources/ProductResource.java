package com.projeto.curso.resources;

import com.projeto.curso.entities.Product;
import com.projeto.curso.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProductResource {
    @Autowired
    private ProductService productService;

            //Generics
    @GetMapping // Lista de usuarios :
    public ResponseEntity<List<Product>> findAll() {
        List<Product> list = productService.findall();
        return ResponseEntity.ok().body(list); //Responde no caminho users
    }

    @GetMapping(value = "/{id}") //Requisao do tipo get , e aceita id
    public ResponseEntity<Product> findById(@PathVariable Long id) { //SO cateogry pois vai retornar apenas um Usuario
        Product product = productService.findById(id);
        return ResponseEntity.ok().body(product);
    }
}
