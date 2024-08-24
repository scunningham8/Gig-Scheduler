package edu.unl.raikes.gigscheduler.mocks;

import java.util.Scanner;

import edu.unl.raikes.gigscheduler.interfaces.IInput;

/**
 * Mocks the input from the user for testing purposes.
 * 
 * @author sarahcunningham
 *
 */
public class InputMock implements IInput{

    // all of the strings that the user will "type"
    String[] input;
    int count = 0;
    
    /**
     * Constructor for the input mock.
     * 
     * @param input the mock
     */
    public InputMock(String[] input) {
        this.input = input;
    }
    
    @Override
    public String nextLine() {
        this.count++;
        return this.input[this.count - 1];
    }



}
