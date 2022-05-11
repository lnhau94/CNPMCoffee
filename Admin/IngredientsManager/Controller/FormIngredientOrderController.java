package Main.Admin.IngredientsManager.Controller;

import Main.Admin.IngredientsManager.Model.IngredientApplicationModel;
import Main.Entity.Element.IncomeDetail;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class FormIngredientOrderController extends MasterController implements Initializable {

    @FXML
    private TextField textFieldName;
    @FXML
    private TextField textFieldID;
    @FXML
    private DatePicker date;
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


    private IngredientApplicationModel model;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.model = MasterController.model;
        idCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()
                .getIngredientChoice().getIngredientId()));
        nameCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()
                .getIngredientChoice().getIngredientName()));
        typeCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()
                .getIngredientChoice().getIngredientType()));
        priceCol.setCellValueFactory(data -> new SimpleStringProperty(String.valueOf(
                data.getValue().getIngredientChoice().getIncomePrice())));
        qtyCol.setCellValueFactory(new PropertyValueFactory<>("orderQty"));
        producerCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()
                .getIngredientChoice().getProducer()));

        textFieldID.setText("WF001");
        textFieldName.setText("Thanh Huyền");

        table.setItems(this.model.getCurrentChoices());
    }

    public void sendOrder(ActionEvent e) {
        this.model.getIncomeReport().setStatus("Waiting");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd");
//        this.model.getIncomeReport().setOrderDate(Date.valueOf(this.date.getValue().format(formatter)));
        this.model.getIncomeReport().setEmployeeIdCreate(this.textFieldID.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Message");
        alert.setHeaderText("Send Successfully");
        alert.showAndWait();
        screenTranfer.switchScene(e);
    }
}
