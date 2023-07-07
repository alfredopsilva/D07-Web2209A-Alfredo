package ca.collegeuniversel.recipes.entities;

import java.util.Objects;

public class Recipe
{
    private final int id;
    private final String name;
    private final String description;
    private final String imagePath;
    private final int categoryId;

    public Recipe(String name, String description, String imagePath, int categoryId)
    {
        this(0, name, description, imagePath, categoryId);
    }

    public Recipe(int id, Recipe other)
    {
        this(id, other.name, other.description, other.imagePath, other.categoryId);
    }

    public Recipe(int id, String name, String description, String imagePath, int categoryId)
    {
        this.id = id;
        this.name = Objects.requireNonNull(name);
        this.description = Objects.requireNonNull(description);
        this.imagePath = Objects.requireNonNull(imagePath);
        this.categoryId = categoryId;
    }

    @Override
    public String toString()
    {
        return "Recipe " + id + " " + name;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }
    
    public String getDescription()
    {
        return description;
    }

    public String getImagePath()
    {
        return imagePath;
    }

    public int getCategoryId()
    {
        return categoryId;
    }
}
