package com.company.participants;

import com.company.obstacles.Obstacle;

public class Participant {
    private int runLength;
    private int jumpHeight;

    public Participant(int runLength, int jumpHeight) {
        this.runLength = runLength;
        this.jumpHeight = jumpHeight;
    }

    public void run(Obstacle treadmill) {
        System.out.println("run");
    }

    public void jump(Obstacle wall) {
        System.out.println("jump");
    }

    public int getRunLength() {
        return runLength;
    }

    public void setRunLength(int runLength) {
        this.runLength = runLength;
    }

    public int getJumpHeight() {
        return jumpHeight;
    }

    public void setJumpHeight(int jumpHeight) {
        this.jumpHeight = jumpHeight;
    }
}