package objects;

import java.util.List;

/**
 * Class that represents a Gig.
 * 
 * @author sarahcunningham
 *
 */
public class Gig {
    private int ID;
    private String name;
    private String dateTime;
    private String description;
    private String ticketCost;
    private String ticketLink;
    private String notes;

    /**
     * Constructor that creates a Gig object.
     * 
     * @param id the id of the gig in the table
     * @param name the name of the gig
     * @param dateTime the date and time of the gig
     * @param description the description of the gig
     * @param ticketCost cost of a ticket to the gig
     * @param ticketLink a link to buy a ticket
     * @param notes notes about the gig
     */
    public Gig(int id, String name, String dateTime, String description, String ticketCost, String ticketLink,
            String notes) {
        this.ID = id;
        this.name = name;
        this.dateTime = dateTime;
        this.description = description;
        this.ticketCost = ticketCost;
        this.ticketLink = ticketLink;
        this.notes = notes;
    }

    /**
     * Creates a large string of all gigs in a list.
     * 
     * @param gigs a list of gigs
     * @return a long string of information
     */
    public static String collectionToString(List<Gig> gigs) {
        StringBuilder toReturn = new StringBuilder();
        for (Gig gig : gigs) {
            toReturn.append(gig.toString() + "\n");
        }
        return toReturn.toString();
    }

    /**
     * Gets the id of the gig.
     * 
     * @return the id of the gig
     */
    public int getID() {
        return this.ID;
    }

    /**
     * Gets the name of the gig.
     * 
     * @return the name of the gig
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the gig.
     * 
     * @param name the name of the gig
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the date and time of the gig.
     * 
     * @return the date and time of the gig
     */
    public String getDateTime() {
        return this.dateTime;
    }

    /**
     * Sets the date and time of the gig.
     * 
     * @param dateTime the date and time of the gig
     */
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * Gets the description of the gig.
     * 
     * @return the description of the gig
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the description of the gig.
     * 
     * @param description the description of the gig
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the ticket cost of the gig.
     * 
     * @return the ticket cost of the gig
     */
    public String getTicketCost() {
        return this.ticketCost;
    }

    /**
     * Sets the ticket cost of the gig.
     * 
     * @param ticketCost the ticket cost of the gig
     */
    public void setTicketCost(String ticketCost) {
        this.ticketCost = ticketCost;
    }

    /**
     * Gets the ticket link of the gig.
     * 
     * @return the ticket link of the gig
     */
    public String getTicketLink() {
        return this.ticketLink;
    }

    /**
     * Sets the ticket link of the gig.
     * 
     * @param ticketLink the ticket link of the gig
     */
    public void setTicketLink(String ticketLink) {
        this.ticketLink = ticketLink;
    }

    /**
     * Gets the notes of the gig.
     * 
     * @return the notes of the gig
     */
    public String getNotes() {
        return this.notes;
    }

    /**
     * Sets the notes of the gig.
     * 
     * @param notes the notes of the gig
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        String toReturn = "Gig name: " + this.name + "\n" + "Start date/time: " + this.dateTime + "\n" + "Description: "
                + this.description + "\n" + "Ticket Cost: $" + this.ticketCost + "\n";
        if (this.ticketLink != null) {
            if (this.ticketLink.length() != 0) {
                toReturn += "Link for tickets: " + this.ticketLink + "\n";
            }
        }
        toReturn += "Notes: " + this.notes + "\n";
        return toReturn;
    }
}
