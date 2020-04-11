package com.danielptuttle.pacman.service;

import com.danielptuttle.pacman.model.characters.GameCharacters;
import com.danielptuttle.pacman.model.characters.Guy;
import com.danielptuttle.pacman.model.characters.GuyType;
import com.danielptuttle.pacman.model.map.MapContext;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class MapUtilsTest {

    @Test
    public void testCreateWallUnit () {
        int startX = 200;
        int startY = 200;
        char[][] map = MapContext.getInstance().getMap();

        char[][] result = MapContext.getInstance().getMap();

        MapUtils.createWallUnit(startX, startY, result);

//        printArray(result);

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

        MapUtils.createLineFromPoint(startX, startY, map, left, length);
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
        MapUtils.createLineFromPoint(startX, startY, map, left, length);

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
        MapUtils.createLineFromPoint(startX, startY, map, right, length);

//        printArray(map);

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
        MapUtils.createLineFromPoint(startX, startY, map, left, length);



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
        MapUtils.createLineFromPoint(startX, startY, map, left, length);

        Assertions.assertEquals('w', map[200][200]);
        Assertions.assertEquals('w', map[224][200]);
        Assertions.assertEquals('w', map[200][126]);
        Assertions.assertEquals('w', map[224][126]);
    }

    //TODO: THESE TESTS ARE ALL FAILING ...FIX!
    @Test
    public void testClean() {
        Guy guy = (Guy) GameCharacters.get().get(GuyType.PACMAN).get(0);
        char[][] map = MapContext.getInstance().getMap();

        int x = 100;
        int y = 100;

        //Moves guy up
        guy.setPosition(guy.getPositionX(), guy.getPositionY() - guy.getSpeed(), map);
        int[] result1 = MapUtils.clean(map, guy);

        Assertions.assertEquals(95, result1[0]);
        Assertions.assertEquals(100, result1[1]);
        Assertions.assertEquals(10, result1[2]);
        Assertions.assertEquals(43, result1[3]);

        //Moves guy right
        guy.setPosition(guy.getPositionX() + guy.getSpeed(), guy.getPositionY(), map);
        int[] result2 = MapUtils.clean(map, guy);

        Assertions.assertEquals(95, result2[0]);
        Assertions.assertEquals(100, result2[1]);
        Assertions.assertEquals(10, result2[2]);
        Assertions.assertEquals(43, result2[3]);


        //Moves the guy down.
        guy.setPosition(guy.getPositionX(),guy.getPositionY() + guy.getSpeed(), map);

        int[] result3 = MapUtils.clean(map, guy);

        Assertions.assertEquals(100, result3[0]);
        Assertions.assertEquals(95, result3[1]);
        Assertions.assertEquals(42, result3[2]);
        Assertions.assertEquals(10, result3[3]);

        //Moves guy left
        guy.setPosition(guy.getPositionX(),guy.getPositionY() + guy.getSpeed(), map);

        int[] result4 = MapUtils.clean(map, guy);

        Assertions.assertEquals(100, result4[0]);
        Assertions.assertEquals(95, result4[1]);
        Assertions.assertEquals(42, result4[2]);
        Assertions.assertEquals(10, result4[3]);
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
