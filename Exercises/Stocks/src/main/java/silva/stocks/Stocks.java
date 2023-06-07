/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package silva.stocks;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;
import silva.stocks.utility.CurrencyHelper;


@WebServlet(name = "Stocks", urlPatterns = {"/"})
/**
 *
 * @author alfredoparreira
 */
public class Stocks extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         
        // Refreshing the page at a defined interval
        response.addIntHeader("refresh", 5);
        
        // Generating Random number
        Random random = new Random(); 
        
        
        //Formatting Object
        NumberFormat formatter = CurrencyHelper.getCurrencyFormatter(Locale.US);
        double currency = 123.45; 
        
        // Write Data
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title> First Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Stocks</h1>");
        out.println("<p>Oracle : " + formatter.format(random.nextDouble() * 100) + "</p>");
        out.println("<p>Microsoft : " + formatter.format(random.nextDouble() * 100) + "</p>");
        out.println("<p>Google : " + formatter.format(random.nextDouble() * 100) + "</p>");
        out.println("</body>");
        out.flush();
         
         
    }
}
