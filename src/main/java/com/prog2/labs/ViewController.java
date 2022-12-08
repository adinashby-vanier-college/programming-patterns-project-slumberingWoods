/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prog2.labs;

/**
 *
 * @author hallo
 */
public class ViewController {
    LibrarianForm lForm;
    StudentForm sForm;
    PickUser pForm;

    public ViewController(LibrarianForm lForm, StudentForm sForm, PickUser pForm) {
        this.lForm = lForm;
        this.sForm = sForm;
        this.pForm = pForm;
    }
    public void showPForm() {
        pForm.setVisible(true);
    }
    public void showLForm() {
        lForm.setVisible(true);
        pForm.setVisible(false);
        sForm.setVisible(false);
    }
    public void showSForm() {
        sForm.setVisible(true);
        lForm.setVisible(false);
        pForm.setVisible(false);
    }
}
