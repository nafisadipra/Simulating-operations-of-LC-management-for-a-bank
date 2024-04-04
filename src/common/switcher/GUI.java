package common.switcher;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author Muyeed
 */
public class GUI {
    private String user;
    private String email;
    private String[] sanData;

    public GUI(String user, String email, String[] sanData) {
        this.user = user;
        this.email = email;
        this.sanData = sanData;
    }

    public void dashClick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/" + user.toLowerCase() + "/Dashboard.fxml"));
            Parent root = loader.load();

            switch (user) {
                case "ADMINISTRATOR":
                    {
                        administrator.DashboardController controller = loader.getController();
                        controller.initData(user, email, sanData);
                        break;
                    }
                case "CREDITANALYST":
                    {
                        creditanalyst.DashboardController controller = loader.getController();
                        controller.initData(user, email, sanData);
                        break;
                    }
                case "CLIENT":
                    {
                        client.DashboardController controller = loader.getController();
                        controller.initData(user, email, sanData);
                        break;
                    }
                case "COMPLIANCEOFFICER":
                    {
                        complianceofficer.DashboardController controller = loader.getController();
                        controller.initData(user, email, sanData);
                        break;
                    }
                case "GENERALMANAGER":
                    {
                        generalmanager.DashboardController controller = loader.getController();
                        controller.initData(user, email, sanData);
                        break;
                    }
                case "ITOFFICER":
                    {
                        itofficer.DashboardController controller = loader.getController();
                        controller.initData(user, email, sanData);
                        break;
                    }
                case "LCOFFICER":
                    {
                        lcofficer.DashboardController controller = loader.getController();
                        controller.initData(user, email, sanData);
                        break;
                    }
                case "MERCHANT":
                    {
                        merchant.DashboardController controller = loader.getController();
                        controller.initData(user, email, sanData);
                        break;
                    }
                case "REPORTINGOFFICER":
                    {
                        reportingofficer.DashboardController controller = loader.getController();
                        controller.initData(user, email, sanData);
                        break;
                    }
                case "SALESREPRESENTATIVE":
                    {
                        salesrepresentative.DashboardController controller = loader.getController();
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
    }
    
    public void reqClick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/" + user.toLowerCase() + "/Requests.fxml"));
            Parent root = loader.load();
            
            switch (user) {
                case "ADMINISTRATOR":
                    {
                        break;
                    }
                case "CREDITANALYST":
                    {
                        creditanalyst.RequestsController controller = loader.getController();
                        controller.initData(user, email, sanData);
                        break;
                    }
                case "CLIENT":
                    {
                        break;
                    }
                case "COMPLIANCEOFFICER":
                    {
                        complianceofficer.RequestsController controller = loader.getController();
                        controller.initData(user, email, sanData);
                        break;
                    }
                case "GENERALMANAGER":
                    {
                        generalmanager.RequestsController controller = loader.getController();
                        controller.initData(user, email, sanData);
                        break;
                    }
                case "ITOFFICER":
                    {
                        break;
                    }
                case "LCOFFICER":
                    {
                        break;
                    }
                case "MERCHANT":
                    {
                        merchant.RequestsController controller = loader.getController();
                        controller.initData(user, email, sanData);
                        break;
                    }
                case "REPORTINGOFFICER":
                    {
                        break;
                    }
                case "SALESREPRESENTATIVE":
                    {
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
    }
    
    public void hisClick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/" + user.toLowerCase() + "/History.fxml"));
            Parent root = loader.load();
            
            switch (user) {
                case "ADMINISTRATOR":
                    {
                        break;
                    }
                case "CREDITANALYST":
                    {
                        break;
                    }
                case "CLIENT":
                    {
                        break;
                    }
                case "COMPLIANCEOFFICER":
                    {
                        break;
                    }
                case "GENERALMANAGER":
                    {
                        generalmanager.HistoryController controller = loader.getController();
                        controller.initData(user, email, sanData);
                        break;
                    }
                case "ITOFFICER":
                    {
                        break;
                    }
                case "LCOFFICER":
                    {
                        lcofficer.HistoryController controller = loader.getController();
                        controller.initData(user, email, sanData);
                        break;
                    }
                case "MERCHANT":
                    {
                        break;
                    }
                case "REPORTINGOFFICER":
                    {
                        break;
                    }
                case "SALESREPRESENTATIVE":
                    {
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
    }
    
    public void cliClick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/" + user.toLowerCase() + "/Clients.fxml"));
            Parent root = loader.load();
            
            switch (user) {
                case "ADMINISTRATOR":
                    {
                        break;
                    }
                case "CREDITANALYST":
                    {
                        creditanalyst.ClientsController controller = loader.getController();
                        controller.initData(user, email, sanData);
                        break;
                    }
                case "CLIENT":
                    {
                        break;
                    }
                case "COMPLIANCEOFFICER":
                    {
                        complianceofficer.ClientsController controller = loader.getController();
                        controller.initData(user, email, sanData);
                        break;
                    }
                case "GENERALMANAGER":
                    {
                        generalmanager.ClientsController controller = loader.getController();
                        controller.initData(user, email, sanData);
                        break;
                    }
                case "ITOFFICER":
                    {
                        break;
                    }
                case "LCOFFICER":
                    {
                        lcofficer.ClientsController controller = loader.getController();
                        controller.initData(user, email, sanData);
                        break;
                    }
                case "MERCHANT":
                    {
                        break;
                    }
                case "REPORTINGOFFICER":
                    {
                        break;
                    }
                case "SALESREPRESENTATIVE":
                    {
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
    }
    
    public void mrcClick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/" + user.toLowerCase() + "/Merchants.fxml"));
            Parent root = loader.load();
            
            switch (user) {
                case "ADMINISTRATOR":
                    {
                        break;
                    }
                case "CREDITANALYST":
                    {
                        creditanalyst.MerchantsController controller = loader.getController();
                        controller.initData(user, email, sanData);
                        break;
                    }
                case "CLIENT":
                    {
                        break;
                    }
                case "COMPLIANCEOFFICER":
                    {
                        complianceofficer.MerchantsController controller = loader.getController();
                        controller.initData(user, email, sanData);
                        break;
                    }
                case "GENERALMANAGER":
                    {
                        generalmanager.MerchantsController controller = loader.getController();
                        controller.initData(user, email, sanData);
                        break;
                    }
                case "ITOFFICER":
                    {
                        break;
                    }
                case "LCOFFICER":
                    {
                        lcofficer.MerchantsController controller = loader.getController();
                        controller.initData(user, email, sanData);
                        break;
                    }
                case "MERCHANT":
                    {
                        break;
                    }
                case "REPORTINGOFFICER":
                    {
                        break;
                    }
                case "SALESREPRESENTATIVE":
                    {
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
    }
    
    public void applcClick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/" + user.toLowerCase() + "/Application.fxml"));
            Parent root = loader.load();
            
            switch (user) {
                case "ADMINISTRATOR":
                    {
                        break;
                    }
                case "CREDITANALYST":
                    {
                        break;
                    }
                case "CLIENT":
                    {
                        client.ApplicationController controller = loader.getController();
                        controller.initData(user, email, sanData);
                        break;
                    }
                case "COMPLIANCEOFFICER":
                    {
                        break;
                    }
                case "GENERALMANAGER":
                    {
                        break;
                    }
                case "ITOFFICER":
                    {
                        break;
                    }
                case "LCOFFICER":
                    {
                        lcofficer.ApplicationController controller = loader.getController();
                        controller.initData(user, email, sanData);
                        break;
                    }
                case "MERCHANT":
                    {
                        break;
                    }
                case "REPORTINGOFFICER":
                    {
                        break;
                    }
                case "SALESREPRESENTATIVE":
                    {
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
    }
    
    public void transClick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/" + user.toLowerCase() + "/Transaction.fxml"));
            Parent root = loader.load();
            
            switch (user) {
                case "ADMINISTRATOR":
                    {
                        break;
                    }
                case "CREDITANALYST":
                    {
                        break;
                    }
                case "CLIENT":
                    {
                        client.TransactionController controller = loader.getController();
                        controller.initData(user, email, sanData);
                        break;
                    }
                case "COMPLIANCEOFFICER":
                    {
                        break;
                    }
                case "GENERALMANAGER":
                    {
                        break;
                    }
                case "ITOFFICER":
                    {
                        break;
                    }
                case "LCOFFICER":
                    {
                        break;
                    }
                case "MERCHANT":
                    {
                        merchant.TransactionController controller = loader.getController();
                        controller.initData(user, email, sanData);
                        break;
                    }
                case "REPORTINGOFFICER":
                    {
                        break;
                    }
                case "SALESREPRESENTATIVE":
                    {
                        salesrepresentative.TransactionController controller = loader.getController();
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
    }
    
    public void ivcClick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/" + user.toLowerCase() + "/Invoice.fxml"));
            Parent root = loader.load();
            
            switch (user) {
                case "ADMINISTRATOR":
                    {
                        break;
                    }
                case "CREDITANALYST":
                    {
                        break;
                    }
                case "CLIENT":
                    {
                        client.InvoiceController controller = loader.getController();
                        controller.initData(user, email, sanData);
                        break;
                    }
                case "COMPLIANCEOFFICER":
                    {
                        break;
                    }
                case "GENERALMANAGER":
                    {
                        break;
                    }
                case "ITOFFICER":
                    {
                        break;
                    }
                case "LCOFFICER":
                    {
                        break;
                    }
                case "MERCHANT":
                    {
                        merchant.InvoiceController controller = loader.getController();
                        controller.initData(user, email, sanData);
                        break;
                    }
                case "REPORTINGOFFICER":
                    {
                        reportingofficer.InvoiceController controller = loader.getController();
                        controller.initData(user, email, sanData);
                        break;
                    }
                case "SALESREPRESENTATIVE":
                    {
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
    }
    
    public void swtClick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/" + user.toLowerCase() + "/Switch.fxml"));
            Parent root = loader.load();
            
            switch (user) {
                case "ADMINISTRATOR":
                    {
                        break;
                    }
                case "CREDITANALYST":
                    {
                        break;
                    }
                case "CLIENT":
                    {
                        client.SwitchController controller = loader.getController();
                        controller.initData(user, email, sanData);
                        break;
                    }
                case "COMPLIANCEOFFICER":
                    {
                        break;
                    }
                case "GENERALMANAGER":
                    {
                        break;
                    }
                case "ITOFFICER":
                    {
                        break;
                    }
                case "LCOFFICER":
                    {
                        break;
                    }
                case "MERCHANT":
                    {
                        merchant.SwitchController controller = loader.getController();
                        controller.initData(user, email, sanData);
                        break;
                    }
                case "REPORTINGOFFICER":
                    {
                        break;
                    }
                case "SALESREPRESENTATIVE":
                    {
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
    }
    
    public void sttClick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/common/settings/SettingsFXML.fxml"));
            Parent root = loader.load();
            
            common.settings.SettingsController controller = loader.getController();
            controller.initData(user, email, sanData);
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("LC Bank Portal");

            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void pcyClick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/" + user.toLowerCase() + "/Policy.fxml"));
            Parent root = loader.load();
            
            switch (user) {
                case "ADMINISTRATOR":
                    {
                        break;
                    }
                case "CREDITANALYST":
                    {
                        break;
                    }
                case "CLIENT":
                    {
                        client.PolicyController controller = loader.getController();
                        controller.initData(user, email, sanData);
                        break;
                    }
                case "COMPLIANCEOFFICER":
                    {
                        complianceofficer.PolicyController controller = loader.getController();
                        controller.initData(user, email, sanData);
                        break;
                    }
                case "GENERALMANAGER":
                    {
                        break;
                    }
                case "ITOFFICER":
                    {
                        break;
                    }
                case "LCOFFICER":
                    {
                        break;
                    }
                case "MERCHANT":
                    {
                        merchant.PolicyController controller = loader.getController();
                        controller.initData(user, email, sanData);
                        break;
                    }
                case "REPORTINGOFFICER":
                    {
                        break;
                    }
                case "SALESREPRESENTATIVE":
                    {
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
    }
    
    public void feedClick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/common/feedback/FeedbackFXML.fxml"));
            Parent root = loader.load();
            
            common.feedback.FeedbackController controller = loader.getController();
            controller.initData(user, email, sanData);
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("LC Bank Portal");

            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void mrcDiseClick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/" + user.toLowerCase() + "/Merchandise.fxml"));
            Parent root = loader.load();
            
            switch (user) {
                case "ADMINISTRATOR":
                    {
                        break;
                    }
                case "CREDITANALYST":
                    {
                        break;
                    }
                case "CLIENT":
                    {
                        break;
                    }
                case "COMPLIANCEOFFICER":
                    {
                        break;
                    }
                case "GENERALMANAGER":
                    {
                        break;
                    }
                case "ITOFFICER":
                    {
                        break;
                    }
                case "LCOFFICER":
                    {
                        break;
                    }
                case "MERCHANT":
                    {
                        merchant.MerchandiseController controller = loader.getController();
                        controller.initData(user, email, sanData);
                        break;
                    }
                case "REPORTINGOFFICER":
                    {
                        break;
                    }
                case "SALESREPRESENTATIVE":
                    {
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
    }
    
    public void advClick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/" + user.toLowerCase() + "/Advertising.fxml"));
            Parent root = loader.load();
            
            switch (user) {
                case "ADMINISTRATOR":
                    {
                        break;
                    }
                case "CREDITANALYST":
                    {
                        break;
                    }
                case "CLIENT":
                    {
                        break;
                    }
                case "COMPLIANCEOFFICER":
                    {
                        break;
                    }
                case "GENERALMANAGER":
                    {
                        break;
                    }
                case "ITOFFICER":
                    {
                        break;
                    }
                case "LCOFFICER":
                    {
                        break;
                    }
                case "MERCHANT":
                    {
                        merchant.AdvertisingController controller = loader.getController();
                        controller.initData(user, email, sanData);
                        break;
                    }
                case "REPORTINGOFFICER":
                    {
                        break;
                    }
                case "SALESREPRESENTATIVE":
                    {
                        salesrepresentative.AdvertisingController controller = loader.getController();
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
    }
    
    public void anlClick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/" + user.toLowerCase() + "/Analytics.fxml"));
            Parent root = loader.load();
            
            switch (user) {
                case "ADMINISTRATOR":
                    {
                        break;
                    }
                case "CREDITANALYST":
                    {
                        creditanalyst.AnalyticsController controller = loader.getController();
                        controller.initData(user, email, sanData);
                        break;
                    }
                case "CLIENT":
                    {
                        break;
                    }
                case "COMPLIANCEOFFICER":
                    {
                        break;
                    }
                case "GENERALMANAGER":
                    {
                        break;
                    }
                case "ITOFFICER":
                    {
                        break;
                    }
                case "LCOFFICER":
                    {
                        break;
                    }
                case "MERCHANT":
                    {
                        break;
                    }
                case "REPORTINGOFFICER":
                    {
                        break;
                    }
                case "SALESREPRESENTATIVE":
                    {
                        salesrepresentative.AnalyticsController controller = loader.getController();
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
    }
    
    public void riskClick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/" + user.toLowerCase() + "/Risk.fxml"));
            Parent root = loader.load();
            
            switch (user) {
                case "ADMINISTRATOR":
                    {
                        break;
                    }
                case "CREDITANALYST":
                    {
                        break;
                    }
                case "CLIENT":
                    {
                        break;
                    }
                case "COMPLIANCEOFFICER":
                    {
                        complianceofficer.RiskController controller = loader.getController();
                        controller.initData(user, email, sanData);
                        break;
                    }
                case "GENERALMANAGER":
                    {
                        break;
                    }
                case "ITOFFICER":
                    {
                        break;
                    }
                case "LCOFFICER":
                    {
                        break;
                    }
                case "MERCHANT":
                    {
                        break;
                    }
                case "REPORTINGOFFICER":
                    {
                        break;
                    }
                case "SALESREPRESENTATIVE":
                    {
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
    }
    
    public void logUserClick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/" + user.toLowerCase() + "/Logs.fxml"));
            Parent root = loader.load();
            
            switch (user) {
                case "ADMINISTRATOR":
                    {
                        administrator.LogsController controller = loader.getController();
                        controller.initData(user, email, sanData);
                        break;
                    }
                case "CREDITANALYST":
                    {
                        break;
                    }
                case "CLIENT":
                    {
                        break;
                    }
                case "COMPLIANCEOFFICER":
                    {
                        break;
                    }
                case "GENERALMANAGER":
                    {
                        break;
                    }
                case "ITOFFICER":
                    {
                        itofficer.LogsController controller = loader.getController();
                        controller.initData(user, email, sanData);
                        break;
                    }
                case "LCOFFICER":
                    {
                        break;
                    }
                case "MERCHANT":
                    {
                        break;
                    }
                case "REPORTINGOFFICER":
                    {
                        break;
                    }
                case "SALESREPRESENTATIVE":
                    {
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
    }
    
    public void mgtClick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/" + user.toLowerCase() + "/Management.fxml"));
            Parent root = loader.load();
            
            switch (user) {
                case "ADMINISTRATOR":
                    {
                        administrator.ManagementController controller = loader.getController();
                        controller.initData(user, email, sanData);
                        break;
                    }
                case "CREDITANALYST":
                    {
                        break;
                    }
                case "CLIENT":
                    {
                        break;
                    }
                case "COMPLIANCEOFFICER":
                    {
                        break;
                    }
                case "GENERALMANAGER":
                    {
                        break;
                    }
                case "ITOFFICER":
                    {
                        break;
                    }
                case "LCOFFICER":
                    {
                        break;
                    }
                case "MERCHANT":
                    {
                        break;
                    }
                case "REPORTINGOFFICER":
                    {
                        break;
                    }
                case "SALESREPRESENTATIVE":
                    {
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
    }
    
    public void monClick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/" + user.toLowerCase() + "/Monitoring.fxml"));
            Parent root = loader.load();
            
            switch (user) {
                case "ADMINISTRATOR":
                    {
                        break;
                    }
                case "CREDITANALYST":
                    {
                        break;
                    }
                case "CLIENT":
                    {
                        break;
                    }
                case "COMPLIANCEOFFICER":
                    {
                        break;
                    }
                case "GENERALMANAGER":
                    {
                        break;
                    }
                case "ITOFFICER":
                    {
                        itofficer.MonitoringController controller = loader.getController();
                        controller.initData(user, email, sanData);
                        break;
                    }
                case "LCOFFICER":
                    {
                        break;
                    }
                case "MERCHANT":
                    {
                        break;
                    }
                case "REPORTINGOFFICER":
                    {
                        break;
                    }
                case "SALESREPRESENTATIVE":
                    {
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
    }
    
    public void bkpClick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/" + user.toLowerCase() + "/Backup.fxml"));
            Parent root = loader.load();
            
            switch (user) {
                case "ADMINISTRATOR":
                    {
                        break;
                    }
                case "CREDITANALYST":
                    {
                        break;
                    }
                case "CLIENT":
                    {
                        break;
                    }
                case "COMPLIANCEOFFICER":
                    {
                        break;
                    }
                case "GENERALMANAGER":
                    {
                        break;
                    }
                case "ITOFFICER":
                    {
                        itofficer.BackupController controller = loader.getController();
                        controller.initData(user, email, sanData);
                        break;
                    }
                case "LCOFFICER":
                    {
                        break;
                    }
                case "MERCHANT":
                    {
                        break;
                    }
                case "REPORTINGOFFICER":
                    {
                        break;
                    }
                case "SALESREPRESENTATIVE":
                    {
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
    }
    
    public void rlnClick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/" + user.toLowerCase() + "/Relationship.fxml"));
            Parent root = loader.load();
            
            switch (user) {
                case "ADMINISTRATOR":
                    {
                        break;
                    }
                case "CREDITANALYST":
                    {
                        break;
                    }
                case "CLIENT":
                    {
                        break;
                    }
                case "COMPLIANCEOFFICER":
                    {
                        break;
                    }
                case "GENERALMANAGER":
                    {
                        break;
                    }
                case "ITOFFICER":
                    {
                        break;
                    }
                case "LCOFFICER":
                    {
                        break;
                    }
                case "MERCHANT":
                    {
                        break;
                    }
                case "REPORTINGOFFICER":
                    {
                        break;
                    }
                case "SALESREPRESENTATIVE":
                    {
                        salesrepresentative.RelationshipController controller = loader.getController();
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
    }
    
    public void rptClick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/" + user.toLowerCase() + "/Reports.fxml"));
            Parent root = loader.load();
            
            switch (user) {
                case "ADMINISTRATOR":
                    {
                        break;
                    }
                case "CREDITANALYST":
                    {
                        break;
                    }
                case "CLIENT":
                    {
                        break;
                    }
                case "COMPLIANCEOFFICER":
                    {
                        break;
                    }
                case "GENERALMANAGER":
                    {
                        break;
                    }
                case "ITOFFICER":
                    {
                        break;
                    }
                case "LCOFFICER":
                    {
                        break;
                    }
                case "MERCHANT":
                    {
                        break;
                    }
                case "REPORTINGOFFICER":
                    {
                        reportingofficer.ReportsController controller = loader.getController();
                        controller.initData(user, email, sanData);
                        break;
                    }
                case "SALESREPRESENTATIVE":
                    {
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
    }
}
