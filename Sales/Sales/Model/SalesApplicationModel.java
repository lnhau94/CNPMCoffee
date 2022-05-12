package Main.Sales.Sales.Model;

import Main.Entity.DataAccess.DAO;
import Main.Entity.Element.Order;
import Main.Entity.Element.OrderDetail;
import Main.Entity.Element.Product;

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
        if(ord.getQuantity()==0){
            currentChoices.remove(i);
        }else{
            currentChoices.set(i, ord);
        }

    }

    public void addItem(OrderDetail od){
        boolean flag = false;
        for(OrderDetail orderDetail : currentChoices){
            if(orderDetail.getProductChoice().getProductId().equals(od.getProductChoice().getProductId())
                    && orderDetail.getSize().equals(od.getSize())){
                orderDetail.setQuantity(orderDetail.getQuantity()+od.getQuantity());
                orderDetail.setPrice(orderDetail.getPrice()+od.getPrice());
                flag=true;
            }
        }
        if(!flag) {
            this.currentChoices.add(od);
        }
    }

    public void updatePrice(){
        calculatePrice();
    }

    public void payCurrentOrder(){
        calculatePrice();
        System.out.println("Save");
        createNewOrder();
    }

    private void calculatePrice(){
        int totalPrice = 0;
        for(OrderDetail od : currentChoices){
            totalPrice += od.getPrice();
        }
        currentOrders.setTotalPrice(totalPrice);
    }

}
