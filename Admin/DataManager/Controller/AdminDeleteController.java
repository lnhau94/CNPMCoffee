package Main.Admin.DataManager.Controller;

import Main.Admin.DataManager.Model.ProductInTable;
import Main.Entity.DataAccess.DAO;
import Main.Entity.Element.Category;
import Main.Entity.Element.Product;

import java.sql.SQLException;

public class AdminDeleteController {
    DAO dao;
    public void DeleteCategory (Category category) throws SQLException {
         dao = new DAO();
        dao.execute("DELETE Category WHERE CategoryName LIKE'"+category.getCategoryName()+"'");
    }
    public void DeleteProduct (ProductInTable product) throws SQLException {
        dao = new DAO();
        dao.execute("DELETE ProductPrice Where ProductID lIKE '"+product.getProductID()+"'");
        dao.execute("DELETE Product Where ProductID LIKE '"+product.getProductID()+"'");
        AdminProductController adminProductController = new AdminProductController();
        adminProductController.GetDataProduct();
    }
}
