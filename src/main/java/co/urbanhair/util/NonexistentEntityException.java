package co.urbanhair.util;

/**
 * Implementation NonexistentEntityException.
 * 
 
 */
@SuppressWarnings("serial")
public class NonexistentEntityException extends Exception {
	
	///////////////////////////////////////////////////////
	// Builder
	///////////////////////////////////////////////////////
    public NonexistentEntityException(String message, Throwable cause) {
        super(message, cause);
    }
    public NonexistentEntityException(String message) {
        super(message);
    }
}
