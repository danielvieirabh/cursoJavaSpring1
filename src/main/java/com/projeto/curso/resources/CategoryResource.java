package com.projeto.curso.resources;

import com.projeto.curso.entities.Category;
import com.projeto.curso.services.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoryResource {
    @Autowired
    private CategoryService categoryService;

            //Generics
    @GetMapping // Lista de usuarios :
    public ResponseEntity<List<Category>> findAll() {
        List<Category> list = categoryService.findall();
        return ResponseEntity.ok().body(list); //Responde no caminho users
    }

    @GetMapping(value = "/{id}") //Requisao do tipo get , e aceita id
    public ResponseEntity<Category> findById(@PathVariable Long id) { //SO cateogry pois vai retornar apenas um Usuario
        Category category = categoryService.findById(id);
        return ResponseEntity.ok().body(category);
    }
}
