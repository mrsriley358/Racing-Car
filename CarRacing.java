/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carracing;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Zachary Hinote
 */
public class CarRacing extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        HBox hBox = new HBox();
        Button btPause = new Button("Pause");
        Button btResume = new Button("Resume");
        
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(btPause, btResume);
        
        BorderPane pane = new BorderPane();
        pane.setTop(hBox);
        
        CarPane car = new CarPane();
        pane.setBottom(car);
        
        Timeline animation = new Timeline(
            new KeyFrame(Duration.millis(100), e -> car.move()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
        
        btPause.setOnAction(e -> animation.pause());
        btResume.setOnAction(e -> animation.play());
        
        
        
        Scene scene = new Scene(pane, 300, 220);
        primaryStage.setTitle("Car Racing");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        pane.setOnKeyPressed(e-> {
            if (e.getCode() == KeyCode.UP) {
                car.increaseSpeed();
            }
            else if (e.getCode() == KeyCode.DOWN) {
                car.decreaseSpeed();
            }
        });
        
        scene.widthProperty().addListener(e -> car.setBarrier(scene.getWidth()));
                
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
