package com.projeto.curso.services;
import com.projeto.curso.entities.Order;
import com.projeto.curso.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired //Injecao de dependencia automaticamente
    private OrderRepository repository;

    //Operacao para buscar todos os usuarios
    public List<Order> findall() {
        return repository.findAll(); //Busca toodos os usuarios
    }

    public Order findById(Long id) { //pegar um usuario por id
       Optional<Order> obj = repository.findById(id);
       return obj.get(); //Ela retorna do tipo Order
    }
}
