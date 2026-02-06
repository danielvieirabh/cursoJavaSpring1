package com.projeto.curso.services;

import com.projeto.curso.entities.Product;
import com.projeto.curso.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired //Injecao de dependencia automaticamente
    private ProductRepository repository;

    //Operacao para buscar todos os usuarios
    public List<Product> findall() {
        return repository.findAll(); //Busca toodos os usuarios
    }

    public Product findById(Long id) { //pegar um usuario por id
       Optional<Product> obj = repository.findById(id);
       return obj.get(); //Ela retorna do tipo Product
    }
}
