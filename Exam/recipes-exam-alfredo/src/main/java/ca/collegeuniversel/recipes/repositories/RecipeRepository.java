package ca.collegeuniversel.recipes.repositories;

import ca.collegeuniversel.recipes.entities.Recipe;
import ca.collegeuniversel.recipes.entities.RecipeCategory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RecipeRepository
{
    private final String connectionUrl;
    private final String connectionUsername;
    private final String connectionPassword;

    public RecipeRepository()
    {        
        String databaseName = "recipes_db";
        connectionUrl = "jdbc:mariadb://localhost:3306/" + databaseName;
        connectionUsername = "root";
        connectionPassword = "admin";
    }
    
    public Recipe getRecipe(int id) throws ClassNotFoundException, SQLException
    {
        // TODO
        return null;
    }
    
    public ArrayList<Recipe> getRecipes() throws ClassNotFoundException, SQLException
    {
        // TODO
        return null;
    }
    
    public ArrayList<Recipe> getRecipesByCategory(RecipeCategory category) throws ClassNotFoundException, SQLException
    {
        return getRecipesByCategory(category.getId());
    }
    
    public ArrayList<Recipe> getRecipesByCategory(int categoryId) throws ClassNotFoundException, SQLException
    {
        // TODO
        return null;
    }
    
    public ArrayList<Recipe> getLikedRecipes(String username) throws ClassNotFoundException, SQLException
    {
        // TODO
        return null;
    }
    
    private static Recipe readNextRecipe(ResultSet resultSet) throws SQLException
    {
        // TODO
        return null;
    }
    
    public Recipe addRecipe(Recipe recipe) throws ClassNotFoundException, SQLException
    {
        // TODO
        return null;
    }
    
    private int getGeneratedId(PreparedStatement statement) throws SQLException
    {
        try (ResultSet generatedKeys = statement.getGeneratedKeys())
        {
            if (generatedKeys.next())
                return generatedKeys.getInt(1);
            throw new SQLException("Failed to read generated id.");
        }
    }
    
    public boolean addLike(String username, int recipeId) throws ClassNotFoundException, SQLException
    {
        // TODO
        return false;
    }
    
    public boolean deleteLike(String username, int recipeId) throws ClassNotFoundException, SQLException
    {
        // TODO
        return false;
    }
}
