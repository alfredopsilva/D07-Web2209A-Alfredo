package com.vehicles.repositories;

import com.vehicles.models.Brand;

import java.sql.*;
import java.util.ArrayList;

public class BrandRepository {
    private final String connectionUrl;
    private final String username;
    private final String password;

    public BrandRepository() {
        String databaseName = "vehicles_db";
        this.connectionUrl = "jdbc:mariadb://localhost:3306/" + databaseName;
        this.username = "root";
        this.password = "admin";
    }

    public ArrayList<Brand> getBrands() throws ClassNotFoundException, SQLException
    {
        Class.forName("org.mariadb.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(connectionUrl,username,password))
        {
            String query = "SELECT * FROM brands";

            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();
            ArrayList<Brand> brands = new ArrayList<>();
            while(resultSet.next())
                brands.add(readNextBrand(resultSet));

            if(brands.isEmpty())
                return null;

            return brands;
        }
    }

    private Brand readNextBrand(ResultSet resultSet) throws SQLException
    {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");

        return new Brand(id, name);
    }
}
