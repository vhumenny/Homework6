package lesson11.homework15.coffee.order;

import java.lang.reflect.Array;
import java.util.Objects;

public class Order {
    private int orderNumber;
    private String clientName;

    public Order(int orderNumber, String clientName) {
        this.orderNumber = orderNumber;
        this.clientName = clientName;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getClientName() {
        return clientName;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", clientName='" + clientName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderNumber == order.orderNumber && Objects.equals(clientName, order.clientName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber, clientName);
    }
}
