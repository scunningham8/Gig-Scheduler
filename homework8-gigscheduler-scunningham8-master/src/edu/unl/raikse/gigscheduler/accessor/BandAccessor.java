package edu.unl.raikse.gigscheduler.accessor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.unl.raikes.gigscheduler.Band;
import edu.unl.raikes.gigscheduler.ConnectionFactory;
import edu.unl.raikes.gigscheduler.interfaces.IBandAccessor;

/**
 * Class to access the band table.
 * 
 * @author sarahcunningham
 *
 */
public class BandAccessor extends ConnectionFactory implements IBandAccessor {

    @Override
    public Band getBandById(int id) {
        Connection conn = null;
        Statement stmt = null;
        Band band = null;

        try {
            // STEP 3: Open a connection
            conn = ConnectionFactory.getConnection();

            // STEP 4: Execute an insert statement
            stmt = conn.createStatement();

            String insert = "SELECT * FROM bands where ID = \"" + id + "\";";

            // STEP 5: Process the results
            ResultSet rs = stmt.executeQuery(insert);
            while (rs.next()) {

                // Retrieve by column name
                String name = rs.getString("name");
                String hometown = rs.getString("hometown");
                String websiteLink = rs.getString("websiteLink");
                String imageLink = rs.getString("imageLink");

                // create character object
                band = new Band(id, name, hometown, websiteLink, imageLink);

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

        return band;
    }

    @Override
    public Band getBandByName(String name) {
        Connection conn = null;
        Statement stmt = null;
        Band band = null;

        try {
            // STEP 3: Open a connection
            conn = ConnectionFactory.getConnection();

            // STEP 4: Execute an insert statement
            stmt = conn.createStatement();

            String insert = "SELECT * FROM bands where name = \"" + name + "\";";

            // STEP 5: Process the results
            ResultSet rs = stmt.executeQuery(insert);
            while (rs.next()) {

                // Retrieve by column name
                int id = rs.getInt("ID");
                String hometown = rs.getString("hometown");
                String websiteLink = rs.getString("websiteLink");
                String imageLink = rs.getString("imageLink");

                // create character object
                band = new Band(id, name, hometown, websiteLink, imageLink);

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

        return band;
    }

    @Override
    public Band saveBand(Band band) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // STEP 3: Open a connection
            conn = ConnectionFactory.getConnection();

            // STEP 4: Execute an insert statement
            stmt = conn.createStatement();

            String insert = "INSERT INTO bands (name, hometown, websiteLink, imageLink) values" + "(\"" + band.getName()
                    + "\", \"" + band.getHometown() + "\", \"" + band.getWebsiteLink() + "\", \"" + band.getImageLink()
                    + "\")";
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

        return band;
    }

}
