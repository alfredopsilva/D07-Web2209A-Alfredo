package com.tasks.service;

import com.tasks.model.Task;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpSession;

import java.util.*;

public class TaskService
{
    //Fields
    private final HttpSession session;
    HashMap<String, Task> tasks;

    //Constructor
    public TaskService(HttpSession session)
    {
        this.session = Objects.requireNonNull(session);
        //TODO: Delete this message at the end
        //noinspection unchecked
        tasks = (HashMap<String, Task>) session.getAttribute("tasks");

        if(tasks == null)
        {
            tasks = new HashMap<>();
            session.setAttribute("tasks",tasks);
        }
    }


    //Methods
    public void addTask(String name) {
        //TODO: It's a verbose solution. Refactor this code when it's finished,.
        ArrayList<Task> arrayTask = new ArrayList<>(tasks.values());
        boolean containName = false;

        //TODO: How to make the same search if my value into this Hashmap is a Task.
        for (Task task : arrayTask) {
            if (task.getName().toLowerCase().equals(name.toLowerCase())) {
                containName = true;
                break;
            }

        }
        if(!containName)
        {
            String id = UUID.randomUUID().toString();
            Task newTask = new Task(id, name, false);
            tasks.put(id, newTask);
            session.setAttribute("message", "Success ! Your task was properly created.");
            session.setAttribute("tasks", tasks);
            session.setAttribute("status", 200);

        }
        else
        {
            session.setAttribute("message", "Error ! Your TodoList already contain this task.");
            session.setAttribute("status", 400);


        }
    }

    public void removeTask(String id)
    {
        tasks.remove(id);
        session.setAttribute("message", "Sucess ! Your task was successfully deleted.");
        session.setAttribute("status", 200);

    }

    public void completeTask(String id)
    {
        if(tasks.containsKey(id))
        {
            tasks.get(id).setComplete(true);
            session.setAttribute("message","Sucess! Your task was successfully completed.");
            session.setAttribute("status", 200);

        }
    }

    public void resetTask(String id)
    {
        if(tasks.containsKey(id))
        {
            if(tasks.get(id).isComplete())
            {
                tasks.get(id).setComplete(false);
                session.setAttribute("message","Sucess! Your task was successfully reseted.");
                session.setAttribute("status", 200);
            }
        }
    }

    public ArrayList<Task> getTasks()
    {
        if(tasks.isEmpty())
        {
            return null;
        }

        ArrayList<Task> listTasks = new ArrayList<>(tasks.values());
        listTasks.sort(Comparator.comparing(Task::getName));
        return listTasks;
    }

}
