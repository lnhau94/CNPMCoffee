package Main.Admin.DataManager.Controller;

import Main.Entity.Element.Employee;
import javafx.collections.FXCollections;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminEmployeeController implements Initializable {
    @FXML
    TableView<Employee> table;
    @FXML
    private TableColumn<Employee, String> idColumn;
    @FXML
    private TableColumn<Employee, String> nameColumn;
    @FXML
    private TableColumn<Employee, Integer> phoneColumn;
    @FXML
    private TableColumn<Employee, Integer> PositionColumn;
    @FXML
    private TableColumn<Employee, Integer> typeColumn;
    private ObservableList<Employee> EmployeeList;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        EmployeeList = FXCollections.observableArrayList(
                new Employee("EXP001","Nguyen Huu Dai","9","1","1"),
                new Employee("EXP002","Huyen","8","1","1"),
                new Employee("EXP003","Hau","7","1","1")
        );
        idColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("EmployeeID"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("EmployeeName"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("EmployeePhone"));
        PositionColumn.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("EmployeePosition"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("EmployeeWorkType"));
        table.setItems(EmployeeList);
    }
    public void changeSceneAddEnvent(ActionEvent e) throws IOException{
        Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(this.getClass().getResource("../CNPMCoffee/Admin/IngredientsManager/View/Admin.Employee.fxml"));
        Parent EmployeeAddViewParent = FXMLLoader.load(getClass().getResource("../View/Admin.Employee.Add.fxml"));
        Scene scene = new Scene(EmployeeAddViewParent);
        stage.setScene(scene);
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
