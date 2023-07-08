package ca.collegeuniversel.recipes.controllers;

import ca.collegeuniversel.recipes.entities.User;
import ca.collegeuniversel.recipes.repositories.RecipeRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LikeRecipeController", urlPatterns = { "/like" })
public class LikeRecipeController extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            //Creating Session
            HttpSession session = request.getSession(true);

            //Retrieving Parameter and Logged User
            String recipeId = request.getParameter("recipeId");
            User loggedUser = (User) session.getAttribute("loggedUser");

            //Creating Repository and Adding Like to DB.
            RecipeRepository recipeRepository = new RecipeRepository();
            recipeRepository.addLike(loggedUser.getUsername(),Integer.parseInt(recipeId));
            session.setAttribute("likedRecipes",recipeRepository.getLikedRecipes(loggedUser.getUsername()));
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw new RuntimeException(e);
        }

        request.getRequestDispatcher("WEB-INF/recipes.jsp").forward(request,response);
    }
}
