package lesson11.homework15.coffee.order;

import java.util.*;

public class CoffeeOrderBoard {
    private HashMap<Integer, String> listOfOrders = new HashMap<>();

    public void add(CoffeeOrderBoard coffeeOrderBoard, String name) {
        if (coffeeOrderBoard.getListOfOrders().isEmpty()) {
            Order order = new Order(1, name);
            coffeeOrderBoard.getListOfOrders().put(order.getOrderNumber(), order.getClientName());
        } else {
            LinkedList<Integer> orderNumbers = new LinkedList<>();
            for (Map.Entry<Integer, String> entry : coffeeOrderBoard.getListOfOrders().entrySet()) {
                orderNumbers.add(entry.getKey());
            }
            Collections.sort(orderNumbers);
            coffeeOrderBoard.getListOfOrders().put(orderNumbers.getLast() + 1, name);
        }
    }

    public Order deliverClosest(CoffeeOrderBoard coffeeOrderBoard) {
        LinkedList<Integer> orderNumbers = new LinkedList<>();
        for (Map.Entry<Integer, String> entry : coffeeOrderBoard.getListOfOrders().entrySet()) {
            orderNumbers.add(entry.getKey());
        }
        Collections.sort(orderNumbers);
        Order order = new Order(orderNumbers.getFirst(),
                coffeeOrderBoard.getListOfOrders().get(coffeeOrderBoard.getListOfOrders()));
        coffeeOrderBoard.getListOfOrders().remove(orderNumbers.getFirst());
        return order;
    }

    public void deliver(CoffeeOrderBoard coffeeOrderBoard, Integer number) {

    }

    public HashMap<Integer, String> getListOfOrders() {
        return listOfOrders;
    }


}
