package com.intellij.jobs.repository;

import com.intellij.jobs.models.Job;
import com.intellij.jobs.models.JobType;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class JobRepository {
    public ArrayList<Job> jobs()
    {
        //Creating ArrayList to store Job Objects
        ArrayList<Job> jobsList = new ArrayList<>();

        //Adding Objects to Array
        jobsList.add(new Job("Front-End Web developer", JobType.PartTime));
        jobsList.add(new Job("Unity Developer", JobType.PartTime));
        jobsList.add(new Job("Back-End Java Developer", JobType.FullTime));
        jobsList.add(new Job("Database admin", JobType.FullTime));
        jobsList.add(new Job("Project Manager", JobType.FullTime));
        jobsList.add(new Job("ASP.NET Developer", JobType.Contractor));
        jobsList.add(new Job("User Experience Designer", JobType.Contractor));

        //Returning ArrayList
        return jobsList;
    }

    public ArrayList<Job> specificJobs(JobType jobType)
    {
        //Filtering Data from Jobs Method with Stream and Return a new ArrayList.
        return  jobs().stream()
                      .filter(job -> job.getType() == jobType)
                      .collect(Collectors.toCollection(ArrayList::new));

    }
}
