package com.jobs2.jobs2.controller;


import com.jobs2.jobs2.models.Job;
import com.jobs2.jobs2.models.JobType;
import com.jobs2.jobs2.repository.JobRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "JobListController", urlPatterns = "/job-selection")

public class JobListController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

        //Setting Content Response to UTF-8;
        JobRepository repository = new JobRepository();
        ArrayList<Job> jobs = new ArrayList<Job>();

        if(jobRequest.equals("All"))
        {

            jobs = repository.jobs();
        }
        else
        {
            jobs = repository.specificJobs(jobType);
        }
        request.setAttribute("jobs",jobs);
        request.setAttribute("jobRequest", jobRequest);

        request.getRequestDispatcher("WEB-INF/jobs.jsp").forward(request,response);
    }
}
