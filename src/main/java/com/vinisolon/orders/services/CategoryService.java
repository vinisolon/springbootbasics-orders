package com.vinisolon.orders.services;

import com.vinisolon.orders.entities.Category;
import com.vinisolon.orders.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Registro para injeção de dependência em UserResource
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> category = repository.findById(id);
        return category.get();
    }

}
