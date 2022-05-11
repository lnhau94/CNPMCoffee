package Main.Admin.IngredientsManager.Controller;

import Main.Admin.IngredientsManager.Model.IncomeReportsApplicationModel;
import Main.Entity.Element.IncomeDetail;
import Main.Entity.Element.IncomeReport;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

public class OrderDetailController extends MasterController implements Initializable {
    @FXML
    private TextField textFieldName;
    @FXML
    private TextField textFieldID;
    @FXML
    private TextField date;
    @FXML
    private TextField textFieldSupplier;


    @FXML
    private TableView<IncomeDetail> table;
    @FXML
    private TableColumn<IncomeDetail, String> idCol;
    @FXML
    private TableColumn<IncomeDetail, String> nameCol;
    @FXML
    private TableColumn<IncomeDetail, String> typeCol;
    @FXML
    private TableColumn<IncomeDetail, String> priceCol;
    @FXML
    private TableColumn<IncomeDetail, String> producerCol;
    @FXML
    private TableColumn<IncomeDetail, Integer> qtyCol;
    @FXML
    private TableColumn<IncomeDetail, Integer> receiveQtyCol;

    private IncomeReportsApplicationModel model;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.model = MasterController.inRModel;

        this.displayChosenItem(this.model.getCurrentIncomeRe());
        idCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()
                .getIngredientChoice().getIngredientId()));
        nameCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()
                .getIngredientChoice().getIngredientName()));
        typeCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()
                .getIngredientChoice().getIngredientType()));
        priceCol.setCellValueFactory(data -> new SimpleStringProperty(String.valueOf(data.getValue()
                .getIngredientChoice().getIncomePrice())));
        producerCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()
                .getIngredientChoice().getProducer()));
        qtyCol.setCellValueFactory(new PropertyValueFactory<IncomeDetail, Integer>("orderQty"));
        receiveQtyCol.setCellValueFactory(new PropertyValueFactory<IncomeDetail, Integer>("receiveQty"));
        this.getDetails(this.model.getIncomeDetails());

    }

    public void displayChosenItem(IncomeReport i) {
        textFieldID.setText("WF001");
        textFieldName.setText("Thanh Huyen");
        textFieldSupplier.setText("Dalat Trung Nguyen");
//        Convert date sql to String
//        Then convert String to LocalDate
        Date date = new Date(2030, 9, 5);
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String strDate = dateFormat.format(date);
//        System.out.println("Converted String " + strDate);
        this.date.setText(strDate);
    }

    public void getDetails(ObservableList<IncomeDetail> incomeDetails) {
        this.table.setItems(incomeDetails);
    }
}
