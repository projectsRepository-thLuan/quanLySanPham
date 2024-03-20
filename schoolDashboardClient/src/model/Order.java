/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Binh Diep
 */
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    private int Id;
    private int customerId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    private int userId;
    private double totalAmount;
    private String status;
    private boolean isDelete;
    private LocalDate date;
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Order(int Id,int userId, int customerId, double totalAmount, String status, boolean isDelete, LocalDate date) {
        this.Id = Id;
        this.customerId = customerId;
        this.totalAmount = totalAmount;
        this.status = status;
        this.isDelete = isDelete;
        this.date = date;
        this.userId = userId;
    }
    
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    // Constructors, getters, and setters
}