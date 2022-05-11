package Main.Sales.Discard.ReportEndDay;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.File;

public class MainReport extends Application {
    
    public void start(Stage primaryStage){
        try {
//            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../ReportEndDay/View/ReportEndDay.fxml"));
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(new File("Sales/Discard/ReportEndDay/View/ReportEndDay.fxml").toURI().toURL());
//            Parent root = (Parent) fxmlLoader.load();
//            Scene scene = new Scene(root);
//            scene.getStylesheets().add(getClass().getResource("../ReportEndDay/View/CSS/ReportEndDay.css").toExternalForm());
//            scene.getStylesheets().add(getClass().getResource("Sales/Discard/ReportEndDay/View/CSS/ReportEndDay.css").toExternalForm());
            primaryStage.setTitle("Report");
            primaryStage.setScene(new Scene(fxmlLoader.load()));
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
