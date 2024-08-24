package edu.unl.raikse.gigscheduler.accessor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edu.unl.raikes.gigscheduler.ConnectionFactory;
import edu.unl.raikes.gigscheduler.GigBand;
import edu.unl.raikes.gigscheduler.interfaces.IGigBandAccessor;

/**
 * Class to access the relationship table.
 * 
 * @author sarahcunningham
 *
 */
public class GigBandAccessor implements IGigBandAccessor {

    @Override
    public GigBand getGigBandsByID(int id) {
        Connection conn = null;
        Statement stmt = null;
        GigBand gigBand = null;

        try {
            // STEP 3: Open a connection
            conn = ConnectionFactory.getConnection();

            // STEP 4: Execute an insert statement
            stmt = conn.createStatement();

            String insert = "SELECT * FROM gig_bands where ID = \"" + id + "\";";
            stmt.executeUpdate(insert, Statement.RETURN_GENERATED_KEYS);

            // STEP 5: Process the results
            ResultSet rs = stmt.getGeneratedKeys();
            while (rs.next()) {

                // Retrieve by column name
                int gigID = rs.getInt("gig_Id");
                int bandID = rs.getInt("band_ID");
                boolean isHeadliner = rs.getBoolean("isHeadliner");

                // create character object
                gigBand = new GigBand(id, gigID, bandID, isHeadliner);

            }

            // STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            } // do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        }

        return gigBand;
    }

    @Override
    public GigBand saveGigBands(GigBand gigBand) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // STEP 3: Open a connection
            conn = ConnectionFactory.getConnection();

            // STEP 4: Execute an insert statement
            stmt = conn.createStatement();

            String insert = "INSERT INTO gig_bands (gig_ID, band_ID, isHeadliner) values" + "(\"" + gigBand.getGigID()
                    + "\", \"" + gigBand.getBandID() + "\", \"" + gigBand.isHeadliner() + "\")";
            stmt.executeUpdate(insert, Statement.RETURN_GENERATED_KEYS);

            // STEP 5: Process the results
            ResultSet rs = stmt.getGeneratedKeys();
            int newID = -1;
            if (rs.next()) {
                newID = rs.getInt(1);
            }

            // STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            } // do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        }

        return gigBand;
    }
    
    @Override
    public ArrayList<GigBand> getGigBandsByGigID(int id) {
        ArrayList<GigBand> allRelationships = new ArrayList<GigBand>();
        Connection conn = null;
        Statement stmt = null;
        GigBand gigBand = null;

        try {
            // STEP 3: Open a connection
            conn = ConnectionFactory.getConnection();

            // STEP 4: Execute an insert statement
            stmt = conn.createStatement();

            String insert = "SELECT * FROM gig_bands where gig_ID = \"" + id + "\";";
            //stmt.executeUpdate(insert, Statement.RETURN_GENERATED_KEYS);

            // STEP 5: Process the results
            ResultSet rs = stmt.executeQuery(insert);
            while (rs.next()) {

                // Retrieve by column name
                int iD = rs.getInt("ID");
                int gigID = rs.getInt("gig_Id");
                int bandID = rs.getInt("band_iD");
                boolean isHeadliner = rs.getBoolean("isHeadliner");

                // create character object
                gigBand = new GigBand(iD, gigID, bandID, isHeadliner);
                allRelationships.add(gigBand);
            }

            // STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            } // do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        }

        return allRelationships;
    }

}
