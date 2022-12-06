/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prog2.labs;

import java.util.ArrayList;

/**
 *
 * @author hallo
 */
public class LibrarianUser implements User{
    ArrayList<Student> students;
    public LibrarianUser(ArrayList<Student> students) {
        this.students = students;
    }   
    @Override
    public String getPermission() {
        return "librarian";
    }
    @Override
    public void createForm() {
        LibrarianForm form = new LibrarianForm();
        form.setVisible(true);
    }
    public ArrayList<Student> getStudents() {
        return students;
    }
    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
    
}
