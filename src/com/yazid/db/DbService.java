/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yazid.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ma39i
 */
public class DbService {
    private static Connection connection;
    private static Statement statement;
    
    public static ResultSet get(String query) {
        try {
            openConnection();

            ResultSet resultSet = statement.executeQuery(query);
                    
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public static int query(String query) {
        try {
            openConnection();
            
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return 0;
    }
    
    public static Connection openConnection() {
        try {
            Class.forName(DbConfig.getDriver());
            if (connection == null) {
                connection = DriverManager.getConnection(
                        DbConfig.getDbUrl(),
                        DbConfig.getDbUser(),
                        DbConfig.getDbPassword()
                );
            }
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
    
    public static void closeStatement() {
        try {
            statement.close();   
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
