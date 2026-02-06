package com.projeto.curso.repositories;

import com.projeto.curso.entities.Category;
import com.projeto.curso.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
