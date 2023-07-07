package ca.collegeuniversel.recipes.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "LogOutController", urlPatterns = { "/logout" })
public class LogOutController extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // TODO
        HttpSession session = request.getSession(true);
        session.removeAttribute("loggedUser");
        request.getRequestDispatcher("WEB-INF/login.jsp").forward(request,response);
    }
}
