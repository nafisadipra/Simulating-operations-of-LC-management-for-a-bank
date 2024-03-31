package common.signIN;

import common.aes.AES;
import common.reader.Reader;
import java.io.IOException;
import java.net.URL;
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
                    
                    switch (user) {
                        case "ADMINISTRATOR":
                            {
                                administrator.Dashboard controller = loader.getController();
                                String[] sanData = {"Dashboard", "Contact", "Notification", "Logs", "Management", "Settings", "Feedback"};
                                controller.initData(user, email, sanData);
                                break;
                            }
                        case "ITOFFICER":
                            {
                                itofficer.Dashboard controller = loader.getController();
                                String[] sanData = {"Dashboard", "Contact", "Notification", "Logs", "Monitoring", "Backup", "Settings", "Feedback"};
                                controller.initData(user, email, sanData);
                                break;
                            }
                        case "CLIENT":
                            {
                                client.Dashboard controller = loader.getController();
                                String[] sanData = {"Dashboard", "Contact", "Notification", "Application", "Transaction", "Invoice", "Switch Account", "Settings", "Policy", "Feedback"};
                                controller.initData(user, email, sanData);
                                break;
                            }
                        case "MERCHANT":
                            {
                                merchant.Dashboard controller = loader.getController();
                                String[] sanData = {"Dashboard", "Contact", "Notification", "Merchandise", "Advertising", "Requests", "Transaction", "Invoice", "Switch Account", "Settings", "Policy", "Feedback"};
                                controller.initData(user, email, sanData);
                                break;
                            }
                        case "GENERALMANAGER":
                            {
                                generalmanager.Dashboard controller = loader.getController();
                                String[] sanData = {"Dashboard", "Contact", "Notification", "Requests", "History", "Clients", "Merchants", "Settings", "Feedback"};
                                controller.initData(user, email, sanData);
                                break;
                            }
                        case "CREDITANALYST":
                            {
                                creditanalyst.Dashboard controller = loader.getController();
                                String[] sanData = {"Dashboard", "Contact", "Notification", "Requests", "Clients", "Merchants", "Analytics", "Settings", "Feedback"};
                                controller.initData(user, email, sanData);
                                break;
                            }
                        case "LCOFFICER":
                            {
                                lcofficer.Dashboard controller = loader.getController();
                                String[] sanData = {"Dashboard", "Contact", "Notification", "L\\C Applications", "History", "Clients", "Merchants", "Settings", "Feedback"};
                                controller.initData(user, email, sanData);
                                break;
                            }
                        case "SALESREPRESENTATIVE":
                            {
                                salesrepresentative.Dashboard controller = loader.getController();
                                String[] sanData = {"Dashboard", "Contact", "Notification", "Relationship", "Advertising", "Transaction", "Analytics", "Settings", "Feedback"};
                                controller.initData(user, email, sanData);
                                break;
                            }
                        case "COMPLIANCEOFFICER":
                            {
                                complianceofficer.Dashboard controller = loader.getController();
                                String[] sanData = {"Dashboard", "Contact", "Notification", "Requests", "Clients", "Merchants", "Risk Assessment", "Policy Management", "Settings", "Feedback"};
                                controller.initData(user, email, sanData);
                                break;
                            }
                        case "REPORTINGOFFICER":
                            {
                                reportingofficer.Dashboard controller = loader.getController();
                                String[] sanData = {"Dashboard", "Contact", "Notification", "Invoice", "Reports", "Settings", "Feedback"};
                                controller.initData(user, email, sanData);
                                break;
                            }
                        default:
                            break;
                    }

                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setTitle("LC Bank Portal");

                    stage.setScene(new Scene(root));
                    stage.show();

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
    private void switchToSignUp(ActionEvent event) {

    }
    
}
