package Main.Sales.Sales.View;

import Main.Entity.Element.OrderDetail;
import Main.Entity.Element.Product;
import Main.Entity.Element.ProductPrice;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;

public class OrderFactory {

    private OrderDetail item;

    private ComboBox<String> sizeChoice;
    private Label name;
    private Label price;
    private TextField qty;
    private Button addBtn,minusBtn;

    public static OrderDetail choiceItem(Product p, Window window){
        Stage stage = new Stage();
        OrderDetail od = new OrderDetail();
        od.setQuantity(0);
        stage.initModality(Modality.APPLICATION_MODAL);
        Label name = new Label(p.getProductName());
        ComboBox<String> sizeChoice = new ComboBox<>();
        for(ProductPrice pp : p.getPriceList()){
            sizeChoice.getItems().add(pp.getSize());
        }
        sizeChoice.getSelectionModel().select(0);
        TextField qty = new TextField("1");
        qty.setEditable(false);
        qty.setPrefSize(35,20);
        Label price = new Label(String.valueOf(p.getPriceList().get(0).getPrice()));
        Button addBtn,minusBtn;
        addBtn = new Button("+");
        addBtn.setOnAction(actionEvent -> {
            qty.setText(String.valueOf(Integer.parseInt(qty.getText())+1));
            price.setText(String.valueOf(Integer.parseInt(qty.getText())
                    * p.getPriceList().get(sizeChoice.getSelectionModel().getSelectedIndex()).getPrice()));
        });
        minusBtn = new Button("-");
        minusBtn.setOnAction(actionEvent -> {
            qty.setText(String.valueOf(Math.max(1,Integer.parseInt(qty.getText())-1)));
            price.setText(String.valueOf(Integer.parseInt(qty.getText())
                    * p.getPriceList().get(sizeChoice.getSelectionModel().getSelectedIndex()).getPrice()));
        });
        sizeChoice.setOnAction(actionEvent -> {
            price.setText(String.valueOf(Integer.parseInt(qty.getText())
                    * p.getPriceList().get(sizeChoice.getSelectionModel().getSelectedIndex()).getPrice()));
        });
        try {
            ImageView img = new ImageView(new Image(new FileInputStream("Icon/up.png")));
            img.setFitHeight(20);
            img.setFitWidth(20);
            addBtn.setGraphic(img);
            addBtn.setText("");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            ImageView img = new ImageView(new Image(new FileInputStream("Icon/down.png")));
            img.setFitHeight(20);
            img.setFitWidth(20);
            minusBtn.setGraphic(img);
            minusBtn.setText("");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Button checkBtn = new Button("OK");
        Button cancelBtn = new Button("Cancel");
        try {
            ImageView img = new ImageView(new Image(new FileInputStream("Icon/cancel2.png")));
            img.setFitHeight(30);
            img.setFitWidth(30);
            cancelBtn.setGraphic(img);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        try {
            ImageView img = new ImageView(new Image(new FileInputStream("Icon/ok.png")));
            img.setFitHeight(30);
            img.setFitWidth(30);
            checkBtn.setGraphic(img);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        checkBtn.setOnAction(actionEvent -> {
            od.setQuantity(Integer.parseInt(qty.getText()));
            od.setProductChoice(p);
            od.setSize(sizeChoice.getSelectionModel().getSelectedItem());
            od.setPrice(Integer.parseInt(price.getText()));

            stage.close();
        });
        cancelBtn.setOnAction(actionEvent -> {
            stage.close();
        });

        FlowPane qtyControl = new FlowPane();
        qtyControl.getChildren().add(minusBtn);
        qtyControl.getChildren().add(qty);
        qtyControl.getChildren().add(addBtn);

        BorderPane root = new BorderPane();
        HBox cont = new HBox();
        VBox cont1 = new VBox();
        VBox cont2 = new VBox();
        cont.setPrefSize(300,200);
        cont1.setPrefSize(100,200);
        cont1.setSpacing(5);
        cont2.setPrefSize(100,200);
        cont2.setSpacing(5);
        Label nameLbl = new Label("Tên Sản phẩm: ");
        Label priceLbl = new Label("Thành tiền: ");
        Label sizeLbl = new Label("Size đang chọn: ");
        Label qtyLbl = new Label("Số lượng: ");
        cont1.getChildren().add(nameLbl);
        cont1.getChildren().add(priceLbl);
        cont1.getChildren().add(sizeLbl);
        cont1.getChildren().add(qtyLbl);
        cont2.getChildren().add(name);
        cont2.getChildren().add(price);
        cont2.getChildren().add(sizeChoice);
        cont2.getChildren().add(qtyControl);
        cont1.setId("cont");
        cont2.setId("cont");


        cont.getChildren().addAll(cont1,cont2);

        root.setCenter(cont);
        FlowPane ctl = new FlowPane(cancelBtn,checkBtn);
        ctl.setId("control");
        ctl.setHgap(10);
        root.setBottom(ctl);


        Scene sc = new Scene(root);
        try {
            sc.getStylesheets().add(new File("Sales/Sales/View/OrderFactory.css").toURI().toURL().toExternalForm());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        stage.setScene(sc);
        stage.centerOnScreen();
        stage.initOwner(window);
        stage.showAndWait();

        return od;
    }

}
