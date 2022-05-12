package Main.Helpers.MainControl;

import Main.Sales.Sales.Control.SalesApplicationControl;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class ControlBar extends VBox {

    ToggleButton saleMenuItem, discardMenuItem, dataManagerMenuItem, salaryManagerMenuItem, ingredientManagerMenuItem;
    Scene salesScreen;
    Scene discardScreen;
    Scene dataManagerScreen;
    Scene ingredientManagerScreen;
    Scene salaryManagerScreen;
    Scene loginScreen;
    Stage owner;
    Menu logoutMenu;

    public ControlBar(Stage stage){
        this.owner = stage;
        initGUI();
        createHandleEvent();
    }
    private void initGUI(){
        saleMenuItem = new ToggleButton("Sale");
        discardMenuItem = new ToggleButton("Discard");
        dataManagerMenuItem = new ToggleButton("Data");
        salaryManagerMenuItem = new ToggleButton("Salary");
        ingredientManagerMenuItem = new ToggleButton("Ingredients");
        salesScreen = new SalesApplicationControl().getView();
        try {
            dataManagerScreen = new Scene(FXMLLoader.load(getClass().getResource("../../Admin/DataManager/View/Admin.fxml")));
            ingredientManagerScreen = new Scene(FXMLLoader.load(getClass().getResource("../../Admin/IngredientsManager/View/IngredientOrder.fxml")));
            discardScreen = new Scene(FXMLLoader.load(new File("Sales/ReportEndDay/View/ReportEndDay.fxml").toURI().toURL()));
            discardScreen.getStylesheets().add(new File("Sales/ReportEndDay/View/CSS/ReportEndDay.css").toURI().toURL().toExternalForm());

            //salaryManagerScreen = new Scene(FXMLLoader.load(getClass().getResource("Admin/DataManager/View/Admin.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        MenuBar menuBar = new MenuBar();

        Menu mainMenu = new Menu("...");
        mainMenu.setId("mainMenu");
        Menu saleMenu = new Menu("Sales");
        //saleMenu.getItems().add(saleMenuItem);
        //saleMenu.getItems().add(discardMenuItem);

        Menu adminMenu = new Menu("Admin");
        //adminMenu.getItems().add(dataManagerMenuItem);
        //adminMenu.getItems().add(ingredientManagerMenuItem);
        //adminMenu.getItems().add(salaryManagerMenuItem);

        logoutMenu = new Menu("Exit");

        mainMenu.getItems().add(saleMenu);
        mainMenu.getItems().add(adminMenu);
        mainMenu.getItems().add(logoutMenu);

        menuBar.getMenus().add(saleMenu);
        menuBar.getMenus().add(adminMenu);
        menuBar.setRotate(270);


        ToggleGroup gr = new ToggleGroup();
        saleMenuItem.setToggleGroup(gr);
        discardMenuItem.setToggleGroup(gr);
        dataManagerMenuItem.setToggleGroup(gr);
        ingredientManagerMenuItem.setToggleGroup(gr);
        salaryManagerMenuItem.setToggleGroup(gr);
        saleMenuItem.setSelected(true);

        this.getChildren().add(saleMenuItem);
        this.getChildren().add(discardMenuItem);
        this.getChildren().add(dataManagerMenuItem);
        this.getChildren().add(ingredientManagerMenuItem);
        this.getChildren().add(salaryManagerMenuItem);




        //this.setRotate(90);

    }

    public void prepareCSS(){
        try {
            this.getScene().getStylesheets().add(new File("Helpers/MainControl/Controlbar.css").toURI().toURL().toExternalForm());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private void changeLocation(){

        if(owner.getX()<100){
            owner.setX(100);
            owner.setY(0);
        }

        this.getScene().getWindow().setX(owner.getX()-100);
        this.getScene().getWindow().setY(owner.getY());


    }

    private void createHandleEvent(){

        saleMenuItem.setOnAction(e->{
            owner.setScene(salesScreen);
            //changeLocation();
        });
        discardMenuItem.setOnAction(e->{
            owner.setScene(discardScreen);
            //changeLocation();
        });
        dataManagerMenuItem.setOnAction(e->{
            owner.setScene(dataManagerScreen);
            //changeLocation();

        });
        //salaryManagerBtn
        ingredientManagerMenuItem.setOnAction(e->{
            owner.setScene(ingredientManagerScreen);
            //changeLocation();
        });
        logoutMenu.setOnAction(e->owner.close());
        owner.sceneProperty().addListener((w,o,n)->{
            w.getValue().getWindow().centerOnScreen();
            changeLocation();
        });
    }

}
