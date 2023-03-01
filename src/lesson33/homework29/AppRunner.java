package lesson33.homework29;

import lesson33.homework29.Cart.Cart;
import lesson33.homework29.configuration.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@Slf4j
public class AppRunner {

    public void start() {
        log.info("Starting app");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Cart cart = context.getBean("cartBean", Cart.class);
        while (true) {
            showListOfCommands();
            String line = new Scanner(System.in).nextLine();
            switch (line) {
                case "add" -> {
                    int id = getId();
                    cart.addProduct(id);
                }
                case "delete" -> {
                    int id = getId();
                    cart.deleteProduct(id);
                }
                case "print" -> cart.print();
                case "finish" -> log.info("Program shuts down.");
                default -> log.warn("Wrong command entered. Please enter correct command!");
            }
            if (line.equals("finish")) return;
        }
    }

    private static int getId() {
        System.out.println("Enter product id");
        return new Scanner(System.in).nextInt();
    }

    private void showListOfCommands() {
        System.out.println("""
                To add product in cart enter - add
                To delete product from cart enter - delete
                To print all products info enter - print
                To finish program enter - finish""");
    }
}
