/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package customer;

import administrator.*;
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
import javafx.scene.chart.AreaChart;
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
public class DashboardCustomerController implements Initializable {

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
        // TODO
    }    

    @FXML
    private void windowClick(MouseEvent event) {
        Sandwich window = tableSide.getSelectionModel().getSelectedItem();     
        if (window.getItem().equals("Notification")) {
            notClick(event);
        }

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
    private void notClick(MouseEvent event) {
        
    }


    @FXML
    private void logClick(MouseEvent event) {
    }
    
}
