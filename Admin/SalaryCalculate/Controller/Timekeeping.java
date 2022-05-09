package Main.Admin.SalaryCalculate.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Timekeeping {
    public void changeSceneTimekeeping(ActionEvent e) throws IOException {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(this.getClass().getResource("../CNPMCoffee/Admin/SalaryCalculate/View/Salarytable.fxml"));
        Parent EmployeeViewParent = FXMLLoader.load(getClass().getResource("../View/Timekeeping.fxml"));
        Scene scene = new Scene(EmployeeViewParent);
        stage.setScene(scene);
    }

    public void changeSceneSalarytable(ActionEvent e) throws IOException {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../View/Salarytable.fxml"));
        Parent ProductViewParent = loader.load();
        Scene scene = new Scene(ProductViewParent);
        stage.setScene(scene);
    }
}
