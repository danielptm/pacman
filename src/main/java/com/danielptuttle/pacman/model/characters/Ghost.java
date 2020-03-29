package com.danielptuttle.pacman.model.characters;

import javafx.scene.image.Image;

public class Ghost extends Guy {
    private Enum color;
    public Ghost(Enum color, Image[] images) {
        super(images);
        this.color = color;
    }
}
