package Main;

import Main.Admin.IngredientsManager.Controller.MasterController;
import Main.Helpers.MainControl.ControlBar;
import Main.Sales.Sales.Control.SalesApplicationControl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;


public class MainApp extends Application {

    Dimension screenSize;

    Stage toolPanel;


    private void createControlBar(Stage stage){
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        toolPanel = new Stage(StageStyle.TRANSPARENT);
        toolPanel.setScene(new Scene(new ControlBar(stage)));
        ((ControlBar)toolPanel.getScene().getRoot()).prepareCSS();
        toolPanel.setX(0);
        toolPanel.setY(screenSize.getHeight()-100);
        toolPanel.sizeToScene();

    }


    public static void main(String[] args){
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.initStyle(StageStyle.TRANSPARENT);
        MasterController.start();
        SalesApplicationControl control = new SalesApplicationControl();
        //stage.setScene(control.getView());
        createControlBar(stage);
        toolPanel.initOwner(stage);
        stage.show();
        toolPanel.show();
    }
}