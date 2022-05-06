package Main.Admin.DataManager.Controller;

import Main.Entity.DataAccess.DAO;
import Main.Entity.Element.Category;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AdminProductAddController implements Initializable {
    @FXML
    private ComboBox<String> CategoryList;
    public static List<String> CategoryNameArray = new ArrayList<>();
    public ObservableList<String> CategoryNameList;
    AdminCategoryController adminCategoryController = new AdminCategoryController();
    public void getCategoryName() throws SQLException {
        CategoryNameArray.clear();
        DAO dao = new DAO();
        ResultSet rs = dao.executeQuery("SELECT * FROM Category");
        while (rs.next()){
            String CategoryName = rs.getString(3);
            CategoryNameArray.add(CategoryName);
        }
        CategoryNameList=FXCollections.observableArrayList(CategoryNameArray);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            getCategoryName();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        CategoryList.setItems(CategoryNameList);

    }
}
