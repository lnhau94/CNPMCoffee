package Main.Admin.DataManager.Controller;


import Main.Entity.DataAccess.DAO;
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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class AdminEmployeeController implements Initializable {
    @FXML
    TableView<Employee> table;
    @FXML
    private TableColumn<Employee, String> idColumn;
    @FXML
    private TableColumn<Employee, String> nameColumn;
    @FXML
    private TableColumn<Employee, String> phoneColumn;
    @FXML
    private TableColumn<Employee, String> PositionColumn;
    @FXML
    private TableColumn<Employee, String> typeColumn;
   public static List<Employee> EmployeeTempList = new ArrayList<>();
    private ObservableList<Employee> EmployeeList;
    public void getDataEmplyee() throws SQLException {
        DAO dao = new DAO();
        ResultSet rs = dao.executeQuery("SELECT * FROM Employee");
        while (rs.next()){
            String EmployeeId = rs.getString(2);
            String EmployeeName= rs.getString(3);
            String EmployeePhone = rs.getString(4);
            String EmployeePosition = rs.getString(5);
            String EmployeeWorkType = rs.getString(6);
            Employee employee = new Employee(EmployeeId,EmployeeName,EmployeePhone,EmployeePosition,EmployeeWorkType);
            EmployeeTempList.add(employee);
        }
    }
    @Override

    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            getDataEmplyee();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        EmployeeList = FXCollections.observableArrayList(EmployeeTempList);
        idColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("employeeID"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("employeeName"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("employeePhone"));
        PositionColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("position"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("type"));
        table.setItems(EmployeeList);
    }
    public void changeSceneAddEvent(ActionEvent e) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("../View/Admin.Employee.Add.fxml"));
        Pane EmployeeAddViewParent = loader.load();
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setDialogPane((DialogPane) EmployeeAddViewParent);
        Optional<ButtonType> ClickedButton = dialog.showAndWait();
        AdminEmployeeAddController adminEmployeeAddController = loader.getController();
        if(ClickedButton.get()== ButtonType.APPLY){
            adminEmployeeAddController.AddEmployee();
            table.setItems(FXCollections.observableArrayList(EmployeeTempList));
            table.refresh();
        }
    }
    public void changeSceneEditEvent(ActionEvent e)throws  IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("../View/Admin.Employee.Edit.fxml"));
        Pane EmployeeAddViewParentEdit = loader.load();
        AdminEmployeeEditController controller= loader.getController();
        Employee selected = table.getSelectionModel().getSelectedItem();
        controller.handleEvent(selected);
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setDialogPane((DialogPane) EmployeeAddViewParentEdit);
        dialog.show();
    }
    public void changeSceneDeleteEvent(ActionEvent e)throws  IOException{
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
