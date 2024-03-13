package administrator;
import common.notification.*;
import common.communication.Message;
import common.reader.Reader;
import common.writer.Writer;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import common.sandwich.Sandwich;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Muyeed
 */
public class CommunicationAdminController implements Initializable {

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
        ArrayList <Message> mesList = new ArrayList();
        mesList.add(new Message("Hello, just a hello from me!", "Muyeed", "11.41PM", "06-03-2024"));
        mesList.add(new Message("You must check the back up!", "Dipra", "10.20am", "05-03-2024"));
        mesList.add(new Message("How can I help?", "Alam", "12.43pm", "05-03-2024"));
        
        utable.setCellValueFactory(new PropertyValueFactory("user"));
        mtable.setCellValueFactory(new PropertyValueFactory("data"));
        ttable.setCellValueFactory(new PropertyValueFactory("time"));
        dtable.setCellValueFactory(new PropertyValueFactory("date"));
        
        table.getItems().setAll(FXCollections.observableArrayList(mesList));

        paneSide.setVisible(false);
        paneLog.setVisible(false);
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

            InboxAdminController controller = loader.getController();
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/common/notification/NotificationFXML.fxml"));
            Parent root = loader.load();

            NotificationController controller = loader.getController();
            String[] x = {"Dash"};
            controller.initData("Administrator", "m@g.com", x);
            
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
        
    }
    
}
