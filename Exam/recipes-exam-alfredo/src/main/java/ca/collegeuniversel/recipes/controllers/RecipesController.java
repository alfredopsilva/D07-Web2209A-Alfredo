package ca.collegeuniversel.recipes.controllers;

import ca.collegeuniversel.recipes.entities.RecipeCategory;
import ca.collegeuniversel.recipes.entities.User;
import ca.collegeuniversel.recipes.repositories.RecipeCategoryRepository;
import ca.collegeuniversel.recipes.repositories.RecipeRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "RecipesController", urlPatterns = { "/recipes" })
public class RecipesController extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // TODO
        try
        {
            //Creating HTTP Session;
            HttpSession session = request.getSession(true);

            // Creating Repositories.
            RecipeCategoryRepository recipeCategoryRepository = new RecipeCategoryRepository();
            RecipeRepository recipeRepository = new RecipeRepository();

            //Retrieving category id.
            String recipeCategory = request.getParameter("categorie");

            //Retrieving LoggedUser
            User loggedUser = (User) session.getAttribute("loggedUser");

            //Setting Inicial Liked Recipes.
            session.setAttribute("likedRecipes",recipeRepository.getLikedRecipes(loggedUser.getUsername()));


            //If is not select, by default will be All.
            if(recipeCategory == null)
            {
                recipeCategory = "All";
            }

            //Setting Id
            int category_id = 0;

            switch (recipeCategory)
            {
                case "All":
                    category_id = 0;
                    break;
                case "Sandwiches":
                    category_id = 1;
                    break;
                case "Soups":
                    category_id = 2;
                    break;
                case "Desserts":
                    category_id = 3;
                    break;
            }

            if(category_id == 0)
                session.setAttribute("recipes",recipeRepository.getRecipes());
            else
                session.setAttribute("recipes",recipeRepository.getRecipesByCategory(category_id));

            request.setAttribute("recipes-categories", recipeCategoryRepository.getCategories());
            request.getRequestDispatcher("WEB-INF/recipes.jsp").forward(request,response);

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
