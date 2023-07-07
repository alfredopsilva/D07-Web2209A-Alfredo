package ca.collegeuniversel.recipes.entities;

import java.util.Objects;

public class RecipeCategory
{
    private final int id;
    private final String name;
    private final String imagePath;
    
    public RecipeCategory(int id, String name, String imagePath)
    {
        this.id = id;
        this.name = Objects.requireNonNull(name);
        this.imagePath = Objects.requireNonNull(imagePath);
    }
    
    @Override
    public String toString()
    {
        return "Recipe category " + id + " " + name;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getImagePath()
    {
        return imagePath;
    }
}
