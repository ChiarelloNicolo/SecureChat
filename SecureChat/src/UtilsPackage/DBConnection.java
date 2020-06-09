package UtilsPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/";
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";

    public DBConnection() {
        super();
    }

    public static Connection openConnection(String database, String username, String password) {
        Connection connessione = null;
        try {
            Class.forName(DB_DRIVER);
            connessione = (Connection) DriverManager.getConnection(DB_URL + database, username, password);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("DB Connection failed: " + ex.getMessage());
        }
        return connessione;
    }

    public static void closeConnection(Connection connessione) {
        if (connessione != null) {
            try {
                connessione.close();
                System.out.println("Connessione chiusa correttamente");
            } catch (SQLException ex) {
                System.out.println("DB Closing error: " + ex.getMessage());
            }
        }
    }

}
