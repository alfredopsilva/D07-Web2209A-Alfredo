package ca.collegeuniversel.recipes.services;

import ca.collegeuniversel.authentication.PasswordHasher;
import ca.collegeuniversel.authentication.PasswordResult;
import ca.collegeuniversel.recipes.entities.User;
import ca.collegeuniversel.recipes.exceptions.UserException;
import ca.collegeuniversel.recipes.exceptions.ValidationException;
import ca.collegeuniversel.recipes.repositories.UserRepository;
import java.sql.SQLException;

public class UserService
{
    private final UserRepository repository;
    private final PasswordHasher passwordHasher;
    
    public UserService()
    {
        repository = new UserRepository();
        passwordHasher = new PasswordHasher();
    }
    
    /**
     * Log in as an existing user.
     * @param username Must not be null, empty, or blank. Must be an existing username.
     * @param password Must not be null, empty, or blank. Must be the correct password for the given user.
     * @return Existing user, if logged in successfully.
     * @throws ValidationException If username is null, empty, or blank. If password is null, empty, or blank.
     * @throws UserException If username does not exist. If password is incorrect.
     * @throws SQLException If an error occurs during database access.
     */
    public User logIn(String username, String password) throws ValidationException, UserException, ClassNotFoundException, SQLException
    {
        if (username == null || username.isBlank())
            throw new ValidationException("Please enter your username.");
        if (password == null || password.isBlank())
            throw new ValidationException("Please enter your password.");
        
        User user = repository.getUser(username);
        
        if (user != null)
        {
            PasswordResult result = passwordHasher.checkPassword(password, user.getPassword());
            if (result == PasswordResult.Correct)
                return user;
        }
        
        throw new UserException("Incorrect username or password.");
    }
}
