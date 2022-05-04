package Main.Admin.DataManager.Controller;

import Main.Entity.Element.Category;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AdminAccountEditController {
    @FXML
    private TextField textName;

    public void handleEvent(Category selected){

            textName.setText(selected.getCategoryName());

    }
}
