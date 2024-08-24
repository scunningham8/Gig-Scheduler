package edu.unl.raikes.gigscheduler.mocks;

import java.util.ArrayList;
import java.util.List;

import edu.unl.raikes.gigscheduler.interfaces.IOutput;

/**
 * Class that mocks the output to the screen.
 * 
 * @author sarahcunningham
 *
 */
public class OutputMock implements IOutput{

    List<String> output;
    
    /**
     * Constructor for the output mock.
     */
    public OutputMock() {
        this.output = new ArrayList<String>();
    }
    
    @Override
    public void print(String stmt) {
        this.output.add(stmt);
        
    }

    @Override
    public void println(String stmt) {
        this.output.add(stmt);
        
    }
    
    /**
     * Getter for ouptput list.
     * 
     * @return the output list
     */
    public List<String> getOutput(){
        return this.output;
    }

}
