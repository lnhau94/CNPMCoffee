package Main.Admin.IngredientsManager.Controller;

import Main.Entity.Element.Ingredient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



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
        this.i = i;
    }

    public void editItem(ActionEvent e) {
        i.setIngredientName(nameTxtField.getText());
        i.setIngredientType(typeTxtField.getText());
        i.setIncomePrice(Integer.parseInt(priceTxtField.getText()));
        i.setProducer(producerTxtField.getText());
        ((Stage) ((Node)e.getSource()).getScene().getWindow()).close();
    }

    public Ingredient getI() {
        return i;
    }
}
