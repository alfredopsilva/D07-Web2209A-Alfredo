package com.routing.routing;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(name = "Router", urlPatterns = {"/router", ""})

public class Router extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageRequest = request.getParameter("page");


        if(pageRequest == null){
            request.getRequestDispatcher("WEB-INF/index.html").forward(request,response);
            return;
        }

        switch(pageRequest)
        {
            case "1":
                request.getRequestDispatcher("WEB-INF/index.html").forward(request,response);
                break;
            case "2":
                request.getRequestDispatcher("WEB-INF/page2.html").forward(request,response);
                break;
            case "3":
                request.getRequestDispatcher("WEB-INF/page3.html").forward(request,response);
                break;
            case "4":
                request.getRequestDispatcher("WEB-INF/page4.html").forward(request,response);
                break;
        }
    }
}
