package Main.Admin.DataManager.Controller;

import Main.Admin.DataManager.Model.AccountInTable;
import Main.Entity.Element.Category;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.swing.text.TabExpander;

public class AdminAccountEditController {
    @FXML
    private Label txtEmployeeId;
    @FXML
    private Label txtName;
    @FXML
    private TextField txtUserName;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private PasswordField txtPasswordAgain;

    public void HandleEvent (AccountInTable account){
        txtEmployeeId.setText(account.getOwnerId());
        txtName.setText(account.getOwnerName());
        txtUserName.setText(account.getUsername());
        txtPassword.setText(account.getPassword());
        txtPasswordAgain.setText(account.getPassword());
    }
    public boolean checkPassword(){
        String password = txtPassword.getText();
        String passwordAgain = txtPasswordAgain.getText();
        if(password.equalsIgnoreCase(passwordAgain)){
            return true;
        }
        return  false;
    }
    public void EditAccount (AccountInTable account){

    }
}
