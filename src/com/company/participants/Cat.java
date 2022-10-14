package com.company.participants;

import com.company.obstacles.Obstacle;

public class Cat extends Participant {

    public Cat(int runLength, int jumpHeight) {
        super(runLength, jumpHeight);
    }

    @Override
    public void run(Obstacle treadmill) {
        System.out.println("Cat runs");
    }

    @Override
    public void jump(Obstacle wall) {
        System.out.println("Cat jumps");
    }

    @Override
    public String toString() {
        return "Cat";
    }
}
