package lesson17.homework16;

import java.time.LocalDate;
import java.util.*;

public class Product {
    private int idNumber;
    private Type type;
    private int price;
    private boolean discount;
    private LocalDate createDate;


    public Product(int idNumber, Type type, int price, boolean discount, LocalDate createDate) {
        this.idNumber = idNumber;
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.createDate = createDate;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public Type getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isDiscount() {
        return discount;
    }

    public LocalDate getCreateDate() {
        return createDate;
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
