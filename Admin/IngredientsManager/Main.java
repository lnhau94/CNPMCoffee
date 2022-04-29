package Main.Admin.IngredientsManager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../IngredientsManager/View/Admin.Employee.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../IngredientsManager/View/Css/Application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}