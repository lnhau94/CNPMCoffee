package Main.Sales.Sales.View;

import Main.Entity.Element.Product;
import Main.Entity.Element.ProductPrice;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class MenuItem extends VBox {
    private ImageView image;
    private Label nameLbl;
    private Label priceLbl;

    private Product product;

    private String labelCSS =
            "-fx-background-color: transparent;" +
                    "-fx-alignment: center;" +
                    "    -fx-text-fill: #fff;" +
                    "    -fx-font-size: 14px;" +
                    "    -fx-effect: dropshadow(three-pass-box, #48cae4,3,1,1,0);";
    private String label2CSS =
                    "-fx-background-color: transparent;" +
                    "-fx-alignment: center;" +
                    "    -fx-text-fill: #fff;" +
                    "    -fx-font-size: 12px;" +
                    "    -fx-effect: dropshadow(three-pass-box, #48cae4,3,1,1,0);";
    private String boxCSS =
                    "    -fx-alignment: center;" +
                    "    -fx-background-radius: 5;" +
                    "    -fx-background-color:  rgba(255, 148, 77, 0.3);" +
                    "    -fx-background-color: linear-gradient(from 25px 25px to 100px 100px, rgba(112,51,8,0.2), rgba(194,91,32,0.5));"+
                    "    -fx-font-size: 16;" +
                    "    -fx-font-weight: 700;" +
                    "    -fx-effect: dropshadow(three-pass-box, rgba(229,164,117,0.96),5,0,1,0);";

    public MenuItem (Product product){
        this.product = product;
        this.setStyle(boxCSS);
        initGUI();
    }

    private void initGUI(){
        this.setSpacing(5);
        nameLbl = new Label(product.getProductName() + " - "+product.getCategoryName());
        this.getChildren().add(nameLbl);
        this.setPrefSize(200,200);
        try {
            image =  new ImageView(new Image(new FileInputStream("Icon/nguyenlieu.png")));
            image.setX(0);
            image.setY(0);
            image.setFitHeight(100);
            image.setFitWidth(100);
            this.getChildren().add(image);
        } catch (FileNotFoundException e) {
            System.out.println("Not found image for "+this.product.getProductName());
        }

        String price="";
        for(ProductPrice pp : product.getPriceList()){
            price += pp.getSize() + "-" + pp.getPrice() + "\t";
        }
        priceLbl = new Label(price);
        priceLbl.setStyle(label2CSS);
        nameLbl.setStyle(labelCSS);
        this.getChildren().add(priceLbl);
    }
}
