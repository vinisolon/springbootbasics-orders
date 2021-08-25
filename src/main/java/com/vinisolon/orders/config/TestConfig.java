package com.vinisolon.orders.config;

import com.vinisolon.orders.entities.User;
import com.vinisolon.orders.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User(null, "Vinicius Solon", "vini@email.com", "19988884444", "123456");
        User user2 = new User(null, "Maria Cecília", "maria@email.com", "19988885555", "654321");

        userRepository.saveAll(Arrays.asList(user1, user2));
    }

}
