package com.company;

import com.company.figures.Figure;
import com.company.figures.Round;
import com.company.figures.Square;
import com.company.figures.Triangle;
import com.company.obstacles.Obstacle;
import com.company.obstacles.Treadmill;
import com.company.obstacles.Wall;
import com.company.participants.Cat;
import com.company.participants.Man;
import com.company.participants.Participant;
import com.company.participants.Robot;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Square square = new Square(2);
        Round round = new Round(3);
        Triangle triangle = new Triangle(2, 4);

        List<Figure> arraylist = new ArrayList<>();
        arraylist.add(square);
        arraylist.add(round);
        arraylist.add(triangle);

        countAllAreas(arraylist);


        Man man = new Man(100, 50);
        Cat cat = new Cat(40, 20);
        Robot robot = new Robot(200, 100);
        Treadmill treadmill = new Treadmill(100);
        Wall wall = new Wall(50);

        man.run(treadmill);
        man.jump(wall);
        cat.run(treadmill);
        cat.jump(wall);
        robot.run(treadmill);
        robot.jump(wall);

        List<Participant> participants = new ArrayList<>();
        participants.add(man);
        participants.add(cat);
        participants.add(robot);
        List<Obstacle> obstacles = new ArrayList<>();
        obstacles.add(treadmill);
        obstacles.add(wall);

        for (Participant p : participants) {
            for (Obstacle o : obstacles) {
                if (o.getClass() == Wall.class) p.jump(o);
                else p.run(o);
                if (o.overcome(p) && o.getClass() == Wall.class) {
                    System.out.println("Participant " + p + " overcame obstacle " + o +
                            " on distance " + wall.getHeight());
                }
                if (!o.overcome(p) && o.getClass() == Wall.class) {
                    System.out.println("Participant " + p + " didn't overcame obstacle " + o +
                            " on distance " + wall.getHeight() + ". He overcame " + p.getJumpHeight());
                }
                if (o.overcome(p) && o.getClass() == Treadmill.class) {
                    System.out.println("Participant " + p + " overcame obstacle " + o +
                            " on distance " + treadmill.getLength());
                }
                if (!o.overcome(p) && o.getClass() == Treadmill.class) {
                    System.out.println("Participant " + p + " didn't overcame obstacle " + o +
                            " on distance " + treadmill.getLength() + ". He overcame " + p.getRunLength());
                }
            }

        }
    }

    public static void countAllAreas(List<Figure> arrayList) {
        int sumSquare = 0;
        for (Figure f : arrayList) {
            sumSquare = sumSquare + f.calcArea();
        }
        System.out.println("Sum of all figures = " + sumSquare);

    }
}