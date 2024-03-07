/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package administrator;

import common.reader.Reader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Muyeed
 */
public class InboxAdminFXMLController implements Initializable {

    @FXML
    private AnchorPane paneSide;
    @FXML
    private TextArea areaSend;
    @FXML
    private TextArea areaMessage;
    @FXML
    private Label labSender;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        paneSide.setVisible(false);
        ArrayList<String> d1 = (new Reader("System", "d1.bin")).readFile();
        labSender.setText("From: " + d1.get(0));
        areaMessage.setText(d1.get(1));
    }

    @FXML
    private void sandAction(MouseEvent event) {
        if (paneSide.isVisible()) {
            paneSide.setVisible(false);
        } else {
            paneSide.setVisible(true);
        }
    }

    @FXML
    private void backMessage(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CommunicationAdminFXML.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Send Message");

            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
        }
    }
    
}
