<%@ page import="com.tasks.model.Task" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String message = (String)session.getAttribute("message");
    ArrayList<Task> taskList = (ArrayList<Task>) session.getAttribute("taskList");
    String id = (String)session.getAttribute("id");
%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/style.css">
    <title>JSP - Hello World</title>
</head>
<body>
    <form action="task" method="post">
        <fieldset>
            <legend>Add Task</legend>
            <input type="text" name="taskName" id="task">
            <input type="submit" value="Add" name="action">
            <p class="message"><%=message%></p>
        </fieldset>
    </form>
    <form action="">
        <fieldset>
            <legend>Tasks</legend>
            <ul>
                <%if(taskList != null){%>
                    <%for(Task task : taskList){%>
                    <li>
                        <p><%=task.getName()%></p>
                        <div>
                            <a href="task?id=<%=task.getId() + "&action=remove"%>">Remove</a>
                            <a href="task?id=<%=task.getId()%>&action=<%=task.isComplete() ? "reset" : "complete"%>">
                                <%=task.isComplete() ? "Reset" : "Complete"%>
                            </a>
                        </div>
                        <%="ID " + id +"</p>"%>
                    </li>
                    <%}%>
                <%}%>
            </ul>
        </fieldset>
    </form>
</body>
</html>