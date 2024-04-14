package administrator;

import common.aes.AES;
import common.device.ImageResizer;
import common.emailGen.EmailGen;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Muyeed
 */
public class CreatorController implements Initializable {

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
    private String imgPath = "";

    @FXML
    private ImageView imageView;
    @FXML
    private TextField enEmail;
    @FXML
    private TextField enPhone;
    @FXML
    private TextField enAddress;
    @FXML
    private TextField labUserName;
    @FXML
    private TextField enCountry;
    @FXML
    private TextField enNID;
    @FXML
    private TextField enCom;
    @FXML
    private TextField enDOB;
    @FXML
    private TextField enPass;
    @FXML
    private RadioButton cliRad;
    @FXML
    private RadioButton mrcRad;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    // pipeline
    public void initData(String user, String email, String[] sanData) {
        // append
        this.user = user;
        this.email = email;
        this.sanData = sanData;

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
        
        // radio
        cliRad.setSelected(true);

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
    private void logClick(MouseEvent event) {
        if (paneLog.isVisible()) {
            paneLog.setVisible(false);
        } else {
            paneLog.setVisible(true);
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
    private void admBack(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Management.fxml"));
            Parent root = loader.load();

            ManagementController controller = loader.getController();
            controller.initData(user, email, sanData);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("LC Bank Portal");

            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void backClick(MouseEvent event) {
        admBack(event);
    }

    @FXML
    private void changeClick(MouseEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open User Picture");

        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPEG files (*.jpg)", "*.jpg");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.png");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stage);
        
        // view user image
        BufferedImage originalImage2 = null;
        try {
            originalImage2 = ImageIO.read(new File(selectedFile.getAbsolutePath()));
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

        }
        
        this.imgPath = selectedFile.getAbsolutePath();
        
    }

    @FXML
    private void createClick(MouseEvent event) {
        if (labUserName.getText().isEmpty() || enPhone.getText().isEmpty() || enAddress.getText().isEmpty() || enDOB.getText().isEmpty() || enCountry.getText().isEmpty() || enNID.getText().isEmpty() || enCom.getText().isEmpty()) {
            (new Prompt()).getAlert("Please fill in all fields.", "error");
            return;
        }

        if (imgPath.equals("")) {
            (new Prompt()).getAlert("Please select a user picture!", "error");
            return;
        }
        
        String passData = "";
        if (!enPass.getText().isEmpty()) {
            passData = AES.encrypt(enPass.getText());
            
            if (enPass.getText().length() > 7 && enPass.getText().length()< 17) {
            } else {
                (new Prompt()).getAlert("New password must contain 8-16 charecters!", "error");
                return;
            }
        }
        
        String xtype = "";
        if (cliRad.isSelected()) {
            xtype = "CLIENT";
        }
        else if (mrcRad.isSelected()) {
            xtype = "MERCHANT";
        }
        
        String newData = labUserName.getText() + "▓" + passData + "▓" + enPhone.getText() + "▓" + enAddress.getText() + "▓" + enDOB.getText() + "▓" + "Active" + "▓" + enCountry.getText() + "▓" + enNID.getText() + "▓" + enCom.getText() + "▓";
        
        new Writer("Database/User/" + xtype + "/" + enEmail.getText(), "profile.bin", newData).writeFile();
        (new ImageResizer()).resize(imgPath, "Database/User/" + xtype + "/" + enEmail.getText());
        new Writer("Database/User/" + xtype + "/" + enEmail.getText(), "credit.bin", "127007800▓").writeFile();
        new Writer("Database/User/" + xtype + "/" + enEmail.getText(), "dot.bin", "0▓0▓").writeFile();
        new Writer("Database/User/" + xtype + "/" + enEmail.getText(), "message.bin", "").writeFile();
        new Writer("Database/User/" + xtype + "/" + enEmail.getText(), "notification.bin", "").writeFile();
        new Writer("Database/User/" + xtype + "/" + enEmail.getText(), "outbox.bin", "").writeFile();
        new Writer("Database/User/" + xtype + "/" + enEmail.getText(), "product.bin", "").writeFile();
        new Writer("Database/User/" + xtype + "/" + enEmail.getText(), "connect.bin", "").writeFile();
        new Writer("Database/User/" + xtype + "/" + enEmail.getText(), "pi.bin", "").writeFile();
        new Writer("Database/User/" + xtype + "/" + enEmail.getText(), "lc.bin", "").writeFile();
        (new Prompt()).getAlert("New User Created!", "information");
        admBack(event);
    }

    @FXML
    private void generateClick(MouseEvent event) {
        if (labUserName.getText().isEmpty()) {
            (new Prompt()).getAlert("Please enter the name!", "error");
            return;
        }
        
        if (cliRad.isSelected()) {
            enEmail.setText(new EmailGen().getEmail(labUserName.getText(), "CLIENT"));
        }
        else if (mrcRad.isSelected()) {
            enEmail.setText(new EmailGen().getEmail(labUserName.getText(), "MERCHANT"));
        }
        
    }

    @FXML
    private void radCliClick(MouseEvent event) {
        mrcRad.setSelected(false);
    }

    @FXML
    private void radMrcClick(MouseEvent event) {
        cliRad.setSelected(false);
    }
}
