package Main.Admin.IngredientsManager.Controller;

import Main.Entity.Element.ProductRecipe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RecipeEditController extends MasterController {
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

    public void getChosenItem(ProductRecipe pr) {
        comboBoxProductName.getSelectionModel().select(pr.getProductId());
        comboBoxIngredientName.getSelectionModel().select(pr.getIngredientId());
        productIdTxtField.setText(pr.getProductId());
        ingredientIdTxtField.setText(pr.getIngredientId());
        ingredientQtyTxtField.setText(String.valueOf(pr.getIngredientQty()));
        productQtyTxtField.setText(String.valueOf(pr.getProductQty()));

        this.pr = pr;
    }

    public void editItem(ActionEvent e) {
        pr.setProductId(productIdTxtField.getText());
        pr.setIngredientId(ingredientIdTxtField.getText());
        pr.setIngredientQty(Integer.parseInt(ingredientQtyTxtField.getText()));
        pr.setProductQty(Integer.parseInt(productQtyTxtField.getText()));
        ((Stage) ((Node)e.getSource()).getScene().getWindow()).close();
    }

    public ProductRecipe getPr() {
        return pr;
    }
}
