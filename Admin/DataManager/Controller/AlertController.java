package Main.Admin.DataManager.Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;

public class AlertController {
    public void AlertSQL(URL url) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("../View/AlertSQL.fxml"));
        Pane ProductAddViewParent = loader.load();
        javafx.scene.control.Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setDialogPane((DialogPane) ProductAddViewParent);
        Optional<ButtonType> ClickedButton = dialog.showAndWait();
        if(ClickedButton.get()==ButtonType.APPLY) {
            dialog.close();
        }
    }
    public void  AlertSuccess(){

    }
    public  void  AlertFailed(){

    }
}
