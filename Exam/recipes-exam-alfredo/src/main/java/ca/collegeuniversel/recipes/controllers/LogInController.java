package ca.collegeuniversel.recipes.controllers;

import ca.collegeuniversel.recipes.entities.User;
import ca.collegeuniversel.recipes.exceptions.UserException;
import ca.collegeuniversel.recipes.exceptions.ValidationException;
import ca.collegeuniversel.recipes.services.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LogInController", urlPatterns = { "/login" })
public class LogInController extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // TODO
        request.getRequestDispatcher("WEB-INF/login.jsp").forward(request,response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try
        {
            //Creating UserService object to validate login.
            UserService userService = new UserService();

            //Validating Login
            if(!username.isBlank() && !password.isBlank())
            {
                User loggedUser = userService.logIn(username,password);

                if(loggedUser != null)
                {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("loggedUser", loggedUser);
                    String path = request.getContextPath()+"/recipes";
//                    request.getRequestDispatcher(path).forward(request,response);
                    response.sendRedirect(path);
                }

            }
            else
            {
                request.setAttribute("error-message","Incorrect username or password.");
            }

        } catch (ValidationException | SQLException  | ClassNotFoundException e) {
            request.setAttribute("error-message",e.getMessage());
            request.getRequestDispatcher("WEB-INF/login.jsp").forward(request,response);

        }
        catch (UserException e)
        {
            request.setAttribute("error-message",e.getMessage());
            request.getRequestDispatcher("WEB-INF/login.jsp").forward(request,response);
        }

    }
}
