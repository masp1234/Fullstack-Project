package com.example.fullstackprojekt.repositories;

import com.example.fullstackprojekt.models.Wish;
import com.example.fullstackprojekt.utilities.ConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class WishRepository {
    Connection connection;


    public WishRepository() {
        connection = ConnectionManager.connectToMySQL();
    }


    public void addWish(Wish wish) {

        final String ADD_QUERY = "INSERT INTO wish(wish_name, wish_description, wish_price, wish_link, wishlist_id) VALUE(?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_QUERY);
            preparedStatement.setString(1, wish.getName());
            preparedStatement.setString(2, wish.getDescription());
            preparedStatement.setDouble(3, wish.getPrice());
            preparedStatement.setString(4, wish.getLink());
            preparedStatement.setInt(5, wish.getWishlistId());
            preparedStatement.executeUpdate();
            System.out.println("is added");
        } catch (SQLException e) {
            System.out.println(e + "Could not add");
            e.printStackTrace();
        }
    }

    public List<Wish> findListById(int id) {
        List<Wish> wishList = new ArrayList<>();
        final String FIND_QUERY = "SELECT * FROM wish  WHERE wishlist_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_QUERY);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int wishId = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String description = resultSet.getString(3);
                double price = resultSet.getDouble(4);
                String link = resultSet.getString(5);
                int isReservedResult = resultSet.getInt(7);

                boolean isReserved = true;
                if (isReservedResult == 0) {
                    isReserved = false;
                }

                wishList.add(new Wish(wishId, name, description, price, link, id, isReserved));
                System.out.println("is found");
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e + "Not Found");
            e.printStackTrace();
        }
        return wishList;
    }

    public Wish selectWishById(int id) {
        final String FIND_QUERY = "SELECT * FROM wish  WHERE wish_id = " + id;

        Wish wish = null;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(FIND_QUERY);
            resultSet.next();

            String name = resultSet.getString(2);
            String description = resultSet.getString(3);
            double price = resultSet.getDouble(4);
            String link = resultSet.getString(5);
            int wishlistId = resultSet.getInt(6);
            int isReservedResult = resultSet.getInt(7);

            boolean isReserved = true;
            if (isReservedResult == 0) {
                isReserved = false;
            }

            wish = new Wish(id, name, description, price, link, wishlistId, isReserved);



            System.out.println("found a wish");

        } catch (SQLException e) {
            System.out.println(e + "Not Found");
            e.printStackTrace();
        }
        return wish;
    }

    public void updateByid(Wish wish) {

        final String UPDATE_QUERY = "UPDATE wish SET wish_name=?, wish_description=?, wish_price=?, wish_link=? WHERE wish_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY);
            preparedStatement.setString(1, wish.getName());
            preparedStatement.setString(2, wish.getDescription());
            preparedStatement.setDouble(3, wish.getPrice());
            preparedStatement.setString(4, wish.getLink());
            preparedStatement.setInt(5, wish.getId());
            preparedStatement.executeUpdate();
            System.out.println("is update");
        } catch (SQLException e) {
            System.out.println("Could not update");
            e.printStackTrace();
        }
    }

    public void deleteById(int id) {
        final String DELETE_QUERY = "DELETE FROM wish WHERE wish_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Is deleted");

        } catch (SQLException e) {
            System.out.println("is not deleted");
            e.printStackTrace();
        }
    }

    public void reserveWish(int id, int isReserved) {
        String query = "UPDATE wish Set wish_is_reserved = ? WHERE wish_id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, isReserved);
            preparedStatement.setInt(2, id);


            preparedStatement.executeUpdate();
            System.out.println("is update");

        } catch (SQLException e) {
            System.out.println("Could not update");
            e.printStackTrace();
        }
    }

    }

