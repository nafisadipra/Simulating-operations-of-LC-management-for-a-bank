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
        
        if (mail.equals("lc.ad.com")) {
            this.user = "AD";
        }
        
        if (mail.equals("lc.it.com")) {
            this.user = "IT";
        }
        
        if (mail.equals("lc.cmo.com")) {
            this.user = "CMO";
        }
        
        if (mail.equals("lc.cli.com")) {
            this.user = "CLI";
        }
        
        if (mail.equals("lc.gm.com")) {
            this.user = "GM";
        }
        
        if (mail.equals("lc.cra.com")) {
            this.user = "CRA";
        }
        
        if (mail.equals("lc.lco.com")) {
            this.user = "LCO";
        }
        
        if (mail.equals("lc.sr.com")) {
            this.user = "SR";
        }
        
        if (mail.equals("lc.crm.com")) {
            this.user = "CRM";
        }
        
        if (mail.equals("lc.ra.com")) {
            this.user = "RA";
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
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/" + user.toLowerCase() + "/DashboardFXML.fxml"));
                    Parent root = loader.load();
                    
                    if (user.equals("AD")) {
                        ad.DashboardController controller = loader.getController();
                        String[] sanData = {"Dashboard", "Message", "Notification", "Access Logs", "User Management", "Settings"};
                        controller.initData(user, email, sanData);
                    }
                    
//                    if (user.equals("Administrator")) {
//                        administrator.DashboardController controller = loader.getController();
//                        String[] sanData = {"Dashboard", "Message", "Notification", "Access Logs", "User Management", "Settings"};
//                        controller.initData(user, email, sanData);
//                    }
//                    
//                    if (user.equals("Administrator")) {
//                        administrator.DashboardController controller = loader.getController();
//                        String[] sanData = {"Dashboard", "Message", "Notification", "Access Logs", "User Management", "Settings"};
//                        controller.initData(user, email, sanData);
//                    }
//                    
//                    if (user.equals("Administrator")) {
//                        administrator.DashboardController controller = loader.getController();
//                        String[] sanData = {"Dashboard", "Message", "Notification", "Access Logs", "User Management", "Settings"};
//                        controller.initData(user, email, sanData);
//                    }
//                    
//                    if (user.equals("Administrator")) {
//                        administrator.DashboardController controller = loader.getController();
//                        String[] sanData = {"Dashboard", "Message", "Notification", "Access Logs", "User Management", "Settings"};
//                        controller.initData(user, email, sanData);
//                    }
//                    
//                    if (user.equals("Administrator")) {
//                        administrator.DashboardController controller = loader.getController();
//                        String[] sanData = {"Dashboard", "Message", "Notification", "Access Logs", "User Management", "Settings"};
//                        controller.initData(user, email, sanData);
//                    }
//                    
//                    if (user.equals("Administrator")) {
//                        administrator.DashboardController controller = loader.getController();
//                        String[] sanData = {"Dashboard", "Message", "Notification", "Access Logs", "User Management", "Settings"};
//                        controller.initData(user, email, sanData);
//                    }
//                    
//                    if (user.equals("Administrator")) {
//                        administrator.DashboardController controller = loader.getController();
//                        String[] sanData = {"Dashboard", "Message", "Notification", "Access Logs", "User Management", "Settings"};
//                        controller.initData(user, email, sanData);
//                    }
//                    
//                    if (user.equals("Administrator")) {
//                        administrator.DashboardController controller = loader.getController();
//                        String[] sanData = {"Dashboard", "Message", "Notification", "Access Logs", "User Management", "Settings"};
//                        controller.initData(user, email, sanData);
//                    }
//                    
//                    if (user.equals("Administrator")) {
//                        administrator.DashboardController controller = loader.getController();
//                        String[] sanData = {"Dashboard", "Message", "Notification", "Access Logs", "User Management", "Settings"};
//                        controller.initData(user, email, sanData);
//                    }
//                    
//                    if (user.equals("Administrator")) {
//                        administrator.DashboardController controller = loader.getController();
//                        String[] sanData = {"Dashboard", "Message", "Notification", "Access Logs", "User Management", "Settings"};
//                        controller.initData(user, email, sanData);
//                    }

                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setTitle(user);

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
