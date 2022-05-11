package Main.Admin.IngredientsManager.Controller;

import Main.Entity.Element.Ingredient;
import Main.Entity.Element.ProductRecipe;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class RecipeAddController extends MasterController {

    @FXML
    private ComboBox<String> comboBoxProductName;
    @FXML
    private ComboBox<String> comboBoxIngredientName;
    @FXML
    private TextField productIdTxtField;
    @FXML
    private TextField ingredientIdTxtField;
    @FXML
    private TextField ingredientQtyTxtField;
    @FXML
    private TextField productQtyTxtField;

    private ProductRecipe pr;



    public void setComboBox(ObservableList<String> productName, ObservableList<String> ingredientName) {
        this.comboBoxProductName.setItems(productName);
        this.comboBoxIngredientName.setItems(ingredientName);
    }




    public void addNewIngredient(ActionEvent e) {
//        pr = new ProductRecipe("CF002", "BH01", 12, 12);
        pr = new ProductRecipe(
                productIdTxtField.getText(),
                ingredientIdTxtField.getText(),
                Integer.parseInt(ingredientQtyTxtField.getText()),
                Integer.parseInt(productQtyTxtField.getText())
        );
        ((Stage) ((Node)e.getSource()).getScene().getWindow()).close();
    }

    public ProductRecipe getPr() {
        return pr;
    }


}
