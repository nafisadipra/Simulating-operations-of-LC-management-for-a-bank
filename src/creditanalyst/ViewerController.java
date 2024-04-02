package creditanalyst;

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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import common.writer.Writer;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Muyeed
 */
public class ViewerController implements Initializable {

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
    @FXML
    private Circle mdot;
    @FXML
    private Circle ndot;
    
    private String user;
    private String email;
    private String[] sanData;
    private String xuser;
    private String xname;
    private String xemail;
    private String xstatus;
    private String xaddress;
    private String xphone;
    private String xtype;
    @FXML
    private ImageView imageView;
    @FXML
    private TextField enEmail;
    @FXML
    private TextField enPhone;
    @FXML
    private TextField enAddress;
    @FXML
    private TextField enStatus;
    @FXML
    private Label labCardMoney;
    @FXML
    private Label labCardName;
    @FXML
    private Label labUserName;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    // pipeline
    public void initData(String user, String email, String[] sanData, String xuser, String xname, String xemail, String xphone, String xaddress, String xstatus) {
        // append
        this.user = user;
        this.email = email;
        this.sanData = sanData;
        this.xuser = xuser;
        this.xname = xname;
        this.xemail = xemail;
        this.xphone = xphone;
        this.xaddress = xaddress;
        this.xstatus = xstatus;
        
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
        ArrayList <ArrayList<String>> proFetch = (new Reader("Database/User/" + user + "/" + email, "profile.bin")).splitFile('▓');
        ArrayList <String> data = proFetch.get(0);
        labName.setText(data.get(0));
        
        // image
        BufferedImage originalImage = null;
        try {
            originalImage = ImageIO.read(new File("Database/User/" + user + "/" + email + "/user.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (originalImage != null) {
            int targetWidth = 50;
            int targetHeight = 50;

            BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_ARGB);
            java.awt.Graphics2D g2d = resizedImage.createGraphics();
            g2d.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
            g2d.dispose();

            Image fxImage = SwingFXUtils.toFXImage(resizedImage, null);

            imageUser.setImage(fxImage);
        }
        
        // dot
        ArrayList <ArrayList<String>> notFetch = (new Reader("Database/User/" + user + "/" + email, "notification.bin")).splitFile('▓');
        ArrayList <ArrayList<String>> mesFetch = (new Reader("Database/User/" + user + "/" + email, "message.bin")).splitFile('▓');
        ArrayList <ArrayList<String>> dotFetch = (new Reader("Database/User/" + user + "/" + email, "dot.bin")).splitFile('▓');
        
        if (mesFetch.size() != Integer.parseInt(dotFetch.get(0).get(0))) {
            mdot.setVisible(true);
        } else {
            mdot.setVisible(false);
        }
        
        if (notFetch.size() != Integer.parseInt(dotFetch.get(0).get(1))) {
            ndot.setVisible(true);
        } else {
            ndot.setVisible(false);
        }
        
        // user
        enEmail.setText(xemail);
        enPhone.setText(xphone);
        enAddress.setText(xaddress);
        enStatus.setText(xstatus);
        labUserName.setText(xname);
        labCardName.setText(xname);
        
        switch (xstatus) {
            case "Active":
                enStatus.setStyle("-fx-text-fill: white; -fx-border-color: black; -fx-background-color: green;");
                break;
            case "Banned":
                enStatus.setStyle("-fx-text-fill: white; -fx-border-color: black; -fx-background-color: red;");
                break;
            case "Restricted":
                enStatus.setStyle("-fx-text-fill: white; -fx-border-color: black; -fx-background-color: orange;");
                break;
            default:
                break;
        }
        
        // user switch
        switch (xuser) {
            case "Administrator":
                this.xtype = "ADMINISTRATOR";
                break;
            case "IT Officer":
                this.xtype = "ITOFFICER";
                break;
            case "Client":
                this.xtype = "CLIENT";
                break;
            case "Merchant":
                this.xtype = "MERCHANT";
                break;
            case "General Manager":
                this.xtype = "GENERALMANAGER";
                break;
            case "Credit Analyst":
                this.xtype = "CREDITANALYST";
                break;
            case "L\\C Officer":
                this.xtype = "LCOFFICER";
                break;
            case "Sales Representative":
                this.xtype = "SALESREPRESENTATIVE";
                break;
            case "Compliance Officer":
                this.xtype = "COMPLIANCEOFFICER";
                break;
            case "Reporting Officer":
                this.xtype = "REPORTINGOFFICER";
                break;
            default:
                break;
        }
        
        // view user image
        BufferedImage originalImage2 = null;
        try {
            originalImage2 = ImageIO.read(new File("Database/User/" + xtype + "/" + xemail + "/user.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (originalImage2 != null) {
            int targetWidth2 = 50;
            int targetHeight2 = 50;

            BufferedImage resizedImage2 = new BufferedImage(targetWidth2, targetHeight2, BufferedImage.TYPE_INT_ARGB);
            java.awt.Graphics2D g2d2 = resizedImage2.createGraphics();
            g2d2.drawImage(originalImage2, 0, 0, targetWidth2, targetHeight2, null);
            g2d2.dispose();

            Image fxImage2 = SwingFXUtils.toFXImage(resizedImage2, null);

            imageView.setImage(fxImage2);
            labCardMoney.setText((new Reader("Database/User/" + xtype + "/" + xemail, "credit.bin")).splitFile('▓').get(0).get(0) + "$");
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

    @FXML
    private void windowClick(MouseEvent event) {
        Sandwich window = tableSide.getSelectionModel().getSelectedItem();
        switch (window.getItem()) {
            case "Notification":
                notClick(event);
                break;
            case "Contact":
                mailClick(event);
                break;
            case "Dashboard":
                dashClick(event);
                break;
            case "Settings":
                settClick(event);
                break;
            case "Feedback":
                feedClick(event);
                break;
            case "Requests":
                reqClick(event);
                break;
            case "History":
                hisClick(event);
                break;
            case "Clients":
                cliClick(event);
                break;
            case "Merchants":
                mrcClick(event);
                break;
            default:
                break;
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
        if (ndot.isVisible() == true) {
            ArrayList <ArrayList<String>> notFetch = (new Reader("Database/User/" + user + "/" + email, "notification.bin")).splitFile('▓');
            ArrayList <ArrayList<String>> dotFetch = (new Reader("Database/User/" + user + "/" + email, "dot.bin")).splitFile('▓');
            String notNum = dotFetch.get(0).get(0) + "▓" + notFetch.size() + "▓";
            new Writer("Database/User/" + user + "/" + email, "dot.bin", notNum).writeFile();
        }
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/common/notification/NotificationFXML.fxml"));
            Parent root = loader.load();

            common.notification.NotificationController controller = loader.getController();
            controller.initData(user, email, sanData);
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("LC Bank Portal");

            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void mailClick(MouseEvent event) {
        if (mdot.isVisible() == true) {
            ArrayList <ArrayList<String>> mesFetch = (new Reader("Database/User/" + user + "/" + email, "message.bin")).splitFile('▓');
            ArrayList <ArrayList<String>> dotFetch = (new Reader("Database/User/" + user + "/" + email, "dot.bin")).splitFile('▓');
            String mesNum = mesFetch.size() + "▓" + dotFetch.get(0).get(1) + "▓";
            new Writer("Database/User/" + user + "/" + email, "dot.bin", mesNum).writeFile();
        }
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/common/message/MessageFXML.fxml"));
            Parent root = loader.load();

            common.message.MessageController controller = loader.getController();
            controller.initData(user, email, sanData);
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("LC Bank Portal");

            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void dashClick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
            Parent root = loader.load();

            DashboardController controller = loader.getController();
            controller.initData(user, email, sanData);
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("LC Bank Portal");

            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void feedClick(MouseEvent event) {
        
    }
    
    private void settClick(MouseEvent event) {
        
    }
    
    private void reqClick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Requests.fxml"));
            Parent root = loader.load();

            RequestsController controller = loader.getController();
            controller.initData(user, email, sanData);
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("LC Bank Portal");

            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void hisClick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Requests.fxml"));
            Parent root = loader.load();

            RequestsController controller = loader.getController();
            controller.initData(user, email, sanData);
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("LC Bank Portal");

            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void cliClick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Clients.fxml"));
            Parent root = loader.load();

            ClientsController controller = loader.getController();
            controller.initData(user, email, sanData);
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("LC Bank Portal");

            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void mrcClick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Merchants.fxml"));
            Parent root = loader.load();

            MerchantsController controller = loader.getController();
            controller.initData(user, email, sanData);
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("LC Bank Portal");

            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void outClick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/common/signIN/SignINFXML.fxml"));
            Parent root = loader.load();
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("LC Bank Portal");

            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void clientBack(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Clients.fxml"));
            Parent root = loader.load();

            ClientsController controller = loader.getController();
            controller.initData(user, email, sanData);
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("LC Bank Portal");

            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void merchantBack(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Merchants.fxml"));
            Parent root = loader.load();

            MerchantsController controller = loader.getController();
            controller.initData(user, email, sanData);
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("LC Bank Portal");

            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void backClick(MouseEvent event) {
        // user switch
        switch (xuser) {
            case "Administrator":
                break;
            case "IT Officer":
                break;
            case "Client":
                clientBack(event);
                break;
            case "Merchant":
                merchantBack(event);
                break;
            case "General Manager":
                break;
            case "Credit Analyst":
                break;
            case "L\\C Officer":
                break;
            case "Sales Representative":
                break;
            case "Compliance Officer":
                break;
            case "Reporting Officer":
                break;
            default:
                break;
        }
    }
    
}
