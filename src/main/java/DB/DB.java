package DB;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
    public static final Logger LOGGER = Logger.getLogger(DB.class);
    Statement statement = null;

    public void printSports() {
        Connection connection = Connector.getConnection();
        try {
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            LOGGER.error(throwables);
        }
        ResultSet result1 = null;
        try {
            String sql = "SELECT * FROM sport";
            LOGGER.debug("Executing SQL: " + sql);
            result1 = statement.executeQuery(sql);
        } catch (SQLException throwables) {
            LOGGER.error(throwables);
        }
        LOGGER.info("Printing statement");
        while (true) {
            try {
                if (!result1.next()) break;
            } catch (SQLException throwables) {
                LOGGER.error(throwables);
            }
            try {
                System.out.println("id:" + result1.getInt("id")
                        + "\t" + result1.getString("name") + "\t\t type: " + result1.getString("type"));
            } catch (SQLException throwables) {
                LOGGER.error(throwables);
            }
        }

    }

    public void addSport(String name, String type) {
        Connection connection = Connector.getConnection();
        try {
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            LOGGER.error(throwables);
        }
        try {
            String sql = "INSERT INTO sport(name, type) values('" + name + "', '" + type + "')";
            LOGGER.debug("Executing SQL: " + sql);
            statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            LOGGER.error(throwables);
        }
    }
}
