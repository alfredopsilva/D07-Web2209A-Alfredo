/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package silva.currency;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import silva.stocks.utility.CurrencyHelper;

@WebServlet(name = "Conversion", urlPatterns = "/conversion")
/**
 *
 * @author alfredoparreira
 */
public class Conversion extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        // Getting and Storing data from Request
        String amountString = request.getParameter("cad");
        String currency = request.getParameter("currency");

        //Local Variables
        double inputAmount = 0;
        double outputAmount = 0;
        String errorMessage = null;
        boolean errorFlag = false;
        Locale local = null;
        var brazilLocale = Locale.of("pt", "BR"); 

        //Parsing data into Double.
        try {
            inputAmount = Double.parseDouble(amountString);
        } catch (Exception e) {
            errorMessage = "Sorry, try again.";
            errorFlag = true;
        }

        // Validating if Amount can be converted
        if (inputAmount <= 0) {
            errorMessage = "You must enter a positive value!";
            errorFlag = true;
        }

        // Setting Formater
        switch (currency) {
            case "eur":
                local = Locale.ITALY;
                break;
            case "usd":
                local = Locale.US;
                break;
            case "brl":
                local = brazilLocale;
                break;

            default:
                errorMessage = "Switch Error!";
        }

        NumberFormat formatter = CurrencyHelper.getCurrencyFormatter(local);
        NumberFormat originFormatter = CurrencyHelper.getCurrencyFormatter(Locale.CANADA);
    

        //Calculating output value
        switch (currency) {
            case "eur":
                outputAmount = inputAmount * .69;
                break;
            case "usd":
                outputAmount = inputAmount * .75;
                break;
            case "brl":
                outputAmount = inputAmount * 3.69;
                break;
            default:
                errorMessage = "Switch Conversion Error!";
        }
        //
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> First Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            if (!errorFlag) {
                out.println("<h1>" + originFormatter.format(inputAmount) + " = "
                        + formatter.format(outputAmount) + "</h1>");

            }
            else 
            {
                out.println("<p>" + errorMessage + "</p>");
            }
            out.println("<a href='index.html'>Return</a>");
            out.flush(); 
        }

    }

}
