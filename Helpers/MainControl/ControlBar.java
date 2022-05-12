package Main.Helpers.MainControl;

import Main.Sales.Sales.Control.SalesApplicationControl;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class ControlBar extends FlowPane {

    MenuItem saleMenuItem, discardMenuItem, dataManagerMenuItem, salaryManagerMenuItem, ingredientManagerMenuItem;
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
        saleMenuItem = new MenuItem("Sale");
        discardMenuItem = new MenuItem("Discard");
        dataManagerMenuItem = new MenuItem("Data");
        salaryManagerMenuItem = new MenuItem("Salary");
        ingredientManagerMenuItem = new MenuItem("Ingredients");
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
        saleMenu.getItems().add(saleMenuItem);
        saleMenu.getItems().add(discardMenuItem);

        Menu adminMenu = new Menu("Admin");
        adminMenu.getItems().add(dataManagerMenuItem);
        adminMenu.getItems().add(ingredientManagerMenuItem);
        adminMenu.getItems().add(salaryManagerMenuItem);

        logoutMenu = new Menu("Exit");

        mainMenu.getItems().add(saleMenu);
        mainMenu.getItems().add(adminMenu);
        mainMenu.getItems().add(logoutMenu);

        menuBar.getMenus().add(mainMenu);

        this.getChildren().add(menuBar);




    }

    public void prepareCSS(){
        try {
            this.getScene().getStylesheets().add(new File("Helpers/MainControl/Controlbar.css").toURI().toURL().toExternalForm());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private void changeLocation(int locale){
        owner.centerOnScreen();

        this.getScene().getWindow().setX(owner.getX()+owner.getWidth()+locale);
        this.getScene().getWindow().setY(owner.getY());


    }

    private void createHandleEvent(){

        saleMenuItem.setOnAction(e->{
            owner.setScene(salesScreen);
            changeLocation(-50);
        });
        discardMenuItem.setOnAction(e->{
            owner.setScene(discardScreen);
            changeLocation(0);
        });
        dataManagerMenuItem.setOnAction(e->{
            owner.setScene(dataManagerScreen);
            changeLocation(0);

        });
        //salaryManagerBtn
        ingredientManagerMenuItem.setOnAction(e->{
            owner.setScene(ingredientManagerScreen);
            changeLocation(0);
        });
        logoutMenu.setOnAction(e->owner.close());
    }

}
