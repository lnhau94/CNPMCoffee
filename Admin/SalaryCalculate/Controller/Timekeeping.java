package Main.Admin.SalaryCalculate.Controller;
import Main.Entity.DataAccess.DAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Timekeeping implements Initializable {
    @FXML
    private TextField name;
    @FXML
    private TextField employeeID;
    public void changeSceneSalarytable(ActionEvent e) throws IOException {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../View/Salarytable.fxml"));
        Parent ProductViewParent = loader.load();
        Scene scene = new Scene(ProductViewParent);
        stage.setScene(scene);
    }
    public void changeSceneEmployee(ActionEvent e) throws IOException {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../View/EmployeeList.fxml"));
        Parent ProductViewParent = loader.load();
        Scene scene = new Scene(ProductViewParent);
        stage.setScene(scene);
    }
    public void checkin(ActionEvent event){
        String ID = employeeID.getText();
        DAO sql = new DAO();
        try {
            sql.execute("INSERT INTO DailyWork(DailyDate,EmployeeID, Checkin,Checkout,WorkingHour) \n" +
                    "VALUES (CURRENT_TIMESTAMP,'"+ID+"',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,0);");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(ID);
    }
    public void checkout(ActionEvent event){
        DAO sql = new DAO();
        String ID = employeeID.getText();
        try {
            sql.execute("UPDATE DailyWork SET \n" +
                    "Checkout=CURRENT_TIMESTAMP,\n" +
                    "WorkingHour=DATEDIFF(MI,Checkin,Checkout)/60\n" +
                    "WHERE EmployeeID = '"+ID+"' AND DATEPART(DAYOFYEAR,DailyDate) = DATEPART(DAYOFYEAR,CURRENT_TIMESTAMP);");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(ID);
    }
    public void accept(){

    }
    //Tính tổng giờ làm
    public  void  countSalaryParttime(){
        // Sql tinh tong mot cot: SELECT SUM(cot) FROM bang WHERE ID = ;
        int x=0;
        int date=0;
        int salary=x*8*date;
    }
    public void  countSalaryFulltime(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
