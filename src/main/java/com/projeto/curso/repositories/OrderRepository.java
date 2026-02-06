package com.projeto.curso.repositories;

import com.projeto.curso.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//                                       Generic
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> { //tipo da entidade e o tipo do id <User, Long>

}
