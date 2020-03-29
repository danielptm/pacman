package com.danielptuttle.pacman;

import com.danielptuttle.pacman.model.characters.Guy;
import com.danielptuttle.pacman.model.characters.GuyType;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;
import java.util.Map;

public class PacmanTimer extends AnimationTimer {
    private GraphicsContext gc;
    private Map<GuyType, List<? extends Guy>> guyMap;

    public PacmanTimer(GraphicsContext gc, Map<GuyType, List<? extends Guy>> guyMap) {
        this.gc = gc;
        this.guyMap = guyMap;
    };

    @Override
    public void handle(long currentNanoTime) {
        gc.drawImage(guyMap.get(GuyType.PACMAN).get(0).getCurrentState(), 200, 200);
    }
}
