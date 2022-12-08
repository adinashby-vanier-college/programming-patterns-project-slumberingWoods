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
    LibrarianForm form;
    public LibrarianUser() {
        form = new LibrarianForm();
    }   
    @Override
    public String getPermission() {
        return "librarian";
    }
    @Override
    public void createForm() {
        form.setVisible(true);
    }   

    @Override
    public void hideForm() {
        form.setVisible(false);
    }
}
