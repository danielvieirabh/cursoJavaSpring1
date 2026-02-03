package com.projeto.curso.config;

import com.projeto.curso.entities.User;
import com.projeto.curso.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test") //la do arquivo aplication
public class TestConfig implements CommandLineRunner {
    @Autowired //Associa a userRepository
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception { //Tudo que colocar aqui sera executado , quando a aplicacao for iniciada
        User u1 = new User(null, "Danzin Brown", "maria@gmail.com", "988888888", "123456"); //null pois o banco que escolhe
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepository.saveAll(Arrays.asList(u1, u2)); //Criar uma lista pros usuarios e salvar no banco
    }
}
