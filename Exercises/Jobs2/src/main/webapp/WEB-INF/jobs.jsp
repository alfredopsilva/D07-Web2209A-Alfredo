<%@ page import="com.jobs2.jobs2.models.JobType" %>
<%@ page import="com.jobs2.jobs2.models.Job" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.jobs2.jobs2.repository.JobRepository" %><%--
  Created by IntelliJ IDEA.
  User: alfredoparreira
  Date: 2023-06-10
  Time: 11:20 a.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    ArrayList<Job> jobs = (ArrayList)request.getAttribute("jobs");
    String jobRequest = (String)request.getAttribute("jobRequest");
%>


<html>
<head>
    <%= "<title>" + jobRequest + "Jobs</title>"%>
</head>
<body>
    <%="<h1>" + jobRequest + " Jobs</h1>"%>
    <%="<ul>"%>
    <% for(Job job : jobs) {%>
        <%="<li>" + job.getTitle() + "</li>"%>
    <%}%>
    <%="</ul>"%>
    <a href='/jobs2/'>Return</a>
    <%="</body>"%>
    <%="</html>"%>
</body>
</html>
