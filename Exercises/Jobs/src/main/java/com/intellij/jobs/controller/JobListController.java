package com.intellij.jobs.controller;

import com.intellij.jobs.models.Job;
import com.intellij.jobs.models.JobType;
import com.intellij.jobs.repository.JobRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "JobRepository", urlPatterns = "/job-selection")

public class JobListController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Setting Content Response to UTF-8;
        response.setContentType("text/html;charset=UTF-8");

        // Accessing and Storing Parameters
        String jobRequest = request.getParameter("job");

        //Local Variables
        JobType jobType = null;

        //Setting Job Filter
        switch (jobRequest)
        {
            case "FullTime":
                jobType = JobType.FullTime;
                break;
            case "PartTime":
                jobType = JobType.PartTime;
                break;
            case "Contractor":
                jobType = JobType.Contractor;
                break;
        }


        //Jobs in Collection
        ArrayList<Job> jobs = new ArrayList<Job>();
        var repository = new JobRepository();

        if(jobRequest.equals("All"))
        {

            jobs = repository.jobs();
        }
        else
        {
            jobs = repository.specificJobs(jobType);
        }

        try(PrintWriter out = response.getWriter())
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> First Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + jobRequest + " Jobs" + "</h1>");
            out.println("<ul>");
            for(Job job : jobs)
            {
                out.println("<li>" + job.getTitle() + "</li>");
            }
            out.println("</ul>");
            out.println("<a href='index.html'>Return</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
