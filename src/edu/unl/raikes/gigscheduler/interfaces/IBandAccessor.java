package edu.unl.raikes.gigscheduler.interfaces;

import edu.unl.raikes.gigscheduler.Band;

/**
 * Interface for the band accessor.
 * 
 * @author sarahcunningham
 *
 */
public interface IBandAccessor {

    /**
     * Finds a band given a certain ID number.
     * 
     * @param id the id number being searcehd for
     * @return the band found
     */
    public Band getBandById(int id);

    /**
     * Saves a new band.
     * 
     * @param band the band to be saved
     * @return the saved band
     */
    public Band saveBand(Band band);

    /**
     * Gets a band based on a given name.
     * 
     * @param name the name being searched for
     * @return the band object, if it's found
     */
    public Band getBandByName(String name);
}
