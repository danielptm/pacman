package com.danielptuttle.pacman.model.characters;

import com.danielptuttle.pacman.model.map.MapContext;
import com.danielptuttle.pacman.service.Direction;
import com.danielptuttle.pacman.service.MapGenerator;
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

    @Test
    public void testObjectIsUp() {
        Pacman pacman = new Pacman(null);
        pacman.setPosition(225,225);
        char[][] map = MapContext.getInstance().getMap();
        MapGenerator.createLineFromPoint(200,200, map, Direction.RIGHT, 2);
        boolean result = pacman.objectIsUp(map);
        Assertions.assertEquals(true, result);
        pacman.setPosition(227, 227);
        boolean result2 = pacman.objectIsUp(map);
        Assertions.assertEquals(false, result2);
    }

    @Test
    public void testObjectIsRight() {
        Pacman pacman = new Pacman(null);
        pacman.setPosition(176,200);
        char[][] map = MapContext.getInstance().getMap();
        MapGenerator.createLineFromPoint(200,200, map, Direction.RIGHT, 2);

        boolean result = pacman.objectIsRight(map);
        Assertions.assertEquals(true, result);

        pacman.setPosition(176, 227);

        boolean result2 = pacman.objectIsRight(map);
        Assertions.assertEquals(false, result2);
    }

    @Test
    public void testObjectIsDown() {
        Pacman pacman = new Pacman(null);
        pacman.setPosition(225,176);
        char[][] map = MapContext.getInstance().getMap();
        MapGenerator.createLineFromPoint(200,200, map, Direction.RIGHT, 2);
        boolean result = pacman.objectIsDown(map);
        Assertions.assertEquals(true, result);
        pacman.setPosition(250, 250);

        boolean result2 = pacman.objectIsDown(map);
        Assertions.assertEquals(false, result2);
    }

    @Test
    public void testObjectIsLeft() {
        Pacman pacman = new Pacman(null);
        pacman.setPosition(224,200);
        char[][] map = MapContext.getInstance().getMap();
        MapGenerator.createLineFromPoint(200,200, map, Direction.RIGHT, 1);
        boolean result = pacman.objectIsLeft(map);
        Assertions.assertEquals(true, result);
        pacman.setPosition(227, 227);
        boolean result2 = pacman.objectIsLeft(map);
        Assertions.assertEquals(false, result2);
    }
}
