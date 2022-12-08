/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prog2.labs;
import java.sql.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author hallo
 */
public class Book {
    Connection con = DatabaseConnection.getConnection();
    String SN;
    String title;
    String author;
    String publisher;
    double price;
    int qte;
    int issuedQte;
    LocalDate DateOfPurchase;

    public Book(String SN, String title, String author, String publisher, double price, int qte, int issuedQte, LocalDate DateOfPurchase) {
        this.SN = SN;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.qte = qte;
        this.issuedQte = issuedQte;
        this.DateOfPurchase = DateOfPurchase;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateOfPurchase.format(formatter);
    }

    public String getSN() {
        return SN;
    }

    public void setSN(String SN) {
        this.SN = SN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public int getIssuedQte() {
        return issuedQte;
    }

    public void setIssuedQte(int issuedQte) {
        this.issuedQte = issuedQte;
    }

    public LocalDate getDateOfPurchase() {
        return DateOfPurchase;
    }

    public void setDateOfPurchase(LocalDate DateOfPurchase) {
        this.DateOfPurchase = DateOfPurchase;
    }
    public boolean addBook(Book book) throws SQLException {
        String query = "insert into Books(SN, Title, Author, Publisher, Price, Quantity, Issued, addedDate) VALUES('" + book.SN + "','" + book.title 
                + "','" + book.author + "','" + book.publisher + "','" + book.price + "','" + book.qte 
                + "','" + book.issuedQte + "','" + book.DateOfPurchase.toString() + "')";
        try (Statement stmt = con.createStatement()) {
            stmt.executeUpdate(query);
            stmt.close();
            return true;
        } catch (Exception e) {
            System.err.println("Got an exception!"); 
            System.out.println(query);
            System.out.println(e);
        }
        return false;
    }
    public boolean issueBook(Book book, Student s) throws SQLException {
        String query = "Insert into IssuedBooks(SN, StId, StName, StudentContact, IssueDate) VALUES('" + book.SN + "','" + 
                s.stId + "','" + s.name + "','" + s.contactNumber + "','" + 
                LocalDate.now().toString() + "','" + "')";
        String query2 = "Update Books set Quantity = Quantity - 1, Issued = Issued + 1 where SN = " + book.SN; 
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
    public boolean returnBook(Book book, Student s) throws SQLException {
        String query = "Update Books set Quantity = Quantity + 1, Issued = Issued - 1 where SN = " + book.SN;
        String query2 = "DELETE FROM IssuedBooks WHERE SN = " + book.SN + "AND StId = " + s.stId;
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
    public static Map<String, String> viewCatalog() {
        String query = "select * from Books";
        Map<String, String> books = new TreeMap<>();
        Connection tempcon = DatabaseConnection.getConnection();
        try (Statement stmt = tempcon.createStatement()) {
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
        return books;
    }
    public static Map<String, String> viewIssuedBooks() {
        String query = "select * from IssuedBooks";
        Map<String, String> books = new TreeMap<>();
        Connection tempcon = DatabaseConnection.getConnection();
        try (Statement stmt = tempcon.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String key = rs.getString("SN");
                String value = rs.getString("id");
                value += " , " + rs.getString("SN");
                value += " , " + rs.getString("StId");
                value += " , " + rs.getString("StName");
                value += " , " + rs.getString("StudentContact");
                value += " , " + rs.getString("IssueDate");
                books.put(key, value);
            }
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error");
            System.out.println(e);
        }
        return books;
    }
}
