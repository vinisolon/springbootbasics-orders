package com.vinisolon.orders.repositories;

import com.vinisolon.orders.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

// @Repository não é necessário, pois a classe já extende e herda o registro do JpaRepository
public interface UserRepository extends JpaRepository<User, Long> {
}
