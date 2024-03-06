/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package common.signIN;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

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
    
}
