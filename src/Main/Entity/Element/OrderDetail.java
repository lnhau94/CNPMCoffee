package Main.Entity.Element;

public class OrderDetail {
    private String productId;
    private String size;
    private int quantity;

    public OrderDetail() {
    }

    public OrderDetail(String productId, String size, int quantity) {
        this.productId = productId;
        this.size = size;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
