package lesson17.homework16;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, Type.FOOD, 150, true, LocalDate.now()));
        products.add(new Product(2, Type.BOOK, 300, true, LocalDate.now()));
        products.add(new Product(3, Type.BOOK, 100, true, LocalDate.now()));
        products.add(new Product(4, Type.ELECTRONICS, 400, false, LocalDate.now()));
        products.add(new Product(5, Type.BOOK, 255, false, LocalDate.now()));
        products.add(new Product(6, Type.BOOK, 50, false, LocalDate.now()));
        products.add(new Product(7, Type.BOOK, 60, false, LocalDate.now()));
        products.add(new Product(8, Type.FOOD, 60, false, LocalDate.now()));

        System.out.println(getBooks(products));
        System.out.println(getProductsWithDiscount(products));
        System.out.println(getCheapestBook(products));
        System.out.println(getThreeLatestProducts(products));
        System.out.println(getProductsSum(products));
        System.out.println(getProductsHashmap(products));
    }

    public static List<Product> getBooks(List<Product> products) {
        return products.stream().filter(p -> p.getPrice() > 250 && p.getType().equals(Type.BOOK)).toList();
    }

    public static List<Product> getProductsWithDiscount(List<Product> products) {
        return products.stream().filter(p -> p.isDiscount() && p.getType().equals(Type.BOOK)).
                peek(product -> product.setPrice(product.getPrice() - (product.getPrice() * 10 / 100))).toList();
    }

    public static Product getCheapestBook(List<Product> products) {
        return products.stream().filter(p -> p.getType().equals(Type.BOOK)).
                min(Comparator.comparingInt(Product::getPrice)).
                orElseThrow(() -> new RuntimeException("Product [category: Book] not found"));
    }

    public static List<Product> getThreeLatestProducts(List<Product> products) {
        return products.stream().sorted(Comparator.comparing(Product::getCreateDate)).
                skip(products.size() - 3).toList();
    }

    public static int getProductsSum(List<Product> products) {
        return products.stream().filter(p -> (p.getPrice() <= 75 && p.getType().equals(Type.BOOK)) &&
                        (p.getCreateDate().isAfter(LocalDate.of(2021, 12, 31)) &&
                                p.getCreateDate().isBefore(LocalDate.of(2023, 1, 1)))).
                mapToInt(Product::getPrice).sum();
    }

    public static Map<Type, LinkedList<Product>> getProductsHashmap(List<Product> products) {
        Map<Type, LinkedList<Product>> productHashMap = new HashMap<>();
        products.stream().map(Product::getType).forEach(p -> productHashMap.put(p, new LinkedList<>()));
        products.stream().forEach(p -> productHashMap.get(p.getType()).add(p));
        return productHashMap;
    }
}
