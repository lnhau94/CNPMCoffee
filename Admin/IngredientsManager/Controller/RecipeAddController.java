package Main.Admin.IngredientsManager.Controller;

import Main.Admin.IngredientsManager.Model.RecipesModel;
import Main.Entity.Element.ProductRecipe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class RecipeAddController extends MasterController implements Initializable{

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
    private RecipesModel model;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        model = MasterController.recipesModel;
        this.comboBoxProductName.setItems(model.getProductNameList());
        this.comboBoxIngredientName.setItems(model.getIngredientNameList());
    }

    public void modifyProductId(ActionEvent e) {
        int index = comboBoxProductName.getSelectionModel().getSelectedIndex();
        productIdTxtField.setText(this.model.getProductIdList().get(index));
    }

    public void modifyIngredientId(ActionEvent e) {
        int index = comboBoxIngredientName.getSelectionModel().getSelectedIndex();
        ingredientIdTxtField.setText(this.model.getIngredientIdList().get(index));
    }

    public void addNewIngredient(ActionEvent e) {
        if(productIdTxtField.getText() == "" || ingredientIdTxtField.getText() == "" ||
                ingredientQtyTxtField.getText() == "" || productQtyTxtField.getText() == "") {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Input");
            alert.showAndWait();
        } else {
            pr = new ProductRecipe(
                    productIdTxtField.getText(),
                    ingredientIdTxtField.getText(),
                    Integer.parseInt(ingredientQtyTxtField.getText()),
                    Integer.parseInt(productQtyTxtField.getText())
            );
            ((Stage) ((Node)e.getSource()).getScene().getWindow()).close();
        }
    }

    public ProductRecipe getPr() {
        return pr;
    }

    public void setPr(ProductRecipe pr) {
        this.pr = pr;
    }
}
