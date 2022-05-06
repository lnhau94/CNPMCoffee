package Main.Admin.DataManager.Controller;

import Main.Entity.DataAccess.DAO;
import Main.Entity.Element.Category;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.Optional;

public class AdminCategoryAddController  {
    @FXML
    private TextField textNameCategory;
    public void AddCategory() throws SQLException {
        String CategoryName = textNameCategory.getText();
            System.out.println(CategoryName);
                Category category = new Category(CategoryName);
                AdminCategoryController categoryController = new AdminCategoryController();
                DAO dao = new DAO();
                dao.execute("INSERT INTO Category (CategoryName) VALUES('"+category.getCategoryName()+"')");
                categoryController.getData();




    }

}
