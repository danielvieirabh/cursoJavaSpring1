package com.projeto.curso.services;

import com.projeto.curso.entities.User;
import com.projeto.curso.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired //Injecao de dependencia automaticamente
    private UserRepository repository;

    //Operacao para buscar todos os usuarios
    public List<User> findall() {
        return repository.findAll(); //Busca toodos os usuarios
    }

    public User findById(Long id) { //pegar um usuario por id
       Optional<User> obj = repository.findById(id);
       return obj.get(); //Ela retorna do tipo User
    }
}
