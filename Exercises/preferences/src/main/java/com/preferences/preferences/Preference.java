package com.preferences.preferences;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "Preference",urlPatterns = {"", "/preference"})

public class Preference extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // Retrieving Array of Cookies.
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies)
        {
            System.out.println(cookie.getName());
        }

        // Retrieving Parameters
        String nameParameter = request.getParameter("name");
        boolean rememberParameter = Boolean.parseBoolean(request.getParameter("remember"));
        String colorParameter = request.getParameter("color");

        //Creating Cookies
        Cookie name = getCookie(cookies,"name");
        Cookie color = getCookie(cookies,"color");
        Cookie remember = getCookie(cookies,"remember");

        Cookie teste = new Cookie("teste","issoeumtest");
        teste.setMaxAge(60);
        response.addCookie(teste);


        if(name != null)
        {
            request.setAttribute("name",nameParameter);
        }
        else
        {
            name = new Cookie("name", nameParameter);
            name.setMaxAge(60 * 60 * 24 * 365);
            response.addCookie(name);
            request.setAttribute("name",nameParameter);
        }

        if(color != null)
        {
            colorParameter = color.getValue();
            request.setAttribute("color", colorParameter);
        }
        else
        {
            color = new Cookie("color",colorParameter);
            color.setMaxAge(60 * 60 * 24 * 365);
            response.addCookie(color);
            request.setAttribute("color",colorParameter);
        }

        if(remember != null)
        {
            rememberParameter = Boolean.parseBoolean(remember.getValue());
            request.setAttribute("remember",rememberParameter);
        }
        else
        {
            remember = new Cookie("remember",Boolean.toString(rememberParameter));
            remember.setMaxAge(60 * 60 * 24 * 365);
            request.setAttribute("remember", Boolean.toString(rememberParameter));
            response.addCookie(remember);
        }

        request.getRequestDispatcher("/remember").forward(request,response);

    }

    private static Cookie getCookie(Cookie[] cookies, String cookieName)
    {
        if(cookies == null)
            return null;

        for(Cookie cookie : cookies)
        {
            if(cookie.getName().equals(cookieName))
                return cookie;
        }

        return null;
    }
}
