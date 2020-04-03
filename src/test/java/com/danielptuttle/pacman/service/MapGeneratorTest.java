package com.danielptuttle.pacman.service;

import com.danielptuttle.pacman.model.map.MapContext;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MapGeneratorTest {

    @Test
    public void testCreateWallUnit () {
        int startX = 200;
        int startY = 200;
        char[][] map = MapContext.getInstance().getMap();

        char[][] result = MapContext.getInstance().getMap();

        MapGenerator.createWallUnit(startX, startY, result);

        printArray(result);

        Assertions.assertEquals('w', result[200][200]);
        Assertions.assertEquals('w', result[212][212]);
        Assertions.assertEquals('w', result[224][224]);


    }

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
    public void testCreateLineFromTop() {
        int startX = 200;
        int startY = 200;
        int length = 3;
        char[][] map = MapContext.getInstance().getMap();
        Direction left = Direction.TOP;
        MapGenerator.createLineFromPoint(startX, startY, map, left, length);

        Assertions.assertEquals('w', map[125][200]);
        Assertions.assertEquals('w', map[125][224]);
    }

    @Test
    public void testCreateLineFromNodeRight() {
        int startX = 200;
        int startY = 200;
        int length = 3;
        char[][] map = MapContext.getInstance().getMap();
        Direction right = Direction.RIGHT;
        MapGenerator.createLineFromPoint(startX, startY, map, right, length);

        printArray(map);

        Assertions.assertEquals('w', map[200][225]);
        Assertions.assertEquals('w', map[224][274]);
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
        Assertions.assertEquals('w', map[275][200]);
        Assertions.assertEquals('w', map[275][224]);
        Assertions.assertEquals('w', map[200][224]);
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
        Assertions.assertEquals('w', map[224][200]);
        Assertions.assertEquals('w', map[200][126]);
        Assertions.assertEquals('w', map[224][126]);
    }


    @Ignore
    public void testing() {
        char[][] ws = new char[8][8];

        ws[2][5] = 'w';
        ws[2][6] = 'w';

        printArray(ws);
    }

    static void printArray(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }


}
