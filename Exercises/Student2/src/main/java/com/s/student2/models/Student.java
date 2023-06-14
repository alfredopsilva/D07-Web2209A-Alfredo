/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.s.student2.models;

import com.s.student2.utility.Validation;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 *
 * @author alfredoparreira
 */
public class Student {
    private final String id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private boolean gratuate;

    //Constructor
    public Student(String id,String firstName, String lastName, LocalDate dateOfBirth, boolean graduate) {

        this.id = Objects.requireNonNull(id);
        this.firstName = Objects.requireNonNull(firstName, "First Name can't be null.");
        this.lastName = Objects.requireNonNull(lastName, "Last Name can't be null.");
        this.dateOfBirth = Validation.checkDate(dateOfBirth);
        this.gratuate = graduate;
    }

    //Getters
    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getAge() {
        LocalDate now = LocalDate.now();
        Period period = Period.between(dateOfBirth, now);
        return period.getYears();
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
    public boolean isGraduate()
    {
        return gratuate;
    }

    //Setters
    public void setFirstName(String firstName) {
        this.firstName = Validation.checkString(firstName, "Your first name must be valid.");
    }

    public void setLastName(String lastName) {
        this.lastName = Validation.checkString(lastName, "Your last name must be valid.");
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = Validation.checkDate(dateOfBirth);
    }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    //To string
    @Override
    public String toString() {
        return "Student : " + id 
                + "<br>" +"Name : "+ getFullName()
                + "<br>" + "Date of Birth : " + formatter.format(dateOfBirth)
                + "<br>" + "Age : " + getAge();
    }
}
