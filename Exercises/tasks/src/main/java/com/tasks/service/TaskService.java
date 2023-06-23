package com.tasks.service;

import com.tasks.model.Task;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class TaskService
{
    //Fields
    private final HttpSession session;
    HashMap<String, Task> tasks;

    //Constructor
    public TaskService(HttpSession session)
    {
        this.session = Objects.requireNonNull(session);
        session.setAttribute("message", "It's connect with Service.");
        tasks = (HashMap<String, Task>) session.getAttribute("tasks");

        if(tasks == null)
        {
            tasks = new HashMap<>();
            session.setAttribute("tasks",tasks);
        }
    }

    //Methods
    public void addTask(String name)
    {

        if(tasks.containsValue(name))
        {
            session.setAttribute("message", "Error ! This task is already in your TodoList.");
        }
        else
        {
            String id = UUID.randomUUID().toString();
            Task task = new Task(id, name, false);
            tasks.put(id,task);
            session.setAttribute("message", "Success ! Your task was properly created.");
        }

    }

    public void removeTask(UUID id)
    {
        tasks.remove(id);
        session.setAttribute("message", "Your task was sucessfully deleted.");
    }

    public void completeTask(UUID id)
    {
        if(tasks.containsKey(id))
        {
            tasks.get(id).setComplete(true);
        }
    }

    public void resetTask(UUID id)
    {
        if(tasks.containsKey(id))
        {
            if(tasks.get(id).isComplete())
            {
                tasks.get(id).setComplete(false);
            }
        }
    }

    public ArrayList<Task> getTasks()
    {
        if(tasks.isEmpty())
        {
            return null;
        }

        return new ArrayList<>(tasks.values());
    }

}
