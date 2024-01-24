package org.example.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.Model.UserModel;
import org.example.dto.UserDto;

import java.io.IOException;
import java.sql.SQLException;

public class SignupFormController {
    public TextField txtPword1;
    public TextField txtUname1;
    public AnchorPane root1;

    public void btnCreateOnAction(ActionEvent actionEvent) throws SQLException {
        String u_name = txtUname1.getText();
        String u_password = txtPword1.getText();

        // validate fields

        if (u_name == null){
            new Alert(Alert.AlertType.ERROR,"username can't empty").show();
            return;
        }

        UserDto userDto = new UserDto(
                u_name,
                u_password

        );

        if (UserModel.saveUser(userDto)){
            new Alert(Alert.AlertType.INFORMATION,"User Account created..!").show();
            txtUname1.setText(null);
            txtPword1.setText(null);
        }else {
            new Alert(Alert.AlertType.WARNING,"User Account creation fail..!").show();
        }

    }


    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {

        AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/View/loginForm.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root1.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Client Form");
        stage.centerOnScreen();
        stage.show();

    }
}
