/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prog2.labs;

/**
 *
 * @author hallo
 */
public class Controller {
    LibraryController libCon;
    ViewController viCon;
    UserFactory fac;
    public static Controller controller;

    private Controller() {
    }

    public Controller(LibraryController libCon, ViewController viCon, UserFactory fac) {
        this.libCon = libCon;
        this.viCon = viCon;
        this.fac = fac;
    }
    
    public static Controller getInstance() {
        if(controller == null) {
            System.out.println();
           controller = new Controller();
        }
        return controller;
    }
    public static Controller getInstance(LibraryController libCon, ViewController viCon, UserFactory fac) {
        if(controller == null) {
           controller = new Controller(libCon, viCon, fac);
        }
         return controller;
    }

    public LibraryController getLibCon() {
        return libCon;
    }

    public void setLibCon(LibraryController libCon) {
        this.libCon = libCon;
    }

    public ViewController getViCon() {
        return viCon;
    }

    public void setViCon(ViewController viCon) {
        this.viCon = viCon;
    }

    public UserFactory getFac() {
        return fac;
    }

    public void setFac(UserFactory fac) {
        this.fac = fac;
    }
    
}
