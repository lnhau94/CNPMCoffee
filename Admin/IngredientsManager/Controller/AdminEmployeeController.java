package Main.Admin.IngredientsManager.Controller;

import Main.Entity.Element.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.text.TabableView;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminEmployeeController implements Initializable {
    @FXML
    private TableView<Employee> tableView;
    @FXML
    private TableColumn<Employee, String> idColumn;
    @FXML
    private TableColumn<Employee, String> nameColumn;
    @FXML
    private TableColumn<Employee, Integer> phoneColumn;
    @FXML
    private TableColumn<Employee, Integer> positionColumn;
    @FXML
    private TableColumn<Employee, Integer> workTypeColumn;
    @FXML
    private TableColumn<Employee, Button> buttonColumn;

    private ObservableList<Employee> EmployeeList;

    public AdminEmployeeController() {
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        EmployeeList = FXCollections.observableArrayList(
                new Employee("EXP001","Nguyen Huu Dai",123456,5487894,1254),
                new Employee("EXP002","Nguyen Huu Dai",123456,5487894,1254),
                new Employee("EXP003","Nguyen Huu Dai",123456,5487894,1254)
        );
        idColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("ID"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("Name"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("Phone"));
        positionColumn.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("Positon"));
        workTypeColumn.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("WorkType"));
        tableView.setItems(EmployeeList);

    }
}
