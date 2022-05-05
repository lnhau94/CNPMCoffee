package Main.Admin.DataManager.Controller;

import Main.Entity.DataAccess.DAO;
import Main.Entity.Element.Category;

import java.sql.SQLException;

public class AdminDeleteController {
    public void DeleteCategory (Category category) throws SQLException {
        DAO dao = new DAO();
        dao.execute("DELETE Category WHERE CategoryName LIKE'"+category.getCategoryName()+"'");
    }
}
