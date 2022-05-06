package Main.Admin.IngredientsManager.Controller;

import Main.Entity.Element.Ingredient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class IngredientOrderController extends MasterController implements Initializable {

    @FXML
    private TableView<Ingredient> table;
    @FXML
    private TableColumn<Ingredient, String> idCol;
    @FXML
    private TableColumn<Ingredient, String> nameCol;
    @FXML
    private TableColumn<Ingredient, String> typeCol;
    @FXML
    private TableColumn<Ingredient, Integer> storageCol;
    @FXML
    private TableColumn<Ingredient, String> producerCol;
    @FXML
    private TableColumn<Ingredient, Integer> priceCol;

    private ObservableList<Ingredient> ingredientList;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ingredientList = FXCollections.observableArrayList(
                new Ingredient("1", "huyen", "caphe", 12,
                        12000, "Dalat Farm"),
                new Ingredient("2", "hau", "duong", 12,
                        12000, "Dalat Farm")
        );
        idCol.setCellValueFactory(new PropertyValueFactory<>("ingredientId"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("ingredientName"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("ingredientType"));
        storageCol.setCellValueFactory(new PropertyValueFactory<>("storage"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("incomePrice"));
        producerCol.setCellValueFactory(new PropertyValueFactory<>("producer"));
        table.setItems(ingredientList);
    }
}
