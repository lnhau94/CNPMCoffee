package Main.Admin.DataManager.Controller;

import Main.Entity.DataAccess.DAO;
import Main.Entity.Element.Category;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AdminCategoryController implements Initializable {
    public void changeSceneAddEvent(ActionEvent e) throws IOException {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("../View/Admin.Category.Add.fxml"));
        Pane CategoryAddParentView = loader.load();
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setDialogPane((DialogPane) CategoryAddParentView);
        dialog.show();
    }

    public void changeSceneEditEvent(ActionEvent e) throws IOException {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("../View/Admin.Category.Edit.fxml"));
        Pane CategoryEditParentView = loader.load();
        AdminCategoryEditController controller = loader.getController();
        Category selected = table.getSelectionModel().getSelectedItem();
        if (selected == null) {
            System.out.println("Hello mấy cưng");
        } else {
            controller.handleEvent(selected);
            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setDialogPane((DialogPane) CategoryEditParentView);
            dialog.show();
        }

    }

    public void changeSceneDeleteEvent(ActionEvent e) throws IOException {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("../View/Admin.Delete.fxml"));
        Pane CategoryDeleteParentView = loader.load();
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setDialogPane((DialogPane) CategoryDeleteParentView);
        dialog.show();
    }

    public void GoBack(ActionEvent e) throws IOException {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(this.getClass().getResource("../CNPMCoffee/Admin/IngredientsManager/View/Admin.Employee.fxml"));
        Parent AdminViewParent = FXMLLoader.load(getClass().getResource("../View/Admin.fxml"));
        Scene scene = new Scene(AdminViewParent);
        stage.setScene(scene);
    }

    @FXML
    TableView<Category> table;
    @FXML
    private TableColumn<Category, String> CategoryIdColumn;
    @FXML
    private TableColumn<Category, String> CategoryNameColumn;
    @FXML
    private TextField textNameCategory;
    ObservableList<Category> CategoryList;
    public List<Category> list = new ArrayList<>();

    public void getData() throws SQLException {
        DAO dao = new DAO();
        ResultSet resultSet = dao.executeQuery("SELECT * FROM Category");
        while (resultSet.next()) {
            Category category = new Category(resultSet.getString(2), resultSet.getString(3));
            list.add(category);
        }
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            this.getData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        CategoryList = FXCollections.observableArrayList(list);
        CategoryIdColumn.setCellValueFactory(new PropertyValueFactory<Category, String>("categoryId"));
        CategoryNameColumn.setCellValueFactory(new PropertyValueFactory<Category, String>("categoryName"));
        table.setItems(CategoryList);
    }

    public static void AddCategory() {

    }
    public void EditCategory(){

    }
    public  void DeleteCategory(){

    }
    public  void SaveData(){

    }
}
