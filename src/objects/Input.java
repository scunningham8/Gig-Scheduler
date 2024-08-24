package objects;

import java.util.Scanner;

import edu.unl.raikes.gigscheduler.interfaces.IInput;

/**
 * Class that gets and stores input from the user.
 * 
 * @author sarahcunningham
 *
 */
public class Input implements IInput{
    Scanner scnr;
    
    /**
     * Constructor for input class.
     * 
     * @param scnr the scanner
     */
    public Input(Scanner scnr) {
        this.scnr = scnr;
    }
    
    @Override
    public String nextLine() {
        return this.scnr.nextLine();
    }


}
