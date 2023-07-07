package ca.collegeuniversel.authentication;

public class HashedPassword
{
    private final byte[] salt;
    private final byte[] hash;

    /**
     * Constructs an object containing a password salt and a password hash.
     * @param salt Randomly generated password salt. Must not be null.
     * @param hash Result of hashing a password with the salt. Must not be null.
     * @throws IllegalArgumentException If one of the parameters is null.
     */
    public HashedPassword(byte[] salt, byte[] hash)
    {
        if (salt == null)
            throw new IllegalArgumentException("Salt must not be null.");
        if (hash == null)
            throw new IllegalArgumentException("Hash must not be null.");
        
        this.salt = salt;
        this.hash = hash;
    }

    /**
     * @return The non-null password salt byte array.
     */
    public byte[] getSalt()
    {
        return salt;
    }

    /**
     * @return The non-null password hash byte array.
     */
    public byte[] getHash()
    {
        return hash;
    }
}
