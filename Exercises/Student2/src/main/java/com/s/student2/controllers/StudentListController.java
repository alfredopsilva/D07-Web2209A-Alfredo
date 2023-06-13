/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.s.student2.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.s.student2.models.Student;
import com.s.student2.repositories.StudentsRepository;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet(name = "StudentListController" , urlPatterns = {"/students", ""})
/**
 *
 * @author alfredoparreira
 */
public class StudentListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // First thing is looking into request to see what was sent.
        // Validate parameters
        // Process the request (Database CRUD, send email, do whatever else needs to be done)

        String id = request.getParameter("id");

        StudentsRepository repository = new StudentsRepository();


        // Think on error -- always redirect to students.jsp if I don't have a valid Id.

        if(id == null || id.isBlank())
        {
            ArrayList<Student> students = repository.getStudents();
            request.setAttribute("students", students);
            request.getRequestDispatcher("WEB-INF/students.jsp").forward(request,response);
        }
        else
        {
        Student student = repository.getStudent(id);
        request.setAttribute("student", student);
        request.getRequestDispatcher("WEB-INF/student.jsp").forward(request,response);

        }

    }
    
}
