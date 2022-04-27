package com.example.fullstackprojekt.repositories;

import com.example.fullstackprojekt.models.Wish;
import com.example.fullstackprojekt.models.WishList;
import com.example.fullstackprojekt.utilities.ConnectionManager;
import org.springframework.stereotype.Repository;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class WishListRepository {
    Connection connection;

    public WishListRepository() {
        connection = ConnectionManager.connectToMySQL();
    }

    public List<WishList> getAllWishlistByUserId(int id) {
        List<WishList> wishList = new ArrayList();
        final String QUERY = "SELECT * FROM wishlist  WHERE wishlist_user_id=" + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY);


            /*
            PreparedStatement preparedStatement=connection.prepareStatement(QUERY);
            preparedStatement.setInt(1,id);


            ResultSet resultSet= preparedStatement.executeQuery();

             */

            while (resultSet.next()) {
                int wishlistId = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String description = resultSet.getString(3);
                int userId = resultSet.getInt(4);
                int ownerId = resultSet.getInt(5);
                wishList.add(new WishList(wishlistId, name, description, userId, ownerId));

            }
            System.out.println("wishlist was found");
            statement.close();
        }catch (SQLException e){
            System.out.println(e + "Not Found");
            e.printStackTrace();
        }
        return wishList;
    }

    public List<WishList> createWishList(WishList wishList){
        List<WishList> newWishList= new ArrayList<>();
        final String QUERY="INSERT INTO wishlist ( wishlist_name, wishlist_description, wishlist_user_id, wishlist_owner_id) VALUES(?, ? , ? , ?)";
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(QUERY);
            preparedStatement.setString(1,wishList.getName());
            preparedStatement.setString(2,wishList.getDescription());
            preparedStatement.setInt(3,wishList.getUserId());
            preparedStatement.setInt(4,wishList.getUserId());
            preparedStatement.executeUpdate();
            newWishList.add(new WishList(wishList.getName(), wishList.getDescription(), wishList.getUserId()));
            preparedStatement.close();
            System.out.println("created");
        }
        catch (SQLException e){
            System.out.println(e + " not created");
            e.printStackTrace();
        }
     return newWishList;
    }

    public WishList findWishListById(int id){
        final String FIND_QUERY="SELECT * FROM wishlist  WHERE wishlist_id=?" + id;
        WishList wishList=null;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(FIND_QUERY);
            preparedStatement.setInt(1,id);
            ResultSet resultSet= preparedStatement.executeQuery();
            resultSet.next();
            id=resultSet.getInt(1);
            String name= resultSet.getString(2);
            String description = resultSet.getString(3);
            int userId = resultSet.getInt(4);
            int ownerId = resultSet.getInt(5);
            wishList= new WishList(id, name, description, userId, ownerId);
            System.out.println("is found");

        }catch (SQLException e){
            System.out.println(e + "Not Found");
            e.printStackTrace();
        }
        return wishList;
    }

    public void updateByid(WishList wishList) {

        final String UPDATE_QUERY="UPDATE wishlist SET wishlist_name=?, wishlist_description=? WHERE wishlist_user_id=?";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(UPDATE_QUERY);
            preparedStatement.setString(1,wishList.getName());
            preparedStatement.setString(2,wishList.getDescription());
            preparedStatement.setInt(3, wishList.getId());
            preparedStatement.executeUpdate();
            System.out.println("is update");
        }catch (SQLException e){
            System.out.println("Could not update");
            e.printStackTrace();
        }
    }

    public void deleteById(int id){
        final String DELETE_QUERY="DELETE FROM wishlist WHERE wishlist_id=?";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(DELETE_QUERY);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            System.out.println("Is deleted");

        }catch (SQLException e){
            System.out.println("is not deleted");
            e.printStackTrace();
        }
    }


    public List<WishList> getAllSharedLists(int userId) {

        List<WishList> wishlistLists = new ArrayList<>();

        String query = "SELECT * FROM wishlist WHERE wishlist_id IN (SELECT wishlist_users_wishlist_id " +
                "FROM wishlist_users WHERE wishlist_users_user_id=" + userId + ")";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int wishlistId = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String description = resultSet.getString(3);
                int wishlistUserId = resultSet.getInt(4);
                int ownerId = resultSet.getInt(5);
                wishlistLists.add(new WishList(wishlistId, name, description, wishlistUserId, ownerId));
            }

        }
        catch (SQLException e) {
            System.out.println("kunne ikke hente de delte lister med userID = " + userId);
            e.printStackTrace();
        }


        return wishlistLists;

    }
}

