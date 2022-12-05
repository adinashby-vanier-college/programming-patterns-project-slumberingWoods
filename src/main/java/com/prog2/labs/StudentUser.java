/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prog2.labs;

/**
 *
 * @author hallo
 */
public class StudentUser implements User {
    @Override
    public String getPermission() {
        return "student";
    }
    @Override
    public void createForm() {
        
    }
}
