package com.vehicles.repositories;

import com.vehicles.models.Brand;
import com.vehicles.models.Vehicle;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class VehicleRepository {
    private final String connectionUrl;
    private final String username;
    private final String password;

    public VehicleRepository()
    {
        String databaseName = "dev_store";
        this.connectionUrl = "jdbc:mariadb://localhost:3306/" + databaseName;
        this.username = "root";
        this.password = "admin";
    }

    public Vehicle getVehicle(int id) throws ClassNotFoundException, SQLException
    {
        Class.forName("org.mariadb.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(connectionUrl,username,password))
        {
            String query = "SELECT id, brand_id, model, year, price  " +
                           "FROM vehicles  " +
                           "WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next())
                return readNextVehicle(resultSet);
            
            return null;
        }
    }

    public ArrayList<Vehicle> getVehiclesByBrand(int brandId) throws ClassNotFoundException, SQLException
    {
        Class.forName("org.mariadb.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(connectionUrl,username,password))
        {
            String query = "SELECT id, brand_id, model, year, price \n" +
                           "FROM vehicles \n" +
                           "WHERE brand_id = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,brandId);

            ResultSet resultSet = statement.executeQuery();
            ArrayList<Vehicle> vehicles = new ArrayList<>();

            while(resultSet.next())
                vehicles.add(readNextVehicle(resultSet));

            if(vehicles.isEmpty())
                return null;

            return vehicles;
        }
    }
    public ArrayList<Vehicle> getVehicles() throws ClassNotFoundException, SQLException
    {
        Class.forName("org.mariadb.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(connectionUrl,username, password))
        {
            String query = "SELECT id, brand_id, model, year, price \n" +
                           "FROM vehicles";


            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();
            ArrayList<Vehicle> vehicles = new ArrayList<>();
            while(resultSet.next())
            {
                vehicles.add(readNextVehicle(resultSet));
            }

            if(vehicles.isEmpty())
                return null;

            return vehicles;
        }
    }

    public Vehicle addVehicle(Vehicle vehicle, Brand brand) throws ClassNotFoundException, SQLException
    {
        Class.forName("org.mariadb.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(connectionUrl,username,password))
        {
            String query = "INSERT INTO vehicles (brand_id, model, year, price) VALUES (?,?,?,?);";
            PreparedStatement statement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);

            statement.setInt(1,brand.getId());
            statement.setString(2,vehicle.getModel());
            statement.setObject(3,vehicle.getYear());
            statement.setFloat(4,vehicle.getPrice());

            int rowsAffected = statement.executeUpdate();
            if(rowsAffected > 0)
            {
                return new Vehicle(getGeneratedId(statement),vehicle);
            }
            //TODO: Why I'm not returning anything here.
            throw new SQLException("Failed to create student.");
        }
    }

    public boolean updateVehicle(Vehicle vehicle, Brand brand) throws ClassNotFoundException, SQLException
    {
        Class.forName("org.mariadb.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(connectionUrl,username,password))
        {
            String query = "UPDATE vehicles SET brandId = ?, model = ?, year = ?, price = ? WHERE v.id = ? ";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,brand.getId());
            statement.setString(2,vehicle.getModel());
            statement.setObject(3,vehicle.getYear());
            statement.setFloat(4,vehicle.getPrice());
            statement.setInt(5,vehicle.getId());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        }
    }

    public boolean removeVehicle(Vehicle vehicle) throws ClassNotFoundException, SQLException
    {
        Class.forName("org.mariadb.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(connectionUrl, username,password))
        {
            String query = "DELETE FROM vehicles WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,vehicle.getId());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        }
    }

        private int getGeneratedId(PreparedStatement statement) throws SQLException {
            try(ResultSet generatedKeys = statement.getGeneratedKeys())
            {
                if(generatedKeys.next())
                    return generatedKeys.getInt(1);
                throw new SQLException("Created Vehicle but failed to read generated Id.");
            }
        }
    private Vehicle readNextVehicle(ResultSet resultSet) throws SQLException
    {
         int id = resultSet.getInt("id");
         int brandId = resultSet.getInt("brand_id");
         String model = resultSet.getString("model");
         float price = resultSet.getFloat("price");
         int year = resultSet.getInt("year");

         return new Vehicle(id, brandId, model, price, year);
    }

}
