package com.example.fullstackprojekt.utilities;

import java.sql.Connection;
import java.sql.DriverManager;

// Singleton og Pure fabrication
// kan lave klassen abstract, da den ikke skal instantieres
public abstract class ConnectionManager {

    // for at sikre, at der kun er 1 connection
    private static Connection connection;


    // kan bruge synchronized keyword i method header til at sikre,
    // at der kun er 1 instans af connection, hvis der er flere tråde
    public static Connection connectToMySQL() {
        String DB_URL = System.getenv("db_url");
        String user = System.getenv("db_user");
        String password = System.getenv("db_password");

        if (connection == null) {
            try {
                connection = DriverManager.getConnection(DB_URL, user, password);
                System.out.println("Virker nu");
            } catch (Exception e) {
                System.out.println("Virker ikke: ");
                e.printStackTrace();
            }
        }
        return connection;
    }

}
