package common.signIN;

import common.aes.AES;
import common.device.IP;
import common.device.ImageResizer;
import common.emailGen.EmailGen;
import common.prompt.Prompt;
import common.reader.Reader;
import common.writer.Writer;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 *
 * @author Muyeed
 */
public class SignUPController implements Initializable {
    @FXML
    private TextField enEmail;
    private TextField enPassword;
    @FXML
    private Label labWarning;
    
    private String user;
    private String email;
    private String imgPath = "";
    @FXML
    private ImageView imageView;
    @FXML
    private TextField labUserName;
    @FXML
    private RadioButton cliRad;
    @FXML
    private RadioButton mrcRad;
    @FXML
    private TextField enPhone;
    @FXML
    private TextField enAddress;
    @FXML
    private TextField enCountry;
    @FXML
    private TextField enNID;
    @FXML
    private TextField enCom;
    @FXML
    private DatePicker enDOB;
    @FXML
    private TextField enPass;
    @FXML
    private TextField enCPass;

    private void loginButtonAction(ActionEvent event) {
        // mail separator
        String mail = "";
        boolean foundAtSymbol = false;
        String emailText = enEmail.getText();
        
        for (int i = 0; i < emailText.length(); i++) {
            if (emailText.charAt(i) == '@') {
                foundAtSymbol = true;
                continue;
            }

            if (foundAtSymbol) {
                mail += emailText.charAt(i);
            }
        }
        
        // user switch
        switch (mail) {
            case "lc.admin.com":
                this.user = "ADMINISTRATOR";
                break;
            case "lc.it.com":
                this.user = "ITOFFICER";
                break;
            case "lc.cli.com":
                this.user = "CLIENT";
                break;
            case "lc.mrc.com":
                this.user = "MERCHANT";
                break;
            case "lc.gm.com":
                this.user = "GENERALMANAGER";
                break;
            case "lc.cr.com":
                this.user = "CREDITANALYST";
                break;
            case "lc.of.com":
                this.user = "LCOFFICER";
                break;
            case "lc.sr.com":
                this.user = "SALESREPRESENTATIVE";
                break;
            case "lc.co.com":
                this.user = "COMPLIANCEOFFICER";
                break;
            case "lc.ro.com":
                this.user = "REPORTINGOFFICER";
                break;
            default:
                break;
        }
        
        this.email = enEmail.getText();

        ArrayList <ArrayList<String>> proFetch = (new Reader("Database/User/" + user + "/" + email, "profile.bin")).splitFile('▓');
        
        if (proFetch.isEmpty()) {
            labWarning.setVisible(true);
        } else {
            ArrayList <String> data = proFetch.get(0);
            String password = AES.decrypt(data.get(1));
            
            if (password.equals(enPassword.getText())) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/" + user.toLowerCase() + "/Dashboard.fxml"));
                    Parent root = loader.load();
                    
                    String logger = "Default";
                    switch (user) {
                        case "ADMINISTRATOR":
                            {
                                administrator.DashboardController controller = loader.getController();
                                String[] sanData = {"Dashboard", "Contact", "Notification", "Logs", "Management", "Settings", "Feedback"};
                                controller.initData(user, email, sanData);
                                logger = "Administrator";
                                break;
                            }
                        case "ITOFFICER":
                            {
                                itofficer.DashboardController controller = loader.getController();
                                String[] sanData = {"Dashboard", "Contact", "Notification", "Logs", "Monitoring", "Backup", "Settings", "Feedback"};
                                controller.initData(user, email, sanData);
                                logger = "IT Officer";
                                break;
                            }
                        case "CLIENT":
                            {
                                client.DashboardController controller = loader.getController();
                                String[] sanData = {"Dashboard", "Contact", "Notification", "Application", "Transaction", "Invoice", "Switch Account", "Settings", "Policy", "Feedback"};
                                controller.initData(user, email, sanData);
                                logger = "Client";
                                break;
                            }
                        case "MERCHANT":
                            {
                                merchant.DashboardController controller = loader.getController();
                                String[] sanData = {"Dashboard", "Contact", "Notification", "Merchandise", "Advertising", "Requests", "Transaction", "Invoice", "Switch Account", "Settings", "Policy", "Feedback"};
                                controller.initData(user, email, sanData);
                                logger = "Merchant";
                                break;
                            }
                        case "GENERALMANAGER":
                            {
                                generalmanager.DashboardController controller = loader.getController();
                                String[] sanData = {"Dashboard", "Contact", "Notification", "Requests", "History", "Clients", "Merchants", "Settings", "Feedback"};
                                controller.initData(user, email, sanData);
                                logger = "General Manager";
                                break;
                            }
                        case "CREDITANALYST":
                            {
                                creditanalyst.DashboardController controller = loader.getController();
                                String[] sanData = {"Dashboard", "Contact", "Notification", "Requests", "Clients", "Merchants", "Analytics", "Settings", "Feedback"};
                                controller.initData(user, email, sanData);
                                logger = "Credit Analyst";
                                break;
                            }
                        case "LCOFFICER":
                            {
                                lcofficer.DashboardController controller = loader.getController();
                                String[] sanData = {"Dashboard", "Contact", "Notification", "L\\C Applications", "History", "Clients", "Merchants", "Settings", "Feedback"};
                                controller.initData(user, email, sanData);
                                logger = "Administrator";
                                break;
                            }
                        case "SALESREPRESENTATIVE":
                            {
                                salesrepresentative.DashboardController controller = loader.getController();
                                String[] sanData = {"Dashboard", "Contact", "Notification", "Relationship", "Advertising", "Transaction", "Analytics", "Settings", "Feedback"};
                                controller.initData(user, email, sanData);
                                logger = "Sales Representative";
                                break;
                            }
                        case "COMPLIANCEOFFICER":
                            {
                                complianceofficer.DashboardController controller = loader.getController();
                                String[] sanData = {"Dashboard", "Contact", "Notification", "Requests", "Clients", "Merchants", "Risk Assessment", "Policy Management", "Settings", "Feedback"};
                                controller.initData(user, email, sanData);
                                logger = "Compliance Officer";
                                break;
                            }
                        case "REPORTINGOFFICER":
                            {
                                reportingofficer.DashboardController controller = loader.getController();
                                String[] sanData = {"Dashboard", "Contact", "Notification", "Invoice", "Reports", "Settings", "Feedback"};
                                controller.initData(user, email, sanData);
                                logger = "Reporting Officer";
                                break;
                            }
                        default:
                            break;
                    }

                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setTitle("LC Bank Portal");

                    stage.setScene(new Scene(root));
                    stage.show();
                    
                    LocalTime currentTime = LocalTime.now();
                    DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("hh:mm a");

                    LocalDate currentDate = LocalDate.now();
                    DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    
                    String log = logger + "▓" + email + "▓" + IP.getIP() + "▓" + currentTime.format(formatTime) + "▓" + currentDate.format(formatDate) + "▓";
                    
                    new Writer("Database/Official/LOG", "signin.bin", log).overWriteFile();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                labWarning.setVisible(false);
            } else {
                labWarning.setVisible(true);
            } 
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
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
    private void radCliClick(MouseEvent event) {
        mrcRad.setSelected(false);
    }

    @FXML
    private void radMrcClick(MouseEvent event) {
        cliRad.setSelected(false);
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
    private void createClick(MouseEvent event) {
        if (labUserName.getText().isEmpty() || enPhone.getText().isEmpty() || enAddress.getText().isEmpty() || enCountry.getText().isEmpty() || enNID.getText().isEmpty() || enCom.getText().isEmpty()) {
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
        
        String newData = labUserName.getText() + "▓" + passData + "▓" + enPhone.getText() + "▓" + enAddress.getText() + "▓" + enDOB.getValue() + "▓" + "Active" + "▓" + enCountry.getText() + "▓" + enNID.getText() + "▓" + enCom.getText() + "▓";
        
        new Writer("Database/User/" + xtype + "/" + enEmail.getText(), "profile.bin", newData).writeFile();
        (new ImageResizer()).resize(imgPath, "Database/User/" + xtype + "/" + enEmail.getText());
        new Writer("Database/User/" + xtype + "/" + enEmail.getText(), "credit.bin", "127007800▓").writeFile();
        new Writer("Database/User/" + xtype + "/" + enEmail.getText(), "dot.bin", "0▓0▓").writeFile();
        new Writer("Database/User/" + xtype + "/" + enEmail.getText(), "message.bin", "").writeFile();
        new Writer("Database/User/" + xtype + "/" + enEmail.getText(), "notification.bin", "").writeFile();
        new Writer("Database/User/" + xtype + "/" + enEmail.getText(), "outbox.bin", "").writeFile();
        new Writer("Database/User/" + xtype + "/" + enEmail.getText(), "product.bin", "").writeFile();
        new Writer("Database/User/" + xtype + "/" + enEmail.getText(), "connect.bin", "").writeFile();
        (new Prompt()).getAlert("New User Created!", "information");
    }
    
}
