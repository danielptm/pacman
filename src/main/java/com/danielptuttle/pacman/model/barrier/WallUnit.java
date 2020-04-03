package com.danielptuttle.pacman.model.barrier;

import com.danielptuttle.pacman.model.characters.GameCharacters;
import javafx.scene.image.Image;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class WallUnit {
    private static final Logger LOGGER = LogManager.getLogger(GameCharacters.class);

    public static int WIDTH = 25;
    public static int HEIGHT = 25;

    private static Image IMAGE;

    static {
        try {
            IMAGE = new Image(new FileInputStream(WallUnit.class.getClassLoader().getResource("barrier.png").getPath()), WIDTH, HEIGHT, false, false);
        } catch (FileNotFoundException e) {
            LOGGER.error("There was a problem instantiating WallUnit: ", e);
        }
    }

    private WallUnit() { }

    public static Image getImage() {
        return IMAGE;
    }
}
