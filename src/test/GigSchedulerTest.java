package edu.unl.raikes.gigscheduler.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.unl.raikes.gigscheduler.interfaces.IBandAccessor;
import edu.unl.raikes.gigscheduler.interfaces.IGigAccessor;
import edu.unl.raikes.gigscheduler.interfaces.IGigBandAccessor;
import edu.unl.raikes.gigscheduler.interfaces.IOutput;
import edu.unl.raikes.gigscheduler.interfaces.IInput;
import edu.unl.raikes.gigscheduler.mocks.BandAccessorMock;
import edu.unl.raikes.gigscheduler.mocks.GigAccessorMock;
import edu.unl.raikes.gigscheduler.mocks.GigBandAccessorMock;
import edu.unl.raikes.gigscheduler.mocks.InputMock;
import edu.unl.raikes.gigscheduler.mocks.OutputMock;
import objects.Band;
import objects.Gig;
import objects.GigScheduler;

public class GigSchedulerTest {

    @Test
    public void testIfGigInformationSavesGenericGig() {
        // setup
        String[] arr = { "", "name", "2004-10-10", "12:00:00", "description", "12.00", "", "yes", "link", "notes" };
        IInput input = new InputMock(arr);
        OutputMock output = new OutputMock();
        IBandAccessor bands = new BandAccessorMock();
        GigAccessorMock gigs = new GigAccessorMock();
        IGigBandAccessor relationships = new GigBandAccessorMock();
        Gig expected = new Gig(10, "name", "2004-10-10 12:00:00", "description", "12.00", "link", "notes");
        int length = 1;

        // make object and pass in mock interfaces
        GigScheduler test = new GigScheduler(input, output, bands, gigs, relationships);

        // execute
        // call functions
        Gig actual = test.gigInformation();
        ArrayList<Gig> hey = gigs.getGigs();

        assertEquals("Gig added was not right", expected.getName(), actual.getName());
        assertEquals("gig was not added to the database", length, hey.size());

    }

    @Test
    public void testIfGigInformationSavesBandWithNoWebsite() {
        // setup
        String[] arr = { "", "name", "2004-10-10", "12:00:00", "description", "12.00", "", "yes", "", "notes" };
        IInput input = new InputMock(arr);
        OutputMock output = new OutputMock();
        IBandAccessor bands = new BandAccessorMock();
        GigAccessorMock gigs = new GigAccessorMock();
        IGigBandAccessor relationships = new GigBandAccessorMock();
        Gig expected = new Gig(10, "name", "date", "description", "cost", "link", "notes");
        int length = 1;

        // make object and pass in mock interfaces
        GigScheduler test = new GigScheduler(input, output, bands, gigs, relationships);

        // execute
        // call functions
        Gig actual = test.gigInformation();
        ArrayList<Gig> hey = gigs.getGigs();

        assertEquals("Gig added was not right", expected.getName(), actual.getName());
        assertEquals("gig was not added to the database", length, hey.size());

    }

    @Test
    public void testIfGigInformationSavesBandWithInvalidDate() {
        // setup
        String[] arr = { "", "name", "abcde", "2004-10-10", "12:00:00", "description", "12.00", "", "yes", "link",
                "notes" };
        IInput input = new InputMock(arr);
        OutputMock output = new OutputMock();
        IBandAccessor bands = new BandAccessorMock();
        GigAccessorMock gigs = new GigAccessorMock();
        IGigBandAccessor relationships = new GigBandAccessorMock();
        Gig expected = new Gig(10, "name", "date", "description", "cost", "link", "notes");
        int length = 1;

        // make object and pass in mock interfaces
        GigScheduler test = new GigScheduler(input, output, bands, gigs, relationships);

        // execute
        // call functions
        Gig actual = test.gigInformation();
        ArrayList<Gig> hey = gigs.getGigs();

        assertEquals("Gig added was not right", expected.getName(), actual.getName());
        assertEquals("gig was not added to the database", length, hey.size());

    }

