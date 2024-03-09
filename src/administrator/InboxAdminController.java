/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package administrator;

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
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Muyeed
 */
public class InboxAdminController implements Initializable {

    @FXML
    private AnchorPane paneSide;
    @FXML
    private TextArea areaSend;
    @FXML
    private TextArea areaMessage;
    @FXML
    private Label labSender;
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
        paneSide.setVisible(false);
        ArrayList<String> d1 = (new Reader("System", "d1.bin")).readFile();
        labSender.setText("From: " + d1.get(0));
        areaMessage.setText(d1.get(1));
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
    private void backMessage(MouseEvent event) {
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

    @FXML
    private void windowClick(MouseEvent event) {
        Sandwich window = tableSide.getSelectionModel().getSelectedItem();
        
        if (window.getItem().equals("Notification")) {
            notClick(event);
        }
        
        if (window.getItem().equals("Message")) {
            mailClick(event);
        }
        
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
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("NotificationAdminFXML.fxml"));
            Parent root = loader.load();

            NotificationAdminController controller = loader.getController();
            controller.setUser("administrator");
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Administrator");

            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
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
