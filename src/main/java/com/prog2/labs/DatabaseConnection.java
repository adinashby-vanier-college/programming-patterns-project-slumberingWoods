/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prog2.labs;
import java.sql.*;
/**
 *
 * @author hallo
 */
class DatabaseConnection {
    private static Connection con = null;

    private DatabaseConnection() {
    }
    /**
     * 
     * @return 
     */
    static Connection getConnection() {
        //Singleton Pattern
        if(con == null) {
            try {
                Class.forName("org.sqlite.JDBC");
                Connection con = DriverManager.getConnection("jdbc:sqlite:Library.db");
                System.out.println("success");
                return con;
            } catch(ClassNotFoundException | SQLException e) {
                System.out.println("failure");
                return null;
            }
        }
        return con;
    }
}
