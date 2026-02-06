package com.projeto.curso.entities.pk;

import com.projeto.curso.entities.Order;
import com.projeto.curso.entities.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Embeddable //Anotcao para chave primaria
public class OrderItemPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne //Muitos para um
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne //Muitos para um
    @JoinColumn(name = "product_id")
    private Product product;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemPK that = (OrderItemPK) o;
        return Objects.equals(order, that.order) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, product);
    }
}
