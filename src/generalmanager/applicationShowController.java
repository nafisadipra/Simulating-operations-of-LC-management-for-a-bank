package generalmanager;

import common.finder.Tree;
import common.lc.PI;
import common.lc.Product;
import common.prompt.Prompt;
import common.reader.Reader;
import common.sandwich.Sandwich;
import common.switcher.GUI;
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
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Muyeed
 */
public class applicationShowController implements Initializable {

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
    @FXML
    private TextField custxtField;
    @FXML
    private TextField addresstxtField;
    @FXML
    private TextField phontxtfield;
    @FXML
    private TextField emailtxtField;
    @FXML
    private Label CusName;
    @FXML
    private Label phoneLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label addressLabel;
    private TextField quantxtField;
    private ComboBox<String> prodComb;

    private CheckBox agreeClick;
    @FXML
    private Label payableLabel;
    @FXML
    private TextField payabletxtField;
    @FXML
    private TableView<Product> productTable;
    @FXML
    private TableColumn<Product, String> Sltable;
    @FXML
    private TableColumn<Product, String> protable;
    @FXML
    private TableColumn<Product, String> quanTable;
    @FXML
    private TableColumn<Product, String> pppTable;
    @FXML
    private TableColumn<Product, String> amountable;

    private ArrayList<Product> cartList = new ArrayList();
    private ComboBox<String> merComb;
    private String Xemail;
    private ArrayList<ArrayList<String>> productFetch;
    private Double payAmount = 0.0;
    private String company = "Null";
    @FXML
    private TableColumn<?, ?> expoTable;
    @FXML
    private TextField compxtField;
    @FXML
    private Label CusName1;
    
