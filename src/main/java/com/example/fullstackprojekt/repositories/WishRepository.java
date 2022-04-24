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

    public List<Wish> getAll(){

        List<Wish> whisList =  new ArrayList<>();
        try{
            Statement statement= connection.createStatement();
            final String SQL_QUERY="SELECT * FROM whish";
            ResultSet resultSet=statement.executeQuery(SQL_QUERY);
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String description = resultSet.getString(3);
                double price = resultSet.getDouble(4);
                String link = resultSet.getString(5);
                whisList.add(new Wish(id,name,description,price,link));
            }
            statement.close();
        }catch (SQLException e){
            System.out.println(e + "Not Found");
            e.printStackTrace();
        }
        return whisList;
    }

    public void addWish(Wish wish){

        final String ADD_QUERY="INSERT INTO wish(wish_name, wish_description, wish_price, wish_link) VALUE(?,?,?,?,)";

        try {
            PreparedStatement preparedStatement=connection.prepareStatement(ADD_QUERY);
            preparedStatement.setString(1,wish.getName());
            preparedStatement.setString(2,wish.getDescription());
            preparedStatement.setDouble(3,wish.getPrice());
            preparedStatement.setString(4,wish.getLink());
            preparedStatement.executeUpdate();
            System.out.println("is added");
        }catch (SQLException e){
            System.out.println(e + "Could not add");
            e.printStackTrace();
        }
    }
    public Wish findListById(int id){
        final String FIND_QUERY="SELECT * FROM wish  WHERE wish_list_id=?";
        Wish wish=null;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(FIND_QUERY);
            preparedStatement.setInt(1,id);
            ResultSet resultSet= preparedStatement.executeQuery();
            resultSet.next();
            id=resultSet.getInt(1);
            String name= resultSet.getString(2);
            String description = resultSet.getString(3);
            double price = resultSet.getDouble(4);
            String link = resultSet.getString(5);
            wish= new Wish(id,name,description,price,link);
            System.out.println("is found");

        }catch (SQLException e){
            System.out.println(e + "Not Found");
            e.printStackTrace();
        }
        return wish;
    }

    public Wish findWishById(int id){
        final String FIND_QUERY="SELECT * FROM wish  WHERE id=?";
        Wish wish=null;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(FIND_QUERY);
            preparedStatement.setInt(1,id);
            ResultSet resultSet= preparedStatement.executeQuery();
            resultSet.next();
            id=resultSet.getInt(1);
            String name= resultSet.getString(2);
            String description = resultSet.getString(3);
            double price = resultSet.getDouble(4);
            String link = resultSet.getString(5);
            wish= new Wish(id,name,description,price,link);
            System.out.println("is found");

        }catch (SQLException e){
            System.out.println(e + "Not Found");
            e.printStackTrace();
        }
        return wish;
    }

    public void updateByid(Wish wish) {

        final String UPDATE_QUERY="UPDATE wish SET wish_name=?, wish_description=?, wish_price=?, wish_link=? WHERE wish_id=?";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(UPDATE_QUERY);
            preparedStatement.setString(1,wish.getName());
            preparedStatement.setString(2,wish.getDescription());
            preparedStatement.setDouble(3,wish.getPrice());
            preparedStatement.setString(4,wish.getLink());
            preparedStatement.setInt(5, wish.getId());
            preparedStatement.executeUpdate();
            System.out.println("is update");
        }catch (SQLException e){
            System.out.println("Could not update");
            e.printStackTrace();
        }
    }

    public void deleteById(int id){
        final String DELETE_QUERY="DELETE FROM wish WHERE wish_id=?";
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
