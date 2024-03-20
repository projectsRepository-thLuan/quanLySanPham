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
public class User implements Serializable {
    private static final long serialVersionUID = 8683736547077756229L;
    public User(){
        
    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public User(String username, String password,int per) {
        this.username = username;
        this.password = password;
        this.per = per;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setPer(int per){
        this.per = per;
    }
    public int getPer(){
        return per;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    int Id;
    String username;
    String password;
    int per;
    boolean isDelete;

    public boolean isDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    
}
