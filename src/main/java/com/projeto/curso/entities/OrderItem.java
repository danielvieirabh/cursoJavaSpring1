package com.projeto.curso.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projeto.curso.entities.pk.OrderItemPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId //Composto
    private OrderItemPK id = new OrderItemPK(); //Identificador , tem que instanciar , se nao nao funciona
    private Integer quantidade;
    private Double preco;

    public OrderItem() {

    }

    public OrderItem(Order order, Product product, Integer quantidade, Double preco) {
        id.setOrder(order); // Passar assim o id
        id.setProduct(product);
        this.quantidade = quantidade;
        this.preco = preco;
    }

    @JsonIgnore //Para nao dar loop em pedidos, pois chama o pedido ais de uma vez
    public Order getOrder() {
        return id.getOrder();
    }

    public void setOrder(Order order) {
        id.setOrder(order);
    }

    public Product getProduct() {
        return id.getProduct();
    }

    public void setProduct(Product product) {
        id.setProduct(product);
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    //Somente campo de id
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public Double getSubTotal() { //No java tem que colocar get na frente do metodo
      return preco * quantidade;
    }
}
