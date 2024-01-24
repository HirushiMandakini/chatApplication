package org.example.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.Model.UserModel;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginPageController {
    public AnchorPane root;
    public TextField txtPword;
    public TextField txtUname;

    public void initialize(){

    }

    public void btnLoginOnAction(ActionEvent actionEvent) {
        String enteredUserName = txtUname.getText();
        String enteredPassword = txtPword.getText();

        if(enteredUserName.isEmpty()) {
            new Alert(Alert.AlertType.INFORMATION, "username required..!!", ButtonType.OK).show();
        }else if(enteredPassword.isEmpty()) {
            new Alert(Alert.AlertType.INFORMATION, "password required..!!", ButtonType.OK).show();
        } else {
            try {
                ResultSet resultSet = UserModel.checkCredentials(enteredUserName, enteredPassword);

                if (resultSet.next()) {
                    String name = resultSet.getString(1);
                    String pass = resultSet.getString(2);


                    if (pass.equals(enteredPassword) & name.equals(enteredUserName)) {

                    //    AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/View/ClientForm.fxml"));
                        ClientFormController controller = new ClientFormController();
                    //    controller.setClientName(txtUname.getText()); // Set the parameter
                    //    Scene scene = new Scene(anchorPane);
                     //   Stage stage = (Stage) root.getScene().getWindow();
                     //   stage.setScene(scene);
                      //  stage.setTitle("Client Form");
                      //  stage.centerOnScreen();
                      //  stage.show();
                        Parent anchorPane = FXMLLoader.load(getClass().getResource("/View/ClientForm.fxml"));
                        Scene scene = new Scene(anchorPane);

                        Stage stage = new Stage();
                        stage.setTitle("Client page");
                        stage.setScene(scene);
                        stage.centerOnScreen();
                        stage.show();

                    } else {
                        new Alert(Alert.AlertType.ERROR, "Invalid username or password").show();
                    }
                }

            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void HyperOnAction(ActionEvent actionEvent) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/View/SignupForm.fxml"));

        Scene scene = new Scene(rootNode);

        root.getChildren().clear();
        Stage stage = (Stage) root.getScene().getWindow();

        stage.setScene(scene);
        stage.setTitle("Signup Form");
    }
    }

