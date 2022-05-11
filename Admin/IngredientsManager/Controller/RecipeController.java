package Main.Admin.IngredientsManager.Controller;

import Main.Admin.IngredientsManager.Model.RecipesModel;
import Main.Entity.DataAccess.DAO;
import Main.Entity.Element.Product;
import Main.Entity.Element.ProductRecipe;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RecipeController extends MasterController implements Initializable {

    @FXML
    private ComboBox<String> comboBoxProductName;
    @FXML
    private Label result;
    @FXML
    private TableView<ProductRecipe> table;
    @FXML
    private TableColumn<ProductRecipe, String> productIdCol;
    @FXML
    private TableColumn<ProductRecipe, String> productNameCol;
    @FXML
    private TableColumn<ProductRecipe, String> ingredientIdCol;
    @FXML
    private TableColumn<ProductRecipe, String> ingredientNameCol;
    @FXML
    private TableColumn<ProductRecipe, Integer> ingredientQtyCol;
    private RecipesModel model;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        model = MasterController.recipesModel;

//        Arrange Combo-box list of product name
        this.comboBoxProductName.setItems(this.model.getProductNameList());

        productIdCol.setCellValueFactory(new PropertyValueFactory<ProductRecipe, String>("productId"));
//        productNameCol.setCellValueFactory(new PropertyValueFactory<ProductRecipe, String>(""));
        productNameCol.setCellValueFactory(data -> new SimpleStringProperty(((new DAO() {
            String findName(){
                for(Product p : getAllProduct()) {
                    if(p.getProductId().equalsIgnoreCase(data.getValue().getProductId())) {
                        return p.getProductName();
                    }
                }
                return null;
            }
        }).findName())));
        ingredientIdCol.setCellValueFactory(new PropertyValueFactory<ProductRecipe, String>("ingredientId"));
//        ingredientNameCol.setCellValueFactory(new PropertyValueFactory<>());
        ingredientQtyCol.setCellValueFactory(new PropertyValueFactory<ProductRecipe, Integer>("ingredientQty"));
//        String str = String.valueOf(new PropertyValueFactory<ProductRecipe, Ingredient>("productQty"));
        String str = "12";
        result.setText(str);

        this.table.setItems(this.model.getRecipesListRecipes());

    }

    public void openAddStage(ActionEvent e) {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(((Node)e.getSource()).getScene().getWindow());
        File file = new File("Admin/IngredientsManager/View/RecipeAdd.fxml");

        FXMLLoader fx = new FXMLLoader();
        RecipeAddController controller;
        try {
            fx.setLocation(file.toURI().toURL());
            stage.setScene(new Scene(fx.load()));
            controller = fx.getController();
            controller.setComboBox(this.model.getProductNameList(), this.model.getIngredientNameList());
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        stage.showAndWait();

        this.model.addNewItem(controller.getPr());
    }

    public void openEditStage(ActionEvent e) {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(((Node)e.getSource()).getScene().getWindow());

        ProductRecipe pr = table.getSelectionModel().getSelectedItem();

        File file;
        FXMLLoader fx = new FXMLLoader();

        if(pr != null) {
            file = new File("Admin/IngredientsManager/View/RecipeEdit.fxml");
            RecipeEditController controller;
            try {
                fx.setLocation(file.toURI().toURL());
                stage.setScene(new Scene(fx.load()));
                controller = fx.getController();
                controller.getChosenItem(pr);
                stage.showAndWait();
                this.model.updateItem(table.getSelectionModel().getSelectedIndex(), controller.getPr());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } else {
            file = new File("Admin/DataManager/View/Alert.fxml");
            try {
                fx.setLocation(file.toURI().toURL());
                stage.setScene(new Scene(fx.load()));
                stage.showAndWait();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void openRemoveStage(ActionEvent e) {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(((Node)e.getSource()).getScene().getWindow());
        ProductRecipe rp = table.getSelectionModel().getSelectedItem();
        File file;
        FXMLLoader fx = new FXMLLoader();
        if(rp != null) {
            file = new File("Admin/IngredientsManager/View/DeleteItemView.fxml");
            DeleteItemController controller;
            try {
                fx.setLocation(file.toURI().toURL());
                stage.setScene(new Scene(fx.load()));
                controller = fx.getController();
                stage.showAndWait();
                if(controller.isRemove()) {
                    this.model.removeItem(rp);
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        } else {
            file = new File("Admin/DataManager/View/Alert.fxml");
            try {
                fx.setLocation(file.toURI().toURL());
                stage.setScene(new Scene(fx.load()));
                stage.showAndWait();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

    }
}