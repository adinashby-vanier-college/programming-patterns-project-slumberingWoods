/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prog2.labs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author hallo
 */
public class UserFactory {
    /**
     * 
     * @param user
     * @param id
     * @return
     * @throws Exception 
     */
    public User GetUser(String user, int id) throws Exception {
        switch (user) {
            case "Student" -> {
                return new StudentUser(id);
            }
            case "Librarian" -> {
                return new LibrarianUser();
            }
            default -> throw new Exception();
        }
    }
}
