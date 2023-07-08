package ca.collegeuniversel.recipes.repositories;

import ca.collegeuniversel.recipes.entities.Recipe;
import ca.collegeuniversel.recipes.entities.RecipeCategory;

import java.sql.*;
import java.util.ArrayList;

public class RecipeRepository
{
    private final String connectionUrl;
    private final String connectionUsername;
    private final String connectionPassword;

    public RecipeRepository()
    {        
        String databaseName = "recipes_db";
        connectionUrl = "jdbc:mariadb://localhost:3315/" + databaseName;
        connectionUsername = "root";
        connectionPassword = "admin";
    }
    
    public Recipe getRecipe(int id) throws ClassNotFoundException, SQLException
    {
        // TODO
        Class.forName("org.mariadb.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(connectionUrl,connectionUsername,connectionPassword))
        {
            String query = "SELECT id, name, description, image_path, category_id FROM recipes WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next())
                return readNextRecipe(resultSet);

            return null;
        }
    }
    
    public ArrayList<Recipe> getRecipes() throws ClassNotFoundException, SQLException {
        // TODO
        Class.forName("org.mariadb.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionUrl, connectionUsername, connectionPassword)) {
            String query = "SELECT id, name, description, image_path, category_id FROM recipes ORDER BY name\n";

            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            ArrayList<Recipe> recipes = new ArrayList<>();

            while (resultSet.next())
                recipes.add(readNextRecipe(resultSet));

            if (recipes.isEmpty())
                return null;

            return recipes;
        }
    }
    public ArrayList<Recipe> getRecipesByCategory(RecipeCategory category) throws ClassNotFoundException, SQLException
    {
        return getRecipesByCategory(category.getId());
    }
    
    public ArrayList<Recipe> getRecipesByCategory(int categoryId) throws ClassNotFoundException, SQLException
    {
        // TODO
        Class.forName("org.mariadb.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionUrl, connectionUsername, connectionPassword)) {
            String query = "SELECT id, name, description, image_path, category_id FROM recipes\n" +
                           "WHERE category_id = ?\n" +
                           "ORDER BY name";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, categoryId);

            ResultSet resultSet = statement.executeQuery();

            ArrayList<Recipe> recipes = new ArrayList<>();

            while (resultSet.next())
                recipes.add(readNextRecipe(resultSet));

            if (recipes.isEmpty())
                return null;

            return recipes;
        }
    }
    
    public ArrayList<Recipe> getLikedRecipes(String username) throws ClassNotFoundException, SQLException
    {
        // TODO
        Class.forName("org.mariadb.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionUrl, connectionUsername, connectionPassword)) {
            String query = "SELECT r.id, r.name, r.description, r.image_path, r.category_id FROM recipes r\n" +
                           "INNER JOIN likes l\n" +
                           "ON r.id = l.recipe_id\n" +
                           "WHERE l.username = ?\n" +
                           "ORDER BY r.name";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();

            ArrayList<Recipe> recipes = new ArrayList<>();

            while (resultSet.next())
                recipes.add(readNextRecipe(resultSet));

            if (recipes.isEmpty())
                return null;

            return recipes;
        }
    }
    
    private static Recipe readNextRecipe(ResultSet resultSet) throws SQLException
    {
        // TODO
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String description = resultSet.getString("description");
        String imagePath = resultSet.getString("image_path");
        int categoryId = resultSet.getInt("category_id");

        return new Recipe(id,name,description,imagePath,categoryId);
    }
    
    public Recipe addRecipe(Recipe recipe) throws ClassNotFoundException, SQLException
    {
        // TODO
        Class.forName("org.mariadb.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(connectionUrl,connectionUsername,connectionPassword))
        {
            String query = "INSERT INTO recipes (name, description, image_path, category_id) VALUES(?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);

            statement.setString(1,recipe.getName());
            statement.setString(2,recipe.getDescription());
            statement.setString(3, recipe.getImagePath());
            statement.setInt(4,recipe.getCategoryId());

            int rowsAffected = statement.executeUpdate();

            if(rowsAffected > 0)
            {
                return new Recipe(getGeneratedId(statement),recipe);
            }
            throw new SQLException("Failed to create Recipe.");
        }
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
        Class.forName("org.mariadb.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(connectionUrl,connectionUsername,connectionPassword))
        {
            String query = "INSERT IGNORE INTO likes (username, recipe_id) VALUES(?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1,username);
            statement.setInt(2,recipeId);

            int rowsAffected = statement.executeUpdate();

            if(rowsAffected > 0)
                return true;

            throw new SQLException("Failed to add like.");
        }
    }
    
    public boolean deleteLike(String username, int recipeId) throws ClassNotFoundException, SQLException
    {
        // TODO
        Class.forName("org.mariadb.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(connectionUrl,connectionUsername,connectionPassword))
        {
            String query = "DELETE FROM likes WHERE username = ? AND recipe_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1,username);
            statement.setInt(2,recipeId);

            int rowsAffected = statement.executeUpdate();

            if(rowsAffected > 0)
                return true;

            throw new SQLException("Failed to delete Like.");
        }
    }
}
