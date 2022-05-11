package Main.Admin.IngredientsManager.Model;

import Main.Entity.DataAccess.DAO;
import Main.Entity.Element.Product;
import Main.Entity.Element.ProductRecipe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RecipesModel {
    private ObservableList<String> productNameList;
    private ObservableList<String> ingredientNameList;
    private ObservableList<ProductRecipe> recipesListRecipes;
    private DAO dao;

    public RecipesModel() {
        this.init();
    }

    public void init() {
        ingredientNameList = FXCollections.observableArrayList(
                "Đường",
                "Cà phê",
                "Trà xanh"
        );
        productNameList = FXCollections.observableArrayList(
                "Trà đào cam sả",
                "Trà hạt sen",
                "Bánh mì"
        );
        recipesListRecipes = FXCollections.observableArrayList(
                new ProductRecipe("123", "D1", 12, 12),
                new ProductRecipe("009", "CF01", 12, 12)
        );
    }

    public ObservableList<String> getProductNameList() {
        return productNameList;
    }

    public void setProductNameList(ObservableList<String> productNameList) {
        this.productNameList = productNameList;
    }

    public ObservableList<ProductRecipe> getRecipesListRecipes() {
        return recipesListRecipes;
    }

    public void setRecipesListRecipes(ObservableList<ProductRecipe> recipesListRecipes) {
        this.recipesListRecipes = recipesListRecipes;
    }

    public ObservableList<String> getIngredientNameList() {
        return ingredientNameList;
    }

    public void addNewItem(ProductRecipe pr) {
        this.getRecipesListRecipes().add(pr);
    }

    public void updateItem(int index, ProductRecipe pr) {
        this.getRecipesListRecipes().set(index, pr);
    }

    public void removeItem(ProductRecipe rp) {
        this.getRecipesListRecipes().remove(rp);
    }
}

