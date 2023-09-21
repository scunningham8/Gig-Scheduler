package edu.unl.raikes.gigscheduler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class that establishes functions needed to connect the code pagage the the MySQL tables.
 * 
 * @author sarahcunningham
 *
 */
public abstract class ConnectionFactory {

    private static final String DB_URL = "jdbc:mysql://20.55.108.210/scunningham8_gigs?useSSL=false&serverTimezone=UTC";
    private static final String USER = "scunningham8";
    private static final String PASS = "huskers";

    /**
     * Establishes a connection with the MySQL database.
     * 
     * @return a connection to a database
     * @throws SQLException exception is handled elsewhere
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }
}
