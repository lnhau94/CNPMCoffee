package Main.Admin.IngredientsManager.Model;

import Main.Entity.DataAccess.DAO;
import Main.Entity.Element.IncomeDetail;
import Main.Entity.Element.IncomeReport;
import Main.Entity.Element.Ingredient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class IngredientApplicationModel {

    private IncomeReport incomeReport;
    private DAO dao;

    private ObservableList<Ingredient> ingredientList = FXCollections.observableArrayList(
            new Ingredient("1", "huyen", "caphe", 12,
                                   12000, "Dalat Farm"),
            new Ingredient("2", "hau", "duong", 12,
                                    12000, "Dalat Farm")
        );

    private ObservableList<IncomeDetail> currentChoices;

    public IngredientApplicationModel() {
        dao = new DAO();
    }


    public ObservableList<IncomeDetail> getCurrentChoices() {
        return currentChoices;
    }

    public void setCurrentChoices(ObservableList<IncomeDetail> currentChoices) {
        this.currentChoices = currentChoices;
    }

    public ObservableList<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(ObservableList<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public IncomeReport getIncomeReport() {
        return incomeReport;
    }

    public void setIncomeReport(IncomeReport incomeReport) {
        this.incomeReport = incomeReport;
    }
    public void addNewItem(Ingredient i) {
        this.ingredientList.add(i);
    }

    public void updateItem(int index, Ingredient i) {
        this.getIngredientList().set(index, i);
    }

    public void removeItem(Ingredient i) {
        this.getIngredientList().remove(i);
    }

    public void createNewOrder(){
        this.incomeReport = new IncomeReport();
        this.currentChoices = FXCollections.observableArrayList();
    }

    public boolean addChosenItem(IncomeDetail incomeDetail) {
        int i = 0;
        for (IncomeDetail id : this.getCurrentChoices()) {
            if(id.getIngredientChoice().getIngredientId().equalsIgnoreCase(
                    incomeDetail.getIngredientChoice().getIngredientId())) {
                id.setOrderQty(id.getOrderQty() + 1);
                currentChoices.set(i, id);
                return true;
            }
            i++;
        }
        this.getCurrentChoices().add(incomeDetail);
        return true;
    }

    public void removeChosenItem(IncomeDetail incomeDetail) {
        this.getCurrentChoices().remove(incomeDetail);
    }

    public void saveIncomeReport() {

    }


}
