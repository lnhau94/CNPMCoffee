package Main.Admin.IngredientsManager;

import Main.Admin.IngredientsManager.Controller.IngredientOrderController;
import Main.Admin.IngredientsManager.Model.IngredientApplicationModel;
import Main.Entity.Element.Ingredient;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class MainIngredient extends Application {
    @Override
    public void start(Stage stage) {
        FXMLLoader fx = new FXMLLoader();
        Parent root = null;
        try {
            fx.setLocation(new File("Admin/IngredientsManager/View/IngredientOrder.fxml").toURI().toURL());
            root = fx.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        stage.setScene(new Scene(root));
        stage.show();
//        stage.initModality(Modality.APPLICATION_MODAL);
//        stage.setScene(new Scene(new Label("Demo")));
//        stage.show();

//        Stage inner = new Stage(){{setScene(new Scene(new Label("Inner"))); }};
        //inner.show(); // Try replacing with showAndWait
//        inner.showAndWait();
//        System.out.println("Done");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
