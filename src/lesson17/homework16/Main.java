package lesson17.homework16;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        Product product = new Product(1, "Food", 150, true, LocalDate.now());
        products.add(product);
        products.add(new Product(2, "Book", 300, true, LocalDate.now()));
        products.add(new Product(3, "Book", 100, true, LocalDate.now()));
        products.add(new Product(4, "Electronics", 400, false, LocalDate.now()));
        products.add(new Product(5, "Book", 255, false, LocalDate.now()));
        products.add(new Product(6, "Book", 50, false, LocalDate.now()));
        products.add(new Product(7, "Book", 60, false, LocalDate.now()));
        products.add(new Product(8, "Food", 60, false, LocalDate.now()));

        System.out.println(product.getBooks(products));
        System.out.println(product.getProductsWithDiscount(products));
        System.out.println(product.getCheapestBook(products));
        System.out.println(product.getThreeLatestProducts(products));
        System.out.println(product.getProductsSum(products));
        System.out.println(product.getProductsHashmap(products));
    }
}
