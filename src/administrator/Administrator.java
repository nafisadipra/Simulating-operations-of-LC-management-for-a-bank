package administrator;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**^
 *
 * @author Muyeed^
 */

// If some one reads. It's me Muyeed.
public class Administrator extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DashboardFXML.fxml"));
        Parent root = loader.load();
        
        DashboardController controller = loader.getController();
        String[] sanData = {"Dashboard", "Message", "Notification", "Access Logs", "User Management", "Settings"};
        controller.initData("Administrator", "m@g.com", sanData);
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        
        stage.setTitle("Administrator");
        stage.show();
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
