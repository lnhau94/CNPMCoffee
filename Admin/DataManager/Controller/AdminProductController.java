package Main.Admin.DataManager.Controller;

import Main.Admin.DataManager.Model.ProductInTable;
import Main.Entity.DataAccess.DAO;
import Main.Entity.Element.Category;
import Main.Entity.Element.Product;
import Main.Entity.Element.ProductPrice;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
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
import java.util.ResourceBundle;

public class AdminProductController implements Initializable {
    @FXML
    private TableView<ProductInTable> productTableView;
    @FXML
    private TableColumn<ProductInTable, String> productIDTableColumn;
    @FXML
    private TableColumn<ProductInTable, String> productNameTableColumn;
    @FXML
    private TableColumn<ProductInTable, String> CategoryNameTableColumn;
    @FXML
    private TableColumn<ProductInTable, Integer> productPriceBySTableColumn;
    @FXML
    private TableColumn<ProductInTable, Integer> productPriceByMTableColumn;
    @FXML
    private TableColumn<ProductInTable, Integer> productPriceByLTableColumn;
    ObservableList<ProductInTable> productInTables;
    public static List<ProductInTable> productInTableList = new ArrayList<>();
    List<Product> productList = new ArrayList<>();
    ArrayList<ProductPrice> productPriceArrayList = new ArrayList<>();
    public void GetDataProduct() throws SQLException {
        productInTableList.clear();
        DAO dao = new DAO();
        ResultSet rs = dao.executeQuery("SELECT ProductID, ProductName, CategoryName FROM Product, Category Where Product.CategoryID = Category.CategoryID");
        while (rs.next()) {
            String productId = rs.getString(1);
            String productName = rs.getString(2);
            String productCategory = rs.getString(3);
            ResultSet resultSet = dao.executeQuery("SELECT * FROM ProductPrice");
            while (resultSet.next()) {
                String productPriceId = resultSet.getString(1);
                if(productId.equalsIgnoreCase(productPriceId)){
                    String productSize = resultSet.getString(2);
                    int productPrice = resultSet.getInt(3);
                    ProductPrice newProductPrice = new ProductPrice(productId, productSize, productPrice);
                    productPriceArrayList.add(newProductPrice);
                }
            }
            Product newProduct = new Product(productId, productName, productCategory,productPriceArrayList);
            ProductInTable productInTable = new ProductInTable(newProduct);
            productInTableList.add(productInTable);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            this.GetDataProduct();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        productInTables= FXCollections.observableArrayList(productInTableList);
                productIDTableColumn.setCellValueFactory(new PropertyValueFactory<ProductInTable, String>("productID"));
                productNameTableColumn.setCellValueFactory(new PropertyValueFactory<ProductInTable, String>("productName"));
                CategoryNameTableColumn.setCellValueFactory(new PropertyValueFactory<ProductInTable, String>("categoryName"));
                productPriceBySTableColumn.setCellValueFactory(new PropertyValueFactory<ProductInTable, Integer>("priceByS"));
                productPriceByMTableColumn.setCellValueFactory(new PropertyValueFactory<ProductInTable, Integer>("priceByM"));
                productPriceByLTableColumn.setCellValueFactory(new PropertyValueFactory<ProductInTable, Integer>("priceByL"));
        productTableView.setItems(productInTables);
    }
    public void changeSceneAddEvent(ActionEvent e) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("../View/Admin.Product.Add.fxml"));
        Pane EmployeeAddViewParent = loader.load();
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setDialogPane((DialogPane) EmployeeAddViewParent);
        dialog.show();
        this.GetDataProduct();
        productInTableList.forEach((element)->{
            System.out.println(element.getProductID()+element.getPriceByS());
        });
    }
    public void changeSceneEditEvent(ActionEvent e) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("../View/Admin.Product.Edit.fxml"));
        Pane EmployeeEditViewParent = loader.load();
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setDialogPane((DialogPane) EmployeeEditViewParent);
        dialog.show();
    }
    public void changeSceneDeleteEvent(ActionEvent e)throws IOException {
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
