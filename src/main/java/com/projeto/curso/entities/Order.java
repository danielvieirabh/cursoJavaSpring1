package com.projeto.curso.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projeto.curso.entities.enums.OrderStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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
    @Enumerated(EnumType.STRING) //Ja manda como string
    private OrderStatus orderStatus;

    @ManyToOne //relacionamento entre pedido e o id do usuario , muitos para um
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "id.order") //Um para muitos
    private Set<OrderItem> items = new HashSet<>();

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL) //atributo mapeado la em Payment e order
    private Payment payment;

    public Order() {
    }

    public Order(Long id,Instant momento , User user, OrderStatus orderStatus ) {
        this.id = id;
        this.momento = momento;
        this.user = user;
        this.orderStatus = orderStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        return orderStatus;
    }
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Set<OrderItem> getItems() {
        return items; //Pedido reconhece os items deles
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
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

    public Double getTotal() { //Fazer total da soma de cada item de pedido
      double soma = 0.0;
      for (OrderItem orderItem : items) {
          soma = soma + orderItem.getSubTotal();
      }
      return soma;
    }
}
