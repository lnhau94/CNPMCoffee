package Main.Helpers.SignIn;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;

public class SignIn {

    @FXML
    private Label header;

    @FXML
    private TextField userTxf;

    @FXML
    private PasswordField passTxf;

    @FXML
    void checkSignIn(ActionEvent event) {
        String user = userTxf.getText();
        String pass = passTxf.getText();
        user = user.trim();
        pass = pass.trim();
        if(user.equals("")||pass.equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Username and Password are required!!!");
            try {
                FXMLLoader fx = new FXMLLoader(new File("Helpers/SignIn/Alert.fxml").toURI().toURL());

                DialogPane dialogPane =  fx.load();;
                AlertController alertController = fx.getController();
                alertController.setMessage("Username and Password are required!!!");
                alertController.setWarningType("Invalid Input!!!");
                alert.setDialogPane(dialogPane);
                alert.initStyle(StageStyle.TRANSPARENT);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            alert.show();
        }else{
            System.out.println("sign");
        }
    }

    @FXML
    void clearContent(ActionEvent event) {
        userTxf.setText("");
        passTxf.setText("");
    }

}
