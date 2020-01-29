/**
 * This exception is thrown to indicate a non allowed duplicate entry 
 * @author Mouna AYARI BEN HADJ KACEM
 * 
 */
@SuppressWarnings("serial")
public class DuplicateItemException extends RuntimeException{
    
  /**
   * Creates a DuplicateItemException with a default error message
   */
  public DuplicateItemException() { 
    super("WARNING: Duplicate Entry."); 
  }
    
  /**
   * Creates a DuplicateItemException with a provided error message
   * @param message error message
   */
   public DuplicateItemException(String message) { 
     super(message); 
   }
}