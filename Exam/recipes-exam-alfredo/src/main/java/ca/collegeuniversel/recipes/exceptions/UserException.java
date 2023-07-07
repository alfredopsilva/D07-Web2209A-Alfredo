package ca.collegeuniversel.recipes.exceptions;

public class UserException extends Exception
{
    public UserException()
    {
        super();
    }
    
    public UserException(String message)
    {
        super(message);
    }
    
    public UserException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
