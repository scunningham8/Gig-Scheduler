package edu.unl.raikes.gigscheduler.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import edu.unl.raikes.gigscheduler.interfaces.IBandAccessor;
import edu.unl.raikes.gigscheduler.interfaces.IGigAccessor;
import edu.unl.raikes.gigscheduler.interfaces.IGigBandAccessor;
import edu.unl.raikes.gigscheduler.interfaces.IInput;
import edu.unl.raikes.gigscheduler.mocks.BandAccessorMock;
import edu.unl.raikes.gigscheduler.mocks.GigAccessorMock;
import edu.unl.raikes.gigscheduler.mocks.GigBandAccessorMock;
import edu.unl.raikes.gigscheduler.mocks.InputMock;
import edu.unl.raikes.gigscheduler.mocks.OutputMock;

import org.junit.Test;

public class ValidationTest {

    @Test
    public void testIfPriceWorksWithTooManyDecimalsRoundDown() {
        // setup
        String price = "101.111";
        String[] mock = { "101" };
        Validation test = new Validation(new InputMock(mock), new OutputMock());
        String expected = "101.11";

        // make object and pass in mock interfaces
        String actual = test.isPrice(price);

        // execute

        assertEquals("Price validation didn't cut off decimals correctly", expected, actual);

    }

    public void testIfPriceWorksWithTooManyDecimalsRoundUp() {
        // setup
        String price = "101.157";
        String[] mock = { "101" };
        Validation test = new Validation(new InputMock(mock), new OutputMock());
        String expected = "101.15";

        // make object and pass in mock interfaces
        String actual = test.isPrice(price);

        // execute

        assertEquals("Price validation didn't cut off decimals correctly", expected, actual);

    }

    @Test
    public void testIfOptionDoesntWorkWithNegativeNumber() {
        // setup
        OutputMock out = new OutputMock();
        List<String> expected = new ArrayList<String>();
        // add the strings that should print - prompt and responses
        expected.add("Sorry, that number isn't one of the options. Please try again. ");
        String[] mock = { "4" };
        String input = "-1";

        // execute
        Validation test = new Validation(new InputMock(mock), out);
        test.isOption(input);
        List<String> actual = out.getOutput();

        // test
        assertEquals("invalid output with a negative number", expected, actual);

    }

    @Test
    public void testIfOptionDoesntWorkWithLargerNumber() {
        // setup
        OutputMock out = new OutputMock();
        List<String> expected = new ArrayList<String>();
        // add the strings that should print - prompt and responses
        expected.add("Sorry, that number isn't one of the options. Please try again. ");
        String[] mock = { "3" };
        String input = "5";

        // execute
        Validation test = new Validation(new InputMock(mock), out);
        test.isOption(input);
        List<String> actual = out.getOutput();

        // test
        assertEquals("invalid output with a large number", expected, actual);

    }

    @Test
    public void testIfOptionDoesntWorkTwice() {
        // setup
        OutputMock out = new OutputMock();
        List<String> expected = new ArrayList<String>();
        // add the strings that should print - prompt and responses
        expected.add("Sorry, that number isn't one of the options. Please try again. ");
        expected.add("Sorry, that number isn't one of the options. Please try again. ");
        String[] mock = { "0", "2" };
        String input = "5";

        // execute
        Validation test = new Validation(new InputMock(mock), out);
        test.isOption(input);
        List<String> actual = out.getOutput();

        // test
        assertEquals("invalid output with a larger number then 0", expected, actual);

    }

    @Test
    public void testIfOptionWorks() {
        // setup
        OutputMock out = new OutputMock();
        List<String> expected = new ArrayList<String>();
        // add the strings that should print - prompt and responses
        String[] mock = { "3" };
        String input = "2";

        // execute
        Validation test = new Validation(new InputMock(mock), out);
        test.isOption(input);
        List<String> actual = out.getOutput();

        // test
        assertEquals("invalid output with a large number", expected, actual);

    }

    @Test
    public void testIfDateWorks() {
        // setup
        OutputMock out = new OutputMock();
        List<String> expected = new ArrayList<String>();
        // add the strings that should print - prompt and responses
        String[] mock = { "3" };
        String input = "2020-10-20";

        // execute
        Validation test = new Validation(new InputMock(mock), out);
        test.isDate(input);
        List<String> actual = out.getOutput();

        // test
        assertEquals("date isn't read correctly", expected, actual);

    }

    @Test
    public void testIfDateDoesntWorkWithNoDashes() {
        // setup
        OutputMock out = new OutputMock();
        List<String> expected = new ArrayList<String>();
        expected.add("Sorry, the date you inputted wasn't in the correct format. Please try again. ");
        String[] mock = { "2020-10-20" };
        String input = "20201020";

        // execute
        Validation test = new Validation(new InputMock(mock), out);
        test.isDate(input);
        List<String> actual = out.getOutput();

        // test
        assertEquals("date isn't read correctly", expected, actual);

    }

