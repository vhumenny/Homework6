package lesson11.homework15.coffee.order;

public class Main {
    public static void main(String[] args) {
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();

        coffeeOrderBoard.add(coffeeOrderBoard, "Vladimir");
        coffeeOrderBoard.add(coffeeOrderBoard, "Anna");
        coffeeOrderBoard.add(coffeeOrderBoard, "Artem");
        coffeeOrderBoard.add(coffeeOrderBoard, "Dima");
        coffeeOrderBoard.add(coffeeOrderBoard, "Vasiliy");

        System.out.println(coffeeOrderBoard.getListOfOrders());
        System.out.println(coffeeOrderBoard.deliverClosest(coffeeOrderBoard));
        System.out.println(coffeeOrderBoard.getListOfOrders());
        System.out.println(coffeeOrderBoard.deliver(coffeeOrderBoard,4));
        coffeeOrderBoard.draw(coffeeOrderBoard);


    }
}
