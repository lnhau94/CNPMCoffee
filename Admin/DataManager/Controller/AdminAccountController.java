package Main.Admin.DataManager.Controller;
import Main.Admin.DataManager.Model.AccountInTable;
import Main.Entity.DataAccess.DAO;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class AdminAccountController implements Initializable {
    @FXML
    TableView<AccountInTable> tableView;
    @FXML
   private TableColumn<AccountInTable, String> ownerIdColumn;
    @FXML
    private TableColumn<AccountInTable, String> ownerNameColumn;
    @FXML
    private TableColumn<AccountInTable, String> userNameColumn;
    @FXML
    private TableColumn<AccountInTable, String> passwordColumn;
    public static List<AccountInTable> accountInTableArrayList = new ArrayList<>();
    ObservableList<AccountInTable> accountInTables;
    public void getDataAccount() throws SQLException {
        accountInTableArrayList.clear();
        DAO dao = new DAO();
        ResultSet rs = dao.executeQuery("SELECT Employee.EmployeeID,EmployeeName,AccountUsername,AccountPassword FROM Employee, Account where Employee.EmployeeID LIKE Account.EmployeeID");
        while (rs.next()){
            String EmployeeID = rs.getString(1);
            String EmployeeName = rs.getString(2);
            String UserName = rs.getString(3);
            String Password = rs.getString(4);
            AccountInTable accountInTable = new AccountInTable(UserName,Password,EmployeeID,EmployeeName);
            accountInTableArrayList.add(accountInTable);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            getDataAccount();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        accountInTables = FXCollections.observableArrayList(accountInTableArrayList);
        ownerIdColumn.setCellValueFactory(new PropertyValueFactory<AccountInTable,String>("ownerId"));
        ownerNameColumn.setCellValueFactory(new PropertyValueFactory<AccountInTable,String>("ownerName"));
        userNameColumn.setCellValueFactory(new PropertyValueFactory<AccountInTable, String>("username"));
        passwordColumn.setCellValueFactory(element -> new SimpleStringProperty(element.getValue().getPassword()));
        tableView.setItems(accountInTables);
    }
    public void changeSceneAddEvent(ActionEvent e) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("../View/Admin.Account.Add.fxml"));
        Pane EmployeeAddViewParent = loader.load();
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setDialogPane((DialogPane) EmployeeAddViewParent);
        AdminAccountAddController adminAccountAddController = loader.getController();
        adminAccountAddController.handleEvent();
        Optional<ButtonType> ClickedButton = dialog.showAndWait();
        if(ClickedButton.get()==ButtonType.APPLY) {
            if(!adminAccountAddController.checkPassword()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Sai mat khau r nhe");
                alert.showAndWait();
            }else{
             adminAccountAddController.AddAccount();
             tableView.setItems(FXCollections.observableArrayList(accountInTableArrayList));
             tableView.refresh();
            }
        }
    }
    public void changeSceneEditEvent(ActionEvent e)throws  IOException{
        FXMLLoader loader = new FXMLLoader();
        AccountInTable selected = tableView.getSelectionModel().getSelectedItem();
        loader.setLocation(this.getClass().getResource("../View/Admin.Account.Edit.fxml"));
        Pane EmployeeAddViewParentEdit = loader.load();
        AdminAccountEditController adminAccountEditController = loader.getController();
        adminAccountEditController.HandleEvent(selected);
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setDialogPane((DialogPane) EmployeeAddViewParentEdit);
        dialog.show();
    }
    public void changeSceneDeleteEvent(ActionEvent e) throws IOException, SQLException {
        Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        AccountInTable account = tableView.getSelectionModel().getSelectedItem();
        if(account==null){
            loader.setLocation(this.getClass().getResource("../View/Alert.fxml"));
            Pane CategoryEditParentView = loader.load();
            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setDialogPane((DialogPane) CategoryEditParentView);
            dialog.showAndWait();
        }else{
            loader.setLocation(this.getClass().getResource("../View/Admin.Delete.fxml"));
            Pane CategoryDeleteParentView = loader.load();
            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setDialogPane((DialogPane)  CategoryDeleteParentView);
            AdminDeleteController adminDeleteController = loader.getController();
            Optional<ButtonType> ClickedButton = dialog.showAndWait();
            if(ClickedButton.get()==ButtonType.YES){
                adminDeleteController.DeleteAccount(account);
                tableView.setItems(FXCollections.observableArrayList(accountInTableArrayList));
                tableView.refresh();

            }
        }

    }
    public void GoBack(ActionEvent e) throws IOException {
        Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(this.getClass().getResource("../CNPMCoffee/Admin/IngredientsManager/View/Admin.Employee.fxml"));
        Parent AdminViewParent = FXMLLoader.load(getClass().getResource("../View/Admin.fxml"));
        Scene scene = new Scene(AdminViewParent);
        stage.setScene(scene);
    }


}
