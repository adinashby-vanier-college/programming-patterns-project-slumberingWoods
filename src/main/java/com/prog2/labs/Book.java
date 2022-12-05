/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prog2.labs;
import java.sql.*;
import java.time.*;

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
        String query = "insert into Books VALUES(" + book.SN + "," + book.title 
                + "," + book.author + "," + book.publisher + "," + book.qte 
                + "," + book.issuedQte + "," + book.DateOfPurchase.toString() + ")";
        try (Statement stmt = con.createStatement()) {
            stmt.executeUpdate(query);
            stmt.close();
            return true;
        } catch (Exception e) {
            System.err.println("Got an exception!"); 
        }
        return false;
    }
    public boolean issueBook(Book book, Student s) throws SQLException {
        String query = "Insert into IssuedBooks VALUES(" + book.SN + "," + 
                s.stId + "," + s.name + "," + s.contactNumber + "," + 
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
        }
        return false;
    }
}
