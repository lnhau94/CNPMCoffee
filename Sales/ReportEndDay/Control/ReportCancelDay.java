package Main.Sales.ReportEndDay.Control;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.ResourceBundle;

import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

import Main.Entity.DataAccess.DAO;
import Main.Entity.Element.Product;
import Main.Sales.ReportEndDay.Model.ProductCancel;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.converter.IntegerStringConverter;
import javafx.scene.Node;

public class ReportCancelDay extends SceneController implements Initializable {

    @FXML
    private AnchorPane firstPane;

    @FXML
    private AnchorPane secondPane;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnEnd;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnOk;

    @FXML
    private Button btnSale;

    @FXML
    private Button btnSuccess;

    @FXML
    private Label timeLabel;

    @FXML
    private ComboBox<String> boxCheck;

    @FXML
    private TextField fieldProductID;

    @FXML
    private TextField fieldProductQty;

    @FXML
    private TableView<ProductCancel> tableProduct;

    @FXML
    private TableColumn<ProductCancel, String> idProduct;

    @FXML
    private TableColumn<ProductCancel, String> nameProduct;

    @FXML
    private TableColumn<ProductCancel, Integer> qtyProduct;

    @Override
    public void screenReportEndDay(ActionEvent event) throws IOException {
        saveData();
        root = FXMLLoader.load((new File("Sales/ReportEndDay/View/ReportEndDay.fxml").toURI().toURL()));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(new File("Sales/ReportEndDay/View/CSS/ReportEndDay.css").toURI().toURL().toExternalForm());
        stage.setScene(scene);
        stage.show();
     }


