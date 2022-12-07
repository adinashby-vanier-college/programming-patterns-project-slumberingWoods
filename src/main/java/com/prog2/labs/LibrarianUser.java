/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prog2.labs;

/**
 *
 * @author hallo
 */
public class LibrarianUser implements User{
    public LibrarianUser() {
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
}
