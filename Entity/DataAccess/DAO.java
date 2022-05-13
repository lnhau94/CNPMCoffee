package Main.Entity.DataAccess;

import Main.Admin.DataManager.Controller.AdminProductController;
import Main.Admin.DataManager.Model.ProductInTable;
import Main.Entity.Element.Product;
import Main.Entity.Element.ProductPrice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    private String connectURL = "jdbc:sqlserver://;" +
                                "serverName=localhost;" +
                                "databaseName=CNPM;" +
                                "encrypt=true;trustServerCertificate=true";
    /*
    private String DBuser = "sa";
<<<<<<< HEAD
//    private String DBpass = "123456";
    private String DBpass = "reallyStrongPwd123";
=======
    private String DBpass = "123456";
            "serverName=database-1.czhlmlnnya7d.ap-southeast-1.rds.amazonaws.com;" +
                    "databaseName=CNPM;" +
                    "encrypt=true;trustServerCertificate=true";
    private String DBuser = "admin";
    private String DBpass = "1248163264128";
//    private String DBpass = "reallyStrongPwd123";
    */
    private String DBuser = "admin";
    private String DBpass = "123456";

    private Connection connect;
    private Statement stmt;

    public ResultSet executeQuery(String sqlQuery){
        ResultSet result = null;
        try {
            connect = DriverManager.getConnection(connectURL,DBuser,DBpass);
            stmt= connect.createStatement();
            result = stmt.executeQuery(sqlQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    public void execute(String sqlQuery) throws SQLException {
        connect = DriverManager.getConnection(connectURL,DBuser,DBpass);
        stmt= connect.createStatement();
        stmt.execute(sqlQuery);
    }
    public boolean insert(String sqlQuery){
        boolean flag = false;
        try {
            connect = DriverManager.getConnection(connectURL,DBuser,DBpass);
            stmt= connect.createStatement();
            flag = stmt.execute(sqlQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flag;
    }

    public List<Product> getAllProduct() {
        ArrayList<Product> list =  new ArrayList<>();
        try {
            new AdminProductController().GetDataProduct();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        for(ProductInTable p : AdminProductController.productInTableList){
            Product tmp = new Product(p.getProductID(), p.getProductName(), p.getCategoryName());
            if(p.getPriceByS()!=0){
                tmp.getPriceList().add(new ProductPrice(tmp.getProductId(), "S",p.getPriceByS()));
            }
            if(p.getPriceByM()!=0){
                tmp.getPriceList().add(new ProductPrice(tmp.getProductId(), "M",p.getPriceByM()));
            }
            if(p.getPriceByL()!=0){
                tmp.getPriceList().add(new ProductPrice(tmp.getProductId(), "L",p.getPriceByL()));
            }
            list.add(tmp);
        }

        return list;
    }

    public PreparedStatement getPrepareStatement(String sqlQuery) throws SQLException {
        connect = DriverManager.getConnection(connectURL,DBuser,DBpass);
        return connect.prepareStatement(sqlQuery);
    }
}
