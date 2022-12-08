/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prog2.labs;

import java.sql.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 *
 * @author hallo
 */
public class Student {
    Connection con = DatabaseConnection.getConnection();
    int stId;
    String name;
    String contactNumber;

    public Student(int stId, String name, String contactNumber) {
        this.stId = stId;
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public int getStId() {
        return stId;
    }

    public void setStId(int stId) {
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
    /**
     * Search by title
     * @param title
     * @return
     * A list of books with title
     * @throws SQLException 
     */
    public List<Book> searchBookByTitle(String title) throws SQLException {
        String query = "select * from Books where Title = '" + title + "'";
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
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
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
    /**
     * Search by author name
     * @param name
     * @return
     * A list of books with author name
     * @throws SQLException 
     */
    public List<Book> searchBookByName(String name) throws SQLException {
        String query = "select * from Books where Author = '" + name + "'";
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
    /**
     * Search by publisher
     * @param publisher
     * @return
     * a list of books with publisher
     * @throws SQLException 
     */
    public List<Book> searchBookByPublisher(String publisher) throws SQLException {
        String query = "select * from Books where Publisher = '" + publisher + "'";
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
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate localDate = LocalDate.parse(tempDate, formatter);
                Book tempBook = new Book(SN, tempTitle, author, tempPublisher, price, qte, issuedQte, localDate);
                books.add(tempBook);
            }
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error");
            System.out.println(e);
        }
        return books;
    }
    /**
     * Issue a book to current student
     * @param book
     * @return
     * Return true if successful else false
     * @throws SQLException 
     */
    public boolean borrow(Book book) throws SQLException {
        String query = "Insert into IssuedBooks(SN, StId, StName, StudentContact, IssueDate) VALUES('" + book.SN + "','" + 
                this.stId + "','" + this.name + "','" + this.contactNumber + "','" + 
                LocalDate.now().toString() + "')";
        String query2 = "Update Books set Quantity = Quantity - 1, Issued = Issued + 1 where SN = '" + book.SN; 
        try (Statement stmt = con.createStatement()) {
            stmt.executeUpdate(query);
            stmt.executeUpdate(query2);
            stmt.close();
            return true;
        } catch (Exception e) {
            System.err.println("Got an exception!"); 
            System.out.println(e);
        }
        return false;
    }
    /**
     * Return issued book using current student
     * @param book
     * @return
     * Return true if successful else false
     * @throws SQLException 
     */
    public boolean isReturn(Book book) throws SQLException{
        String query = "Update Books set Quantity = Quantity + 1, Issued = Issued - 1 where SN = " + book.SN;
        String query2 = "DELETE FROM IssuedBooks WHERE SN = '" + book.SN + "' AND StId = '" + this.stId + "'";
        try (Statement stmt = con.createStatement()) {
            stmt.executeUpdate(query);
            stmt.executeUpdate(query2);
            stmt.close();
            return true;
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.out.println(e);
        }
        return false;
    }
    /**
     * Get a view of IssuedBooks
     * @return 
     * Return a map sorted using Tree Map
     */
    public Map<String, String> viewCatalog() {
        String query = "select * from Books";
        Map<String, String> books = new TreeMap<>();
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String key = rs.getString("SN");
                String value = rs.getString("SN");
                value += " , " + rs.getString("Title");
                value += " , " + rs.getString("Author");
                value += " , " + rs.getString("Publisher");
                value += " , " + rs.getString("Price");
                value += " , " + rs.getString("Quantity");
                value += " , " + rs.getString("Issued");
                value += " , " + rs.getString("addedDate");
                books.put(key, value);
            }
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error");
            System.out.println(e);
        }
        Set s = books.entrySet();
        Iterator i = s.iterator();
        while (i.hasNext()) {
            Map.Entry m = (Map.Entry)i.next();
            String key = (String)m.getKey();
            String value = (String)m.getValue();
            System.out.println("Key : " + key
                    + "  value : " + value);
        }
        return books;
    }
    /**
     * Add Student to database
     * @param student
     * @return
     * Return true if successful else false
     * @throws SQLException 
     */
    public boolean addStudent(Student student) throws SQLException {
        String query = "insert into Students (StudentId, Name, Contact) VALUES('" + student.stId + "','" + student.name
                + "','" + student.contactNumber + "');";
        System.out.println(query);
        try (Statement stmt = con.createStatement()) {
            stmt.executeUpdate(query);
            stmt.close();
            return true;
        } catch (Exception e) {
            System.err.println("Got an exception!"); 
            System.out.println(e);
        }
        return false;
    }
}
