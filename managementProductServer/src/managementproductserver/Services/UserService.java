/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managementproductserver.Services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import managementproductserver.DBAccess;
import model.User;
import java.sql.PreparedStatement;

/**
 *
 * @author Binh Diep
 */
public class UserService {
    DBAccess acc = null;
    
    public UserService(){
        this.acc = new DBAccess();
    }
    
    public List<User> GetAllUser(){
        List<User> listUser = new ArrayList<>();
        try {
            ResultSet rs = acc.Query("select * from taikhoan where isDelete = false");
            while(rs.next()){
                User user = new User();
                user.setPer(rs.getInt("per"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                    listUser.add(user);
            }
        } catch (Exception e) {
        }
        
        return listUser;
    }
    public User Login(String username, String password){
        
        User user = new User();
        ResultSet rs = acc.Query("select * from taikhoan where username ='"+username+"'and password ='"+password+"'");
        try{
        while(rs.next()) {
            
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setPer(rs.getInt("per"));
        }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return user;
    }
    
    public User GetUser(int Id){
        
        User user = new User();
        String query = "SELECT * FROM taikhoan WHERE id = ?";
        try{
            PreparedStatement preparedStatement = acc.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, Id);
            ResultSet rs = preparedStatement.executeQuery();
        while(rs.next()) {
            user.setId(rs.getInt("Id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setPer(rs.getInt("per"));
        }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return user;
    }
    
    public boolean Add(User user) {
        try {
            String sql = "INSERT INTO taikhoan (username, password, per) VALUES (?, ?, ?)";

            try (PreparedStatement preparedStatement = acc.getConnection().prepareStatement(sql)) {
                preparedStatement.setString(1, user.getUsername());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.setInt(3, user.getPer());
                int rowsAffected = preparedStatement.executeUpdate();

                return rowsAffected > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Xử lý ngoại lệ một cách thích hợp trong ứng dụng của bạn
            return false;
        }
    }
    
    public boolean Update(User user) {
        try {
            String sql = "UPDATE taikhoan SET password = ?, per = ? WHERE username = ?";

            try (PreparedStatement preparedStatement = acc.getConnection().prepareStatement(sql)) {
                preparedStatement.setString(1, user.getPassword());
                preparedStatement.setInt(2, user.getPer());
                preparedStatement.setString(3, user.getUsername());

                int rowsAffected = preparedStatement.executeUpdate();

                return rowsAffected > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Xử lý ngoại lệ một cách thích hợp trong ứng dụng của bạn
            return false;
        }
    }
    
    public boolean Delete(String username) {
        try {
            String sql = "UPDATE taikhoan SET isDelete = ? WHERE username = ?";

            try (PreparedStatement preparedStatement = acc.getConnection().prepareStatement(sql)) {
                preparedStatement.setBoolean(1,true);
                preparedStatement.setString(2, username);
                int rowsAffected = preparedStatement.executeUpdate();

                return rowsAffected > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Xử lý ngoại lệ một cách thích hợp trong ứng dụng của bạn
            return false;
        }
    }
}
