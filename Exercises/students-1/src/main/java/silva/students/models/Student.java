/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package silva.students.models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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

  

    public Student(String firstName, String lastName, LocalDate dateOfBirth) {
        this.id = nextId++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }
    
    
    public int getId()
    {
        return id;
    }
    
    public String getFirstName() 
    {
        return firstName;
    }
    
    public String getLastName() 
    {
        return lastName;
    }

    public LocalDate getDateOfBirth() 
    {
        return dateOfBirth;
    }
    
    public void setFirstName(String firstName) 
    {
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName) 
    {
        this.lastName = lastName;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) 
    {
        this.dateOfBirth = dateOfBirth;
    }
    
    public int getAge()
    {
        LocalDate now = LocalDate.now(); 
        return (int)ChronoUnit.YEARS.between(dateOfBirth,now);
        
        
    }

    @Override
    public String toString() {
        return "Student " +  id + " " + firstName + " " + lastName + 
                '\n' + "Date of Birth:" + dateOfBirth + 
                '\n' + "Age:" + getAge();
    }
    
    
    
}
