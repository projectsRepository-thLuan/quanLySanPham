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
import model.Product;

/**
 *
 * @author Binh Diep
 */
public class ProductService {
    DBAccess acc = null;
    
    public ProductService(){
        this.acc = new DBAccess();
    }
    
    public List<Product> getAll() {
        List<Product> listData = new ArrayList<>();
        try {
            ResultSet rs = acc.Query("select * from product");
            while (rs.next()) {
                int id = rs.getInt("id");
                String productName = rs.getString("productName");
                String description = rs.getString("description");
                double price = rs.getDouble("price");
                int stockQuantity = rs.getInt("stockQuantity");
                int categoryId = rs.getInt("categoryId");
                boolean isDelete = rs.getBoolean("isDelete");
                Product product = new Product(id, productName, description, price, stockQuantity, categoryId, isDelete);
                if(!product.isDelete()){
                    listData.add(product);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listData;
    }

    public Product getProductById(int productId) {
        Product product = null;
        try {
            ResultSet rs = acc.Query("select * from product where id = " + productId);
            if (rs.next()) {
                int id = rs.getInt("id");
                String productName = rs.getString("productName");
                String description = rs.getString("description");
                double price = rs.getDouble("price");
                int stockQuantity = rs.getInt("stockQuantity");
                int categoryId = rs.getInt("categoryId");
                boolean isDelete = rs.getBoolean("isDelete");

                product = new Product(id, productName, description, price, stockQuantity, categoryId, isDelete);

                if (product.isDelete()) {
                    // If the product is marked as deleted, set the reference to null
                    product = null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return product;
    }

    
    public List<Product> Search(String searchStr){
        List<Product> listData = new ArrayList<>();
        try {
            ResultSet rs = acc.Query("select * from Product where ProductName like'%" + searchStr+"%'");
            while(rs.next()){
                int id = rs.getInt("id");
                String productName = rs.getString("productName");
                String description = rs.getString("description");
                double price = rs.getDouble("price");
                int stockQuantity = rs.getInt("stockQuantity");
                int categoryId = rs.getInt("categoryId");
                boolean isDelete = rs.getBoolean("isDelete");
                Product product = new Product(id, productName, description, price, stockQuantity, categoryId, isDelete);
                if(!product.isDelete()){
                    listData.add(product);
                }
            }
        } catch (Exception e) {
        }
        
        return listData;
    }
    
    public boolean Add(Product model) {
        try {
            String sql = "INSERT INTO product (productName, description, price, stockQuantity, categoryId, isDelete) VALUES (?, ?, ?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = acc.getConnection().prepareStatement(sql)) {
                preparedStatement.setString(1, model.getProductName());
                preparedStatement.setString(2, model.getDescription());
                preparedStatement.setDouble(3, model.getPrice());
                preparedStatement.setInt(4, model.getStockQuantity());
                preparedStatement.setInt(5, model.getCategoryId());
                preparedStatement.setBoolean(6, false);

                int rowsAffected = preparedStatement.executeUpdate();

                return rowsAffected > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Handle the exception appropriately in your application
            return false;
        }
    }

    
    public boolean Update(Product model) {
        try {
            String sql = "UPDATE Product SET productName = ?, description = ?, price = ?, stockQuantity = ?, categoryId = ?, isDelete = ? WHERE id = ?";

            try (PreparedStatement preparedStatement = acc.getConnection().prepareStatement(sql)) {
                preparedStatement.setString(1, model.getProductName());
                preparedStatement.setString(2, model.getDescription());
                preparedStatement.setDouble(3, model.getPrice());
                preparedStatement.setInt(4, model.getStockQuantity());
                preparedStatement.setInt(5, model.getCategoryId());
                preparedStatement.setBoolean(6, model.isDelete());
                preparedStatement.setInt(7, model.getId());

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
            String sql = "UPDATE Product SET isDelete = ? WHERE Id = ?";

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
