/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managementproductserver.Services;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import managementproductserver.DBAccess;
import model.Order;

public class OrderService {
    private final DBAccess acc;

    public OrderService() {
        this.acc = new DBAccess();
    }

    public List<Order> getAllOrders() {
        List<Order> orderList = new ArrayList<>();
        try {
            ResultSet rs = acc.Query("SELECT * FROM `order` WHERE isDelete = false");
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("id"));
                order.setUserId(rs.getInt("userId"));
                order.setCustomerId(rs.getInt("customerId"));
                order.setTotalAmount(rs.getDouble("totalAmount"));
                order.setStatus(rs.getString("status"));
                order.setIsDelete(rs.getBoolean("isDelete"));
                order.setDate(rs.getDate("date").toLocalDate()); // Adjust as needed
                orderList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }
    
    public Order getOrderByid(int orderId) {
        Order order = new Order();
        try {
            ResultSet rs = acc.Query("SELECT * FROM `order` WHERE id ="+orderId);
            while (rs.next()) {
                order = new Order();
                order.setId(rs.getInt("id"));
                order.setUserId(rs.getInt("userId"));
                order.setCustomerId(rs.getInt("customerId"));
                order.setTotalAmount(rs.getDouble("totalAmount"));
                order.setStatus(rs.getString("status"));
                order.setIsDelete(rs.getBoolean("isDelete"));
                order.setDate(rs.getDate("date").toLocalDate());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }
    
    public boolean updateOrder(Order updatedOrder) {
        try {
            // Assuming that `acc` is an instance of your database accessor
            PreparedStatement preparedStatement = acc.getConnection().prepareStatement("UPDATE `order` SET userId=?, customerId=?, totalAmount=?, status=?, isDelete=?, date=? WHERE id=?");

            preparedStatement.setInt(1, updatedOrder.getUserId());
            preparedStatement.setInt(2, updatedOrder.getCustomerId());
            preparedStatement.setDouble(3, updatedOrder.getTotalAmount());
            preparedStatement.setString(4, updatedOrder.getStatus());
            preparedStatement.setBoolean(5, updatedOrder.isIsDelete());
            preparedStatement.setDate(6, java.sql.Date.valueOf(updatedOrder.getDate())); // Convert LocalDate to java.sql.Date
            preparedStatement.setInt(7, updatedOrder.getId());

            int rowsUpdated = preparedStatement.executeUpdate();

            // Check if the update was successful
            if (rowsUpdated > 0) {
                System.out.println("Order with ID " + updatedOrder.getId() + " updated successfully.");
                return true;
            } else {
                System.out.println("Failed to update order with ID " + updatedOrder.getId() + ". Order not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }



    public boolean addOrder(Order order) {
        try {
            String sql = "INSERT INTO `order` (userId, customerId, totalAmount, status, isDelete, date) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = acc.getConnection().prepareStatement(sql)) {
                preparedStatement.setInt(1, order.getUserId());
                preparedStatement.setInt(2, order.getCustomerId());
                preparedStatement.setDouble(3, order.getTotalAmount());
                preparedStatement.setString(4, "Ok");
                preparedStatement.setBoolean(5, order.isIsDelete());
                preparedStatement.setDate(6, java.sql.Date.valueOf(order.getDate())); // Adjust as needed
                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean deleteOrder(int orderId) {
        try {
            String sql = "UPDATE order SET isDelete = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = acc.getConnection().prepareStatement(sql)) {
                preparedStatement.setBoolean(1, true);
                preparedStatement.setInt(2, orderId);
                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}

