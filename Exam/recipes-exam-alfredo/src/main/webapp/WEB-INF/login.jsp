<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // TODO
    String errorMessage = (String) request.getAttribute("error-message");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css" />
        <title>Log in</title>
    </head>
    <body>
        <!-- TODO -->
        <main>
            <form action="/recipes_exam_alfredo/login" method="POST" class="form__login">
                <fieldset>
                    <legend>Log in</legend>
                    <label for="username">Username</label>
                    <input type="text" name="username" id="username">
                    <label for="password">Username</label>
                    <input type="password" name="password" id="password">
                    <%--            TODO: configure error message.--%>
                    <%if(errorMessage != null) {%>
                        <%="<p class='error'>"+errorMessage+"</p>"%>
                    <% } %>
                    <button>Log in</button>
                </fieldset>
            </form>
        </main>

    </body>
</html>
