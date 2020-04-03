package com.danielptuttle.pacman;

import com.danielptuttle.pacman.model.barrier.WallUnit;
import com.danielptuttle.pacman.model.characters.Ghost;
import com.danielptuttle.pacman.model.characters.Guy;
import com.danielptuttle.pacman.model.characters.GuyType;
import com.danielptuttle.pacman.model.characters.Pacman;
import com.danielptuttle.pacman.model.map.MapContext;
import com.danielptuttle.pacman.service.MapGenerator;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Paint;

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
        MapGenerator.createPlus(mapContext.getMap());

        for (int i = 0; i < mapContext.getHeight(); i++) {
            for (int j = 0; j < mapContext.getWidth(); j++) {
                if (mapContext.getMap()[i][j] == 'w') {
                    gc.drawImage(wallUnit, i, j);
                }
            }
        }
    }

    @Override
    public void handle(long currentNanoTime) {
        Pacman pacman = (Pacman) guyMap.get(GuyType.PACMAN).get(0);

        this.gc.clearRect(pacman.getPositionX(), pacman.getPositionY(), 50, 50);


        Ghost ghost0 = (Ghost) guyMap.get(GuyType.GHOST).get(0);
        Ghost ghost1 = (Ghost) guyMap.get(GuyType.GHOST).get(1);
        Ghost ghost2 = (Ghost) guyMap.get(GuyType.GHOST).get(2);
        Ghost ghost3 = (Ghost) guyMap.get(GuyType.GHOST).get(3);
        Ghost ghost4 = (Ghost) guyMap.get(GuyType.GHOST).get(4);
        Ghost ghost5 = (Ghost) guyMap.get(GuyType.GHOST).get(5);

//        ghost1.setPositionX(55);
//        ghost2.setPositionX(110);
//        ghost3.setPositionX(160);
//        ghost4.setPositionX(215);
//        ghost5.setPositionX(270);
//
//        pacman.setPositionX(330);


//        gc.setFill(Paint.valueOf("RED"));
//        gc.fillRect(pacman.getPositionX(), pacman.getPositionY(), 50, 50);
        this.gc.drawImage(pacman.getCurrentState(), pacman.getPositionX(), pacman.getPositionY());

//        gc.drawImage(WallUnit.getImage(), 300, 300);



//        gc.drawImage(ghost0.getCurrentState(), ghost0.getPositionX(), ghost0.getPositionY());
//        gc.drawImage(ghost1.getCurrentState(), ghost1.getPositionX(), ghost1.getPositionY());
//        gc.drawImage(ghost2.getCurrentState(), ghost2.getPositionX(), ghost2.getPositionY());
//        gc.drawImage(ghost3.getCurrentState(), ghost3.getPositionX(), ghost3.getPositionY());
//        gc.drawImage(ghost4.getCurrentState(), ghost4.getPositionX(), ghost4.getPositionY());
//        gc.drawImage(ghost5.getCurrentState(), ghost5.getPositionX(), ghost5.getPositionY());

    }
}
