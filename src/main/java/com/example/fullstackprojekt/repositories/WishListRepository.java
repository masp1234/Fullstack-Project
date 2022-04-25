package com.example.fullstackprojekt.repositories;

import com.example.fullstackprojekt.models.Wish;
import com.example.fullstackprojekt.models.WishList;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class WishListRepository {
    Connection connection;

    public List<WishList> findByUserId(int id) {
        List wishList = new ArrayList();
        final String FIND_QUERY = "SELECT * FROM wish_list  WHERE user_id=?";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(FIND_QUERY);
            preparedStatement.setInt(1,id);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String description = resultSet.getString(3);
                wishList.add(new WishList(id,name,description));
                System.out.println("is found");
            }
            preparedStatement.close();
        }catch (SQLException e){
            System.out.println(e + "Not Found");
            e.printStackTrace();
        }
        return wishList;
    }

    public WishList findWishListById(int id){
        final String FIND_QUERY="SELECT * FROM wish_list  WHERE wish_list_id=?";
        WishList wishList=null;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(FIND_QUERY);
            preparedStatement.setInt(1,id);
            ResultSet resultSet= preparedStatement.executeQuery();
            resultSet.next();
            id=resultSet.getInt(1);
            String name= resultSet.getString(2);
            String description = resultSet.getString(3);
            wishList= new WishList(id,name,description);
            System.out.println("is found");

        }catch (SQLException e){
            System.out.println(e + "Not Found");
            e.printStackTrace();
        }
        return wishList;
    }

    public void updateByid(WishList wishList) {

        final String UPDATE_QUERY="UPDATE wish SET wish_list_name=?, wish_list_description=? WHERE wish_list_id=?";
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
        final String DELETE_QUERY="DELETE FROM wishList WHERE wish_list_id=?";
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





}

