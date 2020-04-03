package com.danielptuttle.pacman.model.characters;

import com.danielptuttle.pacman.model.barrier.WallUnit;
import javafx.scene.image.Image;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class GameCharactersTest {

    @Test
    public void testLoadGuys() throws IOException {
        Map<GuyType, List<? extends Guy>> guyMap = GameCharacters.get();
        Assertions.assertEquals(6, guyMap.get(GuyType.GHOST).size());
    }

    @Test
    public void testing() {
        Image image = WallUnit.getImage();
    }
}
