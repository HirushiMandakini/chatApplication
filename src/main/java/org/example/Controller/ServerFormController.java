package org.example.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ServerFormController {
    public ScrollPane scrollpaneServer;
    public VBox vboxServer;
    public AnchorPane pane;

    public void btnAddOnAction(ActionEvent actionEvent) throws IOException {


     /*   Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(pane.getScene().getWindow());

        try {
            System.out.println("Loading loginForm.fxml");
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/View/loginForm.fxml"));
            stage.setScene(new Scene(loader.load()));
            System.out.println("loginForm.fxml loaded successfully");
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Something went wrong. Can't add client. " + e.getMessage()).show();
        }


        stage.setTitle("Client Form");
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.show();*/
        Parent anchorPane = FXMLLoader.load(getClass().getResource("/View/loginForm.fxml"));
        Scene scene = new Scene(anchorPane);

        Stage stage = new Stage();
        stage.setTitle("Customer Manage");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    }


