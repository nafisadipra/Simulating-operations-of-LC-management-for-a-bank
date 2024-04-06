/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package itofficer;

import common.device.Force;
import common.prompt.Prompt;
import common.zipper.Decompress;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class RecoveryController implements Initializable {

    @FXML
    private TextField enR;
    @FXML
    private Button rButt;
    @FXML
    private TextArea areaLog;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void restoreClick(MouseEvent event) {
        (new Force()).deleteFolder("Database");
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut((new PrintStream(baos)));
        
        if (!enR.getText().isEmpty()) {
            if ((new Prompt()).getAlert("Warning: previous data will be erased!\nAre you sure?", "confirmation").getResult().getText().equals("Cancel")) {
                return;
            }
            if (new Decompress().run(enR.getText()) == true) {
                String myData = "LC Bank Console v1.2.7 @Author Muyeed\n";
                areaLog.setText(myData + baos.toString());
                (new Prompt()).getAlert("Restore was successful!", "information");
            } else {
                (new Prompt()).getAlert("Error while restoring!", "warning");
            }
            
        } else {
            (new Prompt()).getAlert("Please select Database.zip!", "error");
        }
    }

    @FXML
    private void rClick(MouseEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Backup File");

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("ZIP files (*.zip)", "*.zip");
        fileChooser.getExtensionFilters().add(extFilter);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            enR.setText(selectedFile.getAbsolutePath());
        }
    }
    
}
