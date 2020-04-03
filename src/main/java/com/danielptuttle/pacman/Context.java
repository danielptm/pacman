package com.danielptuttle.pacman;

import com.danielptuttle.pacman.model.characters.Guy;
import com.danielptuttle.pacman.model.characters.GuyType;
import com.danielptuttle.pacman.model.characters.Pacman;
import com.danielptuttle.pacman.model.map.MapContext;
import com.danielptuttle.pacman.model.characters.GameCharacters;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class Context extends Application implements CommandLineRunner {
    @Override
    public void run(String... args) throws NodeDoesNotExist {
        launch(args);
    }

    @Override
    public void start(Stage theStage) throws NodeDoesNotExist {
        theStage.setTitle( "Pacman by 🐢" );

        MapContext mapContext = MapContext.getInstance();
        Canvas canvas = new Canvas( mapContext.getWidth(), mapContext.getHeight() );
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Pane root = new Pane();

        String background = getClass().getClassLoader().getResource("background2.jpg").getPath();
        String formattedBackground = "file://"+background;
        String formattedStyle = String.format("-fx-background-image: url('%s');-fx-background-size: cover;", formattedBackground);
        root.setStyle(formattedStyle);
        root.setPrefWidth(1300);
        root.setPrefHeight(800);

        Map<GuyType, List<? extends Guy>> guyMap = GameCharacters.get();
        Scene theScene = new Scene(root);
        setKeyBoardListener(theScene, (Pacman) guyMap.get(GuyType.PACMAN).get(0));

        theStage.setScene(theScene);

        root.getChildren().add(canvas);

        PacmanTimer pacmanTimer = new PacmanTimer(gc, guyMap);
        pacmanTimer.start();
        theStage.show();

    }

    private void setKeyBoardListener(Scene scene, Pacman pacman) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                        pacman.setPosition(pacman.getPositionX(), pacman.getPositionY() - 5);
                        break;
                    case DOWN:
                        pacman.setPosition(pacman.getPositionX(),pacman.getPositionY() + 5);
                        break;
                    case LEFT:
                        pacman.setPosition(pacman.getPositionX() - 5, pacman.getPositionY());
                        break;
                    case RIGHT:
                        pacman.setPosition(pacman.getPositionX() + 5, pacman.getPositionY());
                        break;
                }
            }
        });
    }
}
