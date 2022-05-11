package Main.Sales.Discard.ReportEndDay.Control;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

public class SceneController {
    public Stage stage;
    public Scene scene;
    public Parent root;

    public void screenReportEndDay(ActionEvent event) throws IOException {
        root = FXMLLoader.load((getClass().getResource("../ReportEndDay/View/ReportEndDay.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../ReportEndDay/View/CSS/ReportEndDay.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void screenReportCancelEndDay(ActionEvent event) throws IOException {
        root = FXMLLoader.load((getClass().getResource("../ReportEndDay/View/ReportCancelEndDay.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../ReportEndDay/View/CSS/ReportCancelEndDay.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
