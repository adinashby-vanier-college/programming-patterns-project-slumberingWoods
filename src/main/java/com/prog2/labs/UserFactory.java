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
    public User GetUser(String user) throws Exception {
        switch (user) {
            case "Student" -> {
                return new StudentUser();
            }
            case "Librarian" -> {
                Connection con = DatabaseConnection.getConnection();
                String query = "select * from Students";
                ArrayList<Student> students = new ArrayList<>();
                try (Statement stmt = con.createStatement()) {
                    ResultSet rs = stmt.executeQuery(query);
                    while (rs.next()) {
                        String id = rs.getString("StudentId");
                        String name = rs.getString("Name");
                        String contact = rs.getString("Contact");
                        Student tempStudent = new Student(id, name, contact);
                        students.add(tempStudent);
                    }
                } catch (SQLException e) {
                    System.out.println("Error");
                }
                return new LibrarianUser(students);
            }
            default -> throw new Exception();
        }
    }
}
