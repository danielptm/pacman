package com.danielptuttle.pacman.model.characters;

import javafx.scene.image.Image;

public abstract class Guy {
    private int positionX;
    private int positionY;

    private Image currentState;

    protected Image[] physicalStates;

    protected Guy(Image[] images) {
        physicalStates = images;
    }

    public void up() {

    }

    public void right() {

    }
    public void down() {

    }
    public void left() {

    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public Image getCurrentState() {
        currentState = physicalStates[(int) Math.floor(Math.random() * 10)];
        return currentState;
    }


}
