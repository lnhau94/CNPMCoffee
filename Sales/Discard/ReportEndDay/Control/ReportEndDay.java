package Main.Sales.Discard.ReportEndDay.Control;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.util.Duration;

public class ReportEndDay extends SceneController implements Initializable {
    @FXML
    private Button btnConfirm;

    @FXML
    private Button btnWrite;

    @FXML
    private Label dateLabel;

    @FXML
    private Label nameEmp;

    @FXML
    private Label totalRevenue;

    @FXML
    private Label totalTea;

    @FXML
    private Label totalBread;

    @FXML
    private Label totalCoffee;

    @FXML
    private Label totalProduct;

    @FXML
    private Label totalOrder;

    static ResultSet loadData(String yourQuery) {
        ResultSet rs = null;
        Connection cnn = null;
        try {
            String url = "jdbc:sqlserver://localhost:1433;databaseName=CNPM";
            String user = "sa";
            String pass = "123456";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cnn = DriverManager.getConnection(url, user, pass);
            Statement state = cnn.createStatement();
            rs = state.executeQuery(yourQuery);
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Không thể tải dữ liệu lên !!");
            alert.showAndWait();
        }
        return rs;
    }

    public String getData(String yourQuery, String date) {
        String value = "";
        ResultSet rs = loadData(String.format(yourQuery, date));
        try {
            while (rs.next()) {
                try {
                    value = rs.getString(1);
                } catch (SQLException e) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("Không thể liên kết để lấy dữ liệu !");
                    alert.showAndWait();
                }
            }
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Không thể liên kết để lấy dữ liệu !");
            alert.showAndWait();
        }
        return value;
    }
   
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        String time = "";
        String valueTotalRevenue = "";
        String valueTotalOrder = "";
        String valueTotalTea = "";
        String valueTotalCoffee = "";
        String valueTotalBread = "";
        String valueTotalProduct = "";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
        Date date = new Date(); 
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Calendar cal = Calendar.getInstance();
                dateLabel.setText(dateFormat.format(cal.getTime()));
            }
        }));
        time = formatter.format(date); 
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        valueTotalRevenue = getData("select sum(TotalPrice) from Tester1 t where OrderDate = ('%s') group by OrderDate", time);
        if (valueTotalRevenue.compareToIgnoreCase("") == 0) {
            valueTotalRevenue = "0";
        }
        totalRevenue.setText(valueTotalRevenue);
        valueTotalOrder = getData("select count(OrderID) from Tester1 t where OrderDate = ('%s') group by OrderDate", time);
        if (valueTotalOrder.compareToIgnoreCase("") == 0) {
            valueTotalOrder = "0";
        }
        totalOrder.setText(valueTotalOrder);
        valueTotalTea = getData("select count(pd.ProductID) from OrderDetails odt join Orders od ON od.OrderID = odt.OrderID join Product pd on pd.ProductID = odt.ProductID join Category ct on ct.CategoryID = pd.CategoryID where ct.CategoryID like N'Trà' and od.OrderDate = '%s' group by od.OrderDate", time);
        if (valueTotalTea.compareToIgnoreCase("") == 0) {
            valueTotalTea = "0";
        }
        totalTea.setText(valueTotalTea);
        valueTotalCoffee = getData("select count(pd.ProductID) from OrderDetails odt join Orders od ON od.OrderID = odt.OrderID join Product pd on pd.ProductID = odt.ProductID join Category ct on ct.CategoryID = pd.CategoryID where ct.CategoryID like N'Cà phê' and od.OrderDate = '%s' group by od.OrderDate", time);
        if (valueTotalCoffee.compareToIgnoreCase("") == 0) {
            valueTotalCoffee = "0";
        }
        totalCoffee.setText(valueTotalCoffee);
        valueTotalBread = getData("select count(pd.ProductID) from OrderDetails odt join Orders od ON od.OrderID = odt.OrderID join Product pd on pd.ProductID = odt.ProductID join Category ct on ct.CategoryID = pd.CategoryID where ct.CategoryID like N'Bánh mì' and od.OrderDate = '%s' group by od.OrderDate", time);
        if (valueTotalBread.compareToIgnoreCase("") == 0) {
            valueTotalBread = "0";
        }
        totalBread.setText(valueTotalBread);
        if (valueTotalProduct.compareToIgnoreCase("") == 0) {
            valueTotalProduct = "0";
        }
        else {
            try {
                valueTotalProduct = String.valueOf(Integer.parseInt(valueTotalTea) + Integer.parseInt(valueTotalCoffee) + Integer.parseInt(valueTotalBread));
            } catch (NumberFormatException e) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Không thể liên kết để lấy dữ liệu !");
                alert.showAndWait();
            }
        }
        totalProduct.setText(valueTotalProduct);
        nameEmp.setText("Phạm Nguyễn Đức Huy");
    }
}
