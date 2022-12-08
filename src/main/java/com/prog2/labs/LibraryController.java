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
    ArrayList<Book> books;
    ArrayList<Student> students;
    public LibraryController() {
        Connection con = DatabaseConnection.getConnection();
        String query = "select * from Students";
        students = new ArrayList<>();
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("StudentId"));
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
            System.out.println(rs.toString());
            while (rs.next()) {
                String SN = rs.getString("SN");
                String tempTitle = rs.getString("Title");
                String author = rs.getString("Author");
                String publisher = rs.getString("Publisher");
                double price = Double.parseDouble(rs.getString("Price"));
                int qte = Integer.parseInt(rs.getString("Quantity"));
                int issuedQte = Integer.parseInt(rs.getString("Issued"));
                String tempDate = rs.getString("addedDate");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate localDate = LocalDate.parse(tempDate, formatter);
                Book tempBook = new Book(SN, tempTitle, author, publisher, price, qte, issuedQte, localDate);
                books.add(tempBook);
            }
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error");
        }
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
    
    public void setStudentName(int index, String name) {
        students.get(index).setName(name);
    }
    public String getStudentName(int index) {
        return students.get(index).getName();
    }
    public void setStudentId(int index, int id) {
        students.get(index).setStId(id);
    }
    public int getStudentId(int index) {
        return students.get(index).getStId();
    }
    public void setStudentContact(int index, String contact) {
        students.get(index).setContactNumber(contact);
    }
    public String getStudentContact(int index) {
        return students.get(index).getContactNumber();
    }
    public void setBookSN(int index, String SN) {
        books.get(index).setSN(SN);
    }
    public String getBookSN(int index) {
        return books.get(index).getSN();
    }
    public void setBookTitle(int index, String title) {
        books.get(index).setTitle(title);
    }
    public String getBookTitle(int index) {
        return books.get(index).getTitle();
    }
    public void setBookAuthor(int index, String author) {
        books.get(index).setAuthor(author);
    }
    public String getBookAuthor(int index) {
        return books.get(index).getAuthor();
    }
    public void setBookPublisher(int index, String publisher) {
        books.get(index).setPublisher(publisher);
    }
    public String getBookPublisher(int index) {
        return books.get(index).getPublisher();
    }
    public void setBookPrice(int index, double price) {
        books.get(index).setPrice(price);
    }
    public double getBookPrice(int index) {
        return books.get(index).getPrice();
    }
    public void setBookQuantity(int index, int qte) {
        books.get(index).setQte(qte);
    }
    public int getBookQuantity(int index) {
        return books.get(index).getQte();
    }
    public void setBookIssued(int index, int qte ) {
        books.get(index).setIssuedQte(qte);
    }
    public int getBookIssued(int index) {
        return books.get(index).getIssuedQte();
    }
    public void setBookDate(int index, LocalDate date) {
        books.get(index).setDateOfPurchase(date);
    }
    public LocalDate getBookDate(int index) {
        return books.get(index).getDateOfPurchase();
    }
}
