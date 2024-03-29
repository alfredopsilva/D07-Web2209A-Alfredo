/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package silva.students.models;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import javax.swing.text.DateFormatter;
import silva.students.utility.Validation;

/**
 *
 * @author alfredoparreira
 */
public class Student {

    //Threshold to generating ID's. 
    private static int nextId = 1000;

    private final int id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

    //Constructor
    public Student(String firstName, String lastName, LocalDate dateOfBirth) {
        this.id = nextId++;
        this.firstName = Objects.requireNonNull(firstName, "First Name can't be null.");
        this.lastName = Objects.requireNonNull(lastName, "Last Name can't be null.");
        this.dateOfBirth = Validation.checkDate(dateOfBirth);
    }

    //Getters
    public int getId() {
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

    //Setters
    public void setFirstName(String firstName) {
        this.firstName = Validation.checkString(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName = Validation.checkString(lastName);
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
