/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package common.signUP;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class SignUPFXMLController implements Initializable {
    
    private Label label;
    @FXML
    private TextField signUpEmail;
    @FXML
    private TextField signUpName;
    @FXML
    private DatePicker dateOfBirth;
    @FXML
    private TextField nationalID;
    @FXML
    private TextField phoneNumber;
    @FXML
    private PasswordField signUpPass;
    @FXML
    private Label switchToSignIn;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void signInButtonAction(ActionEvent event) {
        
    }

    @FXML
    private void switchToLogIn(ActionEvent event) {
        try {
            // FXML Location
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/common/SignIN/SignINFXML.fxml"));
            Parent root = loader.load();
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            
            // Set application title
            stage.setTitle("Sign In");

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
