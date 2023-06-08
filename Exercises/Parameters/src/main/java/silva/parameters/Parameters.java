/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package silva.parameters;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet(name = "Parameters", urlPatterns = "/sign-up")
/**
 *
 * @author alfredoparreira
 */
public class Parameters extends HttpServlet
{
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        
        //Getting and Storing Values
        String firstName = request.getParameter("firstName"); 
        String lastName = request.getParameter("lastName"); 
        String course = request.getParameter("course");
        String time = request.getParameter("time");
        String[] semesters = request.getParameterValues("semester");
        
        
        try(PrintWriter out = response.getWriter())
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> First Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            
            if(firstName != null)
            {
                out.println("<p> First Name: " + firstName + "</p>" );
            }
            else
            {
                 out.println("<p> First Name: No name!</p>" );
            }
            
            if(lastName != null)
            {
                out.println("<p> Last Name: " + lastName + "</p>" );
            }
            else
            {
                 out.println("<p> First Name: No name!</p>" );
            }
            
            out.println("<p> Course: " + course + "</p>" );
            out.println("<p> Time: " + time + "</p>" );
            out.println("<p> Semester: (");
            
            for(String semester : semesters)
            {
                out.println(semester);
            }
            out.println(")</p>");

            out.flush(); 
   
        }
       
    }
    
}
