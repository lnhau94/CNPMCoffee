package Main.Admin.DataManager.Controller;

import Main.Entity.DataAccess.DAO;
import Main.Entity.Element.Category;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class AdminCategoryEditController {
    @FXML
    private TextField textNameCategory;

    public void EidtCategory(Category selected) throws SQLException {

            DAO dao = new DAO();
            String CategoryName = selected.getCategoryName();
            String CategoryNameChange = textNameCategory.getText();
            dao.execute("UPDATE Category SET CategoryName = '"+CategoryNameChange+"' WHERE Upper('"+CategoryName+"')=Upper('CategoryName')");
    }
}
