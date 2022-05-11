package Main.Admin.DataManager.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;

public class AdminAccountController {
    public void changeSceneAddEvent(ActionEvent e) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("../View/Admin.Account.Add.fxml"));
        Pane EmployeeAddViewParent = loader.load();
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setDialogPane((DialogPane) EmployeeAddViewParent);
        dialog.show();
    }
    public void changeSceneEditEvent(ActionEvent e)throws  IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("../View/Admin.Account.Edit.fxml"));
        Pane EmployeeAddViewParentEdit = loader.load();
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setDialogPane((DialogPane) EmployeeAddViewParentEdit);
        dialog.show();
    }
    public void changeSceneDeleteEvent(ActionEvent e)throws IOException {
        Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("../View/Admin.Delete.fxml"));
        Pane CategoryDeleteParentView = loader.load();
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setDialogPane((DialogPane)  CategoryDeleteParentView);
        dialog.show();
    }
    public void GoBack(ActionEvent e) throws IOException {
        Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(this.getClass().getResource("../CNPMCoffee/Admin/IngredientsManager/View/Admin.Employee.fxml"));
        Parent AdminViewParent = FXMLLoader.load(getClass().getResource("../View/Admin.fxml"));
        Scene scene = new Scene(AdminViewParent);
        stage.setScene(scene);
    }
}
