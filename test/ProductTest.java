package Main.test;

import Main.Admin.DataManager.Controller.AdminCategoryController;
import Main.Admin.DataManager.Controller.AdminProductController;
import Main.Admin.DataManager.Model.ProductInTable;
import Main.Entity.DataAccess.DAO;
import Main.Entity.Element.Category;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
import java.sql.SQLException;

public class ProductTest {
    public boolean checkNameProduct(String Name) throws SQLException {
        AdminProductController adminProductController = new AdminProductController();
        adminProductController.GetDataProduct();
        for(ProductInTable product : adminProductController.productInTableList){
            if(product.getProductName().equalsIgnoreCase(Name)) return false;
        }
        return true;
    }

    public boolean editCategory(String oldName, String newName) throws SQLException {
        DAO dao = new DAO();
        AdminCategoryController adminCategoryController = new AdminCategoryController();
        dao.execute("UPDATE Category SET CategoryName = '"+newName
                +"' WHERE '"+oldName+"' LIKE CategoryName");
        adminCategoryController.getData();
        return true;
    }

    @Test
    public void test1() throws SQLException {
        assertEquals(false, checkNameProduct("Cà phê đen"));
    }

    @Test
    public void test2() throws SQLException {
        assertEquals(true, editCategory("Cà phê", "Cà phê đậm"));
    }
}
