package Main.Admin.SalaryCalculate;

import Main.Entity.DataAccess.DAO;
import com.sun.javafx.stage.EmbeddedWindow;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainSalary extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../SalaryCalculate/View/Timekeeping.fxml"));
        Scene scene = new Scene(root);
        EmbeddedWindow stage;
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
