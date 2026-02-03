package com.projeto.curso.repositories;

import com.projeto.curso.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
//                                       Generic
public interface UserRepository extends JpaRepository<User, Long> { //tipo da entidade e o tipo do id <User, Long>

}
