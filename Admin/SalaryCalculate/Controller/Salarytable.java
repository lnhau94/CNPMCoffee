package Main.Admin.SalaryCalculate.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Salarytable {

    public void changeSceneTimekeeping(ActionEvent e) throws IOException {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../View/Timekeeping.fxml"));
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
    //Tính tổng giờ làm
    public double countWorkTime(int month){
        double a=0,b=0;

        // sql giờ checkin: SELECT SUM(checkin) FROM timeKeeping WHERE MONTH()=month AND ID=id;   => checkout
        return b-a;
    }
    // Tính ngày công
    public  int countWorkDate(int month){
        int date = 0;
        // sql ngày làm theo tháng: SELECT COUNT(date) FROM timeKeeping WHERE MONTH()=month;   => checkout
        return date;
    }
    public  void  countSalaryParttime(int month){
        // Sql tinh tong mot cot: SELECT SUM(cot) FROM bang WHERE ID = ;
        int x=0; //  luong theo gio
        double hour=countWorkTime(month); // tong gio lam viec
        double salary=x*hour;
    }
    public void  countSalaryFulltime(){

    }
}
