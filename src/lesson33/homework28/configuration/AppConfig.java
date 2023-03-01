package lesson33.homework28.configuration;

import lesson33.homework28.Cart.Cart;
import lesson33.homework28.storage.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {


    @Bean
    public ProductRepository productRepositoryBean() {
        return new ProductRepository();
    }

    @Bean
    @Scope("prototype")
    public Cart cartBean() {
        return new Cart(productRepositoryBean());
    }
}
