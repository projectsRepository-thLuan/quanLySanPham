package managementproductserver.Services;

import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import managementproductserver.DBAccess;
import model.Category;
import model.OrderDetail;

public class OrderDetailService {
    private final DBAccess acc;

    public OrderDetailService() {
        this.acc = new DBAccess();
    }

    public List<OrderDetail> getAllOrderDetailsByOrderId(int orderId) {
        List<OrderDetail> orderDetails = new ArrayList<>();
        String sql = "SELECT * FROM orderDetail WHERE orderId = ?";
        
        try (PreparedStatement preparedStatement = acc.getConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, orderId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    OrderDetail orderDetail = new OrderDetail();
                    orderDetail.setOrderId(resultSet.getInt("orderId"));
                    orderDetail.setProductId(resultSet.getInt("productId"));
                    orderDetail.setQuantity(resultSet.getInt("quantity"));
                    orderDetails.add(orderDetail);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Hoặc xử lý ngoại lệ một cách thích hợp trong ứng dụng của bạn
        }
        return orderDetails;
    }
    
    public boolean Update(OrderDetail model) {
        try {
            String sql = "UPDATE orderdetail SET quantity =? WHERE productId = ? AND orderId= ?";

            try (PreparedStatement preparedStatement = acc.getConnection().prepareStatement(sql)) {
                preparedStatement.setInt(1, model.getQuantity());
                preparedStatement.setInt(2, model.getProductId());
                preparedStatement.setInt(3, model.getOrderId());

                int rowsAffected = preparedStatement.executeUpdate();

                return rowsAffected > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Handle the exception appropriately in your application
            return false;
        }
    }
    
    public boolean Create(OrderDetail model) {
        try {
            String sql = "INSERT INTO orderdetail (productId, orderId, quantity) VALUES (?, ?, ?)";

            try (PreparedStatement preparedStatement = acc.getConnection().prepareStatement(sql)) {
                preparedStatement.setInt(1, model.getProductId());
                preparedStatement.setInt(2, model.getOrderId());
                preparedStatement.setInt(3, model.getQuantity());

                int rowsAffected = preparedStatement.executeUpdate();

                return rowsAffected > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Handle the exception appropriately in your application
            return false;
        }
    }
    
    public boolean Delete(int productId, int orderId) {
    try {
        String sql = "DELETE FROM orderdetail WHERE productId = ? AND orderId = ?";

        try (PreparedStatement preparedStatement = acc.getConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, productId);
            preparedStatement.setInt(2, orderId);

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        }
    } catch (SQLException ex) {
        ex.printStackTrace(); // Handle the exception appropriately in your application
        return false;
    }
}


}
