package lesson11.homework15.coffee.order;

public class Main {
    public static void main(String[] args) {
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();

        coffeeOrderBoard.add("Vladimir");
        coffeeOrderBoard.add("Anna");
        coffeeOrderBoard.add("Artem");
        coffeeOrderBoard.add("Dima");
        coffeeOrderBoard.add("Vasiliy");
        System.out.println(coffeeOrderBoard.getQueueOfOrders());
        System.out.println(coffeeOrderBoard.deliver());
        System.out.println(coffeeOrderBoard.deliver(3));
        coffeeOrderBoard.draw();
        System.out.println(coffeeOrderBoard.getQueueOfOrders());
    }
}
