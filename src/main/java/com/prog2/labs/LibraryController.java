/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prog2.labs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author hallo
 */
public class LibraryController {
    UserFactory factory;
    ArrayList<Book> books;
    ArrayList<Student> students;

    public LibraryController(UserFactory factory) {
        this.factory = factory;
        Connection con = DatabaseConnection.getConnection();
        String query = "select * from Students";
        students = new ArrayList<>();
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
        String query2 = "select * from Books";
        books = new ArrayList<>();
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query2);
            while (rs.next()) {
                String SN = rs.getString("SN");
                String tempTitle = rs.getString("Title");
                String author = rs.getString("Author");
                String publisher = rs.getString("Publisher");
                double price = Double.parseDouble(rs.getString("Price"));
                int qte = Integer.parseInt(rs.getString("Quantity"));
                int issuedQte = Integer.parseInt(rs.getString("Issued"));
                String tempDate = rs.getString("addedDate");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
                LocalDate localDate = LocalDate.parse(tempDate, formatter);
                Book tempBook = new Book(SN, tempTitle, author, publisher, price, qte, issuedQte, localDate);
                books.add(tempBook);
            }
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error");
        }
    }
    
}
