package Main.Entity.Element;

import java.sql.ResultSet;

public class Product {
    private String productId;
    private String productName;
    private String categoryName;

    public Product() {
    }

    public Product(String productId, String productName, String categoryName) {
        this.productId = productId;
        this.productName = productName;
        this.categoryName = categoryName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
