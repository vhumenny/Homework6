package lesson17.homework16;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

public class Product {
    private int idNumber;
    private String type;
    private int price;
    private boolean discount;
    private LocalDate createDate;

    public List<Product> getBooks(List<Product> products) {
        Stream<Product> stream = products.stream();
        return stream.filter(p -> p.price > 250 && p.type.equals("Book")).toList();
    }

    public List<Product> getProductsWithDiscount(List<Product> products) {
        Stream<Product> stream = products.stream();
        return stream.filter(p -> p.discount && p.type.equals("Book")).
                peek(product -> product.price -= (product.price * 10 / 100)).toList();
    }

    public Product getCheapestBook(List<Product> products) {
        Stream<Product> stream = products.stream();
        return stream.filter(p -> p.type.equals("Book")).
                min(Comparator.comparingInt(p -> p.price)).
                orElseThrow(() -> new RuntimeException("Product [category: Book] not found"));
    }

    public List<Product> getThreeLatestProducts(List<Product> products) {
        Stream<Product> stream = products.stream();
        return stream.sorted(Comparator.comparing(p -> p.createDate)).skip(products.size() - 3).toList();
    }

    public int getProductsSum(List<Product> products) {
        Stream<Product> stream = products.stream();
        return stream.filter(p -> (p.price <= 75 && p.type.equals("Book")) &&
                        (p.createDate.isAfter(LocalDate.of(2021, 12, 31)) &&
                                p.createDate.isBefore(LocalDate.of(2023, 1, 1)))).
                mapToInt(p -> p.price).sum();
    }

    public Map<String, LinkedList<Product>> getProductsHashmap(List<Product> products) {
        Map<String, LinkedList<Product>> productHashMap = new HashMap<>();
        Stream<Product> stream1 = products.stream();
        Stream<Product> stream2 = products.stream();
        stream1.map(p -> p.type).forEach(p -> productHashMap.put(p, new LinkedList<>()));
        stream2.forEach(p -> productHashMap.get(p.type).add(p));
        return productHashMap;
    }

    public Product(int idNumber, String type, int price, boolean discount, LocalDate createDate) {
        this.idNumber = idNumber;
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idNumber=" + idNumber +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", createDate=" + createDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return idNumber == product.idNumber && price == product.price && discount == product.discount &&
                Objects.equals(type, product.type) && Objects.equals(createDate, product.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNumber, type, price, discount, createDate);
    }
}
