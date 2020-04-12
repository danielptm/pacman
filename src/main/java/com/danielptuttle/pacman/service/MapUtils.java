package com.danielptuttle.pacman.service;

import com.danielptuttle.pacman.model.barrier.WallRoot;
import com.danielptuttle.pacman.model.characters.Guy;
import com.danielptuttle.pacman.model.characters.GuyDirection;
import com.danielptuttle.pacman.model.map.MapContext;
import javafx.scene.canvas.GraphicsContext;

import java.util.Arrays;

public class MapUtils {

    public static void createPlus(int middleX, int middleY, char[][] map, int length) {
        createLineFromPoint(middleX, middleY, map, Direction.TOP, length);
        createLineFromPoint(middleX, middleY, map, Direction.RIGHT, length);
        createLineFromPoint(middleX, middleY, map, Direction.LEFT, length);
        createLineFromPoint(middleX, middleY, map, Direction.BOTTOM, length);
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
        createWallUnit(startX, startY, map);
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
     * Cleans the graphics context in an area 5 pixels in every direction of pacman as long as the pixel is not a 'w'
     *
     * @param guy
     */
    public static void clean(GraphicsContext gc, MapContext mapContext, Guy guy) {
        int startY = guy.getPositionY() - 5;
        int startX = guy.getPositionX() - 5;

        int maxY = startY + guy.getImageHeight() + 10;
        int maxX = startX + guy.getImageWidth() + 10;

        for (int y = startY; y < maxY; y++) {
            for (int x = startX; x < maxX; x++) {
                if (x < mapContext.getWidth() - 1 && y < mapContext.getHeight() - 1) {
                    if (mapContext.getMap()[y][x] != 'w') {
                        gc.clearRect(x, y, 1, 1);
                    }
                }
            }
        }
    }
}

