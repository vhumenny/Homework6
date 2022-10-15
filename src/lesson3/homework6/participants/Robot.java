package lesson3.homework6.participants;

import lesson3.homework6.obstacles.Obstacle;

public class Robot extends Participant {

    public Robot(int runLength, int jumpHeight) {
        super(runLength, jumpHeight);
    }

    @Override
    public void run(Obstacle treadmill) {
        System.out.println("Robot runs");
    }

    @Override
    public void jump(Obstacle wall) {
        System.out.println("Robot jumps");
    }

    @Override
    public String toString() {
        return "Robot";
    }
}