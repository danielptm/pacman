package com.danielptuttle.pacman.pacman.characters;

import javafx.scene.image.Image;

import java.awt.image.BufferedImage;

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

    public Image getCurrentState() {
        currentState = physicalStates[(int) Math.floor(Math.random() * 10)];
        return currentState;
    }


}
