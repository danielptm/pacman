package com.danielptuttle.pacman.pacman.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteLoaderTest {

    @Test
    public void testing() throws IOException {
        String fileName = getClass().getClassLoader().getResource("images.png").getPath();
        SpriteLoader spriteLoader = new SpriteLoader(fileName);
        BufferedImage[][] subImages = spriteLoader.buildImageArray();

        Assertions.assertEquals(20, subImages[19].length);

    }
}