    @Test
    public void testIfBandInformationSavesGenericBand() {
        // setup
        String[] arr = { "town", "yes", "url", "yes", "picture" };
        String name = "name";
        IInput input = new InputMock(arr);
        OutputMock output = new OutputMock();
        BandAccessorMock bands = new BandAccessorMock();
        GigAccessorMock gigs = new GigAccessorMock();
        IGigBandAccessor relationships = new GigBandAccessorMock();
        Band expected = new Band(10, name, "town", "url", "picture");
        int length = 1;

        // make object and pass in mock interfaces
        GigScheduler test = new GigScheduler(input, output, bands, gigs, relationships);

        // execute
        // call functions
        Band actual = test.bandInformation(name);
        ArrayList<Band> hey = bands.getBands();

        assertEquals("Band added was not right", expected.getName(), actual.getName());
        assertEquals("band was not added to the database", length, hey.size());

    }

    @Test
    public void testIfBandInformationIsFound() {
        // setup
        String[] arr = { "town", "yes", "url", "yes", "picture" };
        String name = "name";
        IInput input = new InputMock(arr);
        OutputMock output = new OutputMock();
        BandAccessorMock bands = new BandAccessorMock();
        GigAccessorMock gigs = new GigAccessorMock();
        IGigBandAccessor relationships = new GigBandAccessorMock();
        Band expected = new Band(10, name, "town", "url", "picture");
        int length = 1;

        // make object and pass in mock interfaces
        GigScheduler test = new GigScheduler(input, output, bands, gigs, relationships);
        test.bandInformation(name);

        // execute
        // call functions
        Band actual = test.findBand(name);
        ArrayList<Band> hey = bands.getBands();

        assertEquals("Band was not found right", expected.getName(), actual.getName());
        assertEquals("band was not found in the database", length, hey.size());

    }

    @Test
    public void testIfScheduleInformationIsCorrectWithStartAndEndDate() {
        // setup
        String[] arr = { "", "2000-10-10", "2020-10-10" };
        IInput input = new InputMock(arr);
        OutputMock output = new OutputMock();
        BandAccessorMock bands = new BandAccessorMock();
        GigAccessorMock gigs = new GigAccessorMock();
        IGigBandAccessor relationships = new GigBandAccessorMock();
        Gig one = new Gig(10, "name", "1990-10-10 12:00:00", "description", "12.00", "link", "notes");
        Gig two = new Gig(10, "name", "2004-10-10 12:00:00", "description", "12.00", "link", "notes");
        Gig three = new Gig(10, "name", "2008-10-10 12:00:00", "description", "12.00", "link", "notes");
        Gig four = new Gig(10, "name", "2012-10-10 12:00:00", "description", "12.00", "link", "notes");
        Gig five = new Gig(10, "name", "2022-10-10 12:00:00", "description", "12.00", "link", "notes");
        gigs.saveGig(one);
        gigs.saveGig(two);
        gigs.saveGig(three);
        gigs.saveGig(four);
        gigs.saveGig(five);
        ArrayList<Gig> expected = new ArrayList<Gig>();
        expected.add(two);
        expected.add(three);
        expected.add(four);

        // make object and pass in mock interfaces
        GigScheduler test = new GigScheduler(input, output, bands, gigs, relationships);

        // execute
        // call functions
        ArrayList<Gig> actual = test.getFullSchedule();

        assertEquals("Band was not found right", expected, actual);

    }

    @Test
    public void testIfScheduleInformationIsCorrectWithStartDate() {
        // setup
        String[] arr = { "", "2000-10-10", "" };
        IInput input = new InputMock(arr);
        OutputMock output = new OutputMock();
        BandAccessorMock bands = new BandAccessorMock();
        GigAccessorMock gigs = new GigAccessorMock();
        IGigBandAccessor relationships = new GigBandAccessorMock();
        Gig one = new Gig(10, "name", "1990-10-10 12:00:00", "description", "12.00", "link", "notes");
        Gig two = new Gig(10, "name", "2004-10-10 12:00:00", "description", "12.00", "link", "notes");
        Gig three = new Gig(10, "name", "2008-10-10 12:00:00", "description", "12.00", "link", "notes");
        Gig four = new Gig(10, "name", "2012-10-10 12:00:00", "description", "12.00", "link", "notes");
        Gig five = new Gig(10, "name", "2022-10-10 12:00:00", "description", "12.00", "link", "notes");
        gigs.saveGig(one);
        gigs.saveGig(two);
        gigs.saveGig(three);
        gigs.saveGig(four);
        gigs.saveGig(five);
        ArrayList<Gig> expected = new ArrayList<Gig>();
        expected.add(two);
        expected.add(three);
        expected.add(four);
        expected.add(five);

        // make object and pass in mock interfaces
        GigScheduler test = new GigScheduler(input, output, bands, gigs, relationships);

        // execute
        // call functions
        ArrayList<Gig> actual = test.getFullSchedule();

        assertEquals("Band was not found right", expected, actual);

    }
    
