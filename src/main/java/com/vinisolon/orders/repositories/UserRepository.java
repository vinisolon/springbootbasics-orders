package com.vinisolon.orders.repositories;

import com.vinisolon.orders.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
