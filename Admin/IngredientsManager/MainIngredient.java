package Main.Admin.IngredientsManager;

import Main.Admin.IngredientsManager.Controller.IngredientOrderController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        IngredientOrderController controller = fx.getController();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
