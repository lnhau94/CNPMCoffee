package Main.Admin.DataManager.Controller;

import Main.Admin.DataManager.Model.ProductInTable;
import Main.Entity.DataAccess.DAO;
import Main.Entity.Element.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.awt.*;
import java.awt.event.TextEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class AdminProductEditController implements Initializable {
    @FXML
    private TextField textNameProductEdit;
    @FXML
    private TextField PriceSEdit;
    @FXML
    private TextField PriceMEdit;
    @FXML
    private TextField PriceLEdit;
    @FXML
    ComboBox<String> CategoryList;
    public static List<String> CategoryNameArray = new ArrayList<>();
    private ObservableList<String> CategoryNameList;

    AdminProductController adminProductController = new AdminProductController();
    public void getCategoryName() throws SQLException {
        CategoryNameArray.clear();
        DAO dao = new DAO();
        ResultSet rs = dao.executeQuery("SELECT * FROM Category");
        while (rs.next()){
            String CategoryName = rs.getString(3);
            CategoryNameArray.add(CategoryName);
        }

    }
    public void handleEvent(ProductInTable product){
        textNameProductEdit.setText(product.getProductName());
        CategoryList.setValue(product.getCategoryName());
        PriceSEdit.setText(String.valueOf(product.getPriceByS()));
        PriceMEdit.setText(String.valueOf(product.getPriceByM()));
        PriceLEdit.setText(String.valueOf(product.getPriceByL()));
    }
    public boolean checkNameProduct(String Name) throws SQLException {
        AdminProductController adminProductController = new AdminProductController();
        adminProductController.GetDataProduct();
        for(ProductInTable product : adminProductController.productInTableList){
            if(product.getProductName().equalsIgnoreCase(Name)) return false;
        }
        return true;
    }
    public void excuteCheck(ProductInTable product) throws SQLException {
        if(!checkNameProduct(textNameProductEdit.getText())){
            ErrorController ErrorController = new ErrorController();
            try {
                ErrorController.displayError("name");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            EditProduct(product);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            getCategoryName();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        CategoryNameList=FXCollections.observableList(CategoryNameArray);
        CategoryList.setItems(CategoryNameList);
    }
    public void EditProduct(ProductInTable product) throws SQLException {
        AdminCategoryController adminCategoryController = new AdminCategoryController();
        DAO dao = new DAO();
        String ProductID = product.getProductID();
        String ProductNameEdit = textNameProductEdit.getText();
        String CategoryName = CategoryList.getValue();
        String CategoryId = null;
        adminCategoryController.getData();
        for(int i=0;i<adminCategoryController.list.size();i++)
        {
            if(adminCategoryController.list.get(i).getCategoryName().equalsIgnoreCase(CategoryName)){
                CategoryId=adminCategoryController.list.get(i).getCategoryId();
            }
        }
        int PricebyS = Integer.parseInt(PriceSEdit.getText());
        int PricebyM = Integer.parseInt(PriceMEdit.getText());
        int PricebyL = Integer.parseInt(PriceLEdit.getText());
        dao.execute("UPDATE Product Set ProductName=N'"+ProductNameEdit+"', CategoryID='"+CategoryId+"' Where ProductID LIKE '"+ProductID+"'");
        dao.execute("UPDATE ProductPrice Set ProductPrice="+PricebyS+" Where ProductID LIKE '"+ProductID+"' AND ProductSize LIKE 'S'");
        dao.execute("UPDATE ProductPrice Set ProductPrice="+PricebyM+" Where ProductID LIKE '"+ProductID+"' AND ProductSize LIKE 'M'");
        dao.execute("UPDATE ProductPrice Set ProductPrice="+PricebyL+" Where ProductID LIKE '"+ProductID+"' AND ProductSize LIKE 'L'");
        adminProductController.GetDataProduct();

    }

}
