package com.vinisolon.orders.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vinisolon.orders.entities.enums.OrderStatus;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

// Lombok
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
// JPA
@Entity
@Table(name = "orders")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;
    private Integer orderStatus;

    @ManyToOne
    @JoinColumn(name = "fk_client_id") // Chave estrangeira de users na tabela orders
    private User client;

    @OneToMany(mappedBy = "id.order") // O id chave composta que possui o Order
    @Setter(AccessLevel.NONE)
    private Set<OrderItem> itens = new HashSet<>();

    // Cascade ALL é obrigatório para mapeamento 1 para 1 com o mesmo ID
    // Exemplo: Order id 5 -> Payment id 5
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
        this.id = id;
        this.moment = moment;
        setOrderStatus(orderStatus);
        this.client = client;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus != null)
            this.orderStatus = orderStatus.getCode();
    }

    public Double getTotal() {
        Double sum = 0.0;

        for (OrderItem item : itens)
            sum += item.getSubTotal();

        return sum;
    }

}
