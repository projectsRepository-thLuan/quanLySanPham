package managementproductserver;


import java.sql.*;
import javax.swing.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Binh Diep
 */
public class MyConnection {
    public Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); //.newInstance();
            String URL = "jdbc:mysql://localhost/quanly?user=root&password=";
            Connection con = DriverManager.getConnection(URL); return con;
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Loi", JOptionPane.ERROR_MESSAGE);
        return null;
        }
    }
}
