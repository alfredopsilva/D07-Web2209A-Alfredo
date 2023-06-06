/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package silva.firstservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FirstServlet", urlPatterns = {"/alfredo"})

/**
 * @author alfredoparreira
 */
public class FirstServlet extends HttpServlet 
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Read Data from the request
        // Validation of request data
        // Processing ( database access, business logic ... )
        // Write data into the response
        
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title> First Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1> Teste </h1>");
        out.println("<h1> Teste </h1>");
        out.println("<h1> Teste </h1>");
        out.println("</body>");
        out.flush();
        
    }
    
}
