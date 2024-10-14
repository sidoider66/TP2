/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tableau;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
/**
 *
 * @author THINKPAD
 */
public class TableExample {
        public static void main(String[] args) {
        // Data for the table
        String[][] data = {
            {"Ghanem", "Reda", "12", "14", "Admis"},
            {"Zidane", "Mohamed", "08", "10", "Ajourné"}
        };

        // Column Names
        String[] columnNames = {"Nom", "Prénom", "Note1", "Note2", "Décision"};

        // Create the JTable
        JTable table = new JTable(data, columnNames);

        // Add the table to a JScrollPane (for scrollability)
        JScrollPane sp = new JScrollPane(table);

        // Create a frame to hold the table
        JFrame frame = new JFrame();
        frame.setTitle("Student Notes Table");

        // Add the scroll pane with the table to the frame
        frame.add(sp);
        frame.setSize(500, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}
