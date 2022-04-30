package Main.Admin.IngredientsManager.Controller;

import Main.Entity.Element.Employee;
import javafx.collections.FXCollections;

import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
                new Employee("EXP001","Nguyen Huu Dai",9,1,1),
                new Employee("EXP002","Huyen",8,1,1),
                new Employee("EXP003","Hau",7,1,1)
        );
        idColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("EmployeeID"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("EmployeeName"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("EmployeePhone"));
        PositionColumn.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("EmployeePosition"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("EmployeeWorkType"));
        table.setItems(EmployeeList);
    }
}
