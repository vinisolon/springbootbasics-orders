package com.vinisolon.orders.repositories;

import com.vinisolon.orders.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

// @Repository não é necessário, pois a classe já extende e herda o registro do JpaRepository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
