package com.company.obstacles;

import com.company.participants.Participant;

public class Treadmill extends Obstacle {
    private int length;

    public Treadmill(int length) {
        this.length = length;
    }

    @Override
    public boolean overcome(Participant participant) {
        return length <= participant.getRunLength();

    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Treadmill";
    }
}
