package co.urbanhair.util;

/**
 * Implementation PreexistingEntityException.
 * 
 
 */
@SuppressWarnings("serial")
public class PreexistingEntityException extends Exception {
	
	///////////////////////////////////////////////////////
	// Builder
	///////////////////////////////////////////////////////
    public PreexistingEntityException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public PreexistingEntityException(String message) {
        super(message);
    }
}
