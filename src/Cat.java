import obstacles.Obstacle;

public class Cat extends Participant {
    private int runLength;
    private int jumpHeight;

    public Cat(int runLength, int jumpHeight) {
        this.runLength = runLength;
        this.jumpHeight = jumpHeight;
    }

    @Override
    public void run(Obstacle treadmill) {
        System.out.println("Cat runs");
    }

    @Override
    public void jump(Obstacle wall) {
        System.out.println("Cat jumps");
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
