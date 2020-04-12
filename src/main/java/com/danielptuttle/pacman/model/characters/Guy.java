package com.danielptuttle.pacman.model.characters;

import com.danielptuttle.pacman.model.map.MapContext;
import com.danielptuttle.pacman.service.Direction;
import javafx.scene.image.Image;

public abstract class Guy {
    private GuyDirection guyDirection = GuyDirection.DOWN;
    private int speed = 5;

    private int previousX;
    private int previousY;
    private int currentPositionX;
    private int currentPositionY;

    private int upCounter = 9;
    private int rightCounter = 0;
    private int downCounter = 3;
    private int leftCounter = 6;

    private int imageWidth;
    private int imageHeight;

    private Image currentState;

    protected Image[] physicalStates;

    protected Guy(Image[] images, int initialPositionX, int initialPositionY) {
        physicalStates = images;
        this.currentPositionX = initialPositionX;
        this.currentPositionY = initialPositionY;
        setImageHeightAndWidths(this.physicalStates);
    }

    public int getSpeed() {
        return speed;
    }

    void setImageHeightAndWidths(Image[] images) {
        int height = 0;
        int width = 0;

        for (int i = 0; i < images.length; i++) {
            if (images[i].getHeight() > height) {
                height = (int) Math.ceil(images[i].getHeight());
            }
            if (images[i].getWidth() > width) {
                width = (int) Math.ceil(images[i].getWidth());
            }
        }

        this.imageWidth = width;
        this.imageHeight = height;
    }

    public void setPosition(int positionX, int positionY, char[][] map) {
        this.previousY = this.currentPositionY;
        this.previousX = this.currentPositionX;

        if ((positionX > 1 && positionX < 799) && (positionY > 1 && positionY < 798)) {
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
        for (int i = this.currentPositionX; i < this.currentPositionX + this.imageWidth; i++) {
            int detectSpot = this.currentPositionY - 1;
            int boundry = MapContext.getInstance().getHeight();
            if (detectSpot >= boundry || map[detectSpot][i] == 'w') {
                return true;
            }
        }
        return false;
    }

    public boolean objectIsRight(char[][] map) {
        for (int i = this.currentPositionY; i < this.currentPositionY + this.imageHeight; i++) {
            int detectSpot = this.currentPositionX + this.imageWidth + 2;
            int boundry = MapContext.getInstance().getWidth() - 1;
            if (detectSpot >= boundry || map[i][detectSpot] == 'w') {
                return true;
            }
        }
        return false;
    }

    public boolean objectIsDown(char[][] map) {
        for (int i = this.currentPositionX; i < this.currentPositionX + this.imageWidth; i++) {
            int detectSpot = this.currentPositionY + this.imageHeight + 1;
            int boundry = MapContext.getInstance().getHeight() - 1;
            if (detectSpot >= boundry || map[detectSpot][i] == 'w') {
                return true;
            }
        }
        return false;
    }

    public boolean objectIsLeft(char[][] map) {
        for (int i = this.currentPositionY; i < this.currentPositionY + this.imageHeight; i++) {
            int detectSpot = this.currentPositionX - 1;
            int boundry = 0;
            if (detectSpot <= boundry || map[i][detectSpot] == 'w') {
                return true;
            }
        }
        return false;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public int getPreviousX() {
        return previousX;
    }

    public int getPreviousY() {
        return previousY;
    }

    public int getPositionX() {
        return currentPositionX;
    }

    public int getPositionY() {
        return currentPositionY;
    }


    public GuyDirection getGuyDirection() {
        return guyDirection;
    }
}

