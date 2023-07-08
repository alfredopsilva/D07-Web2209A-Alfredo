package ca.collegeuniversel.recipes.controllers;

import ca.collegeuniversel.recipes.entities.Recipe;
import ca.collegeuniversel.recipes.repositories.RecipeRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "AddRecipeController", urlPatterns = { "/add" })
public class AddRecipeController extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
       request.getRequestDispatcher("WEB-INF/add.jsp").forward(request,response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // TODO
        try {
            //Creating Repository
            RecipeRepository recipeRepository = new RecipeRepository();

            //Retrieving Parameters
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            String imagePath = request.getParameter("imagePath");
            String categoryId = request.getParameter("categoryId");

            //Parsing
            int categoryIndex = 0;
            if(categoryId != null)
                categoryIndex = Integer.parseInt(categoryId);

            Recipe addedRecipe = recipeRepository.addRecipe(new Recipe(name,description,imagePath,categoryIndex));

            request.setAttribute("sucess-message", "Your receipt was successfully created!");

        } catch (ClassNotFoundException | SQLException e) {
            request.setAttribute("error-message", e.getMessage());

        }

        request.getRequestDispatcher("WEB-INF/add.jsp").forward(request,response);
    }
}
