package Main.Admin.IngredientsManager.Model;

import Main.Entity.DataAccess.DAO;
import Main.Entity.Element.IncomeDetail;
import Main.Entity.Element.IncomeReport;
import Main.Entity.Element.Ingredient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Date;

public class IncomeReportsApplicationModel {
    private DAO dao;
    private ObservableList<IncomeReport> incomeReports;
    private ObservableList<IncomeDetail> incomeDetails;
    private IncomeReport currentIncomeRe;
    public IncomeReportsApplicationModel() {
        incomeReports = FXCollections.observableArrayList(
                new IncomeReport("DH01", Date.valueOf("2022-05-09"), "WF001",
                        "Dalat", "Waiting")
        );
    }

    public ObservableList<IncomeDetail> getIncomeDetails() {
        return incomeDetails;
    }

    public void setIncomeDetails(ObservableList<IncomeDetail> incomeDetails) {
        this.incomeDetails = incomeDetails;
    }

    public ObservableList<IncomeReport> getIncomeReports() {
        return incomeReports;
    }

    public void setIncomeReports(ObservableList<IncomeReport> incomeReports) {
        this.incomeReports = incomeReports;
    }

    public IncomeReport getCurrentIncomeRe() {
        return currentIncomeRe;
    }

    public void setCurrentIncomeRe(IncomeReport currentIncomeRe) {
        this.currentIncomeRe = currentIncomeRe;
    }

    public void getIncomeDetails(IncomeReport choice) {
        this.currentIncomeRe = choice;
        String sql = "";
        //query sql
        //init list
        this.incomeDetails = FXCollections.observableArrayList(
                new IncomeDetail(new Ingredient("1", "Ca phe", "Ca phe hat"),
                        12),
                new IncomeDetail(new Ingredient("2", "Tra", "Tra say kho"),
                        12),
                new IncomeDetail(new Ingredient("3", "Duong", "Ca phe hat"),
                        12)
        );

    }

    public void updateRecQtyOfOrder() {
        this.currentIncomeRe.setStatus("Confirmed");
//        Sql update receive quantity for each ingredient of order
    }

}
