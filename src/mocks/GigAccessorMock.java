package edu.unl.raikes.gigscheduler.mocks;

import java.util.ArrayList;

import edu.unl.raikes.gigscheduler.interfaces.IGigAccessor;
import objects.Gig;

/**
 * Mock class of a gig accessor for testing.
 * 
 * @author sarahcunningham
 *
 */
public class GigAccessorMock implements IGigAccessor {
    final int FIVE = 4;
    ArrayList<Gig> gigs;

    /**
     * Constructor for the mock.
     */
    public GigAccessorMock() {
        this.gigs = new ArrayList<Gig>();
    }

    @Override
    public Gig getGigByID(int id) {
        for (Gig gig : this.gigs) {
            if (gig.getID() == id) {
                return gig;
            }
        }
        return null;
    }

    @Override
    public Gig saveGig(Gig gig) {
        this.gigs.add(gig);
        return gig;
    }

    /**
     * Getter for the list of gigs.
     * 
     * @return the list of gigs
     */
    public ArrayList<Gig> getGigs() {
        return this.gigs;
    }

    @Override
    public ArrayList<Gig> getGigsInOrderWithBothDates(String startDate, String endDate) {
        ArrayList<Gig> schedule = new ArrayList<Gig>();
        for (Gig gig : this.gigs) {
            if (Integer.valueOf(gig.getDateTime().substring(0, this.FIVE)) > Integer
                    .valueOf(startDate.substring(0, this.FIVE))
                    && Integer.valueOf(gig.getDateTime().substring(0, this.FIVE)) < Integer
                            .valueOf(endDate.substring(0, this.FIVE))) {
                schedule.add(gig);
            }
        }
        return schedule;
    }

    @Override
    public ArrayList<Gig> getGigsInOrderWithStartDate(String startDate) {
        ArrayList<Gig> schedule = new ArrayList<Gig>();
        for (Gig gig : this.gigs) {
            if (Integer.valueOf(gig.getDateTime().substring(0, this.FIVE)) > Integer
                    .valueOf(startDate.substring(0, this.FIVE))) {
                schedule.add(gig);
            }
        }
        return schedule;
    }

    @Override
    public ArrayList<Gig> getGigsInOrderWithEndDate(String endDate) {
        ArrayList<Gig> schedule = new ArrayList<Gig>();
        for (Gig gig : this.gigs) {
            if (Integer.valueOf(gig.getDateTime().substring(0, this.FIVE)) < Integer
                    .valueOf(endDate.substring(0, this.FIVE))) {
                schedule.add(gig);
            }
        }
        return schedule;
    }

    @Override
    public ArrayList<Gig> getGigsInOrderWithNoDates() {
        return this.gigs;
    }

}
