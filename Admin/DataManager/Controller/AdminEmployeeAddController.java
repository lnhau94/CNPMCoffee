package Main.Admin.DataManager.Controller;

import Main.Entity.DataAccess.DAO;
import Main.Entity.Element.Category;
import Main.Entity.Element.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.IOException;
import java.sql.SQLException;

public class AdminEmployeeAddController {
    @FXML
    private TextField textNameEmployee;
    @FXML
    private TextField textPhone;
    @FXML
    private TextField textPosition;
    @FXML
    private TextField textType;

    public void AddEmployee() throws SQLException {
        String NameEmployee = textNameEmployee.getText();
        String Phone = textPhone.getText();
        String Position = textPosition.getText();
        String type = textType.getText();
        System.out.println(NameEmployee + Phone + Position + type);
        Employee employee = new Employee(NameEmployee, Phone, Position, type);
        AdminEmployeeController adminEmployeeController = new AdminEmployeeController();
        DAO dao = new DAO();
        dao.execute("INSERT INTO Employee (EmployeeName,EmployeePhone, WorkPositionID, WorkTypeID) " +
                "VALUES('" + employee.getEmployeeName() + "','" + employee.getEmployeePhone() + "','" + employee.getPosition() + "','" + employee.getType() + "')");
        adminEmployeeController.getDataEmplyee();

    }
}
