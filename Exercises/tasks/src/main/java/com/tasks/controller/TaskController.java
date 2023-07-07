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
        //Starting Session and TaskService.
        HttpSession session = request.getSession(true);
        TaskService taskService = new TaskService(session);

        //Setting an Initial TaskList.

        // Getting Parameters from Hyperlinks.
        String action = (String)request.getParameter("action");
        String id = (String)request.getParameter("id");

       // Switch with Procedures options.
       if(action != null)
       {
           switch (action)
           {
               case "remove":
                   taskService.removeTask(id);
                   break;
               case "reset":
                   taskService.resetTask(id);
                   break;
               case "complete":
                   taskService.completeTask(id);
                   break;
           }
       }

        request.setAttribute("tasksList", taskService.getTasks());
        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //Retrieving Session and Creating a TaskService.
        HttpSession session = request.getSession(true);
        String taskName = request.getParameter("taskName");
        TaskService taskService = new TaskService(session);

        //Calling AddTask
        taskService.addTask(taskName);

        //Setting List with Tasks.
        session.setAttribute("taskList",taskService.getTasks());


        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request,response);
    }
}