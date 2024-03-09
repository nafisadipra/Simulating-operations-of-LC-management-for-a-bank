/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package administrator;
import common.notification.Notification;
import common.reader.Reader;
import common.sandwich.Sandwich;
import java.io.IOException;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class NotificationAdminController implements Initializable {

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
    @FXML
    private AnchorPane paneSide;
    @FXML
    private TableView<Sandwich> tableSide;
    @FXML
    private TableColumn<Sandwich, String> dtableSide;
    @FXML
    private AnchorPane paneLog;
    @FXML
    private Label labName;
    @FXML
    private Button buttLog;
    
        
    private String user;
    private boolean sanState = false;

    
    public void setUser(String user) {
        this.user = user;
    }


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
        
        paneSide.setVisible(false);
        paneLog.setVisible(false);

    }    

    @FXML
    private void sandAction(MouseEvent event) {
        if (paneSide.isVisible()) {
            paneSide.setVisible(false);
        } else {
            paneSide.setVisible(true);
        }
        
        if (sanState == false) {
            ArrayList<Sandwich> sanList = new ArrayList();
            ArrayList<String> sanFetch = new Reader("src/common/sandwich", user + ".bin").readFile();

            for (String x: sanFetch) {
                sanList.add(new Sandwich(x));
            }
            dtableSide.setCellValueFactory(new PropertyValueFactory("item"));
            tableSide.getItems().setAll(FXCollections.observableArrayList(sanList));
            sanState = true;
        }
        
    }

    @FXML
    private void windowClick(MouseEvent event) {
        Sandwich window = tableSide.getSelectionModel().getSelectedItem();
        System.out.println(window.getItem());
    }

    @FXML
    private void logClick(MouseEvent event) {
        if (paneLog.isVisible()) {
            paneLog.setVisible(false);
        } else {
            paneLog.setVisible(true);
        }
    }

    @FXML
    private void notClick(MouseEvent event) {
        
    }

    @FXML
    private void mailClick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CommunicationAdminFXML.fxml"));
            Parent root = loader.load();

            CommunicationAdminController controller = loader.getController();
            controller.setUser("administrator");
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Administrator");

            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
