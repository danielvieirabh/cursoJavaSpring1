package com.projeto.curso.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projeto.curso.entities.enums.OrderStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_order") //colocar isso pois pode dar conflito com sql , pois la ja vem como padrao
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    //Pedido

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUtoIncremeto para ID
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",timezone = "GMT") //formatar o instante
    private Instant momento;//Criar uma para instante

    //      OrderStatus
    private Integer orderStatus; //Deixar Intenger somente aqui

    @ManyToOne //relacionamento entre pedido e cliente , muitos para um
    @JoinColumn(name = "user_id")

    private User user;

    public Order() {
    }

    public Order(Long id,Instant momento , User user, OrderStatus orderStatus ) {
        this.id = id;
        this.momento = momento;
        this.user = user;
        setOrderStatus(orderStatus);
    }

    public User getClient() {
        return user;
    }

    public void setClient(User client) {
        this.user = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMomento() {
        return momento;
    }

    public void setMomento(Instant momento) {
        this.momento = momento;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus); // COnverter o numero inteiro para orderStatus
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus != null) {
            this.orderStatus = orderStatus.getCode();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
