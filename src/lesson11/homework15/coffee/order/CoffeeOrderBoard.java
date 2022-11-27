package lesson11.homework15.coffee.order;

import java.util.*;

public class CoffeeOrderBoard {
    private Queue<Order> queueOfOrders = new LinkedList<>();
    private int lastOrderNumber = 1;

    public void add(String name) {
        queueOfOrders.add(new Order(lastOrderNumber, name));
        lastOrderNumber++;
    }

    public Order deliver() {
        return queueOfOrders.poll();
    }

    public Order deliver(Integer number) {
        Order order;
        for (Order o : queueOfOrders) {
            if (o.getOrderNumber() == number) {
                order = o;
                queueOfOrders.remove(o);
                return order;
            }
        }
        return null;
    }

    public void draw() {
        System.out.println("=======================\n Num   |   Name");
        for (Order order : queueOfOrders) {
            System.out.println("  " + order.getOrderNumber() + "    |   " +
                    order.getClientName());
        }
    }

    public Queue<Order> getQueueOfOrders() {
        return queueOfOrders;
    }
}
