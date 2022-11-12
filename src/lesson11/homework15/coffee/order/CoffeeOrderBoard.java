package lesson11.homework15.coffee.order;

import java.util.*;

public class CoffeeOrderBoard {
    private TreeMap<Integer, String> listOfOrders = new TreeMap<>();

    public void add(String name) {
        Order order;
        if (getListOfOrders().isEmpty()) {
            order = new Order(1, name);
        } else {
            order = new Order(getListOfOrders().lastKey() + 1, name);
        }
        getListOfOrders().put(order.getOrderNumber(), order.getClientName());
    }

    public Order deliver() {
        LinkedList<Integer> orderNumbers = new LinkedList<>();
        for (Map.Entry<Integer, String> entry : getListOfOrders().entrySet()) {
            orderNumbers.add(entry.getKey());
        }
        Order order = new Order(orderNumbers.getFirst(),
                getListOfOrders().get(orderNumbers.getFirst()));
        getListOfOrders().remove(orderNumbers.getFirst());
        return order;
    }

    public Order deliver(Integer number) {
        Order order = new Order(number, getListOfOrders().get(number));
        getListOfOrders().remove(number);
        return order;
    }

    public void draw() {
        LinkedList<Integer> orderNumbers = new LinkedList<>();
        for (Map.Entry<Integer, String> entry : getListOfOrders().entrySet()) {
            orderNumbers.add(entry.getKey());
        }
        System.out.println("=======================\n Num   |   Name");
        for (int i = 0; i < orderNumbers.size(); i++) {
            System.out.println("  " + orderNumbers.get(i) + "    |   " + getListOfOrders().get(orderNumbers.get(i)));
        }
    }

    public TreeMap<Integer, String> getListOfOrders() {
        return listOfOrders;
    }
}
