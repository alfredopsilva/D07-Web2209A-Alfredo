package com.tasks.controller;

import com.tasks.model.Task;
import com.tasks.service.TaskService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;

@WebServlet(name="TaskController", urlPatterns = {"","/task"})
public class TaskController extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession(true);
        TaskService taskService = new TaskService(session);
        request.setAttribute("tasksList", taskService.getTasks());
        String id = (String)request.getParameter("id");
        session.setAttribute("id",id);

        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession(true);
        String taskName = request.getParameter("taskName");
        TaskService taskService = new TaskService(session);
        taskService.addTask(taskName);
        session.setAttribute("taskList",taskService.getTasks());
        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request,response);
    }

    protected void processRequest(String action, String Id, HashMap<String, Task> tasks)
    {

    }

}