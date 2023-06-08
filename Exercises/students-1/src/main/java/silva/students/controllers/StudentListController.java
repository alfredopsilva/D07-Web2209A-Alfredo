/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package silva.students.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import silva.students.models.Student;
import silva.students.repositories.StudentsRepository;

@WebServlet(name = "StudentListController" , urlPatterns = "/student-list")
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
        StudentsRepository repository = new StudentsRepository();
        ArrayList<Student> students = repository.getStudents(); 
        
        // Write to the response ( headers and body )
        response.setContentType("text/html;charset=UTF-8");
        
        
        try(PrintWriter out = response.getWriter())
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> First Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Students </h1>");
            out.println("<ul>");
            for(Student student : students) 
            {
                out.println("<li>" + student.toString() + "</li>");
            }
            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");


            
        }
    }
    
}
