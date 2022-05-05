package Main.Entity.DataAccess;

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
    private String DBuser = "sa";
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
        ArrayList<ProductPrice> productPriceslist =  new ArrayList<>();
        productPriceslist.add(new ProductPrice("123","S",10000));
        productPriceslist.add(new ProductPrice("123","M",20000));
        productPriceslist.add(new ProductPrice("123","L",30000));
        Product tmp = new Product();
        tmp.setProductId("123");
        tmp.setCategoryName("Trà Xanh");
        tmp.setProductName("Trà Lài Hoa Cúc");
        tmp.setPriceList(productPriceslist);
        list.add(tmp);
        tmp = new Product();
        tmp.setProductId("123");
        tmp.setCategoryName("Trà Xanh");
        tmp.setProductName("Trà Lài Hoa Cúc");
        tmp.setPriceList(productPriceslist);
        list.add(tmp);
        tmp.setProductId("123");
        tmp.setCategoryName("Trà Xanh");
        tmp.setProductName("Trà Lài Hoa Cúc");
        tmp.setPriceList(productPriceslist);
        list.add(tmp);
        tmp.setProductId("123");
        tmp.setCategoryName("Trà Xanh");
        tmp.setProductName("Trà Lài Hoa Cúc");
        tmp.setPriceList(productPriceslist);
        list.add(tmp);
        tmp.setProductId("123");
        tmp.setCategoryName("Trà Xanh");
        tmp.setProductName("Trà Lài Hoa Cúc");
        tmp.setPriceList(productPriceslist);
        list.add(tmp);
        tmp.setProductId("123");
        tmp.setCategoryName("Trà Xanh");
        tmp.setProductName("Trà Lài Hoa Cúc");
        tmp.setPriceList(productPriceslist);
        list.add(tmp);
        tmp.setProductId("123");
        tmp.setCategoryName("Trà Xanh");
        tmp.setProductName("Trà Lài Hoa Cúc");
        tmp.setPriceList(productPriceslist);
        list.add(tmp);
        tmp = new Product();
        tmp.setProductId("123");
        tmp.setCategoryName("Trà Xanh");
        tmp.setProductName("Trà Lài Hoa Cúc");
        tmp.setPriceList(productPriceslist);
        list.add(tmp);
        tmp = new Product();
        tmp.setProductId("123");
        tmp.setCategoryName("Trà Xanh");
        tmp.setProductName("Trà Lài Hoa Cúc");
        tmp.setPriceList(productPriceslist);
        list.add(tmp);
        tmp = new Product();
        tmp.setProductId("123");
        tmp.setCategoryName("Trà Xanh");
        tmp.setProductName("Trà Lài Hoa Cúc");
        tmp.setPriceList(productPriceslist);
        list.add(tmp);
        tmp = new Product();
        tmp.setProductId("123");
        tmp.setCategoryName("Trà Xanh");
        tmp.setProductName("Trà Lài Hoa Cúc");
        tmp.setPriceList(productPriceslist);
        list.add(tmp);
        tmp = new Product();
        tmp.setProductId("123");
        tmp.setCategoryName("Trà Xanh");
        tmp.setProductName("Trà Lài Hoa Cúc");
        tmp.setPriceList(productPriceslist);
        list.add(tmp);
        tmp = new Product();
        tmp.setProductId("123");
        tmp.setCategoryName("Trà Xanh");
        tmp.setProductName("Trà Lài Hoa Cúc");
        tmp.setPriceList(productPriceslist);
        list.add(tmp);
        tmp = new Product();
        tmp.setProductId("123");
        tmp.setCategoryName("Trà sữa");
        tmp.setProductName("Trà Lài Hoa Cúc");
        tmp.setPriceList(productPriceslist);
        list.add(tmp);
        tmp = new Product();
        tmp.setProductId("123");
        tmp.setCategoryName("Trà sữa");
        tmp.setProductName("Trà Lài Hoa Cúc");
        tmp.setPriceList(productPriceslist);
        list.add(tmp);
        tmp = new Product();
        tmp.setProductId("123");
        tmp.setCategoryName("Trà sữa");
        tmp.setProductName("Trà Lài Hoa Cúc");
        tmp.setPriceList(productPriceslist);
        list.add(tmp);
        tmp = new Product();
        tmp.setProductId("123");
        tmp.setCategoryName("Trà sữa");
        tmp.setProductName("Trà Lài Hoa Cúc");
        tmp.setPriceList(productPriceslist);
        list.add(tmp);
        tmp = new Product();
        tmp.setProductId("123");
        tmp.setCategoryName("Trà Xanh");
        tmp.setProductName("Trà Lài Hoa Cúc");
        tmp.setPriceList(productPriceslist);
        list.add(tmp);
        tmp = new Product();
        tmp.setProductId("123");
        tmp.setCategoryName("Trà Xanh");
        tmp.setProductName("Trà Lài Hoa Cúc");
        tmp.setPriceList(productPriceslist);
        list.add(tmp);
        tmp = new Product();
        tmp.setProductId("123");
        tmp.setCategoryName("Trà Xanh");
        tmp.setProductName("Trà Lài Hoa Cúc");
        tmp.setPriceList(productPriceslist);
        list.add(tmp);
        tmp = new Product();
        tmp.setProductId("123");
        tmp.setCategoryName("Trà Xanh");
        tmp.setProductName("Trà Lài Hoa Cúc");
        tmp.setPriceList(productPriceslist);
        list.add(tmp);
        tmp = new Product();
        tmp.setProductId("123");
        tmp.setCategoryName("Trà Xanh");
        tmp.setProductName("Trà Lài Hoa Cúc");
        tmp.setPriceList(productPriceslist);
        list.add(tmp);
        tmp = new Product();
        tmp.setProductId("123");
        tmp.setCategoryName("Trà Xanh");
        tmp.setProductName("Trà Lài Hoa Cúc");
        tmp.setPriceList(productPriceslist);
        list.add(tmp);
        tmp = new Product();
        tmp.setProductId("123");
        tmp.setCategoryName("Trà Xanh");
        tmp.setProductName("Trà Lài Hoa Cúc");
        tmp.setPriceList(productPriceslist);
        list.add(tmp);
        tmp = new Product();
        tmp.setProductId("123");
        tmp.setCategoryName("Trà Xanh");
        tmp.setProductName("Trà Lài Hoa Cúc");
        tmp.setPriceList(productPriceslist);
        list.add(tmp);
        tmp = new Product();
        tmp.setProductId("123");
        tmp.setCategoryName("Trà Xanh");
        tmp.setProductName("Trà Lài Hoa Cúc");
        tmp.setPriceList(productPriceslist);
        list.add(tmp);
        tmp = new Product();
        tmp.setProductId("123");
        tmp.setCategoryName("Trà Xanh");
        tmp.setProductName("Trà Lài Hoa Cúc");
        tmp.setPriceList(productPriceslist);
        list.add(tmp);

        return list;
    }
}
