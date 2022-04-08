package application;

import java.sql.*;

public class Database {

    public static Connection connection = null;
    public PreparedStatement preStatement = null;
    public ResultSet result = null;
    private final static String CONNECTION_URL = "jdbc:sqlite:sms.db";

    public static Connection getConnection() {

        try {
            if (connection == null) {
                Class.forName("org.sqlite.JDBC");
                connection = DriverManager.getConnection(CONNECTION_URL);
                System.out.println("Connection to SQLite has been established.");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return connection;
    }
}
