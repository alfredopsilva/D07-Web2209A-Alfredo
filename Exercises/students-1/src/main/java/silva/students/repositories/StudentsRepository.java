/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package silva.students.repositories;

import java.time.LocalDate;
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
        //Creating ArrayList structure.
        ArrayList<Student> students = new ArrayList<>(); 
        
        //Addings students to ArrayList
        students.add(new Student("Alfredo","Silva", LocalDate.of(1990, 9, 19)));
        students.add(new Student("Rehman","Basharat", LocalDate.of(2002, 9, 9)));
        students.add(new Student("Ning","Zheng", LocalDate.of(1994, 12, 26)));
        
        return students;
    } 
    
}
