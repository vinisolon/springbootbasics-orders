package com.vinisolon.orders.entities.pk;

import com.vinisolon.orders.entities.Order;
import com.vinisolon.orders.entities.Product;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

// Lombok
@Getter
@Setter
@EqualsAndHashCode
// JPA
@Embeddable // Anotação para classe auxiliar de chave composta
public class OrderItemPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
