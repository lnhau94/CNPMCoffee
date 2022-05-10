package Main.Admin.IngredientsManager.Controller;

import Main.Entity.Element.Ingredient;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RecipeController extends MasterController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

//    public void openAddStage(ActionEvent e) {
//        Stage stage = new Stage();
//        stage.initModality(Modality.APPLICATION_MODAL);
//        stage.initOwner(((Node)e.getSource()).getScene().getWindow());
//        File file = new File("Admin/IngredientsManager/View/IngredientAdd.fxml");
//
//        FXMLLoader fx = new FXMLLoader();
//        IngredientAddController controller;
//        try {
//            fx.setLocation(file.toURI().toURL());
//            stage.setScene(new Scene(fx.load()));
//            controller = fx.getController();
//        } catch (IOException ex) {
//            throw new RuntimeException(ex);
//        }
//        stage.showAndWait();
//
//        this.model.addNewItem(controller.getI());
//    }
//
//    public void openEditStage(ActionEvent e) {
//        Stage stage = new Stage();
//        stage.initModality(Modality.APPLICATION_MODAL);
//        stage.initOwner(((Node)e.getSource()).getScene().getWindow());
//
//        Ingredient i = table.getSelectionModel().getSelectedItem();
//
//        File file;
//        FXMLLoader fx = new FXMLLoader();
//
//        if(i != null) {
//            file = new File("Admin/IngredientsManager/View/IngredientEdit.fxml");
//            IngredientEditController controller;
//            try {
//                fx.setLocation(file.toURI().toURL());
//                stage.setScene(new Scene(fx.load()));
//                controller = fx.getController();
//                controller.getChosenItem(i);
//                stage.showAndWait();
//                this.model.updateItem(table.getSelectionModel().getSelectedIndex(), controller.getI());
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        } else {
//            file = new File("Admin/DataManager/View/Alert.fxml");
//            try {
//                fx.setLocation(file.toURI().toURL());
//                stage.setScene(new Scene(fx.load()));
//                stage.showAndWait();
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        }
//    }
//
//    public void openRemoveStage(ActionEvent e) {
//        Stage stage = new Stage();
//        stage.initModality(Modality.APPLICATION_MODAL);
//        stage.initOwner(((Node)e.getSource()).getScene().getWindow());
//        Ingredient i = table.getSelectionModel().getSelectedItem();
//        File file;
//        FXMLLoader fx = new FXMLLoader();
//        if(i != null) {
//            file = new File("Admin/IngredientsManager/View/IngredientDelete.fxml");
//            IngredientDeleteController controller;
//            try {
//                fx.setLocation(file.toURI().toURL());
//                stage.setScene(new Scene(fx.load()));
//                controller = fx.getController();
//                stage.showAndWait();
//                if(controller.isRemove()) {
//                    this.model.removeItem(i);
//                }
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//
//        } else {
//            file = new File("Admin/DataManager/View/Alert.fxml");
//            try {
//                fx.setLocation(file.toURI().toURL());
//                stage.setScene(new Scene(fx.load()));
//                stage.showAndWait();
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        }
//
//    }
}
