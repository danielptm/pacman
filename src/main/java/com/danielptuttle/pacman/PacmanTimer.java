package com.danielptuttle.pacman;

import com.danielptuttle.pacman.model.barrier.WallUnit;
import com.danielptuttle.pacman.model.characters.Ghost;
import com.danielptuttle.pacman.model.characters.Guy;
import com.danielptuttle.pacman.model.characters.GuyType;
import com.danielptuttle.pacman.model.characters.Pacman;
import com.danielptuttle.pacman.model.map.MapContext;
import com.danielptuttle.pacman.service.Direction;
import com.danielptuttle.pacman.service.MapUtils;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.List;
import java.util.Map;

public class PacmanTimer extends AnimationTimer {
    private GraphicsContext gc;
    private Map<GuyType, List<? extends Guy>> guyMap;
    private MapContext mapContext = MapContext.getInstance();

    public PacmanTimer(GraphicsContext gc, Map<GuyType, List<? extends Guy>> guyMap) {
        this.gc = gc;
        this.guyMap = guyMap;
        initializeMap(this.gc);
    };

    void initializeMap(GraphicsContext gc) {
        MapContext mapContext = MapContext.getInstance();
        Image wallUnit = WallUnit.getImage();

        setMapBorder(mapContext.getMap());
        createClassicMap();

        for (int i = 0; i < mapContext.getHeight(); i++) {
            for (int j = 0; j < mapContext.getWidth(); j++) {
                if (mapContext.getMap()[i][j] == 'w') {
                    gc.drawImage(wallUnit, j, i);
                }
            }
        }
    }

    void setMapBorder(char[][] map) {
        for (int i = 0; i < 800; i++) {
            map[0][i] = 'w';
            map[i][0] = 'w';
            map[799][i] = 'w';
            map[i][799] = 'w';
        }
    }

    void createClassicMap() {
        MapUtils.createElongatedBox(50, 50, 3, mapContext.getMap());
        MapUtils.createElongatedBox(200, 50, 3, mapContext.getMap());
        MapUtils.createLineFromPoint(400, 0, mapContext.getMap(), Direction.BOTTOM, 3);
        MapUtils.createLineFromPoint(375, 0, mapContext.getMap(), Direction.BOTTOM, 3);
        MapUtils.createLineFromPoint(425, 0, mapContext.getMap(), Direction.BOTTOM, 3);
        MapUtils.createElongatedBox(500, 50, 3, mapContext.getMap());
        MapUtils.createElongatedBox(650, 50, 3, mapContext.getMap());

        MapUtils.createLineFromPoint(350, 400, mapContext.getMap(), Direction.TOP, 3);
        MapUtils.createLineFromPoint(350, 400, mapContext.getMap(), Direction.RIGHT, 4);
        MapUtils.createLineFromPoint(450, 400, mapContext.getMap(), Direction.TOP, 3);

        MapUtils.createElongatedBox(50, 700, 3, mapContext.getMap());
        MapUtils.createElongatedBox(200, 700, 3, mapContext.getMap());
        MapUtils.createLineFromPoint(400, 775, mapContext.getMap(), Direction.TOP, 3);
        MapUtils.createLineFromPoint(375, 775, mapContext.getMap(), Direction.TOP, 3);
        MapUtils.createLineFromPoint(425, 775, mapContext.getMap(), Direction.TOP, 3);
        MapUtils.createElongatedBox(500, 700, 3, mapContext.getMap());
        MapUtils.createElongatedBox(650, 700, 3, mapContext.getMap());

        MapUtils.createPlus(400, 200, mapContext.getMap(),2);
        MapUtils.createPlus(400, 550, mapContext.getMap(), 3);

        MapUtils.createLineFromPoint(725, 625, mapContext.getMap(), Direction.RIGHT, 2);
        MapUtils.createLineFromPoint(725, 150, mapContext.getMap(), Direction.RIGHT, 2);
        MapUtils.createLineFromPoint(0, 625, mapContext.getMap(), Direction.RIGHT, 2);
        MapUtils.createLineFromPoint(0, 150, mapContext.getMap(), Direction.RIGHT, 2);


//
//        MapGenerator.createElongatedBox(230, 55, 2, mapContext.getMap());
//        MapGenerator.createLineFromPoint(400, 1,  mapContext.getMap(), Direction.BOTTOM, 2);
//        MapGenerator.createElongatedBox(485, 55, 2, mapContext.getMap());
//        MapGenerator.createElongatedBox(650, 55, 2, mapContext.getMap());
//
//        MapGenerator.createElongatedBox(60, 150, 2, mapContext.getMap());

//        MapGenerator.createElongatedBox(100, 100, mapContext.getMap());
//        MapGenerator.createElongatedBox(300, 100, mapContext.getMap());
//        MapGenerator.createPlus(400, 400, mapContext.getMap());
//        MapGenerator.createLeftLShape(200, 500, mapContext.getMap());
//        MapGenerator.createRightLShape(500, 500, mapContext.getMap());
    }

    @Override
    public void handle(long currentNanoTime) {
        Pacman pacman = (Pacman) guyMap.get(GuyType.PACMAN).get(0);
        Image currentState = pacman.getCurrentState();

        MapUtils.clean(this.gc, mapContext, pacman);

//        this.gc.clearRect(cleanSpace[0], cleanSpace[1], cleanSpace[2], cleanSpace[3]);

        this.gc.drawImage(currentState, pacman.getPositionX(), pacman.getPositionY());

        Ghost ghost0 = (Ghost) guyMap.get(GuyType.GHOST).get(0);
        Ghost ghost1 = (Ghost) guyMap.get(GuyType.GHOST).get(1);
        Ghost ghost2 = (Ghost) guyMap.get(GuyType.GHOST).get(2);
        Ghost ghost3 = (Ghost) guyMap.get(GuyType.GHOST).get(3);
        Ghost ghost4 = (Ghost) guyMap.get(GuyType.GHOST).get(4);
        Ghost ghost5 = (Ghost) guyMap.get(GuyType.GHOST).get(5);

    }
}
