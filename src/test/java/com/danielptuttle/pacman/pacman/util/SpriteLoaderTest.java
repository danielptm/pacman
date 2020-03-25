package com.danielptuttle.pacman.pacman.util;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class SpriteLoaderTest {

    @Test
    public void testing() throws IOException {
        String fileName = getClass().getClassLoader().getResource("images.png").getPath();
        SpriteLoader spriteLoader = new SpriteLoader(fileName);
        spriteLoader.buildImageArray();


    }
}
