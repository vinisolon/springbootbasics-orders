package com.vinisolon.orders.resources;

import com.vinisolon.orders.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User user = new User(1L, "Teste", "teste@email.com", "123456789", "321654");
        return ResponseEntity.ok().body(user);
    }

}
