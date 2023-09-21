package edu.unl.raikes.gigscheduler.interfaces;

/**
 * Interface to define the output functions.
 * 
 * @author sarahcunningham
 *
 */
public interface IOutput {
    
    /**
     * Prints a string.
     * 
     * @param stmt what needs to be printed
     */
    void print(String stmt);
    
    /**
     * Prints a string with a newline at the end.
     * 
     * @param stmt what needs to be printed
     */
    void println(String stmt);
}
