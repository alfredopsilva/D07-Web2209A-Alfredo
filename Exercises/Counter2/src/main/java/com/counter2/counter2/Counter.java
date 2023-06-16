package com.counter2.counter2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name ="Counter", urlPatterns = {"/counter",""})
public class Counter extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String name = "visitsCount";
        Cookie[] cookies = request.getCookies();
        Cookie cookie = getCookie(cookies, name);

        if(cookie != null)
        {
            int visitsCount = Integer.parseInt(cookie.getValue());
            visitsCount++;

            cookie.setValue(Integer.toString(visitsCount));
            cookie.setMaxAge(3600);

            response.addCookie(cookie);
            request.setAttribute(name,visitsCount);

        }
        else
        {
            cookie = new Cookie(name,"1");
            cookie.setMaxAge(3600);
            response.addCookie(cookie);
            request.setAttribute(name,1);
        }

        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request,response);


        String counterCookie = null;


        Cookie counter = new Cookie("Counter","0");
        counter.setMaxAge(3600);

        int counterIncrementor = 1;
        counter.setValue(Integer.toString(counterIncrementor));

        response.addCookie(counter);

        counterIncrementor++;
        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request,response);
    }

    private static Cookie getCookie(Cookie[] cookies, String name)
    {
        if(cookies == null)
            return null;

        for(Cookie cookie : cookies)
        {
            if(cookie.getName().equals(name))
            {
                return cookie;
            }
        }

        return null;
    }

}
