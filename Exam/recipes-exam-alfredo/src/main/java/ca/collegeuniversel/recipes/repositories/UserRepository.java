package ca.collegeuniversel.recipes.repositories;

import ca.collegeuniversel.authentication.HashedPassword;
import ca.collegeuniversel.recipes.entities.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository
{
    private final String connectionUrl;
    private final String connectionUsername;
    private final String connectionPassword;
    
    public UserRepository()
    {
        String databaseName = "recipes_db";
        connectionUrl = "jdbc:mariadb://localhost:3315/" + databaseName;
        connectionUsername = "root";
        connectionPassword = "admin";
    }
    
    public User getUser(String username) throws ClassNotFoundException, SQLException
    {
        Class.forName("org.mariadb.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionUrl, connectionUsername, connectionPassword))
        {
            String query = "SELECT username, password_salt, password_hash, name FROM users WHERE username = ?";
            
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next())
                return readNextUser(resultSet);
            return null;
        }
    }
    
    private User readNextUser(ResultSet resultSet) throws SQLException
    {
        String username = resultSet.getString("username");
        byte[] passwordSalt = resultSet.getBytes("password_salt");
        byte[] passwordHash = resultSet.getBytes("password_hash");
        String name = resultSet.getString("name");
        
        HashedPassword password = new HashedPassword(passwordSalt, passwordHash);
        return new User(username, password, name);
    }
    
    public User addUser(User user) throws ClassNotFoundException, SQLException
    {
        Class.forName("org.mariadb.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionUrl, connectionUsername, connectionPassword))
        {
            String query = "INSERT INTO users (username, password_salt, password_hash, name) VALUES(?, ?, ?, ?)";
            
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getUsername());
            statement.setBytes(2, user.getPassword().getSalt());
            statement.setBytes(3, user.getPassword().getHash());
            statement.setString(4, user.getName());
            
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0)
                return user;
            throw new SQLException("Failed to add user: " + user);
        }
    }
}
