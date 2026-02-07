package com.projeto.curso.services;

import com.projeto.curso.entities.User;
import com.projeto.curso.repositories.UserRepository;
import com.projeto.curso.services.exceptions.DatabaseException;
import com.projeto.curso.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
       return obj.orElseThrow(() -> new ResourceNotFoundException(id));  //Vai trazer a excecao de erro 404 , se nao tiver o usuario ele traz essa excecao
    }

    //Salvar no banco de dados um dado Usuario , retorna um usuario salvo:
    public User insert(User user) {
       return repository.save(user);
    }

    //Deletar usuario
    public void delete(Long id) {
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException error) {
           throw new ResourceNotFoundException(id);
        }
        catch (DataIntegrityViolationException e) {
//            e.printStackTrace();
            throw new DatabaseException(e.getMessage()); //lançando excecao da minha camada de exercicio
        }

    }

    //Atualizar usuarios
    public User update(Long id, User dados) {
        try {
            User entity = repository.getReferenceById(id);
            updateData(entity, dados);
            return repository.save(entity);
        }
        catch (EntityNotFoundException error) { //Excecoes especificas , bara dar erro 404
            throw new ResourceNotFoundException(id);
        }
    }
    private void updateData(User entity, User dados) { //Atualizar esses campos :
        entity.setNome(dados.getNome());
        entity.setEmail(dados.getEmail());
        entity.setPhone(dados.getPhone());
    }

}
