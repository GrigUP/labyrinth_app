package ru.grig.labyrinth_app.domain;

import ru.grig.labyrinth_app.domain.entities.Robot;

public class RobotState {

    private int x;

    private int y;

    public RobotState() {
    }

    public RobotState(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
