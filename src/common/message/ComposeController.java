package common.message;

import common.notification.NotificationController;
import common.number.RandomNumber;
import common.prompt.Prompt;
import common.reader.Reader;
import common.sandwich.Sandwich;
import common.switcher.GUI;
import common.writer.Writer;
import common.xdir.XDIR;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import static javafx.scene.paint.Color.color;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author Muyeed
 */
public class ComposeController implements Initializable {

    @FXML
    private AnchorPane paneSide;
    @FXML
    private TextArea areaSend;
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
    private TextField fieldSub;
    @FXML
    private TextField fieldTo;

    private String user;
    private String email;
    private String[] sanData;
    private String recieverX;
    private String subjectX;
    private ArrayList<Message> mesList;
    private Message message;
    private String attachment = "null";
    private String path = "null";
    private long random;

    @FXML
    private Circle mdot;
    @FXML
    private Circle ndot;
    @FXML
    private Label labFile;

    // pipeline
    public void initData(String user, String email, String[] sanData, String recieverX, String subjectX) {
        // append
        this.user = user;
        this.email = email;
        this.sanData = sanData;
        this.recieverX = recieverX;
        this.subjectX = subjectX;

        // Generate Random
        this.random = new RandomNumber(8).generate();

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
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(new File("Database/User/" + user + "/" + email + "/user.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image fxImage = SwingFXUtils.toFXImage(bufferedImage, null);
        imageUser.setImage(fxImage);

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
        
        // passed
        fieldTo.setText(recieverX);
        fieldSub.setText(subjectX);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void backMessage(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MessageFXML.fxml"));
            Parent root = loader.load();

            MessageController controller = loader.getController();
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

            NotificationController controller = loader.getController();
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MessageFXML.fxml"));
            Parent root = loader.load();

            MessageController controller = loader.getController();
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/" + user.toLowerCase() + "/Dashboard.fxml"));
            Parent root = loader.load();

            switch (user) {
                case "ADMINISTRATOR": {
                    administrator.DashboardController controller = loader.getController();
                    controller.initData(user, email, sanData);
                    break;
                }
                case "CREDITANALYST": {
                    creditanalyst.DashboardController controller = loader.getController();
                    controller.initData(user, email, sanData);
                    break;
                }
                case "CLIENT": {
                    client.DashboardController controller = loader.getController();
                    controller.initData(user, email, sanData);
                    break;
                }
                case "COMPLIANCEOFFICER": {
                    complianceofficer.DashboardController controller = loader.getController();
                    controller.initData(user, email, sanData);
                    break;
                }
                case "GENERALMANAGER": {
                    generalmanager.DashboardController controller = loader.getController();
                    controller.initData(user, email, sanData);
                    break;
                }
                case "ITOFFICER": {
                    itofficer.DashboardController controller = loader.getController();
                    controller.initData(user, email, sanData);
                    break;
                }
                case "LCOFFICER": {
                    lcofficer.DashboardController controller = loader.getController();
                    controller.initData(user, email, sanData);
                    break;
                }
                case "MERCHANT": {
                    merchant.DashboardController controller = loader.getController();
                    controller.initData(user, email, sanData);
                    break;
                }
                case "REPORTINGOFFICER": {
                    reportingofficer.DashboardController controller = loader.getController();
                    controller.initData(user, email, sanData);
                    break;
                }
                case "SALESREPRESENTATIVE": {
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

    @FXML
    private void sendClick(MouseEvent event) {
        String mail = "";
        boolean foundAtSymbol = false;
        String emailText = fieldTo.getText();

        for (int i = 0; i < emailText.length(); i++) {
            if (emailText.charAt(i) == '@') {
                foundAtSymbol = true;
                continue;
            }

            if (foundAtSymbol) {
                mail += emailText.charAt(i);
            }
        }

        String userText = "";

        // user switch
        switch (mail) {
            case "lc.admin.com":
                userText = "ADMINISTRATOR";
                break;
            case "lc.it.com":
                userText = "ITOFFICER";
                break;
            case "lc.cli.com":
                userText = "CLIENT";
                break;
            case "lc.mrc.com":
                userText = "MERCHANT";
                break;
            case "lc.gm.com":
                userText = "GENERALMANAGER";
                break;
            case "lc.cr.com":
                userText = "CREDITANALYST";
                break;
            case "lc.of.com":
                userText = "LCOFFICER";
                break;
            case "lc.sr.com":
                userText = "SALESREPRESENTATIVE";
                break;
            case "lc.co.com":
                userText = "COMPLIANCEOFFICER";
                break;
            case "lc.ro.com":
                userText = "REPORTINGOFFICER";
                break;
            default:
                break;
        }

        String location = "Database/User/" + userText + "/" + emailText;
        Path destinationPath = Paths.get(location);

        if (Files.exists(destinationPath)) {
            LocalTime currentTime = LocalTime.now();
            DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("hh:mm a");

            LocalDate currentDate = LocalDate.now();
            DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            String fileName = "";

            if (attachment.equals("null")) {
                fileName += "null";
            } else {
                fileName += (random + "_" + attachment);
            }

            String subject = fieldSub.getText();

            if (subject.isEmpty()) {
                subject = "(No Subject)";
            }

            String mesData = areaSend.getText().replaceAll("\\n", "\\\\n") + "▓" + email + "▓"
                    + currentTime.format(formatTime) + "▓" + currentDate.format(formatDate) + "▓" + subject + "▓"
                    + fileName + "▓" + "0";
            new Writer(location, "message.bin", mesData).overWriteFile();
            new Writer("Database/User/" + user + "/" + email, "outbox.bin", mesData).overWriteFile();

            String notData = ("You recieved a message from " + email) + "▓" + "Message" + "▓"
                    + currentTime.format(formatTime) + "▓" + currentDate.format(formatDate);
            new Writer(location, "notification.bin", notData).overWriteFile();

            if (!path.equals("null")) {
                new XDIR(path, location + "/Attachments/" + fileName).copyFile();
                new XDIR(path, "Database/User/" + user + "/" + email + "/Attachments/" + fileName).copyFile();
                ;
            }
            
            (new Prompt()).getAlert("Email sent!", "information");
            mailClick(event);

        } else {
            (new Prompt()).getAlert("Invalid email!", "error");
        }
    }

    @FXML
    private void fileClick(MouseEvent event) {
        this.attachment = "null";
        this.path = "null";
        labFile.setVisible(false);

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");

        File selectedFile = fileChooser.showOpenDialog(((Node) event.getSource()).getScene().getWindow());

        if (selectedFile != null) {
            labFile.setText(selectedFile.getName() + " is attached");
            this.attachment = selectedFile.getName();
            this.path = selectedFile.getPath();
            labFile.setVisible(true);
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

}
