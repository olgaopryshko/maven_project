package DB;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connector {
    private static final Logger LOGGER = Logger.getLogger(Connector.class);
    public static String url = "jdbc:postgresql://127.0.0.1:5432/postgres";
    static Connection connection = null;

    public static Connection getConnection()
    {
        if (connection != null) {
            return connection;
        }

        Properties props = new Properties();
        props.setProperty("user","myuser");
        props.setProperty("password","mypassword");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (
                ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
            LOGGER.error("PostgreSQL JDBC Driver is not found. Include it in your library path");
        }
        try {
            connection = DriverManager.getConnection(url, props);
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
            LOGGER.error("Connection Failed");
        }

        if (connection != null) {
            LOGGER.info("You successfully connected to database now");
        } else {
            LOGGER.info("Failed to make connection to database");
        }
        return connection;
    }


}


