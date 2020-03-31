package com.danielptuttle.pacman.service;

import com.danielptuttle.pacman.model.barrier.WallRoot;

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




    static void createLineFromPoint(int startX, int startY, char[][] map, Direction direction, int length) {
        if (map[startX][startY] == '\u0000') {
            map[startX][startY]= 'w';
        }
        switch(direction) {
            case TOP:
                for (int i = 1; i < length; i++) {
                    map[startX][startY - i] = 'w';
                }
                break;
            case RIGHT:
                for (int i = 1; i < length; i++) {
                    map[startX + i][startY] = 'w';
                }
                break;
            case BOTTOM:
                for (int i = 1; i < length; i++) {
                    map[startX][startY + i] = 'w';
                }
                break;
            case LEFT:
                for (int i = 1; i < length; i++) {
                    map[startX - i][startY] = 'w';
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
