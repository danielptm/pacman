package com.danielptuttle.pacman.model.barrier;

import com.danielptuttle.pacman.model.characters.GameCharacters;
import javafx.scene.image.Image;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class WallUnit {
    private static final Logger LOGGER = LogManager.getLogger(GameCharacters.class);

    private static Image IMAGE;

    static {
        try {
            IMAGE = new Image(new FileInputStream(WallUnit.class.getClassLoader().getResource("barrier.png").getPath()), 25, 25, false, false);
        } catch (FileNotFoundException e) {
            LOGGER.error("There was a problem instantiating WallUnit: ", e);
        }
    }

    public WallUnit() { }

    public Image getImage() {
        return IMAGE;
    }
}
