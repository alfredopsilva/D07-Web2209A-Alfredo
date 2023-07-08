package ca.collegeuniversel.recipes.repositories;

import ca.collegeuniversel.recipes.entities.RecipeCategory;

import java.sql.*;
import java.util.ArrayList;

public class RecipeCategoryRepository
{
    private final String connectionUrl;
    private final String connectionUsername;
    private final String connectionPassword;

    public RecipeCategoryRepository()
    {
        String databaseName = "recipes_db";
        //TODO: Remember to return server to 3315;
        connectionUrl = "jdbc:mariadb://localhost:3315/" + databaseName;
        connectionUsername = "root";
        connectionPassword = "admin";
    }
    
    public RecipeCategory getCategory(int id) throws ClassNotFoundException, SQLException
    {
        Class.forName("org.mariadb.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(connectionUrl,connectionUsername,connectionPassword))
        {
            String query = "SELECT id, name, image_path FROM categories WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next())
                return readNextCategory(resultSet);

            return null;
        }
    }

    public ArrayList<RecipeCategory> getCategories() throws ClassNotFoundException, SQLException
    {
        // TODO
        Class.forName("org.mariadb.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(connectionUrl,connectionUsername,connectionPassword))
        {
            String query = "SELECT id, name, image_path FROM categories";

            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            ArrayList<RecipeCategory> categories = new ArrayList<>();

           while(resultSet.next())
                categories.add(readNextCategory(resultSet));

           if(categories.isEmpty())
                return null;

           return categories;
        }
    }

    private static RecipeCategory readNextCategory(ResultSet resultSet) throws SQLException
    {
        // TODO
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String imagePath = resultSet.getString("image_path");

        return new RecipeCategory(id,name,imagePath);
    }
}
