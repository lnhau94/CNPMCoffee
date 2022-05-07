package Main.Admin.IngredientsManager.Controller;

import Main.Entity.Element.Ingredient;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;

public class IngredientEditController extends MasterController {
    @FXML
    private TextField nameTxtField;
    @FXML
    private TextField typeTxtField;
    @FXML
    private TextField priceTxtField;
    @FXML
    private TextField producerTxtField;

    private Ingredient i;

    public void getChosenItem(Ingredient i) {
        nameTxtField.setText(i.getIngredientName());
        typeTxtField.setText(i.getIngredientType());
        priceTxtField.setText(String.valueOf(i.getIncomePrice()));
        producerTxtField.setText(i.getProducer());
    }

    public void editItem(ActionEvent e) {

    }
}
