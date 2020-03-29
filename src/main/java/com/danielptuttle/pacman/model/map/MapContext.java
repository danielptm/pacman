package com.danielptuttle.pacman.model.map;

public class MapContext {
    private static int width = 800;
    private static int height = 800;


    private boolean[][] availableSpaces = new boolean[width * 4][height * 4];

    private static final MapContext MAP_CONTEXT = new MapContext();

    private MapContext() {}

    public static MapContext get() {
        return MAP_CONTEXT;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
