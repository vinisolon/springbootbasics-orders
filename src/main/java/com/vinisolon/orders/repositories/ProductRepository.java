package com.vinisolon.orders.repositories;

import com.vinisolon.orders.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// @Repository não é necessário, pois a classe já extende e herda o registro do JpaRepository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