    static String date;     
    AutoCompletionBinding<String> fieldId, fieldName;
    String catcomboBox[] = { "M?? s???n ph???m", "T??n s???n ph???m" };
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    DateFormat dateFormatData = new SimpleDateFormat("yyyy-MM-dd");
    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            Calendar cal = Calendar.getInstance();
            timeLabel.setText(dateFormat.format(cal.getTime()));
            date = dateFormatData.format(cal.getTime());
        }
   }));

    ObservableList<Product> listProduct = FXCollections.observableArrayList(new DAO().getAllProduct());

    public static ObservableList<ProductCancel> listData = FXCollections.observableArrayList();

    public class CustomIntegerStringConverter extends IntegerStringConverter {
        private final IntegerStringConverter converter = new IntegerStringConverter();

        @Override
        public String toString(Integer object) {
            try {
                return converter.toString(object);
            } catch (NumberFormatException e) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("S??? l?????ng b???n nh???p kh??ng h???p l??? !");
                alert.showAndWait();
                tableProduct.refresh();
            }
            return null;
        }

        @Override
        public Integer fromString(String string) {
            try {
                return converter.fromString(string);
            } catch (NumberFormatException e) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("S??? l?????ng b???n nh???p kh??ng h???p l??? !");
                alert.showAndWait();
                tableProduct.refresh();
            }
            return -1;
        }
    }

    public ObservableList<String> listId() {
        ObservableList<String> list = FXCollections.observableArrayList();
        for (Product product : listProduct) {
            list.add(product.getProductId());
        }
        return list;
    }

    public ObservableList<String> listName() {
        ObservableList<String> list = FXCollections.observableArrayList();
        for (Product product : listProduct) {
            list.add(product.getProductName());
        }
        return list;
    }

    public void checkTextComboBox() throws Exception {
        if (boxCheck.getValue() != null) {
            if (boxCheck.getValue().compareToIgnoreCase("M?? s???n ph???m") == 0) {
                fieldId = TextFields.bindAutoCompletion(fieldProductID, listId());
                if (fieldName != null) {
                    fieldName.dispose();
                }
            } else if (boxCheck.getValue().compareToIgnoreCase("T??n s???n ph???m") == 0) {
                fieldName = TextFields.bindAutoCompletion(fieldProductID, listName());
                if (fieldId != null) {
                    fieldId.dispose();
                }
            }
        }
    }

    public void checkProductID() throws Exception {
        String productId = "";
        String productQty = "";
        productId = fieldProductID.getText().toUpperCase();
        productQty = fieldProductQty.getText().toUpperCase();
        if (boxCheck.getValue() != null) {
            if (boxCheck.getValue().compareToIgnoreCase("M?? s???n ph???m") == 0) {
                boolean checkId = false;
                boolean checkProduct = false;
                for (Product product : listProduct) {
                    if (productId.compareToIgnoreCase(product.getProductId()) != 0) {
                        checkId = false;
                    } else {
                        checkId = true;
                        try {
                            if (Integer.parseInt(productQty) <= 0) {
                                Alert alert = new Alert(AlertType.ERROR);
                                alert.setHeaderText(null);
                                alert.setContentText("S??? l?????ng b???n nh???p kh??ng h???p l??? !");
                                alert.showAndWait();
                                fieldProductID.setText("");
                                fieldProductQty.setText("");
                            } else {
                                for (int i = 0; i < listData.size(); i++) {
                                    if (productId.compareToIgnoreCase(listData.get(i).getIdProduct()) == 0) {
                                        checkProduct = true;
                                    }
                                }
                                if (checkProduct == false) {
                                    listData.add(new ProductCancel(product.getProductId(), product.getProductName(),
                                            Integer.parseInt(productQty)));
                                } else {
                                    Alert alert = new Alert(AlertType.ERROR);
                                    alert.setHeaderText(null);
                                    alert.setContentText("M?? s???n ph???m b???n nh???p ???? t???n t???i trong b???ng ! Vui l??ng nh???p l???i. ");
                                    alert.showAndWait();
                                    fieldProductID.setText("");
                                    fieldProductQty.setText("");
                                }
                            }
                        } catch (NumberFormatException e) {
                            Alert alert = new Alert(AlertType.ERROR);
                            alert.setHeaderText(null);
                            alert.setContentText("Nh???p sai ?????nh d???ng ! Vui l??ng nh???p l???i.");
                            alert.showAndWait();
                            fieldProductID.setText("");
                            fieldProductQty.setText("");
                        }
                        break;
                    }
                }
                if (checkId == false) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("Nh???p sai m?? s???n ph???m ! Vui l??ng nh???p l???i.");
                    alert.showAndWait();
                    fieldProductID.setText("");
                    fieldProductQty.setText("");
                }
            }
            else if (boxCheck.getValue().compareToIgnoreCase("T??n s???n ph???m") == 0) {
                boolean checkName = false;
                boolean checkProduct = false;
                for (Product product : listProduct) {
                    if (productId.compareToIgnoreCase(product.getProductName()) != 0) {
                        checkName = false;
                    }
                    else {
                        checkName = true;
                        try {
                            if (Integer.parseInt(productQty) <= 0) {
                                Alert alert = new Alert(AlertType.ERROR);
                                alert.setHeaderText(null);
                                alert.setContentText("S??? l?????ng b???n nh???p kh??ng h???p l??? !");
                                alert.showAndWait();
                                fieldProductID.setText("");
                                fieldProductQty.setText("");
                            } else {
                                for (int i = 0; i < listData.size(); i++) {
                                    if (productId.compareToIgnoreCase(listData.get(i).getNameProduct()) == 0) {
                                        checkProduct = true;
                                    }
                                }
                                if (checkProduct == false) {
                                    listData.add(new ProductCancel(product.getProductId(), product.getProductName(),
                                            Integer.parseInt(productQty)));
                                    System.out.println(fieldProductID.getText());
                                } else {
                                    Alert alert = new Alert(AlertType.ERROR);
                                    alert.setHeaderText(null);
                                    alert.setContentText("T??n s???n ph???m b???n nh???p ???? t???n t???i trong b???ng ! Vui l??ng nh???p l???i. ");
                                    alert.showAndWait();
                                    fieldProductID.setText("");
                                    fieldProductQty.setText("");
                                }
                            }
                        } catch (NumberFormatException e) {
                            Alert alert = new Alert(AlertType.ERROR);
                            alert.setHeaderText(null);
                            alert.setContentText("Nh???p sai ?????nh d???ng ! Vui l??ng nh???p l???i.");
                            alert.showAndWait();
                            fieldProductID.setText("");
                            fieldProductQty.setText("");
                        }
                        break;
                    }
                }
                if (checkName == false) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("Nh???p sai t??n s???n ph???m ! Vui l??ng nh???p l???i.");
                    alert.showAndWait();
                    fieldProductID.setText("");
                    fieldProductQty.setText("");
                }
            }
        }
        else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Vui l??ng ch???n m?? ho???c t??n s???n ph???m ????? nh???p.");
            alert.showAndWait();
            fieldProductID.setText("");
            fieldProductQty.setText("");
        }
        Iterator<ProductCancel> products = listData.iterator();
        while (products.hasNext()) {
            if (products.next().getQtyProduct() == 0) {
                products.remove();
            }
        }
    }

    public void editIdColumn(TableColumn.CellEditEvent<ProductCancel, String> idEditEvent) {
        ProductCancel prd = tableProduct.getSelectionModel().getSelectedItem();
        boolean checkId = false;
        boolean checkEquals = false;
        for (Product product : listProduct) {
            if (idEditEvent.getNewValue().compareToIgnoreCase(product.getProductId()) == 0) {
                checkId = true;
                break;
            }
        }
        if (checkId == false) {
            for (int i = 0; i < listData.size(); i++) {
                if (idEditEvent.getOldValue().compareToIgnoreCase(listData.get(i).getIdProduct()) == 0) {
                    listData.get(i).setIdProduct(idEditEvent.getOldValue().toUpperCase());
                }
            }
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Nh???p sai m?? s???n ph???m ! Vui l??ng nh???p l???i.");
            alert.showAndWait();
            tableProduct.refresh();
        } else {
            for (int i = 0; i < listData.size(); i++) {
                if (idEditEvent.getOldValue().compareToIgnoreCase(listData.get(i).getIdProduct()) == 0
                        && idEditEvent.getNewValue().compareToIgnoreCase(listData.get(i).getIdProduct()) != 0) {
                    listData.get(i).setIdProduct(idEditEvent.getNewValue().toUpperCase());
                    for (Product product : listProduct) {
                        if (idEditEvent.getNewValue().compareToIgnoreCase(product.getProductId()) == 0) {
                            listData.get(i).setNameProduct(product.getProductName());
                            tableProduct.refresh();
                        }
                    }
                } else if (idEditEvent.getNewValue().compareToIgnoreCase(listData.get(i).getIdProduct()) == 0) {
                    if (idEditEvent.getOldValue().compareToIgnoreCase(listData.get(i).getIdProduct()) == 0) {
                        listData.get(i).setIdProduct(idEditEvent.getOldValue());
                    }
                    checkEquals = true;
                    break;
                }
            }
        }
        if (checkEquals == true) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("M?? s???n ph???m b???n nh???p ???? t???n t???i trong b???ng ! Vui l??ng nh???p l???i.");
            alert.showAndWait();
            tableProduct.refresh();
        }
    }

    public void editNameColumn(TableColumn.CellEditEvent<ProductCancel, String> nameEditEvent) {
        ProductCancel prd = tableProduct.getSelectionModel().getSelectedItem();
        boolean checkName = false;
        boolean checkEquals = false;
        for (Product product : listProduct) {
            if (nameEditEvent.getNewValue().compareToIgnoreCase(product.getProductName()) == 0) {
                checkName = true;
                break;
            }
        }
        if (checkName == false) {
            for (int i = 0; i < listData.size(); i++) {
                if (nameEditEvent.getNewValue().compareToIgnoreCase(listData.get(i).getNameProduct()) == 0) {
                    listData.get(i).setNameProduct(nameEditEvent.getOldValue());
                }
            }
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Nh???p sai t??n s???n ph???m ! Vui l??ng nh???p l???i.");
            alert.showAndWait();
            tableProduct.refresh();
        }
        else {
            for (int i = 0; i < listData.size(); i++) {
                if (nameEditEvent.getOldValue().compareToIgnoreCase(listData.get(i).getNameProduct()) == 0 && nameEditEvent.getNewValue().compareToIgnoreCase(listData.get(i).getNameProduct()) != 0) {
                    listData.get(i).setNameProduct(nameEditEvent.getNewValue());
                    for (Product product : listProduct) {
                        if (nameEditEvent.getNewValue().compareToIgnoreCase(product.getProductName()) == 0) {
                            listData.get(i).setIdProduct(product.getProductId());
                            tableProduct.refresh();
                        }
                    }
                }
                else if (nameEditEvent.getNewValue().compareToIgnoreCase(listData.get(i).getNameProduct()) == 0) {
                    if (nameEditEvent.getOldValue().compareToIgnoreCase(listData.get(i).getNameProduct()) == 0) {
                        listData.get(i).setNameProduct(nameEditEvent.getOldValue());
                    }
                    checkEquals = true;
                    break;
                }
            }
        }
        if (checkEquals == true) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("T??n s???n ph???m b???n nh???p ???? t???n t???i trong b???ng ! Vui l??ng nh???p l???i.");
            alert.showAndWait();
            tableProduct.refresh();
        }
    }

    public void editQtyColumn(TableColumn.CellEditEvent<ProductCancel, Integer> qtyEditEvent) {
        ProductCancel prd = tableProduct.getSelectionModel().getSelectedItem();
        System.out.println(qtyEditEvent.getNewValue());
        if (qtyEditEvent.getNewValue() == -1 || qtyEditEvent.getNewValue() == null) {
            for (int i = 0; i < listData.size(); i++) {
                if (listData.get(i).getQtyProduct() == -1
                        && listData.get(i).getIdProduct().compareToIgnoreCase(prd.getIdProduct()) == 0) {
                    listData.get(i).setQtyProduct(qtyEditEvent.getOldValue());
                }
            }
        } else if (qtyEditEvent.getNewValue() < 0 && qtyEditEvent.getNewValue() != -1) {
            prd.setQtyProduct(qtyEditEvent.getOldValue());
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("S??? l?????ng b???n nh???p kh??ng h???p l??? !");
            alert.showAndWait();
            tableProduct.refresh();
        } else if (qtyEditEvent.getNewValue() >= 0) {
            for (int i = 0; i < listData.size(); i++) {
                if (listData.get(i).getQtyProduct() >= 0
                        && listData.get(i).getIdProduct().compareToIgnoreCase(prd.getIdProduct()) == 0) {
                    listData.get(i).setQtyProduct(qtyEditEvent.getNewValue());
                }
            }
        }
        System.out.println(prd.getQtyProduct());
        for (int i = 0; i < listData.size(); i++) {
            System.out.println(listData.get(i).getQtyProduct());
        }
        Iterator<ProductCancel> products = listData.iterator();
        while (products.hasNext()) {
            if (products.next().getQtyProduct() == 0) {
                products.remove();
            }
        }
    }

    public void clearData() throws Exception {
        fieldProductID.setText("");
        fieldProductQty.setText("");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        boxCheck.setItems(FXCollections.observableArrayList(catcomboBox));
        idProduct.setCellValueFactory(new PropertyValueFactory<ProductCancel, String>("idProduct"));
        idProduct.setCellFactory(ComboBoxTableCell.forTableColumn(listId()));
        nameProduct.setCellValueFactory(new PropertyValueFactory<ProductCancel, String>("nameProduct"));
        nameProduct.setCellFactory(ComboBoxTableCell.forTableColumn(listName()));
        qtyProduct.setCellValueFactory(new PropertyValueFactory<ProductCancel, Integer>("qtyProduct"));
        qtyProduct.setCellFactory(TextFieldTableCell.forTableColumn(new CustomIntegerStringConverter()));
        tableProduct.setItems(listData);
        tableProduct.setEditable(true); 
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void saveData() {
        Connection cnn = null;
        try {

//            String url = "jdbc:sqlserver://;" +
//                    "serverName=localhost;" +
//                    "databaseName=CNPM;" +
//                    "encrypt=true;trustServerCertificate=true";
//            String user = "admin";
//            String pass = "123456";
            String url = "jdbc:sqlserver://;" +
                    "serverName=" +
                    "databaseName=CNPM;" +
                    "encrypt=true;trustServerCertificate=true";
            String user = "admin";
            String pass = "1248163264128";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cnn = DriverManager.getConnection(url, user, pass);
            Statement state = cnn.createStatement();
            for (ProductCancel pd : listData) {
                state.executeUpdate(String.format("Insert into ProductCancel values ('%s',N'%s', %d, '%s')", pd.getIdProduct(),
                        pd.getNameProduct(), pd.getQtyProduct(), date));
            }
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Kh??ng th??? l??u d??? li???u !!");
            alert.showAndWait();
        }
        listData.clear();
    }
}
