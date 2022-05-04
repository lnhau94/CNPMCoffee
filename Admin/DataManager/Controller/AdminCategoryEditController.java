package Main.Admin.DataManager.Controller;

import Main.Entity.Element.Category;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AdminCategoryEditController {
    @FXML
    private TextField textName;

    public void handleEvent(Category selected){
        if(selected==null){
            System.out.println("Chưa cilck vào đối tượng");
        }else{
            textName.setText(selected.getCategoryName());
        }
    }
}
