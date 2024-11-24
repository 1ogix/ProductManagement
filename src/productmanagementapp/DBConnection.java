/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productmanagementapp;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author alananthonyrubi
 */
public class DBConnection {
    private static Properties loadProperties() throws IOException {
        Properties properties = new Properties();
        try (InputStream input = DBConnection.class.getResourceAsStream("/productmanagementapp/dbconfig.properties")) {
            if (input == null) {
                throw new IOException("Configuration file 'dbconfig.properties' not found.");
            }
            properties.load(input);
        }
        return properties;
    }

    public static Connection getConnection() throws SQLException, IOException {
        Properties props = loadProperties();
        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");

        return DriverManager.getConnection(url, user, password);
    }
}
