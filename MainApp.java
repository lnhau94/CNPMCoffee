package Main;

import Main.Sales.Sales.Control.SalesApplicationControl;
import Main.Sales.Sales.View.SalesApplicationView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainApp extends Application {

    public static void main(String[] args){
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        SalesApplicationControl control = new SalesApplicationControl();
        stage.setScene(control.getView());
        stage.show();
    }
}