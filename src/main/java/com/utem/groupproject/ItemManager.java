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
            String SQL = "SELECT * FROM Food";
            
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
}
