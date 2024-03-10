/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package common.signIN;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Muyeed
 */
public class SignINFXMLController implements Initializable {
    @FXML
    private TextField enEmail;
    @FXML
    private TextField enPassword;
    
    private ArrayList<User> userList = new ArrayList();
    
    @FXML
    private void loginButtonAction(ActionEvent event) {
        for (User x: userList) {
            if (x.email.equals(enEmail.getText()) && x.password.equals(enPassword.getText())) {
                System.out.println("Successfull");
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userList.add(new User("muyeed", "123"));
        userList.add(new User("Alam", "456"));
    }    

    @FXML
    private void switchToSignUp(ActionEvent event) {
        try {
            // FXML Location
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/common/SignUP/SignUPFXML.fxml"));
            Parent root = loader.load();
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            
            // Set application title
            stage.setTitle("Sign Up");

            // Set application icon
            //Image icon = new Image(getClass().getResourceAsStream("resources/icon.png"));
            //stage.getIcons().add(icon);
            
            // Show Time
            stage.setScene(new Scene(root));
            stage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
