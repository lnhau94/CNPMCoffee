package Main;

import Main.Sales.Sales.Control.SalesApplicationControl;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class ControlBar extends FlowPane {

    MenuItem saleBtn, discardBtn, dataManagerBtn, salaryManagerBtn, ingredientManagerBtn;
    Scene salesScreen;
    Scene discardScreen;
    Scene dataManagerScreen;
    Scene ingredientManagerScreen;
    Scene salaryManagerScreen;
    Scene loginScreen;
    Stage owner;

    public ControlBar(Stage stage){
        this.owner = stage;
        initGUI();
        createHandleEvent();
    }
    private void initGUI(){
        saleBtn = new MenuItem("Sale");
        discardBtn = new MenuItem("Discard");
        dataManagerBtn = new MenuItem("Data");
        salaryManagerBtn = new MenuItem("Salary");
        ingredientManagerBtn = new MenuItem("Ingredients");
        salesScreen = new SalesApplicationControl().getView();
        try {
            dataManagerScreen = new Scene(FXMLLoader.load(getClass().getResource("Admin/DataManager/View/Admin.fxml")));
            ingredientManagerScreen = new Scene(FXMLLoader.load(getClass().getResource("Admin/IngredientsManager/View/IngredientOrder.fxml")));
            //salaryManagerScreen = new Scene(FXMLLoader.load(getClass().getResource("Admin/DataManager/View/Admin.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        MenuBar menuBar = new MenuBar();

        Menu mainMenu = new Menu("...");
        mainMenu.setId("mainMenu");
        Menu saleMenu = new Menu("Sales");
        saleMenu.getItems().add(saleBtn);
        saleMenu.getItems().add(discardBtn);

        Menu adminMenu = new Menu("Admin");
        adminMenu.getItems().add(dataManagerBtn);
        adminMenu.getItems().add(ingredientManagerBtn);
        adminMenu.getItems().add(salaryManagerBtn);

        mainMenu.getItems().add(saleMenu);
        mainMenu.getItems().add(adminMenu);

        menuBar.getMenus().add(mainMenu);

        this.getChildren().add(menuBar);




    }

    public void prepareCSS(){
        try {
            this.getScene().getStylesheets().add(new File("Controlbar.css").toURI().toURL().toExternalForm());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private void createHandleEvent(){

        saleBtn.setOnAction(e->{
            owner.setScene(salesScreen);
            owner.centerOnScreen();
        });
        //discardBtn
        dataManagerBtn.setOnAction(e->{
            owner.setScene(dataManagerScreen);
            owner.centerOnScreen();
        });
        //salaryManagerBtn
        ingredientManagerBtn.setOnAction(e->{
            owner.setScene(ingredientManagerScreen);
            owner.centerOnScreen();
        });
    }

}
