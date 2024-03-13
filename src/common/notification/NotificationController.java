package common.notification;
import common.reader.Reader;
import common.sandwich.Sandwich;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author Muyeed
 */
public class NotificationController implements Initializable {

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
    private ImageView imageUser;
    
    private String user;
    private String email;
    private String[] sanData = {};
    private ArrayList<Notification> notList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    // pipeline
    public void initData(String user, String email, String[] sanData) {
        // Side Panel
        ArrayList<Sandwich> sanList = new ArrayList();

        for (String x: sanData) {
            sanList.add(new Sandwich(x));
        }
        dtableSide.setCellValueFactory(new PropertyValueFactory("item"));
        tableSide.getItems().setAll(FXCollections.observableArrayList(sanList));
        
        // Show Panel
        paneSide.setVisible(false);
        paneLog.setVisible(false);
        ArrayList <ArrayList> proFetch = (new Reader("Database/User/" + user + "/" + email, "profile.bin")).spliteFile();
        ArrayList <String> name = proFetch.get(0);
        labName.setText(name.get(0));
        
        // Notification
        notList = new ArrayList();
        ArrayList <ArrayList> notFetch = (new Reader("Database/User/" + user + "/" + email, "notification.bin")).spliteFile();
        
        for (ArrayList <String> x: notFetch) {
            notList.add(new Notification(x.get(0), x.get(1), x.get(2), x.get(3)));
        }
        
        ntable.setCellValueFactory(new PropertyValueFactory<>("data"));
        utable.setCellValueFactory(new PropertyValueFactory<>("user"));
        ttable.setCellValueFactory(new PropertyValueFactory<>("time"));
        dtable.setCellValueFactory(new PropertyValueFactory<>("date"));
        table.getItems().addAll(FXCollections.observableArrayList(notList));
        
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(new File("Database/User/" + user + "/" + email + "/user.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image fxImage = SwingFXUtils.toFXImage(bufferedImage, null);
        imageUser.setImage(fxImage);
        
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
        
    }

    @FXML
    private void mailClick(MouseEvent event) {
        
    }
    
}
