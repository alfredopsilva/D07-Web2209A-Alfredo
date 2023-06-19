package com.preferences.preferences;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Remember", urlPatterns = {"/remember"})
public class Remember extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = (String)request.getAttribute("name");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>TESTE</title>");
        out.println("<head>");
        out.println("<body>");
        out.println("<h1> REMEMBER </h1>");
        out.println("<h1> " + name  + "</h1>");
        out.println("</body>");
        out.println("</html>");
        out.flush();
    }
}
