package ca.collegeuniversel.recipes.controllers;

import ca.collegeuniversel.recipes.entities.Recipe;
import ca.collegeuniversel.recipes.entities.RecipeCategory;
import ca.collegeuniversel.recipes.repositories.RecipeCategoryRepository;
import ca.collegeuniversel.recipes.repositories.RecipeRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "TestController", urlPatterns = { "/test" })
public class TestController extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            testRecipeQueries();
            testAddRecipeCommand();
            testLikeRecipeCommands();
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw new ServletException(e.getMessage(), e);
        }
    }

    private void testRecipeQueries() throws ClassNotFoundException, SQLException
    {
        RecipeCategoryRepository categoryRepository = new RecipeCategoryRepository();
        RecipeRepository recipeRepository = new RecipeRepository();
        
        RecipeCategory category1 = categoryRepository.getCategory(1);
        RecipeCategory category2 = categoryRepository.getCategory(2);
        RecipeCategory category3 = categoryRepository.getCategory(3);
        RecipeCategory fakeCategory = categoryRepository.getCategory(999); // Null (fake id)
        
        ArrayList<RecipeCategory> categories = categoryRepository.getCategories(); // Size = 3
        
        Recipe recipe100001 = recipeRepository.getRecipe(100001);
        Recipe recipe100002 = recipeRepository.getRecipe(100002);
        Recipe recipe100003 = recipeRepository.getRecipe(100003);
        Recipe recipe100010 = recipeRepository.getRecipe(100010);
        Recipe fakeRecipe = recipeRepository.getRecipe(999); // Null (fake id)
        
        ArrayList<Recipe> allRecipes = recipeRepository.getRecipes(); // Size = 10
        
        ArrayList<Recipe> sandwichRecipes = recipeRepository.getRecipesByCategory(category1); // Size = 4
        ArrayList<Recipe> soupRecipes = recipeRepository.getRecipesByCategory(category2); // Size = 3
        ArrayList<Recipe> dessertRecipes = recipeRepository.getRecipesByCategory(category3); // Size = 3
        ArrayList<Recipe> fakeCategoryRecipes = recipeRepository.getRecipesByCategory(999); // Empty (fake id)
        
        ArrayList<Recipe> recipesLikedByAdmin = recipeRepository.getLikedRecipes("admin"); // Empty (user liked no recipes)
        ArrayList<Recipe> recipesLikedByAnna = recipeRepository.getLikedRecipes("anna"); // Size = 2
        ArrayList<Recipe> recipesLikedByCatherine = recipeRepository.getLikedRecipes("catherine"); // Size = 4
        ArrayList<Recipe> recipesLikedByFakeUser = recipeRepository.getLikedRecipes("fake"); // Empty (fake username)
        
        System.out.println();
    }
    
    private void testAddRecipeCommand() throws ClassNotFoundException, SQLException
    {
        RecipeRepository repository = new RecipeRepository();
        
        Recipe recipe = repository.addRecipe(new Recipe("Test name", "Test description", "Test image url", 1));
        recipe = repository.getRecipe(recipe.getId());
        // TODO: Manually delete test record from recipes database table
        
        System.out.println();
    }
    
    private void testLikeRecipeCommands() throws ClassNotFoundException, SQLException
    {
        RecipeRepository repository = new RecipeRepository();
        
        ArrayList<Recipe> recipesLikedByAdmin = repository.getLikedRecipes("admin"); // Empty (user liked no recipes)

        boolean added = repository.addLike("admin", 100002); // Added
        added = repository.addLike("admin", 100003); // Added
        added = repository.addLike("admin", 100002); // Not added (already added)
        added = repository.addLike("admin", 100003); // Not added (already added)

        recipesLikedByAdmin = repository.getLikedRecipes("admin"); // Size = 2

        boolean deleted = repository.deleteLike("admin", 100002); // Deleted
        deleted = repository.deleteLike("admin", 100003); // Deleted
        deleted = repository.deleteLike("admin", 100002); // Not deleted (already deleted)
        deleted = repository.deleteLike("admin", 100003); // Not deleted (already deleted)

        recipesLikedByAdmin = repository.getLikedRecipes("admin"); // Empty

        System.out.println();
    }
}
