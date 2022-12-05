/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prog2.labs;

import java.sql.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hallo
 */
public class Student {
    Connection con = DatabaseConnection.getConnection();
    String stId;
    String name;
    String contactNumber;

    public Student(String stId, String name, String contactNumber) {
        this.stId = stId;
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public String getStId() {
        return stId;
    }

    public void setStId(String stId) {
        this.stId = stId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    public List<Book> searchBookByTitle(String title) throws SQLException {
        String query = "select * from Books where Title = " + title;
        List<Book> books = new ArrayList<>();
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
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
        return books;
    }
        public List<Book> searchBookByName(String name) throws SQLException {
        String query = "select * from Books where Author = " + name;
        List<Book> books = new ArrayList<>();
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
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
        return books;
    }
    public List<Book> searchBookByPublisher(String publisher) throws SQLException {
        String query = "select * from Books where Publisher = " + publisher;
        List<Book> books = new ArrayList<>();
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String SN = rs.getString("SN");
                String tempTitle = rs.getString("Title");
                String author = rs.getString("Author");
                String tempPublisher = rs.getString("Publisher");
                double price = Double.parseDouble(rs.getString("Price"));
                int qte = Integer.parseInt(rs.getString("Quantity"));
                int issuedQte = Integer.parseInt(rs.getString("Issued"));
                String tempDate = rs.getString("addedDate");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
                LocalDate localDate = LocalDate.parse(tempDate, formatter);
                Book tempBook = new Book(SN, tempTitle, author, tempPublisher, price, qte, issuedQte, localDate);
                books.add(tempBook);
            }
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error");
        }
        return books;
    }
    public boolean borrow(Book book) throws SQLException {
        String query = "Insert into IssuedBooks VALUES(" + book.SN + "," + 
                this.stId + "," + this.name + "," + this.contactNumber + "," + 
                LocalDate.now().toString() + "," + ")";
        String query2 = "Update Books set Quantity = Quantity - 1, Issued = Issued + 1 where SN = " + book.SN; 
        try (Statement stmt = con.createStatement()) {
            stmt.executeUpdate(query);
            stmt.executeUpdate(query2);
            stmt.close();
            return true;
        } catch (Exception e) {
            System.err.println("Got an exception!"); 
        }
        return false;
    }
    public boolean isReturn(Book book) throws SQLException{
        String query = "Update Books set Quantity = Quantity + 1, Issued = Issued - 1 where SN = " + book.SN;
        String query2 = "DELETE FROM IssuedBooks WHERE SN = " + book.SN;
        try (Statement stmt = con.createStatement()) {
            stmt.executeUpdate(query);
            stmt.executeUpdate(query2);
            stmt.close();
            return true;
        } catch (Exception e) {
            System.err.println("Got an exception!"); 
        }
        return false;
    }
}
