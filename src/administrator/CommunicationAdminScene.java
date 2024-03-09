/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package administrator;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**^
 *
 * @author Muyeed
 */

// If some one reads. It's me Muyeed.

public class CommunicationAdminScene extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CommunicationAdminFXML.fxml"));
        Parent root = loader.load();

        CommunicationAdminController controller = loader.getController();
        controller.setUser("administrator");

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
