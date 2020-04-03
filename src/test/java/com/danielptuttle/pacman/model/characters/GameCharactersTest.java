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

    @Test
    public void testCalculateImageStateUp() {
        Pacman pacman = new Pacman(null);
        int prevX = 2;
        int prevY = 2;
        int newX = 2;
        int newY = 1;
        pacman.calculateImageState(prevX, prevY, newX, newY);
        GuyDirection result = pacman.getGuyDirection();
        Assertions.assertEquals(GuyDirection.UP, result);
    }

    @Test
    public void testCalculateImageStateRight() {
        Pacman pacman = new Pacman(null);
        int prevX = 2;
        int prevY = 2;
        int newX = 3;
        int newY = 2;
        pacman.calculateImageState(prevX, prevY, newX, newY);
        GuyDirection result = pacman.getGuyDirection();

        Assertions.assertEquals(GuyDirection.RIGHT, result);
    }

    @Test
    public void testCalculateImageStateDown() {
        Pacman pacman = new Pacman(null);
        int prevX = 2;
        int prevY = 2;
        int newX = 2;
        int newY = 3;
        pacman.calculateImageState(prevX, prevY, newX, newY);
        GuyDirection result = pacman.getGuyDirection();
        Assertions.assertEquals(GuyDirection.DOWN, result);
    }

    @Test
    public void testCalculateImageStateLeft() {
        Pacman pacman = new Pacman(null);
        int prevX = 2;
        int prevY = 2;
        int newX = 1;
        int newY = 2;
        pacman.calculateImageState(prevX, prevY, newX, newY);
        GuyDirection result = pacman.getGuyDirection();
        Assertions.assertEquals(GuyDirection.LEFT, result);
    }
}
