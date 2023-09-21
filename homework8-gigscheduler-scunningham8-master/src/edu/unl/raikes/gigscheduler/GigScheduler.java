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
 * Class that holds the main functionality of gig scheduler.
 * 
 * @author sarahcunningham
 *
 */
public class GigScheduler {
    static int numGigs = 0;
    static int numBands = 0;
    static int numRelationships = 0;
    static final String YES = "yes";
    Validation validate;
    
    IInput scnr;
    IOutput output;
    IBandAccessor bands;
    IGigAccessor gigs;
    IGigBandAccessor relationships;

    /**
     * Constructor for gig schedular core methods.
     * 
     * @param scnr what the user types
     * @param output what goes to the console
     * @param bands the band accessor interface
     * @param gigs the gig accessor interface
     * @param relationships the gig band accessor interface
     */
    public GigScheduler(IInput scnr, IOutput output, IBandAccessor bands, IGigAccessor gigs,
            IGigBandAccessor relationships) {
        this.scnr = scnr;
        this.output = output;
        this.bands = bands;
        this.gigs = gigs;
        this.relationships = relationships;
        this.validate = new Validation(scnr, output);
    }

    /**
     * Displays the help menu to the user, then gets next instruction.
     * 
     * @param scnr the scanner to get the next instruction
     */
    public void goToHelpMenu() {
        this.output.println("Help Menu: \n");
        // creates a string builder to add all of the strings in the file to
        StringBuilder fileString = new StringBuilder();

        // creates a healthy scanner
        Scanner stringReader = null;
        try {
            stringReader = new Scanner(new File("./src/USER_MANUAL.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }

        // adds all lines in the file to the string builder
        while (stringReader.hasNextLine()) {
            fileString.append(stringReader.nextLine());
            fileString.append("\n");
        }

        // closes scanner
        stringReader.close();
        this.output.println(fileString.toString());

    }

    /**
     * Allows the user to add a new Gig to the table.
     * 
     * @param scnr scanner to find the information needed
     */
    public void addNewGig() {
        Gig gig = this.gigInformation();
        ArrayList<Band> bands = this.getAllBands();

        for (Band band : bands) {
            numRelationships++;
            this.relationships
                    .saveGigBands(new GigBand(numRelationships, gig.getID(), band.getID(), band.isHeadliner()));
        }
    }

    /**
     * Asks user for information about the gig they're creating.
     * 
     * @param scnr scanner to collect information
     * @return a gig object based on their information
     */
    public Gig gigInformation() {
        // gets and stores all information
        this.output.println("So...to add a new gig, I'm going to need some information! \n"
                // names
                + "What do you want to name your gig? ");
        this.scnr.nextLine();
        String name = this.scnr.nextLine();
        name = this.validate.is100Chars(name);
        this.output.println("What date do you want to have your gig on? (please enter date in the YYYY-MM-DD format) ");
        // date
        String date = this.scnr.nextLine();
        date = this.validate.isDate(date);
        // time
        this.output
                .println("What time do you want it to be at? (please enter in military time in the HH:MM:SS format) ");
        String time = this.scnr.nextLine();
        time = this.validate.isTime(time);
        // description
        this.output.println("Please write a description about your gig for those interested in buying tickets to read. "
                + "(1,000 character limit) ");
        String description = this.scnr.nextLine();
        description = this.validate.is1000Chars(description);
        // cost
        this.output.print("How much are tickets to your gig going to cost? \n$");
        String cost = this.scnr.nextLine();
        cost = this.validate.isPrice(cost);
        // ticket link
        this.output.println("Do you have a website you are going to use to sell the ticekts on? (enter yes or no) ");
        this.scnr.nextLine();
        String yesNo = this.scnr.nextLine();
        String ticketLink = "";
        if (yesNo.toLowerCase().equals(YES)) {
            this.output.println("What is the URL for said website? ");
            ticketLink = this.scnr.nextLine();
            ticketLink = this.validate.is100Chars(ticketLink);
        }
        // notes
        this.output.println("Please include any additional notes about your gig (500 character limit) ");
        String notes = this.scnr.nextLine();
        notes = this.validate.is500Chars(notes);

        // formates dateTime for SQL
        String dateTime = date + " " + time;

        // returns a band
        numGigs++;
        return this.gigs.saveGig(new Gig(numGigs, name, dateTime, description, cost, ticketLink, notes));
    }

    /**
     * Asks users for band information and returns the band.
     * 
     * @param scnr scanner to collect the information
     * @return the band
     */
    public ArrayList<Band> getAllBands() {
        ArrayList<Band> bands = new ArrayList<Band>();

        // user intro
        this.output.println("Now, it's time to invite some bands to play at your gig!!");
        this.output.println("What band do you want to invite first? ");

        // adds first band
        String name = this.scnr.nextLine();
        name = this.validate.is50Chars(name);
        Band band = this.findBand(name);
        if (band != null) {
            this.output.println("Yayyy, you invited your first band!");
            bands.add(band);
        } else {
            this.output.println("Looks, like we don't have that band on file, "
                    + "so I'm going to need some extra information about them.");
        }

        String enterBand = "";

        // adds as many bands as the user wants
        while (Integer.valueOf(enterBand) == 1) {
            // gets the name
            this.output.println("What is the name of the next band you want to invite?");
            name = this.scnr.nextLine();
            name = this.validate.is50Chars(name);

            // determines if it's in the table
            band = this.findBand(name);
            String isHeadliner;

            // adds band to the list of bands
            if (band != null) {
                this.output.println("Is this band a headliner? (enter yes or no)");
                isHeadliner = this.scnr.nextLine();
                if (isHeadliner.equals(YES)) {
                    band.setHeadliner(true);
                } else {
                    band.setHeadliner(false);
                }
                this.output.println("Success! You've added the band to your gig!");
                bands.add(band);
            } else {
                band = this.bandInformation(name);
                this.output.println("Is this band a headliner? (enter yes or no)");
                isHeadliner = this.scnr.nextLine();
                if (isHeadliner.equals(YES)) {
                    band.setHeadliner(true);
                } else {
                    band.setHeadliner(false);
                }
                bands.add(band);

            }

            this.output.println("If you want to enter another band enter 1, if you're done, enter 0 ");
            enterBand = this.scnr.nextLine();
        }

        return bands;

    }

    /**
     * Collects information from the user about a band they're adding to a gig.
     * 
     * @param scnr scanner to grab the information
     * @param name the name of the band they're adding
     * @return a band object based on the information they provided
     */
    public Band bandInformation(String name) {
        this.output.println("What is their hometown? ");
        String hometown = this.scnr.nextLine();
        hometown = this.validate.is50Chars(hometown);
        this.output.println("Do they have a website? (enter yes or no) ");
        String websiteExistance = this.scnr.nextLine();
        String websiteLink = "";
        if (websiteExistance.toLowerCase().equals(YES)) {
            this.output.println("What is the URL for it? ");
            websiteLink = this.scnr.nextLine();
            websiteLink = this.validate.is500Chars(websiteLink);
        }
        this.output.println("Do you want to include a picure of them? (enter yes or no) ");
        String imageExistance = this.scnr.nextLine();
        String imageLink = "";
        if (imageExistance.toLowerCase().equals(YES)) {
            this.output.println("What is the URL for it? ");
            imageLink = this.scnr.nextLine();
            imageLink = this.validate.is500Chars(imageLink);
        }

        numBands++;
        return this.bands.saveBand(new Band(numBands, name, hometown, websiteLink, imageLink));
    }

    /**
     * Determines whether or not a band is already stored in the database.
     * 
     * @param name the name of the band
     * @return the band found, or null if not found
     */
    public Band findBand(String name) {
        return this.bands.getBandByName(name);

    }

    /**
     * Allows the user to view the entire schedule given start and end dates.
     * 
     * @param scnr the scanner to get the information.
     */
    public ArrayList<Gig> getFullSchedule() {
        ArrayList<Gig> gigsInOrder = new ArrayList<Gig>();

        this.output.println("ooOOooh, you want to view the entire schedule! Imma need some input on that.");
        this.output.println("If you want to provide a start date, please enter it in the YYYY-MM-DD format. "
                + "If not, just hit enter. ");
        this.scnr.nextLine();
        String startDate = this.scnr.nextLine();
        this.output.println("If you want to provide an end date, please enter it in the YYYY-MM-DD format. "
                + "If not, just hit enter. ");
        String endDate = this.scnr.nextLine();

        if (startDate.length() == 0 && endDate.length() > 0) {
            // display from beginning of time to end date
            endDate = this.validate.isDate(endDate);
            gigsInOrder = this.gigs.getGigsInOrderWithEndDate(endDate);

        } else if (startDate.length() > 0 && endDate.length() == 0) {
            // display from start date to end of time
            startDate = this.validate.isDate(startDate);
            gigsInOrder = this.gigs.getGigsInOrderWithStartDate(startDate);

        } else if (startDate.length() > 0 && endDate.length() > 0) {
            // display from start date to end date
            endDate = this.validate.isDate(endDate);
            startDate = this.validate.isDate(startDate);
            gigsInOrder = this.gigs.getGigsInOrderWithBothDates(startDate, endDate);

        } else {
            gigsInOrder = this.gigs.getGigsInOrderWithNoDates();
        }

        return gigsInOrder;
    }

    /**
     * Prints out the schedule given an array list of gigs.
     * 
     * @param scnr scanner to get input
     */
    public void printOutSchedule() {
        ArrayList<Gig> allGigs = this.getFullSchedule();
        for (Gig gig : allGigs) {
            this.output.println(gig.toString());
            ArrayList<GigBand> relationships = this.relationships.getGigBandsByGigID(gig.getID());
            for (GigBand relationship : relationships) {
                this.output.println(relationship.toString());
            }
            this.output.println("");
        }
    }

    /**
     * Displays the user actions so that they can pick what to do.
     */
    public String chooseOption() {
        this.output.println("If you would like to go to the help menu, enter 1.\n"
                + "If you would like to add a new gig, enter 2.\n"
                + "If you would like to view the entire schedule, enter 3\n"
                + "If you would like to quit the application, enter 4.");
        String selection = this.scnr.nextLine();
        return this.validate.isOption(selection);
    }
    
    /**
     * Function that calls all the necessary functions.
     */
    public void run() {
        final int USER3 = 3;
        final int USER4 = 4;

        this.output.println("Hi! Welcome to Gig Scheduler!");
        String selection = this.chooseOption();

        while (Integer.valueOf(selection) != USER4) {
            if (Integer.valueOf(selection) == 1) {
                this.goToHelpMenu();
                selection = this.chooseOption();
            } else if (Integer.valueOf(selection) == 2) {
                this.addNewGig();
                selection = this.chooseOption();
            } else if (Integer.valueOf(selection) == USER3) {
                this.printOutSchedule();
                selection = this.chooseOption();
            }
        }

        this.output.println("Thanks for using the Gig Scheduler! We hope you come again soon!");
        System.exit(0);
    }
}
