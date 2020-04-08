package com.danielptuttle.pacman.model.characters;

import javafx.scene.image.Image;

public abstract class Guy {
    private GuyDirection guyDirection = GuyDirection.DOWN;

    private int previousX;
    private int previousY;
    private int currentPositionX;
    private int currentPositionY;

    int upCounter = 9;
    int rightCounter = 0;
    int downCounter = 3;
    int leftCounter = 6;

    private Image currentState;

    protected Image[] physicalStates;

    protected Guy(Image[] images, int initialPositionX, int initialPositionY) {
        physicalStates = images;
        this.currentPositionX = initialPositionX;
        this.currentPositionY = initialPositionY;
    }

    public int getPositionX() {
        return currentPositionX;
    }

    public int getPositionY() {
        return currentPositionY;
    }

    public void setPosition(int positionX, int positionY, char[][] map) {
        this.previousY = this.currentPositionY;
        this.previousX = this.currentPositionX;

        if (positionX > this.previousX) {
            if (!objectIsRight(map)) {
                this.currentPositionX = positionX;
            }
        }
        if (positionX < this.previousX) {
            if (!objectIsLeft(map)) {
                this.currentPositionX = positionX;
            }
        }

        if (positionY > this.previousY) {
            if (!objectIsDown(map)) {
                this.currentPositionY = positionY;
            }
        }

        if (positionY < this.previousY) {
            if (!objectIsUp(map)) {
                this.currentPositionY = positionY;
            }
        }
        calculateImageState(this.previousX, this.previousY, this.currentPositionX, this.currentPositionY);
    }

    void calculateImageState(int prevX, int prevY, int newX, int newY) {
        if (prevX == newX) {
            if (newY > prevY) {
                if (downCounter < 5) {
                    downCounter++;
                } else {
                    downCounter = 3;
                }
                guyDirection = GuyDirection.DOWN;
            }
            if (newY < prevY) {
                guyDirection = GuyDirection.UP;
            }
        }
        if (prevY == newY) {
            if (newX > prevX) {
                if (rightCounter < 2) {
                    rightCounter++;
                } else {
                    rightCounter = 0;
                }
                guyDirection = GuyDirection.RIGHT;
            }
            if (newX < prevX) {
                if (leftCounter < 8) {
                    leftCounter++;
                } else {
                    leftCounter = 6;
                }
                guyDirection = GuyDirection.LEFT;
            }
        }
    }

    public Image getCurrentState() {
        switch (this.guyDirection) {
            case UP:
                this.currentState = physicalStates[upCounter];
                break;
            case RIGHT:
                this.currentState = physicalStates[rightCounter];
                break;
            case DOWN:
                this.currentState = physicalStates[downCounter];
                break;
            case LEFT:
                this.currentState = physicalStates[leftCounter];
                break;
        }
        return currentState;
    }

    //TODO: Fix the unit tests for these functions, because they are messed up.
    public boolean objectIsUp(char[][] map) {
        for (int i = this.currentPositionX; i < this.currentPositionX + 49; i++) {
            if (map[this.currentPositionY - 1][i] == 'w') {
                return true;
            }
        }
        return false;
    }


    public boolean objectIsRight(char[][] map) {
        for (int i = this.currentPositionY; i < this.currentPositionY + 50; i++) {
            if (map[i][this.currentPositionX + 50] == 'w') {
                return true;
            }
        }
        return false;
    }

    public boolean objectIsDown(char[][] map) {
        for (int i = this.currentPositionX; i < this.currentPositionX + 49; i++) {
            if (map[this.currentPositionY + 50][i] == 'w') {
                return true;
            }
        }
        return false;
    }

    public boolean objectIsLeft(char[][] map) {
        for (int i = this.currentPositionY; i < this.currentPositionY + 49; i++) {
            if (map[i][this.currentPositionX - 1] == 'w') {
                return true;
            }
        }
        return false;
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
