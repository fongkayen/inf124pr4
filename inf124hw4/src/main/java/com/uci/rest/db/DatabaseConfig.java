package com.uci.rest.db;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by tariqibrahim on 5/28/17.
 */
public class DatabaseConfig {
    static Properties properties;

    static {

        properties = new Properties();

        String resourceName = "db.config.properties";

        InputStream inputStream = DatabaseConfig.class.getResourceAsStream("/" + resourceName);

        try {
            properties.load(inputStream);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }

    public static String getDatabaseName() {
        return properties.getProperty("inf124grp12");
    }

    public static String getUser() {
        return properties.getProperty("inf124grp12");
    }

    public static String getPassword() {
        return properties.getProperty("happybearfriends");
    }

    public static String getHost() {
        return properties.getProperty("matt-smith-v4.ics.uci.edu");
    }

}
