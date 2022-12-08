/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.prog2.labs;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author hallo
 */
public class StudentTest {
    
    public StudentTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getStId method, of class Student.
     */
    @Test
    public void testGetStId() {
        System.out.println("getStId");
        Student instance = new Student(1, "John", "5146023140");
        int expResult = 1;
        int result = instance.getStId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setStId method, of class Student.
     */
    @Test
    public void testSetStId() {
        System.out.println("setStId");
        int stId = 0;
        Student instance = new Student(1, "John", "5146023140");
        instance.setStId(stId);
    }

    /**
     * Test of getName method, of class Student.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Student instance = new Student(1, "John", "5146023140");
        String expResult = "John";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Student.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Student instance = new Student(1, "John", "5146023140");
        instance.setName(name);
    }

    /**
     * Test of getContactNumber method, of class Student.
     */
    @Test
    public void testGetContactNumber() {
        System.out.println("getContactNumber");
        Student instance = new Student(1, "John", "5146023140");
        String expResult = "5146023140";
        String result = instance.getContactNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of setContactNumber method, of class Student.
     */
    @Test
    public void testSetContactNumber() {
        System.out.println("setContactNumber");
        String contactNumber = "";
        Student instance = new Student(1, "John", "5146023140");
        instance.setContactNumber(contactNumber);
    }

    /**
     * Test of searchBookByTitle method, of class Student.
     */
    @Test
    public void testSearchBookByTitle() throws Exception {
        System.out.println("searchBookByTitle");
        String title = "";
        Student instance = new Student(1, "John", "5146023140");
        List<Book> expResult = new ArrayList<>();
        List<Book> result = instance.searchBookByTitle(title);
        assertEquals(expResult, result);
    }

    /**
     * Test of searchBookByName method, of class Student.
     */
    @Test
    public void testSearchBookByName() throws Exception {
        System.out.println("searchBookByName");
        String name = "";
        Student instance = new Student(1, "John", "5146023140");
        List<Book> expResult = new ArrayList<>();
        List<Book> result = instance.searchBookByName(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of searchBookByPublisher method, of class Student.
     */
    @Test
    public void testSearchBookByPublisher() throws Exception {
        System.out.println("searchBookByPublisher");
        String publisher = "";
        Student instance = new Student(1, "John", "5146023140");
        List<Book> expResult = new ArrayList<>();
        List<Book> result = instance.searchBookByPublisher(publisher);
        assertEquals(expResult, result);
    }

    /**
     * Test of borrow method, of class Student.
     */
    @Test
    public void testBorrow() throws Exception {
        System.out.println("borrow");
        Book book = new Book ("1249712894", "test", "test", "test", 219.23, 1, 1, LocalDate.now());
        Student instance = new Student(1, "John", "5146023140");
        boolean expResult = true;
        boolean result = instance.borrow(book);
        assertEquals(expResult, result);
    }

    /**
     * Test of isReturn method, of class Student.
     */
    @Test
    public void testIsReturn() throws Exception {
        System.out.println("isReturn");
        Book book = new Book ("1249712894", "test", "test", "test", 219.23, 1, 1, LocalDate.now());
        Student instance = new Student(1, "John", "5146023140");
        boolean expResult = true;
        boolean result = instance.isReturn(book);
        assertEquals(expResult, result);
    }

    /**
     * Test of viewCatalog method, of class Student.
     * intentionally failed
     */
    @Test
    public void testViewCatalog() {
        System.out.println("viewCatalog");
        Student instance = new Student(1, "John", "5146023140");
        Map<String, String> expResult = null;
        Map<String, String> result = instance.viewCatalog();
        assertEquals(expResult, result);
    }

    /**
     * Test of addStudent method, of class Student.
     */
    @Test
    public void testAddStudent() throws Exception {
        System.out.println("addStudent");
        Student student = new Student(2, "John", "5146023140");
        Student instance = new Student(1, "John", "5146023140");
        boolean expResult = false;
        boolean result = instance.addStudent(student);
        assertEquals(expResult, result);
    }
    
}
