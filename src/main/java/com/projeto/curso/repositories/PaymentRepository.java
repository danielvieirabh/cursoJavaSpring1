package com.projeto.curso.repositories;

import com.projeto.curso.entities.Category;
import com.projeto.curso.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
