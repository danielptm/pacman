package com.danielptuttle.pacman.pacman;

import com.danielptuttle.pacman.pacman.characters.Guy;
import com.danielptuttle.pacman.pacman.characters.GuyType;
import com.danielptuttle.pacman.pacman.util.SpriteLoader;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
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
        Group root = new Group();
        Scene theScene = new Scene( root );
        theStage.setScene(theScene);
        Canvas canvas = new Canvas( 1000, 800 );
        root.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        String fileName = getClass().getClassLoader().getResource("images.png").getPath();
        SpriteLoader spriteLoader = new SpriteLoader(fileName);
        BufferedImage[][] images = spriteLoader.loadSpritesFromSheet();
        Map<GuyType, List<? extends Guy>> guyMap = spriteLoader.loadGuys(images);
        PacmanTimer pacmanTimer = new PacmanTimer(gc, guyMap);
        pacmanTimer.start();
        theStage.show();
    }
}
