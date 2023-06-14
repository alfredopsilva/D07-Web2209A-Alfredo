/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.s.student2.repositories;

import com.s.student2.models.Student;
import com.s.student2.utility.Validation;

import java.time.LocalDate;
import java.util.*;

/**
 *
 * @author alfredoparreira
 */
public class StudentsRepository 
{
    private HashMap<String,Student> students;


    public StudentsRepository()
    {
        students = new HashMap<>();

        var alfredo = new Student("1000","Alfredo","Silva", LocalDate.of(1990, 9, 19),false);
        students.put(alfredo.getId(),alfredo);

        var rehman = new Student("1001","Rehman","Basharat", LocalDate.of(2002, 9, 9),false);
        students.put(rehman.getId(),rehman);

        var ning = new Student("1002","Ning","Zheng", LocalDate.of(1994, 12, 26),false);
        students.put(ning.getId(),ning);

    }


    public ArrayList<Student> getStudents()
    {
        ArrayList<Student> studentsList = new ArrayList<>(students.values());

        studentsList.sort(Comparator.comparing(Student::getFullName));

        return studentsList;
    }

    public Student getStudent(String id)
    {
        //Converting int id to String and Checking if it's valid.
        String stringId = Validation.checkString(id, "Your ID must be a valid number.");

        // Checking if HashMap contains this key, if it contains, return the value.
        if(students.containsKey(stringId))
            return students.get(stringId);

        return null;
    }

    public boolean isEnrolled(String id)
    {
        //Converting int id to String.
        String stringId = Validation.checkString(id, "Your ID must be a valid number.");
        return students.containsKey(stringId);
    }

}
