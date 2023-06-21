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

        Cookie[] cookies = request.getCookies();

        Cookie name = getCookie(cookies,"name");
        Cookie color = getCookie(cookies,"color");

        if(name != null)
            request.setAttribute("name",name.getValue());

        if(color != null)
            request.setAttribute("color", color.getValue());


        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        // Retrieving Parameters
        String nameParameter = request.getParameter("name");
        String rememberParameter = request.getParameter("remember");
        String colorParameter = request.getParameter("color");
        boolean remember = Boolean.parseBoolean(rememberParameter);


        //Check if remember was checked. If it wasn't, delete all cookies.
        if(rememberParameter != null && remember == true)
        {
            int cookieDuration = 60 * 60;

            Cookie nameCookie = new Cookie("name",nameParameter);
            nameCookie.setMaxAge(cookieDuration);
            response.addCookie(nameCookie);

            Cookie colorCoookie = new Cookie("color",colorParameter);
            colorCoookie.setMaxAge(cookieDuration);
            response.addCookie(colorCoookie);

            Cookie rememberCookie = new Cookie("remember",rememberParameter);
            rememberCookie.setMaxAge(cookieDuration);
            response.addCookie(rememberCookie);
        }
        else
        {
            Cookie[] cookies = request.getCookies();
            Cookie nameCookie = getCookie(cookies, "name");
            if(nameCookie != null)
            {
                nameCookie.setMaxAge(0);
                response.addCookie(nameCookie);
            }

            Cookie colorCookie = getCookie(cookies,"color");
            if(colorCookie != null)
            {
                colorCookie.setMaxAge(0);
                response.addCookie(colorCookie);
            }

            Cookie rememberCookie = getCookie(cookies,"remember");
            if(rememberCookie != null)
            {
                rememberCookie.setMaxAge(0);
                response.addCookie(rememberCookie);
            }
        }

        if(nameParameter != null)
        {
            request.setAttribute("name",nameParameter);
        }
        if(colorParameter != null)
        {
            request.setAttribute("color",colorParameter);
        }
        if(rememberParameter != null)
        {
            if(remember){
                request.setAttribute("remember","true");
            }
            else
            {
                request.setAttribute("remember", "false");
            }
        }

        request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(request,response);

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
