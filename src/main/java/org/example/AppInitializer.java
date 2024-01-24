package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppInitializer extends Application {
    public static void main(String[] args) {
            launch(args);
    }

    public void start(Stage primaryStage)throws IOException {
        Parent parent= FXMLLoader.load(this.getClass().getResource("/View/LoginApplication.fxml"));
        Scene scene=new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }
}
