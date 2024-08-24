package objects;

import java.util.List;

/**
 * Represents the Bands table.
 * 
 * @author sarahcunningham
 *
 */
public class Band {
    private int ID;
    private String name;
    private String hometown;
    private String websiteLink;
    private String imageLink;
    private boolean isHeadliner;
    
    /**
     * Constructor that creates a Band object.
     * 
     * @param ID the ID to identify it in the table
     * @param name the name of the band
     * @param hometown the hometown of the band
     * @param websiteLink a URL to the band's website
     * @param imageLink a URL to an image of the band
     */
    public Band(int id, String name, String hometown, String websiteLink, String imageLink) {
        this.ID = id;
        this.name = name;
        this.hometown = hometown;
        this.websiteLink = websiteLink;
        this.imageLink = imageLink;
    }
    
    /**
     * Creates a large string of all bands in a list.
     * 
     * @param bands a list of bands
     * @return a long string of information
     */
    public static String collectionToString(List<Band> bands) {
        StringBuilder toReturn = new StringBuilder();
        for (Band band : bands) {
            toReturn.append(band.toString() + "\n");
        }
        return toReturn.toString();
    }

    /**
     * Gets the ID of a band.
     * 
     * @return the ID of the band
     */
    public int getID() {
        return this.ID;
    }

    /**
     * Gets the name of a band.
     * 
     * @return the name of the band
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of a band.
     * 
     * @param name the name of the band
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the hometown of a band.
     * 
     * @return the hometown of the band
     */
    public String getHometown() {
        return this.hometown;
    }

    /**
     * Sets the hometown of a band.
     * 
     * @param hometown the hometown of the band
     */
    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    /**
     * Gets the website link of a band.
     * 
     * @return the website link of the band
     */
    public String getWebsiteLink() {
        return this.websiteLink;
    }

    /**
     * Sets the website link of a band.
     * 
     * @param website link the website link of the band
     */
    public void setWebsiteLink(String websiteLink) {
        this.websiteLink = websiteLink;
    }

    /**
     * Gets the image link of a band.
     * 
     * @return the image link of the band
     */
    public String getImageLink() {
        return this.imageLink;
    }

    /**
     * Sets the image link of a band.
     * 
     * @param image link the image link of the band
     */
    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }
    
    /**
     * Gets whether or not a band is a headliner.
     * 
     * @return the result
     */
    public boolean isHeadliner() {
        return this.isHeadliner;
    }

    /**
     * Sets whether or not a band is a headliner.
     * 
     * @param isHeadliner the value
     */
    public void setHeadliner(boolean isHeadliner) {
        this.isHeadliner = isHeadliner;
    }

    @Override
    public String toString() {
        String toReturn = String.format("band name: %s \n"
                + "\thometown: %s \n", this.name, this.hometown);
        if (this.websiteLink.length() != 0 || this.websiteLink != null) {
            toReturn += "\twebsite: " + this.websiteLink + "\n";
        }
        if (this.websiteLink.length() != 0) {
            toReturn += "image: " + this.imageLink + "\n";
        }
        return toReturn;
    }

}