    @Test
    public void testIfScheduleInformationIsCorrectWithEndDate() {
        // setup
        String[] arr = { "", "", "2010-10-10" };
        IInput input = new InputMock(arr);
        OutputMock output = new OutputMock();
        BandAccessorMock bands = new BandAccessorMock();
        GigAccessorMock gigs = new GigAccessorMock();
        IGigBandAccessor relationships = new GigBandAccessorMock();
        Gig one = new Gig(10, "name", "1990-10-10 12:00:00", "description", "12.00", "link", "notes");
        Gig two = new Gig(10, "name", "2004-10-10 12:00:00", "description", "12.00", "link", "notes");
        Gig three = new Gig(10, "name", "2008-10-10 12:00:00", "description", "12.00", "link", "notes");
        Gig four = new Gig(10, "name", "2012-10-10 12:00:00", "description", "12.00", "link", "notes");
        Gig five = new Gig(10, "name", "2022-10-10 12:00:00", "description", "12.00", "link", "notes");
        gigs.saveGig(one);
        gigs.saveGig(two);
        gigs.saveGig(three);
        gigs.saveGig(four);
        gigs.saveGig(five);
        ArrayList<Gig> expected = new ArrayList<Gig>();
        expected.add(one);
        expected.add(two);
        expected.add(three);

        // make object and pass in mock interfaces
        GigScheduler test = new GigScheduler(input, output, bands, gigs, relationships);

        // execute
        // call functions
        ArrayList<Gig> actual = test.getFullSchedule();

        assertEquals("Band was not found right", expected, actual);

    }
    
    @Test
    public void testIfScheduleInformationIsCorrectWithNoDate() {
        // setup
        String[] arr = { "", "", "" };
        IInput input = new InputMock(arr);
        OutputMock output = new OutputMock();
        BandAccessorMock bands = new BandAccessorMock();
        GigAccessorMock gigs = new GigAccessorMock();
        IGigBandAccessor relationships = new GigBandAccessorMock();
        Gig one = new Gig(10, "name", "1990-10-10 12:00:00", "description", "12.00", "link", "notes");
        Gig two = new Gig(10, "name", "2004-10-10 12:00:00", "description", "12.00", "link", "notes");
        Gig three = new Gig(10, "name", "2008-10-10 12:00:00", "description", "12.00", "link", "notes");
        Gig four = new Gig(10, "name", "2012-10-10 12:00:00", "description", "12.00", "link", "notes");
        Gig five = new Gig(10, "name", "2022-10-10 12:00:00", "description", "12.00", "link", "notes");
        gigs.saveGig(one);
        gigs.saveGig(two);
        gigs.saveGig(three);
        gigs.saveGig(four);
        gigs.saveGig(five);
        ArrayList<Gig> expected = new ArrayList<Gig>();
        expected.add(one);
        expected.add(two);
        expected.add(three);
        expected.add(four);
        expected.add(five);

        // make object and pass in mock interfaces
        GigScheduler test = new GigScheduler(input, output, bands, gigs, relationships);

        // execute
        // call functions
        ArrayList<Gig> actual = test.getFullSchedule();

        assertEquals("Band was not found right", expected, actual);

    }
    
    @Test
    public void testIfChooseOptionWorks() {
        // setup
        String[] arr = { "3" };
        IInput input = new InputMock(arr);
        OutputMock output = new OutputMock();
        BandAccessorMock bands = new BandAccessorMock();
        GigAccessorMock gigs = new GigAccessorMock();
        IGigBandAccessor relationships = new GigBandAccessorMock();
        String expected = "3";

        // make object and pass in mock interfaces
        GigScheduler test = new GigScheduler(input, output, bands, gigs, relationships);

        // execute
        // call functions
        String actual = test.chooseOption();

        assertEquals("Band was not found right", expected, actual);

    }
}
