package Main.Sales.Sales.Control;

import Main.Entity.DataAccess.DAO;
import Main.Entity.Element.OrderDetail;
import Main.Sales.Sales.Model.SalesApplicationModel;
import Main.Sales.Sales.View.SalesApplicationView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.io.File;
import java.io.IOException;

public class SalesApplicationControl {

    private SalesApplicationView view;
    private SalesApplicationModel model;

    DAO dao;
    public SalesApplicationControl(){
        model = new SalesApplicationModel();
        view = new SalesApplicationView(this);
        dao = new DAO();
    }

    public Scene getView(){
        return this.view.getScreen();
    }

    public void pay(){
        System.out.println("Paid");
        OrderDetail test = new OrderDetail();
        test.setProductChoice(this.getModel().getProductList().get(1));
        test.setSize("H");
        test.setQuantity(1);
        this.getModel().getCurrentChoices().add(test);
        this.view.updateOrder();
    }

    public void setView(SalesApplicationView view) {
        this.view = view;
    }

    public SalesApplicationModel getModel() {
        return model;
    }

    public void setModel(SalesApplicationModel model) {
        this.model = model;
    }

    public DAO getDao() {
        return dao;
    }

    public void setDao(DAO dao) {
        this.dao = dao;
    }
}
