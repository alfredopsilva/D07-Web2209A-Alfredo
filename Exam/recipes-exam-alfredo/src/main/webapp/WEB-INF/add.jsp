<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // TODO
    String errorMessage = (String) request.getAttribute("error-message");
    String sucessMessage = (String) request.getAttribute("sucess-message");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css" />
        <title>Add Recipe</title>
    </head>
    <body>
        <!-- TODO -->
        <form action="<%=request.getContextPath()%>/add" method="POST" class="form__add">
            <fieldset>
                <legend>Add Recipe</legend>

                <label for="name">Name</label>
                <input type="text" name="name" id="name">

                <label for="description">Description</label>
                <input type="text" name="description" id="description">

                <label for="imagePath">Image Path</label>
                <input type="text" name="imagePath" id="imagePath">

                <label for="categoryId">Category Id</label>
                <input type="text" name="categoryId" id="categoryId">

                <%if(errorMessage != null) {%>
                    <%="<p class='error'>"+errorMessage+"</p>"%>
                <% } %>

                <%if(sucessMessage != null) {%>
                    <%="<p class='error'>"+sucessMessage+"</p>"%>
                <% } %>

                <button>Add</button>
            </fieldset>
        </form>
        <a href="<%=request.getContextPath()%>/recipes">View recipes</a>
    </body>
</html>
