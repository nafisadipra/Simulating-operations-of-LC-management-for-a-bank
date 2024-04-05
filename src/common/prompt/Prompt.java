package common.prompt;

import javafx.scene.control.Alert;

/**
 *
 * @author Muyeed
 */
public class Prompt {
    public Alert getAlert(String message, String type) {
        
        Alert alert = new Alert(Alert.AlertType.ERROR);
        
        switch (type.toLowerCase()) {
            case "error":
                alert = new Alert(Alert.AlertType.ERROR);
                break;
            case "confirmation":
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                break;
            case "information":
                alert = new Alert(Alert.AlertType.INFORMATION);
                break;
            case "warning":
                alert = new Alert(Alert.AlertType.WARNING);
                break;
            case "none":
                alert = new Alert(Alert.AlertType.NONE);
                break;
            default:
                break;
        }
        
        alert.setTitle(type.toUpperCase());
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
        
        return alert;
    }
}
