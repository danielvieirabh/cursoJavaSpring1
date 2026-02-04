package com.projeto.curso.config;

import com.projeto.curso.entities.Order;
import com.projeto.curso.entities.User;
import com.projeto.curso.repositories.OrderRepository;
import com.projeto.curso.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test") //la do arquivo aplication
public class TestConfig implements CommandLineRunner {
    @Autowired //Associa a userRepository
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception { //Tudo que colocar aqui sera executado , quando a aplicacao for iniciada
        User usuario1 = new User(null, "Danzin Brown", "maria@gmail.com", "988888888", "123456"); //null pois o banco que escolhe
        User usuario2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order pedido1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), usuario1); //Formato ISO8601
        Order pedido2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), usuario2); //pedido 2 do usuario 2 (Sao relacoes)
        Order pedido3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), usuario1); //pedido 3 do suario 1

        userRepository.saveAll(Arrays.asList(usuario1, usuario2)); //Criar uma lista pros usuarios e salvar no banco
        orderRepository.saveAll(Arrays.asList(pedido1,pedido2,pedido3));
    }
}
