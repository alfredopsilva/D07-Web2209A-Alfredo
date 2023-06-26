<%@ page import="com.tasks.model.Task" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String message = (String)session.getAttribute("message");
    ArrayList<Task> taskList = (ArrayList<Task>) session.getAttribute("taskList");
    int status = 0;
    if(session.getAttribute("status") != null)
    {
        status = (int)session.getAttribute("status");
    }
//    int status = 0;
//    if(stringStatus != null){
//        status = Integer.parseInt(stringStatus);
//    }
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
            <%if(message != null){%>
                <p class="message <%=status == 200 ? "sucess" : "error"%>" ><%=message%></p>
                <%System.out.println(status);%>
            <%}%>
        </fieldset>
    </form>
    <form action="">
        <fieldset>
            <legend>Tasks</legend>
            <ul>
                <%if(taskList != null){%>
                    <%for(Task task : taskList){%>
                    <li>
                        <p class="<%=task.isComplete() ? "task complete" : "task"%>"><%=task.getName()%></p>
                        <div class="links">
                            <a href="task?id=<%=task.getId() + "&action=remove"%>">Remove</a>
                            <a href="task?id=<%=task.getId()%>&action=<%=task.isComplete() ? "reset" : "complete"%>">
                                <%=task.isComplete() ? "Reset" : "Complete"%>
                            </a>
                        </div>
                    </li>
                    <%}%>
                <%}%>
            </ul>
        </fieldset>
    </form>
</body>
</html>