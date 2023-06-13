<%@ page import="com.s.student2.models.Student" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: alfredoparreira
  Date: 2023-06-12
  Time: 3:02 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<Student> students = (ArrayList<Student>) request.getAttribute("students");
%>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>Title</title>
</head>
<body>
    <section>
        <h1>Students</h1>
        <% for (Student student : students) {%>
            <%="<a href='students?id=" + student.getId() + "'>" + student.getFullName() + "</a>"%>
            <%="<ul>"%>
                <%="<li>"%>
                    <%="<p>ID: " + student.getId() + "</p>"%>
                <%="</li>"%>
                <%="<li>"%>
                    <% if (student.isGraduate() == true) { %>
                    <%= "<p>Graduated</p>"%>
                <% } else { %>
                    <%= "<p>Not Graduated</p>"%>
                <% } %>
                <%="</li>"%>
            <%="</ul>"%>
        <% } %>
    </section>
</body>
</html>
