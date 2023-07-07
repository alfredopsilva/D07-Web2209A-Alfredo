package ca.collegeuniversel.recipes.exceptions;

public class BadRequestException extends Exception
{
    public BadRequestException()
    {
        super();
    }

    public BadRequestException(String message)
    {
        super(message);
    }

    public BadRequestException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
