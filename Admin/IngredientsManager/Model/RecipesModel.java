package Main.Admin.IngredientsManager.Model;

import Main.Entity.DataAccess.DAO;
import Main.Entity.Element.Ingredient;
import Main.Entity.Element.Product;
import Main.Entity.Element.ProductRecipe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class RecipesModel {
    private ObservableList<Product> productList;
    private ObservableList<Ingredient> ingredientList;
    private ObservableList<String> IngredientNameList;
    private ObservableList<String> IngredientIdList;
    private ObservableList<String> ProductNameList;
    private ObservableList<String> ProductIdList;

    private ObservableList<ProductRecipe> recipesList;

    private DAO dao;

    public RecipesModel() {
        this.init();
    }

    public void init() {
        this.dao = new DAO();
        try {
            ingredientList = dao.getAllIngredient();
            productList = this.dao.getAllProduct2();
            recipesList = this.dao.getAllProductRecipe();

            setIngredientNameList();
            setIngredientIdList();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ObservableList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ObservableList<Product> productList) {
        this.productList = productList;
    }

    public void setIngredientList(ObservableList<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public ObservableList<ProductRecipe> getRecipesList() {
        return recipesList;
    }

    public void setRecipesList(ObservableList<ProductRecipe> recipesList) {
        this.recipesList = recipesList;
    }

    public DAO getDao() {
        return dao;
    }

    public void setDao(DAO dao) {
        this.dao = dao;
    }

    public ObservableList<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public ObservableList<String> getIngredientNameList() {
        return IngredientNameList;
    }

    public void setIngredientNameList() {
        IngredientNameList = FXCollections.observableArrayList();
        this.getIngredientList().forEach(data -> {
            IngredientNameList.add(data.getIngredientName());
        });
    }

    public ObservableList<String> getIngredientIdList() {
        return IngredientIdList;
    }

    public void setIngredientIdList() {
        IngredientIdList = FXCollections.observableArrayList();
        this.getIngredientList().forEach(data -> {
            IngredientIdList.add(data.getIngredientId());
        });
    }

    public ObservableList<String> getProductNameList() {
        return ProductNameList;
    }

    public void setProductNameList() {
        ProductNameList = FXCollections.observableArrayList();
        this.getProductList().forEach(data -> {
            ProductNameList.add(data.getProductName());
        });
    }

    public ObservableList<String> getProductIdList() {
        return ProductIdList;
    }

    public void setProductIdList() {
        ProductIdList = FXCollections.observableArrayList();
        this.getProductList().forEach(data -> {
            ProductIdList.add(data.getProductName());
        });
    }

    public String findIngredientNameById(String id) {
        for (Ingredient ingredient : this.getIngredientList()) {
            if(id.equalsIgnoreCase(ingredient.getIngredientId())) {
                return ingredient.getIngredientName();
            }
        }
        return null;
    }

    public String findProductNameById(String id) {
        for (Product p : this.getProductList()) {
            if(id.equalsIgnoreCase(p.getProductId())) {
                return p.getProductName();
            }
        }
        return null;
    }

    public void addNewItem(ProductRecipe pr) {
        this.getRecipesList().add(pr);
    }

    public void updateItem(int index, ProductRecipe pr) {
        this.getRecipesList().set(index, pr);
    }

    public void removeItem(ProductRecipe rp) {
        this.getRecipesList().remove(rp);
    }
}

