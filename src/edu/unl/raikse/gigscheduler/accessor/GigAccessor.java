package edu.unl.raikse.gigscheduler.accessor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edu.unl.raikes.gigscheduler.ConnectionFactory;
import edu.unl.raikes.gigscheduler.Gig;
import edu.unl.raikes.gigscheduler.interfaces.IGigAccessor;

/**
 * Class to access the gig table.
 * 
 * @author sarahcunningham
 *
 */
public class GigAccessor extends ConnectionFactory implements IGigAccessor {

    @Override
    public Gig getGigByID(int id) {
        Connection conn = null;
        Statement stmt = null;
        Gig gig = null;

        try {
            // STEP 3: Open a connection
            conn = ConnectionFactory.getConnection();

            // STEP 4: Execute an insert statement
            stmt = conn.createStatement();

            String insert = "SELECT * FROM gigs where ID = \"" + id + "\";";

            // STEP 5: Process the results
            ResultSet rs = stmt.executeQuery(insert);
            while (rs.next()) {

                // Retrieve by column name
                String name = rs.getString("name");
                String dateTime = rs.getString("startdateTime");
                String description = rs.getString("description");
                double ticketCost = rs.getDouble("ticketCost");
                String ticketLink = rs.getString("websiteLink");
                String notes = rs.getString("notes");

                // create character object
                gig = new Gig(id, name, dateTime, description, (ticketCost + ""), ticketLink, notes);

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

        return gig;
    }

    @Override
    public Gig saveGig(Gig gig) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // STEP 3: Open a connection
            conn = ConnectionFactory.getConnection();

            // STEP 4: Execute an insert statement
            stmt = conn.createStatement();

            String insert = "INSERT INTO gigs (name, startdateTime, description, ticketCost, websiteLink, notes) values"
                    + "(\"" + gig.getName() + "\", \"" + gig.getDateTime() + "\", \"" + gig.getDescription() + "\", \""
                    + gig.getTicketCost() + "\", \"" + gig.getTicketLink() + "\", \"" + gig.getNotes() + "\")";
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

        return gig;
    }

    @Override
    public ArrayList<Gig> getGigsInOrderWithBothDates(String startDate, String endDate) {
        ArrayList<Gig> gigList = new ArrayList<Gig>();
        Connection conn = null;
        Statement stmt = null;
        try {
            // STEP 3: Open a connection
            conn = ConnectionFactory.getConnection();
            // STEP 4: Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT * FROM gigs where startdatetime > '" + startDate + " 00:00:00'"
                    + " and startDateTime < '" + endDate + " 23:59:59'" + " ORDER BY startdatetime;";
            ResultSet rs = stmt.executeQuery(sql);
            // STEP 5: Extract data from result set & display values
            while (rs.next()) {

                // Retrieve by column name
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String dateTime = rs.getString("startdateTime");
                String description = rs.getString("description");
                double ticketCost = rs.getDouble("ticketCost");
                String ticketLink = rs.getString("websiteLink");
                String notes = rs.getString("notes");

                // create character object
                Gig c = new Gig(id, name, dateTime, description, (ticketCost + ""), ticketLink, notes);
                gigList.add(c);
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

        return gigList;
    }

    @Override
    public ArrayList<Gig> getGigsInOrderWithStartDate(String startDate) {
        ArrayList<Gig> gigList = new ArrayList<Gig>();
        Connection conn = null;
        Statement stmt = null;
        try {
            // STEP 3: Open a connection
            conn = ConnectionFactory.getConnection();
            // STEP 4: Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT * FROM gigs where startdatetime > '" + startDate + " 00:00:00'"
                    + " ORDER BY startdatetime;";
            ResultSet rs = stmt.executeQuery(sql);

            // STEP 5: Extract data from result set & display values
            while (rs.next()) {

                // Retrieve by column name
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String dateTime = rs.getString("startdateTime");
                String description = rs.getString("description");
                double ticketCost = rs.getDouble("ticketCost");
                String ticketLink = rs.getString("websiteLink");
                String notes = rs.getString("notes");

                // create character object
                Gig c = new Gig(id, name, dateTime, description, (ticketCost + ""), ticketLink, notes);

                gigList.add(c);
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

        return gigList;
    }

    @Override
    public ArrayList<Gig> getGigsInOrderWithEndDate(String endDate) {
        ArrayList<Gig> gigList = new ArrayList<Gig>();
        Connection conn = null;
        Statement stmt = null;
        try {
            // STEP 3: Open a connection
            conn = ConnectionFactory.getConnection();
            // STEP 4: Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT * FROM gigs where startDateTime < '" + endDate + " 23:59:59'"
                    + " ORDER BY startDateTime;";
            ResultSet rs = stmt.executeQuery(sql);
            // STEP 5: Extract data from result set & display values
            while (rs.next()) {

                // Retrieve by column name
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String dateTime = rs.getString("startdateTime");
                String description = rs.getString("description");
                double ticketCost = rs.getDouble("ticketCost");
                String ticketLink = rs.getString("websiteLink");
                String notes = rs.getString("notes");

                // create character object
                Gig c = new Gig(id, name, dateTime, description, (ticketCost + ""), ticketLink, notes);
                gigList.add(c);
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

        return gigList;
    }

    @Override
    public ArrayList<Gig> getGigsInOrderWithNoDates() {
        ArrayList<Gig> gigList = new ArrayList<Gig>();
        Connection conn = null;
        Statement stmt = null;
        try {
            // STEP 3: Open a connection
            conn = ConnectionFactory.getConnection();
            // STEP 4: Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT * FROM gigs ORDER BY startdatetime;";
            ResultSet rs = stmt.executeQuery(sql);

            // STEP 5: Extract data from result set & display values
            while (rs.next()) {

                // Retrieve by column name
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String dateTime = rs.getString("startdateTime");
                String description = rs.getString("description");
                double ticketCost = rs.getDouble("ticketCost");
                String ticketLink = rs.getString("websiteLink");
                String notes = rs.getString("notes");

                // create character object
                Gig c = new Gig(id, name, dateTime, description, (ticketCost + ""), ticketLink, notes);
                gigList.add(c);
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

        return gigList;
    }

}
