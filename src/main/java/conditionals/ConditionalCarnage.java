package conditionals;

class Robot {
    public void wagTail() {
    }

    public void smile() {
    }

    public void lookLeft() {
    }

    public void lookRight() {
    }

    public void dance() {
    }

    public void screamLikeAMonkey() {
    }
}


class Environment {
    public boolean motionToTheLeft() {
        return false;
    }

    public boolean motionToTheRight() {
        return false;
    }

    public boolean motionBelow() {
        return false;
    }

    public boolean motionAbove() {
        return false;
    }

}

public class ConditionalCarnage {
    public void runOpeningSequence() {
        Robot robot = new Robot();
        Environment sense = new Environment();
        robot.smile();
        robot.wagTail();
        if (sense.motionToTheLeft()) robot.lookLeft();
        if (sense.motionToTheLeft() && sense.motionToTheRight()) robot.lookRight();
        if (sense.motionToTheLeft() && !sense.motionToTheRight()) robot.dance();

        if (sense.motionToTheRight()) robot.lookLeft();
        if (sense.motionToTheRight() && sense.motionToTheLeft()) robot.smile();
        if (sense.motionToTheRight() && !sense.motionToTheLeft()) robot.dance();

        if (sense.motionBelow() || sense.motionAbove()) robot.screamLikeAMonkey();
    }
}