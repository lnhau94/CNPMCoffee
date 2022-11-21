package Main.test;

import Main.Entity.Element.Order;
import Main.Entity.Element.OrderDetail;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class SalesApplicationModelTest {


    ArrayList<OrderDetail> currentChoices;
    private Order currentOrders = new Order();

    public void calculatePrice(){
        int totalPrice = 0;
        for(OrderDetail od : currentChoices){
            totalPrice += od.getPrice();
        }
        currentOrders.setTotalPrice(totalPrice);
    }

    @Test
    public void calculatePriceForNone(){
        currentChoices = new ArrayList<>();
        this.calculatePrice();
        assertEquals(0,currentOrders.getTotalPrice());
    }
}
