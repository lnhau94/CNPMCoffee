package Main.Sales.Sales.View;

import Main.Entity.Element.Product;
import Main.Sales.Sales.Control.SalesApplicationControl;
import Main.Sales.Sales.Model.SalesApplicationModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SalesApplicationView{

    private FlowPane menu;

    private FlowPane controlPnl;

    private BorderPane root;

    Scene mainScene;
    ArrayList<Button> buttons;

    String[] cates = {"Trà sữa", "Cà phê"};

    SalesApplicationControl controller;

    public SalesApplicationView(SalesApplicationControl controller){
        this.controller = controller;
        initGUI();
    }

    private void initGUI(){
        root = new BorderPane();
        mainScene = new Scene(root);
        mainScene.getStylesheets().add(getClass().getResource("SalesStyle.css").toExternalForm());
        createMenu();
        createControlPnl();
        createButtons();
    }

    private void createControlPnl(){
        controlPnl = new FlowPane();
        controlPnl.setPrefSize(100,50);
        controlPnl.setHgap(5);
        controlPnl.setAlignment(Pos.CENTER);
        root.setTop(controlPnl);
    }

    private void createMenu(){
        menu = new FlowPane();
        menu.setHgap(10);
        menu.setPrefSize(500,500);
        for (Product p : this.controller.getModel().getProductList()) {
            menu.getChildren().add(new MenuItem(p));
        }
        root.setCenter(menu);
    }

    private void createButtons(){
        buttons = new ArrayList<>();
        for(int i=0;i< cates.length;i++) {
            buttons.add( new Button(cates[i]));
            buttons.get(i).setOnAction(actionEvent -> controller.pay());
            controlPnl.getChildren().add(buttons.get(i));
        }
    }
    public Scene getScreen(){
        return this.mainScene;
    }

}
