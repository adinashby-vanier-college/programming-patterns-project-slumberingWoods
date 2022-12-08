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
    PickUser pForm;
    User user;

    public ViewController(PickUser pForm) {
        this.pForm = pForm;
    }
    public ViewController(User user, PickUser pForm) {
        this.user = user;
        this.pForm = pForm;
    }

    public void showPForm() {
        pForm.setVisible(true);
    }
    public void hidePForm() {
        pForm.setVisible(false);
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
}
