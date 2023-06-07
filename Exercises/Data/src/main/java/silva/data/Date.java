/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package silva.data;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "Date", urlPatterns = "/")

/**
 *
 * @author alfredoparreira
 */
public class Date extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.addIntHeader("refresh", 5);
        
        
        LocalDateTime now = LocalDateTime.now(); 
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        
        
        PrintWriter out = response.getWriter(); 
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title> First Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Dates</h1>");
        out.println("<p>Current Time : " + now + "</p>");
        out.println("<p>Current Formated Date : " + dateFormatter.format(now) + "</p>");
        out.println("<p>Current Formated Date : " + timeFormatter.format(now) + "</p>");
        out.println("</body>");
        out.flush();
     
    }
    
}
