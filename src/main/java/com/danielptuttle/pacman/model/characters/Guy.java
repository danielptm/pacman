package com.danielptuttle.pacman.model.characters;

import javafx.scene.image.Image;

public abstract class Guy {
    private GuyDirection guyDirection = GuyDirection.DOWN;

    private int previousX;
    private int previousY;
    private int currentPositionX;
    private int currentPositionY;

    private Image currentState;

    protected Image[] physicalStates;

    protected Guy(Image[] images) {
        physicalStates = images;
    }

    public int getPositionX() {
        return currentPositionX;
    }

    public int getPositionY() {
        return currentPositionY;
    }

    public void setPositionX(int positionX) {
        this.previousX = this.currentPositionX;
        this.currentPositionX = positionX;
        calculateImageState(this.previousX, this.previousY, this.currentPositionX, this.currentPositionY);
    }

    public void setPositionY(int positionY) {
        this.previousY = this.currentPositionY;
        this.currentPositionY = positionY;
        calculateImageState(this.previousX, this.previousY, this.currentPositionX, this.currentPositionY);
    }

    void calculateImageState(int prevX, int prevY, int newX, int newY) {
        if (prevX == newX) {
            if (newY > prevY) {
                guyDirection = GuyDirection.DOWN;
            }
            if (newY < prevY) {
                guyDirection = GuyDirection.UP;
            }
        }
        if (prevY == newY) {
            if (newX > prevX) {
                guyDirection = GuyDirection.RIGHT;
            }
            if (newX < prevX) {
                guyDirection = GuyDirection.LEFT;
            }
        }
    }

    public Image getCurrentState() {
        switch (guyDirection) {
            case UP:
                currentState = physicalStates[0];
                break;
            case RIGHT:
                currentState = physicalStates[1];
                break;
            case DOWN:
                currentState = physicalStates[2];
                break;
            case LEFT:
                currentState = physicalStates[3];
                break;
        }
        return currentState;
    }

    public GuyDirection getGuyDirection() {
        return guyDirection;
    }
}

enum GuyDirection{
    UP,
    RIGHT,
    DOWN,
    LEFT
}
