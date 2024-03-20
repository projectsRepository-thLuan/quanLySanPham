/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managementproductserver.Services;

/**
 *
 * @author Binh Diep
 */

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import managementproductserver.DBAccess;
import model.Custommer;

public class CustommerService {
    private final DBAccess acc;

    public CustommerService() {
        this.acc = new DBAccess();
    }

    public List<Custommer> getAllCustomers() {
        List<Custommer> customerList = new ArrayList<>();
        try {
            ResultSet rs = acc.Query("SELECT * FROM customer WHERE isDelete = false");
            while (rs.next()) {
                Custommer customer = new Custommer();
                customer.setId(rs.getInt("id"));
                customer.setCustomerName(rs.getString("customerName"));
                customer.setAddress(rs.getString("address"));
                customer.setEmail(rs.getString("email"));
                customer.setPhoneNumber(rs.getString("phonenumber"));
                customer.setIsDelete(rs.getBoolean("isDelete"));
                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    public Custommer GetCustommer(int Id){
        
        Custommer custommer = new Custommer();
        String query = "SELECT * FROM customer WHERE id = ?";
        try{
            PreparedStatement preparedStatement = acc.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, Id);
            ResultSet rs = preparedStatement.executeQuery();
        while(rs.next()) {
                custommer.setId(rs.getInt("id"));
                custommer.setCustomerName(rs.getString("customerName"));
                custommer.setAddress(rs.getString("address"));
                custommer.setEmail(rs.getString("email"));
                custommer.setPhoneNumber(rs.getString("phonenumber"));
                custommer.setIsDelete(rs.getBoolean("isDelete"));
        }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return custommer;
    }
    
    public boolean addCustomer(Custommer customer) {
        try {
            String sql = "INSERT INTO customer (customerName, address, email, phonenumber, isDelete) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = acc.getConnection().prepareStatement(sql)) {
                preparedStatement.setString(1, customer.getCustomerName());
                preparedStatement.setString(2, customer.getAddress());
                preparedStatement.setString(3, customer.getEmail());
                preparedStatement.setString(4, customer.getPhoneNumber());
                preparedStatement.setBoolean(5, false);
                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean updateCustomer(Custommer customer) {
        try {
            String sql = "UPDATE customer SET customerName = ?, address = ?, email = ?, phonenumber = ?,isDelete =? WHERE id = ?";
            try (PreparedStatement preparedStatement = acc.getConnection().prepareStatement(sql)) {
                preparedStatement.setString(1, customer.getCustomerName());
                preparedStatement.setString(2, customer.getAddress());
                preparedStatement.setString(3, customer.getEmail());
                preparedStatement.setString(4, customer.getPhoneNumber());
                preparedStatement.setBoolean(5, customer.isIsDelete());
                preparedStatement.setInt(6, customer.getId());
                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean deleteCustomer(int customerId) {
        try {
            String sql = "UPDATE customer SET isDelete = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = acc.getConnection().prepareStatement(sql)) {
                preparedStatement.setBoolean(1, true);
                preparedStatement.setInt(2, customerId);
                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
