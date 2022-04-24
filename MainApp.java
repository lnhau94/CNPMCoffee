package Main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MainApp extends Application {

    public static void main(String[] args){
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox();
        Scene sc = new Scene(root,300,300);
        root.getChildren().add(new Label("Code quài không chạy"));
        stage.setScene(sc);
        stage.show();
    }
}