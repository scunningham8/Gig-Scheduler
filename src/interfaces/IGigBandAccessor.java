package edu.unl.raikes.gigscheduler.interfaces;

import java.util.ArrayList;

import objects.GigBand;

/**
 * Interface for the gig band accessor.
 * 
 * @author sarahcunningham
 *
 */
public interface IGigBandAccessor {
    
    /**
     * Finds a gig band based on a given ID number.
     * 
     * @param id the id of the one to be found
     * @return the gig band found
     */
    GigBand getGigBandsByID(int id);
    
    /**
     * Saves a new gig band to the table.
     * 
     * @param gigBand the gig band to be saved
     * @return the saved gig band
     */
    GigBand saveGigBands(GigBand gigBand);
    
    /**
     * Gets all gig band relationships given a gig ID.
     * 
     * @param id the gig id
     * @return all of the relationships
     */
    public ArrayList<GigBand> getGigBandsByGigID(int id);
}
