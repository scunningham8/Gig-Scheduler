package edu.unl.raikes.gigscheduler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import edu.unl.raikes.gigscheduler.interfaces.IBandAccessor;
import edu.unl.raikes.gigscheduler.interfaces.IGigAccessor;
import edu.unl.raikes.gigscheduler.interfaces.IGigBandAccessor;
import edu.unl.raikes.gigscheduler.interfaces.IOutput;
import edu.unl.raikes.gigscheduler.interfaces.IInput;
import edu.unl.raikse.gigscheduler.accessor.BandAccessor;
import edu.unl.raikse.gigscheduler.accessor.GigAccessor;
import edu.unl.raikse.gigscheduler.accessor.GigBandAccessor;

/**
 * Main class for package.
 * 
 * @author sarahcunningham
 *
 */
public class GigSchedulerRunner {

    /**
     * Main function.
     * 
     * @param args String[]
     */
    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        GigScheduler gigScheduler = new GigScheduler(new Input(scnr), new Output(), new BandAccessor(),
                new GigAccessor(), new GigBandAccessor());
        gigScheduler.run();

    }

}
