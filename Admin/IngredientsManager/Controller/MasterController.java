package Main.Admin.IngredientsManager.Controller;

import Main.Admin.IngredientsManager.Model.IngredientApplicationModel;
import javafx.event.ActionEvent;
import javafx.stage.Window;

public class MasterController {

    public static ScreenTranfer screenTranfer;

    public static IngredientApplicationModel model;

    public void changeScene(ActionEvent e){
        screenTranfer.switchScene(e);
    }

    public static void start() {
        MasterController.model = new IngredientApplicationModel();
        MasterController.screenTranfer = new ScreenTranfer();
    }


}
