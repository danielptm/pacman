package com.danielptuttle.pacman.service;

import com.danielptuttle.pacman.model.characters.GameCharacters;
import com.danielptuttle.pacman.model.characters.Guy;
import com.danielptuttle.pacman.model.characters.GuyType;
import com.danielptuttle.pacman.model.characters.Pacman;
import com.danielptuttle.pacman.model.map.MapContext;
import javafx.scene.image.Image;
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

    //TODO: Implement this test with the corresponding function.
    @Test
    public void testClean() {
        Map<GuyType, List<? extends Guy>> guys = GameCharacters.get();
        Guy guy = (Guy) guys.get(GuyType.PACMAN);
        char[][] map = MapContext.getInstance().getMap();

        guy.setPosition(100,100, map);
        //Moves the guy down.
        guy.setPosition(guy.getPositionX(),guy.getPositionY() + guy.getSpeed(), map);

        MapUtils.clean(map, guy);




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
