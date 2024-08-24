package test;

import java.util.Scanner;

import edu.unl.raikes.gigscheduler.interfaces.IOutput;
import edu.unl.raikes.gigscheduler.interfaces.IInput;
import edu.unl.raikes.gigscheduler.interfaces.IValidation;

/**
 * Holds all input validation functions.
 * 
 * @author sarahcunningham
 *
 */
public class Validation implements IValidation {
    static int USER_3 = 3;
    static int USER_4 = 4;
    static int USER_5 = 5;
    static int USER_7 = 7;
    static int USER_8 = 8;
    static int USER_9 = 9;
    static int USER_10 = 10;
    static int USER_24 = 24;
    static int USER_59 = 59;
    static int MAX_50 = 50;
    static int USER_100 = 100;
    static int MAX_500 = 500;
    static int MAX_1000 = 1000;
    static int MONTH_MAX = 12;
    static int DAY_MAX = 31;
    static char DASH = '-';
    static char COLON = ':';
    IInput scnr;
    IOutput out;

    /**
     * Constructor for input validation.
     * 
     * @param scnr what the user will input
     */
    public Validation(IInput scnr, IOutput out) {
        this.scnr = scnr;
        this.out = out;
    }

    @Override
    public String isOption(String input) {
        while (Integer.valueOf(input) > USER_4 || Integer.valueOf(input) < 1) {
            this.out.println("Sorry, that number isn't one of the options. Please try again. ");
            input = this.scnr.nextLine();
        }
        return input;
    }

    @Override
    public String isDate(String date) {
        boolean isDate = false;

        String year = "";
        String month = "";
        String day = "";
        while (!isDate) {

            if (date.length() != USER_10) {
                this.out.println("Sorry, the date you inputted wasn't in the correct format. Please try again. ");
                date = this.scnr.nextLine();
                isDate = false;
            } else {

                year = date.substring(0, USER_4);
                month = date.substring(USER_5, USER_7);
                day = date.substring(USER_8, USER_10);

                // if the dashes aren't in the right spots
                if (date.charAt(USER_4) != DASH || date.charAt(USER_7) != DASH) {
                    this.out.println("Sorry, the date you inputted wasn't in the correct format. Please try again. ");
                    date = this.scnr.nextLine();
                    isDate = false;

                    // if the year/month/day aren't number
                } else if (!year.matches("[0-9]+") || !month.matches("[0-9]+") || !day.matches("[0-9]+")) {
                    this.out.println("Sorry, the date you inputted wasn't in the correct format. Please try again. ");
                    date = this.scnr.nextLine();
                    isDate = false;
                } else {
                    isDate = true;
                }
            }

        }

        return date;
    }

    @Override
    public String isTime(String time) {
        boolean isTime = false;

        String hour = "";
        String minute = "";
        String second = "";
        while (!isTime) {

            if (time.length() != USER_8) {
                this.out.println("Sorry, the time you inputted wasn't in the correct format. Please try again. ");
                time = this.scnr.nextLine();
                isTime = false;
            } else {
                hour = time.substring(0, 2);
                minute = time.substring(USER_3, USER_5);
                second = time.substring(USER_7);
                

                if (time.charAt(2) != COLON || time.charAt(USER_5) != COLON) {
                    this.out.println("Sorry, the time you inputted wasn't in the correct format. Please try again. ");
                    time = this.scnr.nextLine();
                    isTime = false;
                } else if (Integer.valueOf(hour) > USER_24 || Integer.valueOf(minute) > USER_59
                        || Integer.valueOf(second) > USER_59) {
                    this.out.println("Sorry, the time you inputted wasn't in the correct format. Please try again. ");
                    time = this.scnr.nextLine();
                    isTime = false;
                } else if (!hour.matches("[0-9]+") || !minute.matches("[0-9]+") || !second.matches("[0-9]+")) {
                    this.out.println("Sorry, the time you inputted wasn't in the correct format. Please try again. ");
                    time = this.scnr.nextLine();
                    isTime = false;
                } else {
                    isTime = true;
                }
            }

        }

        return time;
    }

    @Override
    public String isPrice(String price) {
        price = "" + (Double.valueOf(price) * USER_100);
        price = Math.floor(Double.valueOf(price)) + "";
        return (Double.valueOf(price) / USER_100) + "";
    }

    @Override
    public String is50Chars(String string) {
        while (string.length() > MAX_50) {
            this.out.println("Sorry, that's too many characters. Please try again. ");
            string = this.scnr.nextLine();
        }

        return string;
    }

    @Override
    public String is100Chars(String string) {
        while (string.length() > USER_100) {
            this.out.println("Sorry, that's too many characters. Please try again. ");
            string = this.scnr.nextLine();
        }
        return string;
    }

    @Override
    public String is500Chars(String string) {
        while (string.length() > MAX_500) {
            this.out.println("Sorry, that's too many characters. Please try again. ");
            string = this.scnr.nextLine();
        }
        return string;
    }

    @Override
    public String is1000Chars(String string) {
        while (string.length() > MAX_1000) {
            this.out.println("Sorry, that's too many characters. Please try again. ");
            string = this.scnr.nextLine();
        }
        return string;
    }
}
