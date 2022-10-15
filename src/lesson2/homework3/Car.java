package lesson2.homework3;

public class Car {

    public void start () {
        startElectricity();
        startCommand();
        startFuelSystem();
    }
    private void startElectricity(){
        System.out.println("Start electricity");
    }
    private void startCommand(){
        System.out.println("start command");
    }
    private void startFuelSystem(){
        System.out.println("start fuel system");
    }
}
