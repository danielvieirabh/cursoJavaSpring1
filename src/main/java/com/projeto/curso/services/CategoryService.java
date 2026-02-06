package com.projeto.curso.services;
import com.projeto.curso.entities.Category;
import com.projeto.curso.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired //Injecao de dependencia automaticamente
    private CategoryRepository repository;

    //Operacao para buscar todos os usuarios
    public List<Category> findall() {
        return repository.findAll(); //Busca toodos os usuarios
    }

    public Category findById(Long id) { //pegar um usuario por id
       Optional<Category> obj = repository.findById(id);
       return obj.get(); //Ela retorna do tipo Category
    }
}
