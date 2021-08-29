package com.vinisolon.orders.config;

import com.vinisolon.orders.entities.Order;
import com.vinisolon.orders.entities.User;
import com.vinisolon.orders.entities.enums.OrderStatus;
import com.vinisolon.orders.repositories.OrderRepository;
import com.vinisolon.orders.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User(null, "Vinicius Solon", "vini@email.com", "19988884444", "123456");
        User user2 = new User(null, "Maria Cecília", "maria@email.com", "19988885555", "654321");

        userRepository.saveAll(Arrays.asList(user1, user2));

        Order order1 = new Order(null, Instant.parse("2019-06-20T19:53:15Z"), OrderStatus.PAID, user1);
        Order order2 = new Order(null, Instant.parse("2019-07-21T03:42:23Z"), OrderStatus.SHIPPED, user2);
        Order order3 = new Order(null, Instant.parse("2019-07-22T15:21:17Z"), OrderStatus.WAITING_PAYMENT, user1);

        orderRepository.saveAll(Arrays.asList(order1, order2, order3));
    }

}
