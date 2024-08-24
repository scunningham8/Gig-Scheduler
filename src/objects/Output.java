package objects;

import edu.unl.raikes.gigscheduler.interfaces.IOutput;

/**
 * Class for what is printed out to the console.
 * 
 * @author sarahcunningham
 *
 */
public class Output implements IOutput{
    
    @Override
    public void print(String stmt) {
        System.out.print(stmt);
        
    }

    @Override
    public void println(String stmt) {
        System.out.println(stmt);
        
    }

}
