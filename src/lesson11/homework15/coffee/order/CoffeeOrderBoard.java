package lesson11.homework15.coffee.order;

import java.util.*;

public class CoffeeOrderBoard {
    private TreeMap<Integer, String> listOfOrders = new TreeMap<>();

    public void add(CoffeeOrderBoard coffeeOrderBoard, String name) {
        if (coffeeOrderBoard.getListOfOrders().isEmpty()) {
            Order order = new Order(1, name);
            coffeeOrderBoard.getListOfOrders().put(order.getOrderNumber(), order.getClientName());
        } else {
            LinkedList<Integer> orderNumbers = new LinkedList<>();
            for (Map.Entry<Integer, String> entry : coffeeOrderBoard.getListOfOrders().entrySet()) {
                orderNumbers.add(entry.getKey());
            }
            coffeeOrderBoard.getListOfOrders().put(orderNumbers.getLast() + 1, name);
        }
    }

    public Order deliverClosest(CoffeeOrderBoard coffeeOrderBoard) {
        LinkedList<Integer> orderNumbers = new LinkedList<>();
        for (Map.Entry<Integer, String> entry : coffeeOrderBoard.getListOfOrders().entrySet()) {
            orderNumbers.add(entry.getKey());
        }
        Order order = new Order(orderNumbers.getFirst(),
                coffeeOrderBoard.getListOfOrders().get(orderNumbers.getFirst()));
        coffeeOrderBoard.getListOfOrders().remove(orderNumbers.getFirst());
        return order;
    }

    public Order deliver(CoffeeOrderBoard coffeeOrderBoard, Integer number) {
        Order order = new Order(number, coffeeOrderBoard.getListOfOrders().get(number));
        coffeeOrderBoard.getListOfOrders().remove(number);
        return order;
    }

    public void draw(CoffeeOrderBoard coffeeOrderBoard) {
        LinkedList<Integer> orderNumbers = new LinkedList<>();
        for (Map.Entry<Integer, String> entry : coffeeOrderBoard.getListOfOrders().entrySet()) {
            orderNumbers.add(entry.getKey());
        }
        System.out.println("=======================\n Num   |   Name");
        for (int i = 0; i < orderNumbers.size(); i++) {
            System.out.println("  " + orderNumbers.get(i) + "    |   " + coffeeOrderBoard.getListOfOrders().get(orderNumbers.get(i)));
        }
    }

    public TreeMap<Integer, String> getListOfOrders() {
        return listOfOrders;
    }
}
