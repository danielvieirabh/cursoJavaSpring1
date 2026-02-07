package com.projeto.curso.repositories;

import com.projeto.curso.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//                                       Generic
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> { //tipo da entidade e o tipo do id <User, Long>

}
