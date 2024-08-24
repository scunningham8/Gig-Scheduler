package edu.unl.raikes.gigscheduler.mocks;

import java.util.ArrayList;

import edu.unl.raikes.gigscheduler.Band;
import edu.unl.raikes.gigscheduler.interfaces.IBandAccessor;

/**
 * Mock class of a band accessor for testing.
 * 
 * @author sarahcunningham
 *
 */
public class BandAccessorMock implements IBandAccessor {
    ArrayList<Band> bands;

    /**
     * Constructor for the mock.
     */
    public BandAccessorMock() {
        this.bands = new ArrayList<Band>();
    }

    @Override
    public Band getBandById(int id) {
        for (Band band : this.bands) {
            if (band.getID() == id) {
                return band;
            }
        }
        return null;
    }

    @Override
    public Band saveBand(Band band) {
        this.bands.add(band);
        return band;
    }

    /**
     * Getter for the list of bands.
     * 
     * @return the list of bands
     */
    public ArrayList<Band> getBands() {
        return this.bands;
    }

    @Override
    public Band getBandByName(String name) {
        for (Band band : this.bands) {
            if (band.getName().equals(name)) {
                return band;
            }
        }
        return null;
    }

}
