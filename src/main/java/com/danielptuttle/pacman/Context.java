package com.danielptuttle.pacman;

import com.danielptuttle.pacman.model.characters.Guy;
import com.danielptuttle.pacman.model.characters.GuyType;
import com.danielptuttle.pacman.model.map.MapContext;
import com.danielptuttle.pacman.util.SpriteLoader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Map;

@Component
public class Context extends Application implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage theStage) throws Exception {
        theStage.setTitle( "Pacman by 🐢" );
        Pane root = new Pane();

        String background = getClass().getClassLoader().getResource("background2.jpg").getPath();
        String formattedBackground = "file://"+background;
        String formattedStyle = String.format("-fx-background-image: url('%s');-fx-background-size: cover;", formattedBackground);
        root.setStyle(formattedStyle);
        root.setPrefWidth(1300);
        root.setPrefHeight(800);

        Scene theScene = new Scene( root );
        theStage.setScene(theScene);

        MapContext mapContext = MapContext.get();
        Canvas canvas = new Canvas( mapContext.getWidth(), mapContext.getHeight() );
        GraphicsContext gc = canvas.getGraphicsContext2D();

        root.getChildren().add(canvas);

        String fileName = getClass().getClassLoader().getResource("images.png").getPath();
        SpriteLoader spriteLoader = new SpriteLoader(fileName);
        BufferedImage[][] images = spriteLoader.loadSpritesFromSheet();
        Map<GuyType, List<? extends Guy>> guyMap = spriteLoader.loadGuys(images);
        PacmanTimer pacmanTimer = new PacmanTimer(gc, guyMap);
        pacmanTimer.start();

        theStage.show();
    }
}
