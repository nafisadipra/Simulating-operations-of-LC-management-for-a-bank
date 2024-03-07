/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package administrator;

import common.writer.Writer;
import common.communication.Message;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Muyeed
 */
public class CommunicationAdminFXMLController implements Initializable {

    @FXML
    private TableView<Message> table;
    @FXML
    private TableColumn<Message, String> utable;
    @FXML
    private TableColumn<Message, String> mtable;
    @FXML
    private TableColumn<Message, String> ttable;
    @FXML
    private TableColumn<Message, String> dtable;
    
    private final ArrayList<Message> mesList = new ArrayList();
    @FXML
    private AnchorPane paneSide;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mesList.add(new Message("Hello, just a hello from me!", "Muyeed", "11.41PM", "06-03-2024"));
        mesList.add(new Message("You must check the back up!", "Dipra", "10.20am", "05-03-2024"));
        mesList.add(new Message("How can I help?", "Alam", "12.43pm", "05-03-2024"));
        
        utable.setCellValueFactory(new PropertyValueFactory("user"));
        mtable.setCellValueFactory(new PropertyValueFactory("data"));
        ttable.setCellValueFactory(new PropertyValueFactory("time"));
        dtable.setCellValueFactory(new PropertyValueFactory("date"));
        
        table.getItems().setAll(FXCollections.observableArrayList(mesList));
        
        paneSide.setVisible(false);
        
    }    

    @FXML
    private void sendMessage(MouseEvent event) {
        Message message = table.getSelectionModel().getSelectedItem();
        System.out.println(message.getData());
        
        Writer d1 = new Writer("System", "d1.bin", message.getUser() + "\n" + message.getData());
        d1.writeFile();
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InboxAdminFXML.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Send Message");

            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void sandAction(MouseEvent event) {
        if (paneSide.isVisible()) {
            paneSide.setVisible(false);
        } else {
            paneSide.setVisible(true);
        }
    }
    
}
