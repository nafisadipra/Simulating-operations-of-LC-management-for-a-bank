/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package administrator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author User
 */
public class DashboardAdminController implements Initializable {

    @FXML
    private AnchorPane paneSide;
    @FXML
    private TableView<?> tableSide;
    @FXML
    private TableColumn<?, ?> dtableSide;
    @FXML
    private AnchorPane paneLog;
    @FXML
    private Label labName;
    @FXML
    private Button buttLog;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void windowClick(MouseEvent event) {
    }

    @FXML
    private void sandAction(MouseEvent event) {
    }

    @FXML
    private void notClick(MouseEvent event) {
    }

    @FXML
    private void mailClick(MouseEvent event) {
    }

    @FXML
    private void logClick(MouseEvent event) {
    }
    
}