    @Test
    public void testIfDateDoesntWorkWithLettersAndNoDashes() {
        // setup
        OutputMock out = new OutputMock();
        List<String> expected = new ArrayList<String>();
        expected.add("Sorry, the date you inputted wasn't in the correct format. Please try again. ");
        String[] mock = { "2020-10-20" };
        String input = "abcdefghij";

        // execute
        Validation test = new Validation(new InputMock(mock), out);
        test.isDate(input);
        List<String> actual = out.getOutput();

        // test
        assertEquals("date isn't read correctly", expected, actual);

    }

    @Test
    public void testIfDateDoesntWorkWithLettersAndDashes() {
        // setup
        OutputMock out = new OutputMock();
        List<String> expected = new ArrayList<String>();
        expected.add("Sorry, the date you inputted wasn't in the correct format. Please try again. ");
        String[] mock = { "2020-10-20" };
        String input = "abcd-fg-ij";

        // execute
        Validation test = new Validation(new InputMock(mock), out);
        test.isDate(input);
        List<String> actual = out.getOutput();

        // test
        assertEquals("date isn't read correctly", expected, actual);

    }

    @Test
    public void testIfDateDoesntWorkWithTooManyDigits() {
        // setup
        OutputMock out = new OutputMock();
        List<String> expected = new ArrayList<String>();
        expected.add("Sorry, the date you inputted wasn't in the correct format. Please try again. ");
        String[] mock = { "2020-10-20" };
        String input = "2020-10-200";

        // execute
        Validation test = new Validation(new InputMock(mock), out);
        test.isDate(input);
        List<String> actual = out.getOutput();

        // test
        assertEquals("date isn't read correctly", expected, actual);

    }

    @Test
    public void testIfDateDoesntWorkWithOneLessDigits() {
        // setup
        OutputMock out = new OutputMock();
        List<String> expected = new ArrayList<String>();
        expected.add("Sorry, the date you inputted wasn't in the correct format. Please try again. ");
        String[] mock = { "2020-10-20" };
        String input = "2020-10-2";

        // execute
        Validation test = new Validation(new InputMock(mock), out);
        test.isDate(input);
        List<String> actual = out.getOutput();

        // test
        assertEquals("date isn't read correctly", expected, actual);

    }

    @Test
    public void testIfDateDoesntWorkWithMultipleProblems() {
        // setup
        OutputMock out = new OutputMock();
        List<String> expected = new ArrayList<String>();
        expected.add("Sorry, the date you inputted wasn't in the correct format. Please try again. ");
        expected.add("Sorry, the date you inputted wasn't in the correct format. Please try again. ");
        expected.add("Sorry, the date you inputted wasn't in the correct format. Please try again. ");
        expected.add("Sorry, the date you inputted wasn't in the correct format. Please try again. ");
        String[] mock = { "2020-10-2", "avs", "11-12-2004", "2004-06-04" };
        String input = "2020102002";

        // execute
        Validation test = new Validation(new InputMock(mock), out);
        test.isDate(input);
        List<String> actual = out.getOutput();

        // test
        assertEquals("date isn't read correctly", expected, actual);

    }

    @Test
    public void testIfTimeDoesntWorkWithOneLessDigits() {
        // setup
        OutputMock out = new OutputMock();
        List<String> expected = new ArrayList<String>();
        expected.add("Sorry, the time you inputted wasn't in the correct format. Please try again. ");
        String[] mock = { "12:24:00" };
        String input = "12:24:0";

        // execute
        Validation test = new Validation(new InputMock(mock), out);

        test.isTime(input);
        List<String> actual = out.getOutput();

        // test
        assertEquals("time isn't read correctly", expected, actual);

    }

    @Test
    public void testIfTimeDoesntWorkWithMultipleProblems() {
        // setup
        OutputMock out = new OutputMock();
        List<String> expected = new ArrayList<String>();
        expected.add("Sorry, the time you inputted wasn't in the correct format. Please try again. ");
        expected.add("Sorry, the time you inputted wasn't in the correct format. Please try again. ");
        expected.add("Sorry, the time you inputted wasn't in the correct format. Please try again. ");
        expected.add("Sorry, the time you inputted wasn't in the correct format. Please try again. ");
        String[] mock = { "2020-10-2", "avs", "11-12-2004", "00:00:00" };
        String input = "000000";

        // execute
        Validation test = new Validation(new InputMock(mock), out);
        test.isTime(input);
        List<String> actual = out.getOutput();

        // test
        assertEquals("date isn't read correctly", expected, actual);

    }

    @Test
    public void testIfTimeDoesntWorkWithOneLetters() {
        // setup
        OutputMock out = new OutputMock();
        List<String> expected = new ArrayList<String>();
        expected.add("Sorry, the time you inputted wasn't in the correct format. Please try again. ");
        String[] mock = { "12:24:00" };
        String input = "abcdefgh";

        // execute
        Validation test = new Validation(new InputMock(mock), out);

        test.isTime(input);
        List<String> actual = out.getOutput();

        // test
        assertEquals("date isn't read correctly", expected, actual);

    }

