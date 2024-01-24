package org.example.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ClientFormController {
    public TextField txtText;
    public TextArea txtTextArea;
    public Text txtName;
    public ScrollPane Scrollpane;
    public VBox vbox;

    private String ClientName="client";

    public void btnPhotoOnAction(ActionEvent actionEvent) {
    }

    public void btnIconOnAction(ActionEvent actionEvent) {
    }

    public void btnSendOnAction(ActionEvent actionEvent) {
    }

    public void setClientName(String name) {
        ClientName=name;
    }
}
