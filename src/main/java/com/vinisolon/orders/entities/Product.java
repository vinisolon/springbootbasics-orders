package com.vinisolon.orders.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

// Lombok
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
// JPA
@Entity
@Table(name = "products")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imgUrl;

    @ManyToMany
    @JoinTable(name = "products_x_categories",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    @Setter(AccessLevel.NONE) // Usar somente getters em coleções
    private Set<Category> categories = new HashSet<>();

    @OneToMany(mappedBy = "id.product") // O id chave composta que possui o Product
    @Setter(AccessLevel.NONE) // Usar somente getters em coleções
    @Getter(AccessLevel.NONE) // Método get personalizado
    private Set<OrderItem> itens = new HashSet<>();

    public Product(Long id, String name, String description, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    @JsonIgnore // Para evitar acesso de mão dupla e causar loop infinito na requisição
    public Set<Order> getOrders() {
        Set<Order> orders = new HashSet<>();
        for (OrderItem item : itens)
            orders.add(item.getOrder());
        return orders;
    }

}
