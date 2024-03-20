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
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    public Category(int id, String categoryName) {
        this.categoryName = categoryName;
    }


    public int getId() {
        return Id;
    }

    public void setId(int categoryId) {
        this.Id = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Category(int Id, String categoryName, String description, boolean isDelete) {
        this.Id = Id;
        this.categoryName = categoryName;
        this.description = description;
        this.isDelete = isDelete;
    }

    public Category() {
    }
    
    public String getStringId(){
        return String.valueOf(Id);
    }
    
    private int Id;
    private String categoryName;
    private String description;
    private boolean isDelete;
    // Constructors, getters, and setters

    @Override
    public String toString() {
        return categoryName;
    }
    
    
}
