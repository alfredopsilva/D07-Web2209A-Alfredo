<%@ page import="ca.collegeuniversel.recipes.entities.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ca.collegeuniversel.recipes.entities.RecipeCategory" %>
<%@ page import="ca.collegeuniversel.recipes.entities.Recipe" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // TODO
    User loggedUser = (User) session.getAttribute("loggedUser");
    ArrayList<RecipeCategory> recipeCategories = (ArrayList<RecipeCategory>) request.getAttribute("recipes-categories");
    ArrayList<Recipe> recipes = (ArrayList<Recipe>) session.getAttribute("recipes");
    ArrayList<Recipe> likedRecipes = (ArrayList<Recipe>) session.getAttribute("likedRecipes");

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recipes</title>
        <link rel="stylesheet" href="css/style.css" />
    </head>
    <body class="container vertical">
        <!-- TODO -->
    <section class="recipe__welcome">
        <h1>WELCOME <%=loggedUser.getName()%></h1>
        <div class="recipe__buttons">
            <a href="<%=request.getContextPath()%>/logout" class="recipe__button">Log out</a>
            <a href="<%=request.getContextPath()%>/add" class="recipe__button">Add recipe</a>
        </div>
    </section>
    <section class="recipes">
        <fieldset class="recipe__categories">
            <legend>Categories</legend>
            <%if(recipeCategories != null) { %>
                <a href="<%=request.getContextPath()%>/recipes?categorie=All">
                    <div class="recipe__categorieBox">
                        <h4 class="recipe__subtitle">All</h4>
                        <img src="images/categories/all.png" alt="" class="recipe__img">
                    </div>
                </a>
                <%for(RecipeCategory recipeCategory : recipeCategories) { %>
                    <a href="<%=request.getContextPath()%>/recipes?categorie=<%=recipeCategory.getName()%>">
                        <div class="recipe__categorieBox">
                            <h4 class="recipe__subtitle"><%=recipeCategory.getName()%></h4>
                            <img src="<%=recipeCategory.getImagePath()%>" class="recipe__img" alt="">
                        </div>
                    </a>
                <% } %>
            <% } %>
        </fieldset>
    </section>
    <section>
        <%for(Recipe recipe : recipes) {%>
            <div class="recipe__box">
                <div>
                    <h4 class="recipe__box-subtitle"><%=recipe.getName()%></h4>
                    <p class="recipe__box-description"><%=recipe.getDescription()%></p>
                    <%if(!likedRecipes.contains(recipe)) {%>
                        <a href="<%=request.getContextPath()%>/like?recipeId=<%=recipe.getId()%>">Like</a>
                    <%} else {%>
                        <a href="<%=request.getContextPath()%>/unlike?recipeId=<%=recipe.getId()%>">Unlike</a>
                    <% } %>
                </div>
                <img src="<%=recipe.getImagePath()%>" alt="" class="recipe__box-img">
            </div>
        <% } %>
    </section>
    </body>
</html>
