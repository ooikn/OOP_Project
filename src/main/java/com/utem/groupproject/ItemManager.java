/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utem.groupproject;

import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author mangy
 */
public class ItemManager{
    private ArrayList<Food> foodList;
    private ArrayList<Drink> drinkList;
    
    private Food food = new Food() {};
    private Drink drink = new Drink() {};
    
    private Database db = new Database();

    public ItemManager() {
    }
    
    public ArrayList<Food> readAllFood() throws ClassNotFoundException {
        foodList = new ArrayList<Food>();
        
        try{
            String SQL = "SELECT * FROM food";
            
            PreparedStatement ps = db.openConnection().prepareStatement(SQL);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                food = new Food(){};
                
                food.setItemID(rs.getString("FOODID"));
                food.setItemName(rs.getString("NAME"));
                food.setItemType(rs.getString("TYPE"));
                food.setArrivalDate(rs.getString("ARRIVALDATE"));
                food.setExpiredDate(rs.getString("EXPIREDDATE"));
                food.setItemPrice(rs.getDouble("PRICE"));
                food.setItemQuantity(rs.getInt("QUANTITY"));
                
                foodList.add(food);   
            }
        }
        catch (SQLException err)
        {
            JOptionPane.showMessageDialog(null,err.getMessage());
        }
        return foodList;
    }
    
    public ArrayList<Drink> readAllDrink() throws ClassNotFoundException{
        drinkList = new ArrayList<Drink>();
        try{
            String SQL = "SELECT * FROM drink";
            
            PreparedStatement ps = db.openConnection().prepareStatement(SQL);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                drink = new Drink(){};
                
                drink.setItemID(rs.getString("DRINKID"));
                drink.setItemName(rs.getString("NAME"));
                drink.setItemType(rs.getString("TYPE"));
                drink.setArrivalDate(rs.getString("ARRIVALDATE"));
                drink.setExpiredDate(rs.getString("EXPIREDDATE"));
                drink.setItemPrice(rs.getDouble("PRICE"));
                drink.setItemQuantity(rs.getInt("QUANTITY"));
                
                drinkList.add(drink);
            }
        }
        catch (SQLException err)
        {
            JOptionPane.showMessageDialog(null,err.getMessage());
        }
        return drinkList;
    }
    
    public void saveFood(Food food) throws ClassNotFoundException{
        
        String foodID = food.getItemID();
        String type = food.getItemType();
        String name = food.getItemName();
        String arrival = food.getArrivalDate();
        String expired = food.getExpireDate();
        double price = food.getItemPrice();
        int qty = food.getItemQuantity();
        
        try {
                        
            String SQL = "INSERT INTO food VALUES (?,?,?,?,?,?,?)";
            
            PreparedStatement ps = db.openConnection().prepareStatement(SQL);
            
            ps.setString(1, foodID);
            ps.setString(2, name);
            ps.setString(3, type);
            ps.setString(4, arrival);
            ps.setString(5, expired);
            ps.setDouble(6, price);
            ps.setInt(7,qty);
            
            ps.executeUpdate();
        }
        catch (SQLException err){
            JOptionPane.showMessageDialog(null,err.getMessage());
        }
    }
    
    public void saveDrink(Drink drink)throws ClassNotFoundException{
        
        String drinkID = drink.getItemID();
        String type = drink.getItemType();
        String name = drink.getItemName();
        String arrival = drink.getArrivalDate();
        String expired = drink.getExpireDate();
        double price = drink.getItemPrice();
        int qty = drink.getItemQuantity();
        
        try {
                        
            String SQL = "INSERT INTO drink VALUES (?,?,?,?,?,?,?)";
            
            PreparedStatement ps = db.openConnection().prepareStatement(SQL);
            
            ps.setString(1, drinkID);
            ps.setString(2, name);
            ps.setString(3, type);
            ps.setString(4, arrival);
            ps.setString(5, expired);
            ps.setDouble(6, price);
            ps.setInt(7,qty);
            
            ps.executeUpdate();
        }
        catch (SQLException err){
            JOptionPane.showMessageDialog(null,err.getMessage());
        }
    }
}