    @Test
    public void testIfTimeWorks() {
        // setup
        OutputMock out = new OutputMock();
        List<String> expected = new ArrayList<String>();
        // expected.add("Sorry, the date you inputted wasn't in the correct format. Please try again. ");
        String[] mock = { "12:24:00" };
        String input = "12:24:00";

        // execute
        Validation test = new Validation(new InputMock(mock), out);

        System.out.println(test.isTime(input));
        List<String> actual = out.getOutput();

        // test
        assertEquals("date isn't read correctly", expected, actual);

    }

    @Test
    public void testIfIs50CharsDoesntWorkWithMoreThan50Chars() {
        // setup
        OutputMock out = new OutputMock();
        List<String> expected = new ArrayList<String>();
        expected.add("Sorry, that's too many characters. Please try again. ");
        String[] mock = { "12:24:00" };
        String input = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";

        // execute
        Validation test = new Validation(new InputMock(mock), out);

        test.is50Chars(input);
        List<String> actual = out.getOutput();

        // test
        assertEquals("date isn't read correctly", expected, actual);

    }

    @Test
    public void testIfIs50CharsDoesntWorskWithLessThan50Chars() {
        // setup
        OutputMock out = new OutputMock();
        List<String> expected = new ArrayList<String>();
        String[] mock = { "12:24:00" };
        String input = "abcdefghijklmnopqrstvwxyz";

        // execute
        Validation test = new Validation(new InputMock(mock), out);

        test.is50Chars(input);
        List<String> actual = out.getOutput();

        // test
        assertEquals("date isn't read correctly", expected, actual);

    }

    @Test
    public void testIfIs100CharsDoesntWorkWithMoreThan100Chars() {
        // setup
        OutputMock out = new OutputMock();
        List<String> expected = new ArrayList<String>();
        expected.add("Sorry, that's too many characters. Please try again. ");
        String[] mock = { "12:24:00" };
        String input = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdef"
                + "ghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";

        // execute
        Validation test = new Validation(new InputMock(mock), out);

        test.is100Chars(input);
        List<String> actual = out.getOutput();

        // test
        assertEquals("date isn't read correctly", expected, actual);

    }

    @Test
    public void testIfIs100CharsDoesntWorskWithLessThan100Chars() {
        // setup
        OutputMock out = new OutputMock();
        List<String> expected = new ArrayList<String>();
        String[] mock = { "12:24:00" };
        String input = "abcdefghijklmnopqrstvwxyz";

        // execute
        Validation test = new Validation(new InputMock(mock), out);

        test.is50Chars(input);
        List<String> actual = out.getOutput();

        // test
        assertEquals("date isn't read correctly", expected, actual);

    }
    
    @Test
    public void testIfIs500CharsDoesntWorkWithMoreThan500Chars() {
        // setup
        OutputMock out = new OutputMock();
        List<String> expected = new ArrayList<String>();
        expected.add("Sorry, that's too many characters. Please try again. ");
        String[] mock = { "12:24:00" };
        String input = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdef"
                + "ghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
                + "ghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
                + "ghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";

        // execute
        Validation test = new Validation(new InputMock(mock), out);

        test.is100Chars(input);
        List<String> actual = out.getOutput();

        // test
        assertEquals("date isn't read correctly", expected, actual);

    }

    @Test
    public void testIfIs500CharsDoesntWorskWithLessThan500Chars() {
        // setup
        OutputMock out = new OutputMock();
        List<String> expected = new ArrayList<String>();
        String[] mock = { "12:24:00" };
        String input = "abcdefghijklmnopqrstvwxyz";

        // execute
        Validation test = new Validation(new InputMock(mock), out);

        test.is50Chars(input);
        List<String> actual = out.getOutput();

        // test
        assertEquals("date isn't read correctly", expected, actual);

    }
    
    @Test
    public void testIfIs1000CharsDoesntWorkWithMoreThan1000Chars() {
        // setup
        OutputMock out = new OutputMock();
        List<String> expected = new ArrayList<String>();
        expected.add("Sorry, that's too many characters. Please try again. ");
        String[] mock = { "12:24:00" };
        String input = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdef"
                + "ghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
                + "ghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
                + "ghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
                + "ghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
                + "ghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
                + "ghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
                + "ghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";

        // execute
        Validation test = new Validation(new InputMock(mock), out);

        test.is100Chars(input);
        List<String> actual = out.getOutput();

        // test
        assertEquals("date isn't read correctly", expected, actual);

    }

    @Test
    public void testIfIs1000CharsDoesntWorskWithLessThan1000Chars() {
        // setup
        OutputMock out = new OutputMock();
        List<String> expected = new ArrayList<String>();
        String[] mock = { "12:24:00" };
        String input = "abcdefghijklmnopqrstvwxyz";

        // execute
        Validation test = new Validation(new InputMock(mock), out);

        test.is50Chars(input);
        List<String> actual = out.getOutput();

        // test
        assertEquals("date isn't read correctly", expected, actual);

    }

}
