package com.danielptuttle.pacman.model.characters;

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
}
