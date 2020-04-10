package com.danielptuttle.pacman.service;

import com.danielptuttle.pacman.model.barrier.WallRoot;
import com.danielptuttle.pacman.model.characters.Guy;

import java.util.Arrays;

public class MapUtils {

    public static void createPlus(int middleX, int middleY, char[][] map) {
        createLineFromPoint(middleX, middleY, map, Direction.TOP, 3);
        createLineFromPoint(middleX, middleY, map, Direction.RIGHT, 3);
        createLineFromPoint(middleX, middleY, map, Direction.LEFT, 3);
        createLineFromPoint(middleX, middleY, map, Direction.BOTTOM, 3);
    }

    public static void createRightLShape(int middleX, int middleY, char[][] map) {
        createLineFromPoint(middleX, middleY, map, Direction.TOP, 2);
        createLineFromPoint(middleX, middleY, map, Direction.LEFT, 2);
        createLineFromPoint(middleX, middleY, map, Direction.RIGHT, 3);
    }

    public static void createLeftLShape(int middleX, int middleY, char[][] map) {
        createLineFromPoint(middleX, middleY, map, Direction.TOP, 2);
        createLineFromPoint(middleX, middleY, map, Direction.LEFT, 3);
        createLineFromPoint(middleX, middleY, map, Direction.RIGHT, 2);
    }

    public static void createHalfDownPlus(int middleX, int middleY, char[][] map) {
        createLineFromPoint(middleX, middleY, map, Direction.BOTTOM, 2);
        createLineFromPoint(middleX, middleY, map, Direction.LEFT, 2);
        createLineFromPoint(middleX, middleY, map, Direction.RIGHT, 2);
    }

    public static void createQuarterRightPlus(int middleX, int middleY, char[][] map) {
        createLineFromPoint(middleX, middleY, map, Direction.BOTTOM, 2);
        createLineFromPoint(middleX, middleY, map, Direction.RIGHT, 2);
    }

    public static void createQuarterLeftPlus(int middleX, int middleY, char[][] map) {
        createLineFromPoint(middleX, middleY, map, Direction.BOTTOM, 2);
        createLineFromPoint(middleX, middleY, map, Direction.LEFT, 2);
    }

    public static void createElongatedBox(int middleX, int middleY, int length, char[][] map) {
        createLineFromPoint(middleX, middleY, map, Direction.RIGHT, length);
        createLineFromPoint(middleX , middleY + 25, map, Direction.RIGHT, length);
    }

    public WallRoot createTShape(int middleX, int middleY, char[][] map) {
        return null;
    }

    public WallRoot createBox(int middleX, int middleY, char[][] map) {
        return null;
    }



    static void createWallUnit(int startX, int startY, char[][] map) {
        for (int i = 0; i < 25; i++) {
            Arrays.fill(map[startY + i], startX, startX + 25, 'w');
        }
    }

    static boolean hasWallUnit(int startX, int startY, char[][] map) {
        boolean result = false;
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                if (map[startX + i][startY + j] == 'w') {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    public static void createLineFromPoint(int startX, int startY, char[][] map, Direction direction, int length) {

        boolean unitExists = hasWallUnit(startX, startY, map);
        if (!unitExists) {
            createWallUnit(startX, startY, map);
        }
        switch(direction) {
            case TOP:
                for (int i = 1; i <= length; i++) {
                    createWallUnit(startX, startY - (i * 25), map);
                }
                break;
            case RIGHT:
                for (int i = 1; i <= length; i++) {
                    createWallUnit(startX + (i * 25), startY, map);
                }
                break;
            case BOTTOM:
                for (int i = 1; i <= length; i++) {
                    createWallUnit(startX, startY + (i * 25), map);
                }
                break;
            case LEFT:
                for (int i = 1; i <= length; i++) {
                    createWallUnit(startX - (i * 25), startY , map);
                }
                break;
        }
    }

    /**
     * Takes a Guy and the map and returns int[]. The int[] has a lenth of 4 and describes a rectangle
     * where the guy has been. This int[] can be used by the clearRect() function of the
     * GraphicsContext.
     * The int[] has a length of 4.
     * int[0]
     * @param map
     * @param guy
     */
    public static int[] clean(char[][] map, Guy guy) {

        return null;
    }

}

