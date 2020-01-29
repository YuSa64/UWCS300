package pq;
/**
 * CS300 - Programming II
 * A runtime exception for an empty queue.
 * @author Mouna AYARI BEN HADJ KACEM
 * 
 */
@SuppressWarnings("serial")
public class EmptyQueueException extends RuntimeException{
    
    public EmptyQueueException() { 
        super("WARNING: The Queue is empty."); 
    }
    
    public EmptyQueueException(String message) { 
        super(message); 
    }
}