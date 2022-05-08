package Main;

import Main.Admin.IngredientsManager.Controller.MasterController;
import Main.Sales.Sales.Control.SalesApplicationControl;
import Main.Sales.Sales.View.SalesApplicationView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;


public class MainApp extends Application {

    Dimension screenSize;

    BorderPane mainScreen;
    Stage toolPanel;


    private void createControlBar(Stage stage){
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

        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        SalesApplicationControl control = new SalesApplicationControl();
        stage.setScene(control.getView());

        createControlBar(stage);
        toolPanel.initOwner(stage);
        stage.setResizable(false);
        stage.show();
        toolPanel.show();
    }
}