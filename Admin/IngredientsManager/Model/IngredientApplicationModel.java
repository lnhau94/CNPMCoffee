package Main.Admin.IngredientsManager.Model;

import Main.Entity.DataAccess.DAO;
import Main.Entity.Element.Ingredient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class IngredientApplicationModel {

    private Ingredient i;
    private DAO dao;

    private ObservableList<Ingredient> ingredientList = FXCollections.observableArrayList(
            new Ingredient("1", "huyen", "caphe", 12,
                                   12000, "Dalat Farm"),
            new Ingredient("2", "hau", "duong", 12,
                                    12000, "Dalat Farm")
        );

    public IngredientApplicationModel() {
    }

    public IngredientApplicationModel(Ingredient i) {
        this.i = i;
    }

    public ObservableList<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(ObservableList<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public void addItem(Ingredient i) {
        this.ingredientList.add(i);
        this.getIngredientList().forEach(item -> {
            System.out.println(item.getIngredientName());
        });

        System.out.println(this.getIngredientList().size());
    }

    public void updateItem(int index, Ingredient i) {
        this.getIngredientList().set(index, i);
    }

    public void removeItem(Ingredient i) {
        this.getIngredientList().remove(i);
    }


}
