package com.vinisolon.orders.config;

import com.vinisolon.orders.entities.Category;
import com.vinisolon.orders.entities.Order;
import com.vinisolon.orders.entities.Product;
import com.vinisolon.orders.entities.User;
import com.vinisolon.orders.entities.enums.OrderStatus;
import com.vinisolon.orders.repositories.CategoryRepository;
import com.vinisolon.orders.repositories.OrderRepository;
import com.vinisolon.orders.repositories.ProductRepository;
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

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User(null, "Vinicius Solon", "vini@email.com", "19988884444", "123456");
        User user2 = new User(null, "Maria Cecília", "maria@email.com", "19988885555", "654321");

        userRepository.saveAll(Arrays.asList(user1, user2));

        Order order1 = new Order(null, Instant.parse("2019-06-20T19:53:15Z"), OrderStatus.PAID, user1);
        Order order2 = new Order(null, Instant.parse("2019-07-21T03:42:23Z"), OrderStatus.SHIPPED, user2);
        Order order3 = new Order(null, Instant.parse("2019-07-22T15:21:17Z"), OrderStatus.WAITING_PAYMENT, user1);

        orderRepository.saveAll(Arrays.asList(order1, order2, order3));

        Category category1 = new Category(null, "Electronics");
        Category category2 = new Category(null, "Books");
        Category category3 = new Category(null, "Clothes");

        categoryRepository.saveAll(Arrays.asList(category1, category2, category3));

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        // Relacionando categorias aos produtos
        p1.getCategories().add(category2);
        p2.getCategories().addAll(Arrays.asList(category1, category3));
        p3.getCategories().add(category3);
        p4.getCategories().add(category3);
        p5.getCategories().add(category2);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

    }

}
