package com.danielptuttle.pacman.service;

import com.danielptuttle.pacman.model.barrier.WallRoot;

import java.util.Arrays;

public class MapGenerator {

    public static WallRoot createPlus() {
        WallRoot wallRoot = new WallRoot(300);
        int num = 5;
        return wallRoot;
    }

    public WallRoot createLShape() {
        return null;
    }

    public WallRoot createTShape() {
        return null;
    }

    public WallRoot createBox() {
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

    static void createLineFromPoint(int startX, int startY, char[][] map, Direction direction, int length) {

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
}

enum Direction {
    TOP,
    RIGHT,
    BOTTOM,
    LEFT
}
