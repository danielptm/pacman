package com.danielptuttle.pacman.model.characters;

import javafx.scene.image.Image;

public class Ghost extends Guy {
    private Enum color;
    public Ghost(Enum color, Image[] images, int initialPositionX, int initialPositionY) {
        super(images, initialPositionX, initialPositionY);
        this.color = color;
    }
}
