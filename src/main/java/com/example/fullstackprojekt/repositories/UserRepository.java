package com.example.fullstackprojekt.repositories;

import com.example.fullstackprojekt.models.User;
import com.example.fullstackprojekt.utilities.ConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class UserRepository {

    Connection connection;


    public UserRepository() {
        connection = ConnectionManager.connectToMySQL();
    }


    public void createUser(User user) {

        String query = "INSERT INTO user (user_email, user_password, user_firstname, user_lastname) VALUES(?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFirstName());
            preparedStatement.setString(4, user.getLastName());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println("kan ikke indsætte bruger");
            e.printStackTrace();
        }

    }

    public User selectUserById(int id) {
    String query = "SELECT * FROM user WHERE user_id = " + id;
    User selectedUser = null;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int userId = resultSet.getInt(1);
                String userEmail = resultSet.getString(2);
                String password = resultSet.getString(3);
                String userFirstname = resultSet.getString(4);
                String userLastname = resultSet.getString(5);
                selectedUser = new User(userId, userEmail, password, userFirstname, userLastname);
            }

        } catch (SQLException e) {
            System.out.println("kunne ikke finde bruger");
            e.printStackTrace();
        }
        System.out.println(selectedUser);

        return selectedUser;
    }
}
