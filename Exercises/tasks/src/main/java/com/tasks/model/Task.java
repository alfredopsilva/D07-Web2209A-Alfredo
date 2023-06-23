package com.tasks.model;

import java.util.Objects;
import java.util.UUID;

public class Task
{
    private String id;
    private String name;
    private boolean complete;

    //Constructors
    public Task(String id, String name, boolean complete)
    {
        this.id = Objects.requireNonNull(id);
        this.name = Objects.requireNonNull(name);;
        this.complete = complete;
    }

    //Setters
    public void setComplete(boolean complete)
    {
        this.complete = complete;
    }

    //Getters
    public String getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public boolean isComplete()
    {
        return complete;
    }
}
