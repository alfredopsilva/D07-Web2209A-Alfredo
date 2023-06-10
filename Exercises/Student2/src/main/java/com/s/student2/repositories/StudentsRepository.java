/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.s.student2.repositories;

import com.s.student2.models.Student;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

/**
 *
 * @author alfredoparreira
 */
public class StudentsRepository 
{
    
    public ArrayList<Student> getStudents()
    {   
        //Creating HashMap structure.
        HashMap<String,Student> students2 = new HashMap<>();
        
        //Addings students to HashMap
        students2.put("1000",new Student("Alfredo","Silva", LocalDate.of(1990, 9, 19),false));
        students2.put("1001",new Student("Rehman","Basharat", LocalDate.of(2002, 9, 9),false));
        students2.put("1002",new Student("Ning","Zheng", LocalDate.of(1994, 12, 26),false));

        ArrayList<Student> students = new ArrayList<>(students2.values());


        return Collections.sort(students);
    } 
    
}
