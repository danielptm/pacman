package com.danielptuttle.pacman.util;

import com.danielptuttle.pacman.model.characters.Guy;
import com.danielptuttle.pacman.model.characters.GuyType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SpriteLoaderTest {

    private SpriteLoader spriteLoader;

    @BeforeEach
    public void setup() {
        String fileName = getClass().getClassLoader().getResource("images.png").getPath();
        this.spriteLoader = new SpriteLoader(fileName);
    }

    @Test
    public void testBuild() throws IOException {
        BufferedImage[][] subImages = spriteLoader.loadSpritesFromSheet();
        Assertions.assertEquals(20, subImages[19].length);
    }

    @Test
    public void testLoadGuys() throws IOException {
        BufferedImage[][] subImages = spriteLoader.loadSpritesFromSheet();
        Map<GuyType, List<? extends Guy>> guyMap = spriteLoader.loadGuys(subImages);
        Assertions.assertEquals(6, guyMap.get(GuyType.GHOST).size());
    }
}
