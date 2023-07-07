package ca.collegeuniversel.recipes.entities;

import ca.collegeuniversel.authentication.HashedPassword;
import java.util.Objects;

public class User
{
    private final String username;
    private final HashedPassword password;
    private final String name;
    
    public User(String username, HashedPassword password, String name)
    {
        this.username = Objects.requireNonNull(username);
        this.password = Objects.requireNonNull(password);
        this.name = Objects.requireNonNull(name);
    }
    
    @Override
    public String toString()
    {
        return "User " + username;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public HashedPassword getPassword()
    {
        return password;
    }
    
    public String getName()
    {
        return name;
    }
}