    private PI PIdata;
    @FXML
    private Button aprvButt;
    @FXML
    private Button declbutt;
    @FXML
    private TextField statusField;
    @FXML
    private Label emailLabel1;
    @FXML
    private TextField CRAstatusField;
    @FXML
    private Label emailLabel11;
    @FXML
    private TextField CMOstatusField;
    @FXML
    private Label emailLabel111;
    @FXML
    private TextField MRCstatusField;
    @FXML
    private Label emailLabel1111;
    @FXML
    private AnchorPane subAnch;
    @FXML
    private ComboBox<String> merCom;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    // pipeline
    public void initData(String user, String email, String[] sanData, PI PIdata) {
        // append
        this.user = user;
        this.email = email;
        this.sanData = sanData;
        this.PIdata= PIdata;

        // Side Panel
        ArrayList<Sandwich> sanList = new ArrayList();

        for (String x : sanData) {
            sanList.add(new Sandwich(x));
        }
        dtableSide.setCellValueFactory(new PropertyValueFactory("item"));
        tableSide.getItems().setAll(FXCollections.observableArrayList(sanList));

        // Show Panel
        paneSide.setVisible(false);
        paneLog.setVisible(false);
        ArrayList<ArrayList<String>> proFetch = (new Reader("Database/User/" + user + "/" + email, "profile.bin"))
                .splitFile('▓');
        ArrayList<String> data = proFetch.get(0);
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
        ArrayList<ArrayList<String>> notFetch = (new Reader("Database/User/" + user + "/" + email, "notification.bin"))
                .splitFile('▓');
        ArrayList<ArrayList<String>> mesFetch = (new Reader("Database/User/" + user + "/" + email, "message.bin"))
                .splitFile('▓');
        ArrayList<ArrayList<String>> dotFetch = (new Reader("Database/User/" + user + "/" + email, "dot.bin"))
                .splitFile('▓');

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
        
        //
        custxtField.setText(PIdata.getCustomer());
        compxtField.setText(PIdata.getCompany());
        addresstxtField.setText(PIdata.getAddress());        
        phontxtfield.setText(PIdata.getPhone());
        emailtxtField.setText(PIdata.getEmail()); 
        payabletxtField.setText(PIdata.getTotal_amount());
        statusField.setText(PIdata.getGmStatus());
        CRAstatusField.setText(PIdata.getCrStatus());
        CMOstatusField.setText(PIdata.getCompStatus());
        MRCstatusField.setText(PIdata.getMrcStatus());
        
        if (statusField.getText().equals("Approved")) {
            statusField.setStyle("-fx-text-fill: white; -fx-border-color: black; -fx-background-color: green;");
            aprvButt.setDisable(true);
            declbutt.setDisable(true);
            
        }
        else if (statusField.getText().equals("Declined")) {
            statusField.setStyle("-fx-text-fill: white; -fx-border-color: black; -fx-background-color: red;");
            aprvButt.setDisable(true);
            declbutt.setDisable(true);
            
        }
        if (CRAstatusField.getText().equals("Approved")) {
            CRAstatusField.setStyle("-fx-text-fill: white; -fx-border-color: black; -fx-background-color: green;");
        }
        else if (CRAstatusField.getText().equals("Declined")) {
            CRAstatusField.setStyle("-fx-text-fill: white; -fx-border-color: black; -fx-background-color: red;");
        }
        if (CMOstatusField.getText().equals("Approved")) {
            CMOstatusField.setStyle("-fx-text-fill: white; -fx-border-color: black; -fx-background-color: green;");
        }
        else if (CMOstatusField.getText().equals("Declined")) {
            CMOstatusField.setStyle("-fx-text-fill: white; -fx-border-color: black; -fx-background-color: red;");
        }
        if (MRCstatusField.getText().equals("Approved")) {
            MRCstatusField.setStyle("-fx-text-fill: white; -fx-border-color: black; -fx-background-color: green;");
        }
        else if (MRCstatusField.getText().equals("Declined")) {
            MRCstatusField.setStyle("-fx-text-fill: white; -fx-border-color: black; -fx-background-color: red;");
        }

        // table
        Sltable.setCellValueFactory(new PropertyValueFactory("serial"));
        protable.setCellValueFactory(new PropertyValueFactory("product"));
        quanTable.setCellValueFactory(new PropertyValueFactory("quantity"));
        pppTable.setCellValueFactory(new PropertyValueFactory("price"));
        amountable.setCellValueFactory(new PropertyValueFactory("amount"));
        expoTable.setCellValueFactory(new PropertyValueFactory("exporter"));
        productTable.getItems().addAll(PIdata.getProductList());
        
        ArrayList<String> mrcList = new Tree("Database/User/MERCHANT").view();
        merCom.getItems().addAll(mrcList);
        merCom.setValue("Select");
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
                (new GUI(user, email, sanData)).dashClick(event);
                break;
            case "Application":
                (new GUI(user, email, sanData)).applcClick(event);
                break;
            case "Transaction":
                (new GUI(user, email, sanData)).transClick(event);
                break;
            case "Invoice":
                (new GUI(user, email, sanData)).ivcClick(event);
                break;
            case "Switch Account":
                (new GUI(user, email, sanData)).swtClick(event);
                break;
            case "Settings":
                (new GUI(user, email, sanData)).sttClick(event);
                break;
            case "Policy":
                (new GUI(user, email, sanData)).pcyClick(event);
                break;
            case "Policy Management":
                (new GUI(user, email, sanData)).pcyClick(event);
                break;
            case "Feedback":
                (new GUI(user, email, sanData)).feedClick(event);
                break;
            case "Merchandise":
                (new GUI(user, email, sanData)).mrcDiseClick(event);
                break;
            case "Advertising":
                (new GUI(user, email, sanData)).advClick(event);
                break;
            case "Requests":
                (new GUI(user, email, sanData)).reqClick(event);
                break;
            case "History":
                (new GUI(user, email, sanData)).hisClick(event);
                break;
            case "Clients":
                (new GUI(user, email, sanData)).cliClick(event);
                break;
            case "Merchants":
                (new GUI(user, email, sanData)).mrcClick(event);
                break;
            case "Analytics":
                (new GUI(user, email, sanData)).anlClick(event);
                break;
            case "Risk Assessment":
                (new GUI(user, email, sanData)).riskClick(event);
                break;
            case "L\\C Application":
                (new GUI(user, email, sanData)).applcClick(event);
                break;
            case "Logs":
                (new GUI(user, email, sanData)).logUserClick(event);
                break;
            case "Management":
                (new GUI(user, email, sanData)).mgtClick(event);
                break;
            case "Monitoring":
                (new GUI(user, email, sanData)).monClick(event);
                break;
            case "Backup":
                (new GUI(user, email, sanData)).bkpClick(event);
                break;
            case "Relationship":
                (new GUI(user, email, sanData)).rlnClick(event);
                break;
            case "Reports":
                (new GUI(user, email, sanData)).rptClick(event);
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
            ArrayList<ArrayList<String>> notFetch = (new Reader("Database/User/" + user + "/" + email,
                    "notification.bin")).splitFile('▓');
            ArrayList<ArrayList<String>> dotFetch = (new Reader("Database/User/" + user + "/" + email, "dot.bin"))
                    .splitFile('▓');
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
            ArrayList<ArrayList<String>> mesFetch = (new Reader("Database/User/" + user + "/" + email, "message.bin"))
                    .splitFile('▓');
            ArrayList<ArrayList<String>> dotFetch = (new Reader("Database/User/" + user + "/" + email, "dot.bin"))
                    .splitFile('▓');
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

    @FXML
    private void aprvClick(MouseEvent event) {
        subAnch.setVisible(true);
    }

    @FXML
    private void declClick(MouseEvent event) {
        if ((new Prompt()).getAlert("Are you sure to Decline", "confirmation").getResult().getText().equals("Cancel")) {
            return;
        }
        
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("hh:mm a");

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        String notData = ("Your PI (" + PIdata.getSerial() + ") request has been declined!") + "▓" + "PI Request" + "▓"
        + currentTime.format(formatTime) + "▓" + currentDate.format(formatDate);
        new Writer("Database/User/CLIENT/"+ emailtxtField.getText(), "notification.bin", notData).overWriteFile();
        
        String cliData = PIdata.getCustomer() + "▓" + PIdata.getCompany() + "▓" + PIdata.getAddress() + "▓" + PIdata.getPhone() + "▓" + PIdata.getEmail() + "▓" ;
        String merData= "\n"+PIdata.getMerchant()+  "▓";
        String amount= "\n"+ PIdata.getTotal_amount()+ "▓";
        String proData= "";
        
        for(Product X : PIdata.getProductList()){
            proData += "\n" + X.getProduct()+ "▓" + X.getPrice() + "▓"+ X.getQuantity()+ "▓" + X.getAmount()+ "▓" ;
        }
        
        String alldata= cliData + merData + "\n"+ PIdata.getTime()+"▓"+ PIdata.getDate()+ amount +"\nDeclined"+"▓"+PIdata.getCrStatus()+"▓"+PIdata.getCompStatus()+"▓"+PIdata.getMrcStatus()+"▓" + proData;
        new Writer("Database/Official/PI",  PIdata.getSerial() + ".bin", alldata).writeFile();
        statusField.setText("Declined");
        statusField.setStyle("-fx-text-fill: white; -fx-border-color: black; -fx-background-color: red;");
        aprvButt.setDisable(true);
        declbutt.setDisable(true);
    }

    @FXML
    private void backClick(MouseEvent event) {
        (new GUI(user, email, sanData)).reqClick(event);
    }

    @FXML
    private void sendClick(MouseEvent event) {
        if (merCom.getValue().equals("Select")) {
            new Prompt().getAlert("Please fill in all fields.", "error");
            return;
        }
        
        if ((new Prompt()).getAlert("Are you sure to Approve?", "confirmation").getResult().getText().equals("Cancel")) {
            return;
        }
        
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("hh:mm a");

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        String notData = ("You recieved a PI Request from " + emailtxtField.getText()) + "▓" + "PI Request" + "▓"
        + currentTime.format(formatTime) + "▓" + currentDate.format(formatDate);
        new Writer("Database/User/MERCHANT/"+ merCom.getValue(), "notification.bin", notData).overWriteFile();
        
        String cliData = PIdata.getCustomer() + "▓" + PIdata.getCompany() + "▓" + PIdata.getAddress() + "▓" + PIdata.getPhone() + "▓" + PIdata.getEmail() + "▓" ;
        String merData= "\n"+PIdata.getMerchant()+  "▓";
        String amount= "\n"+ PIdata.getTotal_amount()+ "▓";
        String proData= "";
        
        for(Product X : PIdata.getProductList()){
            proData += "\n" + X.getProduct()+ "▓" + X.getPrice() + "▓"+ X.getQuantity()+ "▓" + X.getAmount()+ "▓" ;
        }
        
        String alldata= cliData + merData + "\n"+ PIdata.getTime()+"▓"+ PIdata.getDate()+ amount +"\nApproved"+"▓"+PIdata.getCrStatus()+"▓"+PIdata.getCompStatus()+"▓"+PIdata.getMrcStatus()+"▓" + proData;
        new Writer("Database/Official/PI",  PIdata.getSerial() + ".bin", alldata).writeFile();
        statusField.setText("Approved");
        statusField.setStyle("-fx-text-fill: white; -fx-border-color: black; -fx-background-color: green;");
        aprvButt.setDisable(true);
        declbutt.setDisable(true);
        subAnch.setVisible(false);
    }

    @FXML
    private void closeClick(MouseEvent event) {
        subAnch.setVisible(false);
    }
}
