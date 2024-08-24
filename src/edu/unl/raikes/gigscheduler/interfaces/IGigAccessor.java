package edu.unl.raikes.gigscheduler.interfaces;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edu.unl.raikes.gigscheduler.ConnectionFactory;
import edu.unl.raikes.gigscheduler.Gig;

/**
 * Interface for the gig accessor.
 * 
 * @author sarahcunningham
 *
 */
public interface IGigAccessor {

    /**
     * Finds a gig based on a given ID number.
     * 
     * @param id the id number being searched for
     * @return the found gig
     */
    public Gig getGigByID(int id);
    
    /**
     * Saves a new gig to the table.
     * 
     * @param gig the gig to be saved
     * @return the gig saved
     */
    public Gig saveGig(Gig gig);
    
    /**
     * Gets all of the gigs between two dates in order.
     * 
     * @param startDate the start date
     * @param endDate the end date
     * @return an array list of the gigs in order
     */
    public ArrayList<Gig> getGigsInOrderWithBothDates(String startDate, String endDate);

    /**
     * Gets all of the gigs between only start date.
     * 
     * @param startDate the start date
     * @param endDate the end date
     * @return an array list of the gigs in order
     */
    public ArrayList<Gig> getGigsInOrderWithStartDate(String startDate);

    /**
     * Gets all of the gigs between use the end date in order.
     * 
     * @param startDate the start date
     * @param endDate the end date
     * @return an array list of the gigs in order
     */
    public ArrayList<Gig> getGigsInOrderWithEndDate(String endDate);

    /**
     * Gets all of the gigs between use the end date in order.
     * 
     * @param startDate the start date
     * @param endDate the end date
     * @return an array list of the gigs in order
     */
    public ArrayList<Gig> getGigsInOrderWithNoDates();
}
