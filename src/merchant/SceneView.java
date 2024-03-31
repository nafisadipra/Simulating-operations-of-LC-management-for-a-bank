package merchant;

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
public class SceneView extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
        Parent root = loader.load();
        
        merchant.Dashboard controller = loader.getController();
        String[] sanData = {"Dashboard", "Contact", "Notification", "Merchandise", "Advertising", "Requests", "Transaction", "Invoice", "Switch Account", "Settings", "Policy", "Feedback"};
        controller.initData("MERCHANT", "fuad@lc.mrc.com", sanData);
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        
        stage.setTitle("LC Bank Portal");
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
