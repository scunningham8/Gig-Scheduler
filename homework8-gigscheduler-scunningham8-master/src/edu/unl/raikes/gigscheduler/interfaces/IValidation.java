package edu.unl.raikes.gigscheduler.interfaces;

/**
 * Interface for input validation.
 * 
 * @author sarahcunningham
 *
 */
public interface IValidation {
    
    /**
     * Validates that a user entered a valid option.
     * 
     * @param scnr scanner to catch the input
     * @param input the number the user chose
     * @return a valid option
     */
    public String isOption(String input);

    /**
     * Validates that the use inputted their date right.
     * 
     * @param date what the user inputted
     * @return a validated date
     */
    public String isDate(String date);

    /**
     * Validates that the use inputted their time right.
     * 
     * @param time what the user inputted
     * @return a validated time
     */
    public String isTime(String time);

    /**
     * Validates that a user entered the price right ex: 12.20.
     * 
     * @param price what the user entered
     * @return a validated price
     */
    public String isPrice(String price);

    /**
     * Makes sure a string is less than or equal to 50 chars.
     * 
     * @param string the string being checked
     * @return a validated string
     */
    public String is50Chars(String string);

    /**
     * Makes sure a string is less than or equal to 100 chars.
     * 
     * @param string the string being checked
     * @return a validated string
     */
    public String is100Chars(String string);

    /**
     * Makes sure a string is less than or equal to 500 chars.
     * 
     * @param string the string being checked
     * @return a validated string
     */
    public String is500Chars(String string);

    /**
     * Makes sure a string is less than or equal to 1000 chars.
     * 
     * @param string the string being checked
     * @return a validated string
     */
    public String is1000Chars(String string);
}
