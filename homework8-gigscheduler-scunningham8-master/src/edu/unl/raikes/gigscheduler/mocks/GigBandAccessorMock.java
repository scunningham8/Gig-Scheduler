package edu.unl.raikes.gigscheduler.mocks;

import java.util.ArrayList;

import edu.unl.raikes.gigscheduler.Gig;
import edu.unl.raikes.gigscheduler.GigBand;
import edu.unl.raikes.gigscheduler.interfaces.IGigBandAccessor;

/**
 * Mock class of a gig band accessor for testing.
 * 
 * @author sarahcunningham
 *
 */
public class GigBandAccessorMock implements IGigBandAccessor {
    ArrayList<GigBand> relationships;

    /**
     * Constructor for the mock.
     */
    public GigBandAccessorMock() {
        this.relationships = new ArrayList<GigBand>();
    }

    @Override
    public GigBand getGigBandsByID(int id) {
        for (GigBand relationships : this.relationships) {
            if (relationships.getID() == id) {
                return relationships;
            }
        }
        return null;
    }

    @Override
    public GigBand saveGigBands(GigBand gigBand) {
        this.relationships.add(gigBand);
        return null;
    }

    /**
     * Getter for the list of relationships.
     * 
     * @return the list of relationships
     */
    public ArrayList<GigBand> getRelationships() {
        return this.relationships;
    }

    @Override
    public ArrayList<GigBand> getGigBandsByGigID(int id) {
        ArrayList<GigBand> gigbands = new ArrayList<GigBand>();
        for (GigBand relationship : this.relationships) {
            if (relationship.getGigID() == id) {
                gigbands.add(relationship);
            }
        }
        return gigbands;
    }

}
