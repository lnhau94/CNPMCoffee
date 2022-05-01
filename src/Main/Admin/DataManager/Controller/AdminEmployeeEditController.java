package Main.Admin.DataManager.Controller;

import Main.Entity.Element.Employee;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AdminEmployeeEditController {
    @FXML
    private TextField textName;
    @FXML
    private TextField textPhone;
    @FXML
    private TextField textPosition;
    @FXML
    private TextField textWorkType;
    public void handleEvent(Employee employee){
        textName.setText(employee.getEmployeeName());
        textPhone.setText(employee.getEmployeePhone());
        textPosition.setText(employee.getPosition());
        textWorkType.setText(employee.getType());
    }
}
