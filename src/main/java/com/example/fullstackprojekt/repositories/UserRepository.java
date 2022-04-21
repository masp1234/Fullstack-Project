package com.example.fullstackprojekt.repositories;

import com.example.fullstackprojekt.utilities.ConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class UserRepository {

    Connection connection;



    public UserRepository() {
        connection = ConnectionManager.connectToMySQL();
    }


    public void createUser() {

        String query = "INSERT INTO user (user_email, user_password, user_firstname, user_lastname) VALUES(?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, );
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println("kan ikke indsætte bruger");
            e.printStackTrace();
        }

    }
}
