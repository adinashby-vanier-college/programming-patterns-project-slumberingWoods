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
            String query = "select * from Books";
            Map<String, String> books = new TreeMap<>();
            Connection tempcon = DatabaseConnection.getConnection();
            try (Statement stmt = tempcon.createStatement()) {
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    String key = rs.getString("SN");
                    String value = rs.getString("SN");
                    value += " , " + rs.getString("Title");
                    value += " , " + rs.getString("Author");
                    value += " , " + rs.getString("Publisher");
                    value += " , " + rs.getString("Price");
                    value += " , " + rs.getString("Quantity");
                    value += " , " + rs.getString("Issued");
                    value += " , " + rs.getString("addedDate");
                    books.put(key, value);
                }
                stmt.close();
            } catch (SQLException e) {
                System.out.println("Error");
            }
            System.out.println(books.toString());
	}
	/**
	 * Please refer to the README file for question(s) description
	 */
}