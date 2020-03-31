package com.danielptuttle.pacman.service;

import com.danielptuttle.pacman.model.map.MapContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MapGeneratorTest {

    @Test
    public void testCreateLineFromNodeTop() {
        int startX = 200;
        int startY = 200;
        int length = 3;
        char[][] map = MapContext.getInstance().getMap();
        Direction left = Direction.TOP;

        MapGenerator.createLineFromPoint(startX, startY, map, left, length);
        Assertions.assertEquals('w', map[200][200]);
        Assertions.assertEquals('w', map[200][199]);
        Assertions.assertEquals('w', map[200][198]);
    }

    @Test
    public void testCreateLineFromNodeRight() {
        int startX = 200;
        int startY = 200;
        int length = 3;
        char[][] map = MapContext.getInstance().getMap();
        Direction left = Direction.RIGHT;
        MapGenerator.createLineFromPoint(startX, startY, map, left, length);
        Assertions.assertEquals('w', map[200][200]);
        Assertions.assertEquals('w', map[201][200]);
        Assertions.assertEquals('w', map[202][200]);

    }

    @Test
    public void testCreateLineFromNodeBottom() {
        int startX = 200;
        int startY = 200;
        int length = 3;
        char[][] map = MapContext.getInstance().getMap();
        Direction left = Direction.BOTTOM;
        MapGenerator.createLineFromPoint(startX, startY, map, left, length);
        Assertions.assertEquals('w', map[200][200]);
        Assertions.assertEquals('w', map[200][201]);
        Assertions.assertEquals('w', map[200][202]);
    }

    @Test
    public void testCreateLineFromNodeLeft() {
        int startX = 200;
        int startY = 200;
        int length = 3;
        char[][] map = MapContext.getInstance().getMap();
        Direction left = Direction.LEFT;
        MapGenerator.createLineFromPoint(startX, startY, map, left, length);
        Assertions.assertEquals('w', map[200][200]);
        Assertions.assertEquals('w', map[199][200]);
        Assertions.assertEquals('w', map[198][200]);
    }




}
