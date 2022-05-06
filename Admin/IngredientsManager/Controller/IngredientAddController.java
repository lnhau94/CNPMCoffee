package Main.Admin.IngredientsManager.Controller;

import Main.Entity.Element.Ingredient;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class IngredientAddController extends MasterController{

    @FXML
    private TextField nameTxtField;
    @FXML
    private TextField typeTxtField;
    @FXML
    private TextField priceTxtField;
    @FXML
    private TextField producerTxtField;

    public void addNewIngredient() {
        Ingredient newIngredient = new Ingredient(nameTxtField.getText(), typeTxtField.getText(),
                Integer.parseInt(priceTxtField.getText()), producerTxtField.getText());
    }


}
