package Main.Sales.Sales.View;

import Main.Entity.Element.OrderDetail;
import Main.Entity.Element.Product;
import Main.Sales.Sales.Control.SalesApplicationControl;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class SalesApplicationView{

    private BorderPane root;
    private GridPane menu;
    private FlowPane controlPnl;
    private BorderPane orderPnl;
    TableView<OrderDetail> orderBody;
    FlowPane orderTittle;
    FlowPane orderFootter;
    private Scene mainScene;
    private ArrayList<Button> buttons;

    private String[] cates = {"Trà sữa", "Cà phê"};

    private SalesApplicationControl controller;

    public SalesApplicationView(SalesApplicationControl controller){
        this.controller = controller;
        initGUI();

    }

    private void initGUI(){
        root = new BorderPane();
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        mainScene = new Scene(root,d.getWidth(),d.getHeight()-100);
        mainScene.getStylesheets().add(getClass().getResource("SalesStyle.css").toExternalForm());
        createMenu();
        createControlPnl();
        createSearchBar();
        createFilterButtons();
        createOrderPnl();
    }

    private void createSearchBar(){
        TextField search = new TextField();
        search.setPromptText("Search Drink!");
        controlPnl.getChildren().add(search);
    }

    private void createControlPnl(){
        controlPnl = new FlowPane();
        controlPnl.setPrefSize(100,50);
        controlPnl.setHgap(5);
        controlPnl.setAlignment(Pos.CENTER_LEFT);
        root.setTop(controlPnl);
    }

    private void createMenu(){
        int i = 0;
        int j = 0;
        menu = new GridPane();
        menu.setHgap(10);
        menu.setVgap(10);
        for (Product p : this.controller.getModel().getProductList()) {
            MenuItem tmp = new MenuItem(p);
            tmp.setOnMouseClicked(mouseEvent -> {
                controller.addNewItem(p);
            });
            menu.add(tmp,i,j);
            i++;
            if(i==5){
                j++;
                i=0;
            }
        }
        try {
            Image img = new Image(new FileInputStream("Icon/menubackground.jpg"));
            menu.setBackground(new Background(new BackgroundImage(
                                img,null,null,null,
                        new BackgroundSize(menu.getWidth(),menu.getHeight(),true,true,true,true))));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ScrollPane srcViewMenu= new ScrollPane(menu);
        srcViewMenu.setFitToHeight(true);
        srcViewMenu.setFitToWidth(true);
        srcViewMenu.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        srcViewMenu.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        root.setCenter(srcViewMenu);
    }

    private void createOrderPnl(){
        orderPnl = new BorderPane();
        orderPnl.setPrefSize(350,300);
        createOrderTittle();
        createOrderBody();

        orderFootter =  new FlowPane();
        orderPnl.setTop(orderTittle);
        orderPnl.setBottom(orderFootter);
        orderPnl.setCenter(orderBody);
        root.setRight(orderPnl);
    }

    private void createOrderBody(){
        orderBody = new TableView<>();
        TableColumn<OrderDetail,String> indexColumn = new TableColumn<>("STT");
        TableColumn<OrderDetail,String> nameColumn = new TableColumn<>("Tên");
        TableColumn<OrderDetail,String> sizeColumn = new TableColumn<>("Size");
        TableColumn<OrderDetail,Integer> qtyColumn = new TableColumn<>("Số lượng");
        TableColumn<OrderDetail,Integer> priceColumn = new TableColumn<>("Thành tiền");

        indexColumn.setCellValueFactory(data -> new SimpleStringProperty(
                String.valueOf(controller.getModel().getCurrentChoices().indexOf(data.getValue())+1)));

        nameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getProductChoice().getProductName()));
        sizeColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
        qtyColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        indexColumn.setPrefWidth(30);
        nameColumn.setPrefWidth(110);
        sizeColumn.setPrefWidth(40);
        qtyColumn.setPrefWidth(80);
        priceColumn.setPrefWidth(100);

        orderBody.setOnMouseClicked(mouseEvent -> {
            if(orderBody.getSelectionModel().getSelectedIndex()>=0){
                this.controller.updateItem(orderBody.getSelectionModel().getSelectedIndex());
            }
        });


        orderBody.getColumns().addAll(indexColumn,nameColumn,sizeColumn,qtyColumn,priceColumn);
        updateOrder();

    }

    public void updateOrder(){
        orderBody.setItems(FXCollections.observableList(this.controller.getModel().getCurrentChoices()));
    }

    private void createOrderTittle(){
        orderTittle = new FlowPane();
        orderTittle.setId("pane");
        orderTittle.setPrefSize(200,50);
        orderTittle.setAlignment(Pos.TOP_RIGHT);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Label timeLbl = new Label(dateFormat.format((System.currentTimeMillis())));
        orderTittle.setStyle(
                        "-fx-background-color: #5F50F1;" +
                        "    -fx-text-fill: #fff;" +
                        "    -fx-background-radius: 5;" +
                        "    -fx-font-size: 14;" +
                        "    -fx-font-weight: 700;" +
                        "    -fx-effect: dropshadow(three-pass-box, #48cae4,5,0,1,0);");
        timeLbl.setStyle(
                "    -fx-background-color: #5F50F1;" +
                "    -fx-text-fill: #fff;" +
                "    -fx-font-size: 14;" +
                "    -fx-font-weight: 700;");
        orderTittle.getChildren().add(timeLbl);
    }

    private void createFilterButtons(){
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
