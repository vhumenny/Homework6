package lesson33.homework28.cart;

import lesson33.homework28.entity.Product;
import lesson33.homework28.storage.ProductRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Cart {
    private List<Product> productList;
    private ProductRepository productRepository;

    public Cart(ProductRepository productRepository) {
        this.productList = new ArrayList<>();
        this.productRepository = productRepository;
    }

    public void addProduct(long id) {
        Product product = productRepository.getProductById(id);
        productList.add(product);
        productRepository.removeProduct(product);
        log.debug("Add {} in cart", product.getName());
    }

    public void deleteProduct(long id) {
        Product product = productList.stream().filter(p -> p.getId() == id).findFirst().orElseThrow();
        productList.remove(product);
        productRepository.addProduct(product);
        log.debug("Delete {} from cart", product.getName());
    }

    public void print() {
        System.out.println(productRepository);
        System.out.println(productList);
    }

}
