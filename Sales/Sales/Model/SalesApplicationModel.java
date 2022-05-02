package Main.Sales.Sales.Model;

import Main.Entity.DataAccess.DAO;
import Main.Entity.Element.Order;
import Main.Entity.Element.OrderDetail;
import Main.Entity.Element.Product;
import Main.Sales.Sales.View.OrderFactory;
import javafx.stage.Window;

import java.util.ArrayList;
import java.util.List;

public class SalesApplicationModel {
    List<Product> productList;
    Order currentOrders;
    ArrayList<OrderDetail> currentChoices;
    DAO dao;

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Order getCurrentOrders() {
        return currentOrders;
    }

    public void setCurrentOrders(Order currentOrders) {
        this.currentOrders = currentOrders;
    }

    public ArrayList<OrderDetail> getCurrentChoices() {
        return currentChoices;
    }

    public void setCurrentChoices(ArrayList<OrderDetail> currentChoices) {
        this.currentChoices = currentChoices;
    }

    public DAO getDao() {
        return dao;
    }

    public void setDao(DAO dao) {
        this.dao = dao;
    }

    public SalesApplicationModel(){

        dao = new DAO();
        this.productList = dao.getAllProduct();
        createNewOrder();
    }

    public void createNewOrder(){
        currentOrders = new Order();
        currentChoices = new ArrayList<>();

    }

    public void updateChoice(int i,OrderDetail ord){
        currentChoices.set(i, ord);
    }

    public void addItem(OrderDetail od){
        this.currentChoices.add(od);
    }

    public void save(){

    }

}
