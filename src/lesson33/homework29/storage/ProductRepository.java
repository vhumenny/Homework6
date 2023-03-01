package lesson33.homework29.storage;

import lesson33.homework29.entity.Product;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@ToString
@Slf4j
public class ProductRepository {
    List<Product> productStorage;

    public ProductRepository() {
        this.productStorage = load();
    }

    public List<Product> load() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1L, "beer", BigDecimal.valueOf(50)));
        products.add(new Product(2L, "cola", BigDecimal.valueOf(30)));
        products.add(new Product(3L, "apple", BigDecimal.valueOf(20)));
        return products;
    }

    public void removeProduct(Product product) {
        productStorage.remove(product);
        log.debug("Remove {} from product repository", product.getName());
    }

    public Product getProductById(long id) {
        return productStorage.stream().filter(product -> product.getId() == id).findFirst().orElseThrow();
    }

    public List<Product> getProductStorage() {
        return productStorage;
    }

    public void addProduct(Product product) {
        productStorage.add(product);
        log.debug("Add {} in product repository", product.getName());
    }
}
