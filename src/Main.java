public class Main {
    public static void main(String[] args) {

        Man man = new Man();
        Cat cat = new Cat();
        Robot robot= new Robot();

        Treadmill treadmill=new Treadmill();
        Wall wall = new Wall();

        man.run(treadmill);
        man.jump(wall);

        cat.run(treadmill);
        cat.jump(wall);

        robot.run(treadmill);
        robot.jump(wall);

        Participant [] participants = new Participant[] {man,cat,robot};
        Obstacle [] obstacles = new Obstacle[] {treadmill,wall};

        for (int i = 0; i < participants.length; i++) {

            for (int j = 0; j < obstacles.length; j++) {
                if (obstacles[j]==treadmill){
                    participants[i].run(obstacles[j]);
                }
                else {
                    participants[i].jump(obstacles[j]);
                }


            }
        }

    }
}

class Participant {
    public void run(Treadmill treadmill) {
        System.out.println("run");
    }

    public void jump(Wall wall) {
        System.out.println("jump");
    }
}

class Man extends Participant {
    public void run(Treadmill treadmill) {
        System.out.println("Man runs");
    }

    public void jump(Wall wall) {
        System.out.println("Man jumps");
    }
}

class Cat extends Participant {
    public void run(Treadmill treadmill) {
        System.out.println("Cat runs");
    }

    public void jump(Wall wall) {
        System.out.println("Cat jumps");
    }
}

class Robot extends Participant {
    public void run(Treadmill treadmill) {
        System.out.println("Robot runs");
    }

    public void jump(Wall wall) {
        System.out.println("Robot jumps");
    }

}