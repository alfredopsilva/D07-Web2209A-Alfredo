package ca.collegeuniversel.recipes.controllers;

import ca.collegeuniversel.recipes.entities.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "HomeController", urlPatterns = { "" })
public class HomeController extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("user");
        if (user != null)
        {
            response.sendRedirect("recipes");
        }
        else
        {
            session.invalidate();
            response.sendRedirect("login");
        }
    }
}
