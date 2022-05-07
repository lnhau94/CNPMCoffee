package Main.Admin.IngredientsManager.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class ScreenTranfer {

    private static final HashMap<String, String> url = new HashMap<>() {
        {
            put("incomeCfmBtn", "Admin/IngredientsManager/View/ConfirmOrder.fxml");
            put("orderListBtn", "Admin/IngredientsManager/View/OrderList.fxml");
            put("newOrderBtn", "Admin/IngredientsManager/View/CreateIngredientOrder.fxml");
            put("backWarehouseBtn", "Admin/IngredientsManager/View/IngredientOrder.fxml");
            put("cfmDetailBtn", "Admin/IngredientsManager/View/ConfirmDetail.fxml");
            put("orderDetailBtn", "Admin/IngredientsManager/View/OrderDetail.fxml");
            put("frmIngredientOrder", "Admin/IngredientsManager/View/FormIngredientOrder.fxml");
            put("backAdminBtn", "Admin/DataManager/View/Admin.fxml");
            put("addIngredientBtn", "Admin/IngredientsManager/View/IngredientAdd.fxml");
            put("editIngredientBtn", "Admin/IngredientsManager/View/IngredientEdit.fxml");
            put("removeIngredientBtn", "Admin/IngredientsManager/View/IngredientDelete.fxml");
        }
    };

    private static Scene getScene(Button btn) {
        File file = new File(url.get(btn.getId()));
        try {
            return new Scene(FXMLLoader.load(file.toURI().toURL()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void switchScene(ActionEvent e){
        ((Stage) ((Node)e.getSource()).getScene().getWindow()).setScene(getScene((Button) e.getSource()));
    }


}
