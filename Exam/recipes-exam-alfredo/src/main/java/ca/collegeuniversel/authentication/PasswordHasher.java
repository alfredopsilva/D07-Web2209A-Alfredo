package ca.collegeuniversel.authentication;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PasswordHasher
{
    /**
     * Hashes the given password with a randomly generated salt.
     * @param password Must not be null.
     * @return An object containing the random salt byte array and the computed hash byte array.
     * @throws IllegalArgumentException If the password is null.
     */
    public HashedPassword hashPassword(String password)
    {
        if (password == null)
            throw new IllegalArgumentException("Password must not be null.");
        
        return hashPassword(convertToByteArray(password), generateRandomSalt(32));
    }
    
    /**
     * Checks whether the given password correctly matches the stored password.
     * <p>
     * This is done by hashing the given password with the stored salt,
     * and comparing the resulting hash with the stored hash. <br>
     * If the resulting hash is equal to the stored hash,
     * then the password is correct. Otherwise, it is incorrect.
     * @param password Must not be null.
     * @param storedPassword Must not be null.
     * @return A password result specifying whether the given password is correct or incorrect.
     * @throws IllegalArgumentException If one of the parameters is null.
     */
    public PasswordResult checkPassword(String password, HashedPassword storedPassword)
    {
        if (password == null)
            throw new IllegalArgumentException("Password must not be null.");
        if (storedPassword == null)
            throw new IllegalArgumentException("Stored password must not be null.");
        
        byte[] passwordByteArray = convertToByteArray(password);
        HashedPassword hashedPassword = hashPassword(passwordByteArray, storedPassword.getSalt());

        if (byteArraysAreEqual(hashedPassword.getHash(), storedPassword.getHash()))
            return PasswordResult.Correct;
        return PasswordResult.Incorrect;
    }
    
    private static byte[] convertToByteArray(String text)
    {
        return text.getBytes(StandardCharsets.UTF_8);
    }
    
    private static byte[] generateRandomSalt(int length)
    {
        if (length < 1)
            throw new IllegalArgumentException("Length must not be less than 1.");
        
        byte[] salt = new byte[length];
        new SecureRandom().nextBytes(salt);
        return salt;
    }
    
    private static HashedPassword hashPassword(byte[] password, byte[] salt)
    {
        byte[] saltedPassword = new byte[password.length + salt.length];
        System.arraycopy(password, 0, saltedPassword, 0, password.length);
        System.arraycopy(salt, 0, saltedPassword, password.length, salt.length);
        
        try
        {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(saltedPassword);
            return new HashedPassword(salt, hash);
        }
        catch (NoSuchAlgorithmException e)
        {
            throw new RuntimeException(e);
        }
    }
    
    private static boolean byteArraysAreEqual(byte[] first, byte[] second)
    {
        if (first.length != second.length)
            return false;

        for (int i = 0; i < first.length; i++)
        {
            if (first[i] != second[i])
                return false;
        }

        return true;
    }
}
