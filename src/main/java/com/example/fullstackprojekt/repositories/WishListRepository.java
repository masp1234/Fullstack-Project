package com.example.fullstackprojekt.repositories;

import com.example.fullstackprojekt.models.WishList;
import com.example.fullstackprojekt.utilities.ConnectionManager;
import org.springframework.stereotype.Repository;

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
        final String QUERY = "SELECT * FROM wishlist  WHERE wishlist_owner_id=" + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY);

            while (resultSet.next()) {
                int wishlistId = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String description = resultSet.getString(3);
                int ownerId = resultSet.getInt(4);



                wishList.add(new WishList(wishlistId, name, description, ownerId, true));


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
        final String QUERY="INSERT INTO wishlist ( wishlist_name, wishlist_description, wishlist_owner_id) VALUES(?, ? , ?)";
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(QUERY);
            preparedStatement.setString(1, wishList.getName());
            preparedStatement.setString(2, wishList.getDescription());
            preparedStatement.setInt(3, wishList.getOwnerId());
            preparedStatement.executeUpdate();
            newWishList.add(new WishList(wishList.getName(), wishList.getDescription(), wishList.getOwnerId()));
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
        final String FIND_QUERY="SELECT * FROM wishlist  WHERE wishlist_id="+id;
        WishList wishList = null;
        try {
           PreparedStatement preparedStatement=connection.prepareStatement(FIND_QUERY);
           ResultSet resultSet=preparedStatement.executeQuery();
           resultSet.next();
           int wishlistId = resultSet.getInt(1);
           String name = resultSet.getString(2);
           String description = resultSet.getString(3);
           wishList = new WishList(wishlistId, name, description);
            System.out.println("is found");
        }catch (SQLException e){
            System.out.println(e + "Not Found");
            e.printStackTrace();
        }
        return wishList;
    }

    public void updateByid(WishList wishList) {
        final String UPDATE_QUERY="UPDATE wishlist SET wishlist_name=?, wishlist_description=? WHERE wishlist_id=?";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(UPDATE_QUERY);
            preparedStatement.setString(1,wishList.getName());
            preparedStatement.setString(2,wishList.getDescription());
            preparedStatement.setInt(3, wishList.getId());
            preparedStatement.executeUpdate();

            preparedStatement.close();

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


    public List<WishList> getAllSharedLists(int id) {

        List<WishList> wishlistLists = new ArrayList<>();

        String query = "SELECT * FROM wishlist WHERE wishlist_id IN (SELECT wishlist_users_wishlist_id " +
                "FROM wishlist_users WHERE wishlist_users_user_id=" + id + ")";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int wishlistId = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String description = resultSet.getString(3);
                int ownerId = resultSet.getInt(4);

                wishlistLists.add(new WishList(wishlistId, name, description, ownerId, false));

            }

        }
        catch (SQLException e) {
            System.out.println("kunne ikke hente de delte lister med userID = " + id);
            e.printStackTrace();
        }


        return wishlistLists;

    }
}

