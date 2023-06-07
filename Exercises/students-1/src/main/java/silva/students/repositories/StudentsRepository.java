/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package silva.students.repositories;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import silva.students.models.Student;

/**
 *
 * @author alfredoparreira
 */
public class StudentsRepository 
{
    
    public ArrayList<Student> getStudents()
    {   
        
        var alfredo = new Student("Alfredo","Silva", LocalDate.of(1990, 9, 19));
        var gabriela = new Student("Alfredo","Silva", LocalDate.of(1990, 9, 19));
        var rehman = new Student("Alfredo","Silva", LocalDate.of(1990, 9, 19));
    } 
    
}
