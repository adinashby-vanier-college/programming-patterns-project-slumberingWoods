package com.prog2.labs;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author adinashby
 *
 */

public class Project {

	/**
	 * Write your test code below in the main (optional).
	 *
	 */
	public static void main(String[] args) {
            PickUser pForm = new PickUser();
            
            ViewController viCon = new ViewController(pForm);
            LibraryController libCon = new LibraryController();
            UserFactory fac = new UserFactory();
            Controller controller;
            controller = Controller.getInstance(libCon, viCon, fac);
            controller.getViCon().showPForm();

	}
	/**
	 * Please refer to the README file for question(s) description
	 */
}