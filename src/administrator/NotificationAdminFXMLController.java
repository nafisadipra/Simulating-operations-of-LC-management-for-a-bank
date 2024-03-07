/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package administrator;
import common.notification.Notification;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author User
 */
public class NotificationAdminFXMLController implements Initializable {

    @FXML
    private TableView<Notification> table;
    @FXML
    private TableColumn<Notification, String> ntable;
    @FXML
    private TableColumn<Notification, String> utable;
    @FXML
    private TableColumn<Notification, String> ttable;
    @FXML
    private TableColumn<Notification, String> dtable;
    
    private ArrayList<Notification> notList = new ArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        notList.add(new Notification("Hello, just a hello from me!", "Muyeed", "11.41PM", "06-03-2024"));
        notList.add(new Notification("You must check the back up!", "Dipra", "10.20am", "05-03-2024"));
        notList.add(new Notification("Can you please pick up the call? I'm waiting", "Alam", "10.52PM", "05-03-2024"));
        
        ntable.setCellValueFactory(new PropertyValueFactory<>("data"));
        utable.setCellValueFactory(new PropertyValueFactory<>("user"));
        ttable.setCellValueFactory(new PropertyValueFactory<>("time"));
        dtable.setCellValueFactory(new PropertyValueFactory<>("date"));
        
        table.getItems().addAll(FXCollections.observableArrayList(notList));
        
        
    }    
    
}
