package Main.Sales.Discard.ReportEndDay;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class MainReport extends Application {
    
    public void start(Stage primaryStage){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../ReportEndDay/View/ReportEndDay.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("../ReportEndDay/View/CSS/ReportEndDay.css").toExternalForm());
            primaryStage.setTitle("Report");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Lỗi hệ thống !");
            alert.showAndWait();
        }
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
