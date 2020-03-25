package com.danielptuttle.pacman.pacman;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Start extends Application implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage theStage) throws Exception {
        theStage.setTitle( "Canvas Example" );

        Group root = new Group();
        Scene theScene = new Scene( root );
        theStage.setScene( theScene );

        Canvas canvas = new Canvas( 400, 200 );
        root.getChildren().add( canvas );

        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill( Color.RED );
        gc.setStroke( Color.BLACK );
        gc.setLineWidth(2);
        Font theFont = Font.font( "Times New Roman", FontWeight.BOLD, 48 );
        gc.setFont( theFont );
        gc.fillText( "Hello, World!", 60, 50 );
        gc.strokeText( "Hello, World!", 60, 50 );

        final long startNanoTime = System.nanoTime();

        new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;

                double x = Math.floor(Math.random() * 100);
                double y = Math.floor(Math.random() * 100);

                // background image clears canvas
                gc.fillText( "Hello, World!", x, y );
                gc.strokeText( "Hello, World!", x, y );
            }
        }.start();

        theStage.show();
    }
}
