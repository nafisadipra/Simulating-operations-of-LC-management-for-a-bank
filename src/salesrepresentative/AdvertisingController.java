package salesrepresentative;

import common.advertisement.Advertisement;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Muyeed
 */
public class AdvertisingController implements Initializable {

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
    private TableView<Advertisement> table;
    @FXML
    private ComboBox<String> prodCom;
    @FXML
    private TableColumn<Advertisement, String> tprod;
    @FXML
    private TableColumn<Advertisement, String> tbrief;
    @FXML
    private TableColumn<Advertisement, String> tstatus;
    @FXML
    private ComboBox<String> filterComb;
    @FXML
    private Button createID1;
    @FXML
    private Button reqClick;
    @FXML
    private TextArea areaBrief;

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

        // product
        String[] filterList = { "All", "Accepted", "Pending", "Rejected" };
        filterComb.getItems().setAll(filterList);
        filterComb.setValue(filterList[0]);
        
        ArrayList<ArrayList<String>>productFetch = (new Reader("Database/User/MERCHANT/" + email, "product.bin")).splitFile('▓');
        ArrayList<String> productList = new ArrayList();
        
        for (ArrayList<String> Y : productFetch) {
            productList.add(Y.get(1) + " - " + Y.get(0));

        }
        
        prodCom.getItems().setAll(productList);
    
        // advertisement
        getAdv();
        
    }
    
    private void getAdv(){
        ArrayList<Advertisement> advList = new ArrayList();
        ArrayList<ArrayList<String>> advFetch = (new Reader("Database/Official/ADVERTISEMENT", "advertisement.bin")).splitFile('▓');

        for(ArrayList<String> Y : advFetch){
            if (filterComb.getValue().equals("All") && Y.get(3).equals(email)) {
                advList.add(new Advertisement(Y.get(0), Y.get(1), Y.get(2), Y.get(3)));
            } else {
                if (Y.get(2).equals(filterComb.getValue()) && Y.get(3).equals(email)) {
                    advList.add(new Advertisement(Y.get(0), Y.get(1), Y.get(2), Y.get(3)));
                }
            }
        }

        tprod.setCellValueFactory(new PropertyValueFactory("product"));
        tbrief.setCellValueFactory(new PropertyValueFactory("brief"));
        tstatus.setCellValueFactory(new PropertyValueFactory("status"));
        table.getItems().setAll(advList);
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

    private void dashClick(MouseEvent event) {

    }

    private void feedClick(MouseEvent event) {

    }

    private void settClick(MouseEvent event) {

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
    private void userCLick(MouseEvent event) {
    }

    @FXML
    private void filterClick(MouseEvent event) {
        table.getItems().clear();
        getAdv();
    }

    @FXML
    private void reqClick(MouseEvent event) {
        if (prodCom.getValue() == null || prodCom.getValue().equals("Select") || areaBrief.getText() == null || areaBrief.getText().isEmpty()) {
            (new Prompt()).getAlert("Please fill in all fields!", "error");
            return;
        }

        if ((new Prompt()).getAlert("Are you sure?", "confirmation").getResult().getText().equals("Cancel")) {
            return;
        }

        String advD = prodCom.getValue() + "▓" + areaBrief.getText() + "▓" + "Pending" + "▓" + email + "▓";
        new Writer("Database/Official/ADVERTISEMENT", "advertisement.bin", advD).overWriteFile();
        (new GUI(user, email, sanData)).advClick(event);
    }

}
