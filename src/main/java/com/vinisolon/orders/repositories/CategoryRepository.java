package com.vinisolon.orders.repositories;

import com.vinisolon.orders.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
