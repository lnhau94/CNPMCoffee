package Main.Admin.IngredientsManager.Model;

import Main.Entity.DataAccess.DAO;
import Main.Entity.Element.ProductRecipe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RecipesModel {
    private ObservableList<String> productNameList;
    private ObservableList<ProductRecipe> recipesListRecipes;
    private DAO dao;

    public RecipesModel() {
        productNameList = FXCollections.observableArrayList(
                "Trà đào cam sả",
                "Trà hạt sen",
                "Bánh mì"
        );
        recipesListRecipes = FXCollections.observableArrayList(
                new ProductRecipe("PD01", "D1", 12, 12),
                new ProductRecipe("PD01", "CF01", 12, 12)
        );
    }








}
