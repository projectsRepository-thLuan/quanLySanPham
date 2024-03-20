/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Binh Diep
 */
public class Custommer implements Serializable {
    private static final long serialVersionUID = 1L;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Custommer(int id, String customerName, String address, String email, String phoneNumber, boolean isDelete) {
        this.id = id;
        this.customerName = customerName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return getCustomerName();
    }
    
    
    
    private int id;
    private String customerName;
    private String address;
    private String email;
    private String phoneNumber;
    private boolean isDelete;
    
}
