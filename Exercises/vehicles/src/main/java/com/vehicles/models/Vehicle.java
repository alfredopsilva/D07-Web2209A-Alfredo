package com.vehicles.models;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

public class Vehicle {
    private int id;
    private int brandId;
    private String model;
    private float price;
    private int year ;

    //Constructors
    public Vehicle(int brand_id, String model, float price, int year) {
        this.brandId = brand_id;
        this.model = model;
        this.price = price;
        this.year = year;
        this.id = 0;
    }
    public Vehicle(int id, Vehicle original) {
        this.id = id;
        this.brandId = original.brandId;
        this.model = original.model;
        this.price = original.price;
        this.year = original.year;
    }

    //TODO: Why just this constructor have validation of Objects.requireNonNull.
    public Vehicle(int id, int brandId, String model, float price, int year) {
        this.id = id;
        this.brandId = brandId;
        this.model = Objects.requireNonNull(model);
        this.price = price;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public int getBrandId() {
        return brandId;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
