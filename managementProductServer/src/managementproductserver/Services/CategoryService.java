/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managementproductserver.Services;

import java.util.ArrayList;
import java.util.List;
import model.Category;
import managementproductserver.DBAccess;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Binh Diep
 */
public class CategoryService {
    DBAccess acc = null;
    
    public CategoryService(){
        this.acc = new DBAccess();
    }
    
    public List<Category> getAll(){
        List<Category> listData = new ArrayList<>();
        try {
            ResultSet rs = acc.Query("select * from category");
            while(rs.next()){
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setCategoryName(rs.getString("categoryName"));
                category.setDescription(rs.getString("description"));
                category.setIsDelete(rs.getBoolean("isDelete"));
                if(category.IsDelete()!=true)
                    listData.add(category);
            }
        } catch (Exception e) {
        }
        
        return listData;
    }
    
    public List<Category> Search(String searchStr){
        List<Category> listData = new ArrayList<>();
        try {
            ResultSet rs = acc.Query("select * from category where categoryName like'%" + searchStr+"%'");
            while(rs.next()){
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setCategoryName(rs.getString("categoryName"));
                category.setDescription(rs.getString("description"));
                category.setIsDelete(rs.getBoolean("isDelete"));
                if(category.IsDelete()!=true)
                    listData.add(category);
            }
        } catch (Exception e) {
        }
        
        return listData;
    }
    
    public boolean Add(Category model) {
        try {
            String sql = "INSERT INTO Category (categoryName, description, isDelete) VALUES (?, ?, ?)";

            try (PreparedStatement preparedStatement = acc.getConnection().prepareStatement(sql)) {
                preparedStatement.setString(1, model.getCategoryName());
                preparedStatement.setString(2, model.getDescription());
                preparedStatement.setBoolean(3, model.IsDelete());

                int rowsAffected = preparedStatement.executeUpdate();

                return rowsAffected > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Handle the exception appropriately in your application
            return false;
        }
    }
    
    public boolean Update(Category model) {
        try {
            String sql = "UPDATE Category SET categoryName = ?, description = ? WHERE Id = ?";

            try (PreparedStatement preparedStatement = acc.getConnection().prepareStatement(sql)) {
                preparedStatement.setString(1, model.getCategoryName());
                preparedStatement.setString(2, model.getDescription());
                preparedStatement.setInt(3, model.getId());

                int rowsAffected = preparedStatement.executeUpdate();

                return rowsAffected > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Handle the exception appropriately in your application
            return false;
        }
    }
    public boolean Delete(int id) {
        try {
            String sql = "UPDATE Category SET isDelete = ? WHERE Id = ?";

            try (PreparedStatement preparedStatement = acc.getConnection().prepareStatement(sql)) {
                preparedStatement.setBoolean(1, true);
                preparedStatement.setInt(2, id);

                int rowsAffected = preparedStatement.executeUpdate();

                return rowsAffected > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Handle the exception appropriately in your application
            return false;
        }
    }
}
