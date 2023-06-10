package com.jobs2.jobs2.models;


import java.util.Objects;

public class Job {
    private String title;
    private JobType type;

    public Job(String title, JobType type) {

        this.title = Objects.requireNonNull(title);
        this.type = Objects.requireNonNull(type);

    }

    //Getters
    public String getTitle() {
        return title;
    }

    public JobType getType() {
        return type;
    }

    //Setters
    public void setTitle(String title) {
        this.title = Objects.requireNonNull(title);
    }

    public void setType(JobType type) {
        this.type = Objects.requireNonNull(type);
    }

    //ToString

    @Override
    public String toString() {
        return "Job" + type + " " + title + ".";
    }
}
