package objects;

import edu.unl.raikse.gigscheduler.accessor.BandAccessor;
import edu.unl.raikse.gigscheduler.accessor.GigAccessor;

/**
 * Creates an object for the relationship between a gig and aband.
 * 
 * @author sarahcunningham
 *
 */
public class GigBand {
    private int ID;
    private int gigID;
    private int bandID;
    private boolean isHeadliner;
    private GigAccessor gigTable;
    private BandAccessor bandTable;

    /**
     * Creates a GigBands relationship object.
     * 
     * @param id the id of the relationship
     * @param gigID the id of the gig
     * @param bandID the id of the band
     * @param isHeadliner boolean to determine if the band is a headliner or not
     */
    public GigBand(int id, int gigID, int bandID, boolean isHeadliner) {
        this.ID = id;
        this.gigID = gigID;
        this.bandID = bandID;
        this.isHeadliner = isHeadliner;
        this.gigTable = new GigAccessor();
        this.bandTable = new BandAccessor();
    }

    /**
     * Gets the ID of the relationship.
     * 
     * @return the ID of the relationship
     */
    public int getID() {
        return this.ID;
    }

    /**
     * Gets the ID of the gig.
     * 
     * @return the ID of the gig
     */
    public int getGigID() {
        return this.gigID;
    }

    /**
     * Gets the ID of the band.
     * 
     * @return the ID of the band
     */
    public int getBandID() {
        return this.bandID;
    }

    /**
     * Gets the headliner boolean for the band.
     * 
     * @return the ID of the relationship
     */
    public boolean isHeadliner() {
        return this.isHeadliner;
    }

    /**
     * Sets the boolean for the headliner.
     * 
     * @param isHeadliner boolean to tell if the band is a headliner or not
     */
    public void setHeadliner(boolean isHeadliner) {
        this.isHeadliner = isHeadliner;
    }

    @Override
    public String toString() {
        String toReturn = "\t" + this.bandTable.getBandById(this.bandID).getName() + " is";
        if (this.isHeadliner) {
            toReturn += " a headliner and is";
        }
        toReturn += " playing at " + this.gigTable.getGigByID(this.gigID).getName();
        return toReturn;

    }

}
