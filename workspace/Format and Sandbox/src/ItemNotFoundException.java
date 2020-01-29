/**
 * Thrown when an item is not found 
 * @author Mouna AYARI BEN HADJ KACEM
 * 
 */
@SuppressWarnings("serial")
public class ItemNotFoundException extends RuntimeException{
    
  /**
   * Creates an ItemNotFoundException with a default error message
   */
   public ItemNotFoundException() { 
     super("WARNING: Item not found."); 
   }
    
   /**
    * Creates an ItemNotFoundException with a provided error message
    * @param message error message
    */
   public ItemNotFoundException(String message) { 
     super(message); 
   }
}