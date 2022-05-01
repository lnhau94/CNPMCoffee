package Main.Sales.Sales.View;

import Main.Entity.Element.Product;
import Main.Entity.Element.ProductPrice;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class MenuItem extends AnchorPane {
    private ImageView image;
    private Label nameLbl;
    private Label priceLbl;

    private Product product;

    public MenuItem (Product product){
        this.product = product;
        initGUI();
    }

    private void initGUI(){
        try {
            image =  new ImageView(new Image(new FileInputStream("src\\Main\\Icon\\nguyenlieu.png")));
            image.setX(0);
            image.setY(0);
            image.setFitHeight(100);
            image.setFitWidth(100);
            this.getChildren().add(image);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        nameLbl = new Label(product.getProductName());
        nameLbl.setLayoutX(0);
        nameLbl.setLayoutY(110);
        String price="";
        for(ProductPrice pp : product.getPriceList()){
            price +=pp.getSize()+"-"+String.valueOf(pp.getPrice());
        }
        priceLbl = new Label(price);
        priceLbl.setLayoutX(0);
        priceLbl.setLayoutY(150);
        this.getChildren().add(nameLbl);
        this.getChildren().add(priceLbl);
    }
}
