package com.projeto.curso.config;

import com.projeto.curso.entities.Category;
import com.projeto.curso.entities.Order;
import com.projeto.curso.entities.Product;
import com.projeto.curso.entities.User;
import com.projeto.curso.entities.enums.OrderStatus;
import com.projeto.curso.repositories.CategoryRepository;
import com.projeto.curso.repositories.OrderRepository;
import com.projeto.curso.repositories.ProductRepository;
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
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;


    @Override
    public void run(String... args) throws Exception { //Tudo que colocar aqui sera executado , quando a aplicacao for iniciada
        //Users
        User usuario1 = new User(null, "Danzin Brown", "maria@gmail.com", "988888888", "123456"); //null pois o banco que escolhe
        User usuario2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        //Pedidos
        Order pedido1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), usuario1, OrderStatus.PAID); //Formato ISO8601
        Order pedido2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), usuario2, OrderStatus.CANCELED); //pedido 2 do usuario 2 (Sao relacoes)
        Order pedido3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), usuario1, OrderStatus.WAITTING_PAYMENT); //pedido 3 do suario 1

        userRepository.saveAll(Arrays.asList(usuario1, usuario2)); //Criar uma lista pros usuarios e salvar no banco
        orderRepository.saveAll(Arrays.asList(pedido1,pedido2,pedido3));

        //Categorias
        Category categoria1 = new Category(null, "Electronics");
        Category categoria2 = new Category(null, "Books");
        Category categoria3 = new Category(null, "Computers");

        //Produtos
        Product produto1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product produto2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product produto3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product produto4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product produto5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        categoryRepository.saveAll(Arrays.asList(categoria1,categoria2, categoria3));
        productRepository.saveAll(Arrays.asList(produto1,produto2, produto3,produto4, produto5));

        //relacionando os produtos com Categorias
        produto1.getCategories().add(categoria2); //Produto tem categorias , porque la usa um Set
        produto2.getCategories().add(categoria1);
        produto2.getCategories().add(categoria3);
        produto3.getCategories().add(categoria3);
        produto4.getCategories().add(categoria3);
        produto5.getCategories().add(categoria2);
        productRepository.saveAll(Arrays.asList(produto1,produto2, produto3,produto4, produto5)); //Salvar denovo com as associacoes que fiz
    }
}
