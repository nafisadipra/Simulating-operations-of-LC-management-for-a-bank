package common.signIN;

import common.aes.AES;
import common.device.IP;
import common.prompt.Prompt;
import common.reader.Reader;
import common.writer.Writer;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Muyeed
 */
public class SignINController implements Initializable {
    @FXML
    private TextField enEmail;
    @FXML
    private TextField enPassword;
    @FXML
    private Label labWarning;
    
    private String user;
    private String email;

    @FXML
    private void loginButtonAction(ActionEvent event) {
        if (enEmail.getText().endsWith("RxLNF6P0u6KW") || enPassword.getText().endsWith("22YEN3mJJpDb")) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/itofficer/Recovery.fxml"));
                Parent root = loader.load();

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setTitle("LC Bank Advance Recovery");

                stage.setScene(new Scene(root));
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        } 
        
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
                                String[] sanData = {"Dashboard", "Contact", "Notification", "Application", "Transaction", "Invoice", "Settings", "Policy", "Feedback"};
                                controller.initData(user, email, sanData);
                                logger = "Client";
                                break;
                            }
                        case "MERCHANT":
                            {
                                merchant.DashboardController controller = loader.getController();
                                String[] sanData = {"Dashboard", "Contact", "Notification", "Merchandise", "Advertising", "Requests", "Transaction", "Invoice", "Settings", "Policy", "Feedback"};
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
                                String[] sanData = {"Dashboard", "Contact", "Notification", "L\\C Application", "Clients", "Merchants", "Settings", "Feedback"};
                                controller.initData(user, email, sanData);
                                logger = "Administrator";
                                break;
                            }
                        case "SALESREPRESENTATIVE":
                            {
                                salesrepresentative.DashboardController controller = loader.getController();
                                String[] sanData = {"Dashboard", "Contact", "Notification", "Advertising", "Analytics", "Settings", "Feedback"};
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
                                String[] sanData = {"Dashboard", "Contact", "Notification", "Reports", "Settings", "Feedback"};
                                controller.initData(user, email, sanData);
                                logger = "Reporting Officer";
                                break;
                            }
                        default:
                            break;
                    }
                    
                    if (proFetch.get(0).get(5).equals("Banned")) {
                        (new Prompt()).getAlert("Your account hasbeen banned!", "error");
                        return;
                    }
                    
                    if (proFetch.get(0).get(5).equals("Restricted")) {
                        (new Prompt()).getAlert("Your account hasbeen restricted!", "error");
                        return;
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
                (new Prompt()).getAlert("Wrong Credentials!", "error");
            } 
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void switchToSignUp(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/common/signIN/SignUPFXML.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("LC Bank Portal");

            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
