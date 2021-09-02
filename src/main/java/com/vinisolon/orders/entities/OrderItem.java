package com.vinisolon.orders.entities;

import com.vinisolon.orders.entities.pk.OrderItemPK;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

// Lombok
@Getter
@Setter
@EqualsAndHashCode(of = "id")
// JPA
@Entity
@Table(name = "order_item")
public class OrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    @EmbeddedId // Anotação para id de chave composta
    private OrderItemPK id;

    private Integer quantity;
    private Double price;

    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        // Setando a chave composta de OrderItemPK
        id.setOrder(order);
        id.setProduct(product);

        this.quantity = quantity;
        this.price = price;
    }

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

}
