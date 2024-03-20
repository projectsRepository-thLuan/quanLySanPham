/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managementproductserver;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import managementproductserver.Services.CategoryService;
import managementproductserver.Services.CustommerService;
import managementproductserver.Services.OrderDetailService;
import managementproductserver.Services.OrderService;
import managementproductserver.Services.ProductService;
import managementproductserver.Services.UserService;
import model.Category;
import model.Custommer;
import model.Order;
import model.OrderDetail;
import model.Product;
import model.User;

/**
 *
 * @author Binh Diep
 */public class LoginClientHandler implements Runnable {
    private Socket clientSocket;
    private Scanner in = null;
    private ObjectOutputStream writer;

    public LoginClientHandler(Socket clientSocket) throws IOException {
        this.clientSocket = clientSocket;
        try {
            this.in = new Scanner(this.clientSocket.getInputStream());
            this.writer = new ObjectOutputStream(clientSocket.getOutputStream());
            new Thread(this).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            handleRequests();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            closeResources();
        }
    }

    private void handleRequests() throws IOException {
            String request = in.nextLine().trim();
            System.out.println(request);
            String[] arrRequest = request.split("-");
            if (arrRequest[1].equals("Account")) {
                handleAccountRequests(arrRequest);
            } else if (arrRequest[1].equals("Category")) {
                handleCategoryRequests(arrRequest);
            }else if(arrRequest[1].equals("Product")){
                handleProductRequests(arrRequest);
            }else if(arrRequest[1].equals("Custommer")){
                handleCustommerRequests(arrRequest);
            }else if(arrRequest[1].equals("Order")){
                handleOderRequests(arrRequest);
            }else if(arrRequest[1].equals("OrderDetail")){
                handleOderDetailRequests(arrRequest);
            }
    }

    private void handleAccountRequests(String[] arrRequest) throws IOException {
        UserService service = new UserService();
        if (arrRequest[0].equals("GetAll")) {
            List<User> userList = service.GetAllUser();
            writer.writeObject(userList);
            writer.flush();
        } else if (arrRequest[0].equals("Login") && arrRequest.length == 4) {
            User userLogin = new UserService().Login(arrRequest[2], arrRequest[3]);
            writer.writeObject(userLogin);
            writer.flush();
        } else if (arrRequest[0].equals("Create")) {
            User model = new User(arrRequest[2],arrRequest[3],Integer.parseInt(arrRequest[4]));
            service.Add(model);
            List<User> userList = service.GetAllUser();
            writer.writeObject(userList);
            writer.flush();
        }
        else if (arrRequest[0].equals("Update")) {
            User model = new User(arrRequest[2],arrRequest[3],Integer.parseInt(arrRequest[4]));
            service.Update(model);
            List<User> userList = service.GetAllUser();
            writer.writeObject(userList);
            writer.flush();
        }
        else if (arrRequest[0].equals("Delete")) {
            service.Delete(arrRequest[2]);
            List<User> userList = service.GetAllUser();
            writer.writeObject(userList);
            writer.flush();
        }else if (arrRequest[0].equals("GetUsername")) {
            User user =  service.GetUser(Integer.parseInt( arrRequest[2]));
            writer.writeObject(user);
            writer.flush();
        }
    }

    private void handleCategoryRequests(String[] arrRequest) throws IOException {
        CategoryService service = new CategoryService();
        if(arrRequest[0].equals("GetAll")) {
            List<Category> categoryList = service.getAll();
            writer.writeObject(categoryList);
            writer.flush();
        }else if(arrRequest[0].equals("Create")){
            Category category = new Category(arrRequest[2],arrRequest[3]);
            service.Add(category);
            List<Category> categoryList = service.getAll();
            writer.writeObject(categoryList);
            writer.flush();
        }else if(arrRequest[0].equals("Update")){
            Category category = new Category(Integer.parseInt(arrRequest[4]),arrRequest[2],arrRequest[3]);
            if(service.Update(category) == true){
                List<Category> categoryList = service.getAll();
                writer.writeObject(categoryList);
                writer.flush();
            }  
        }else if(arrRequest[0].equals("Delete")){
            if(service.Delete(Integer.parseInt(arrRequest[2]))){
                List<Category> categoryList = service.getAll();
                writer.writeObject(categoryList);
                writer.flush();
            }
        }else if(arrRequest[0].equals("Search")){
            List<Category> categoryList = service.Search(arrRequest[2]);
            if(!categoryList.isEmpty()){
                writer.writeObject(categoryList);
                writer.flush();
            }  
        }
    }

    private void handleProductRequests(String[] arrRequest) throws IOException {
        ProductService service = new ProductService();
        if (arrRequest[0].equals("GetAll")) {
            List<Product> productList = service.getAll();
            for(Product product: productList){
                System.out.println(product.getProductName());
            }
            writer.writeObject(productList);
            writer.flush();
        }else if(arrRequest[0].equals("Create")){
            //String request = "Create-Product-"+name+"-"+des+"-"+price+"-"+quantity+"-"+categoryId;
            String cleanedPrice = arrRequest[4].replace(".", "").replace(",", ".");
            double price = Double.parseDouble(cleanedPrice);
            int quantity = Integer.parseInt(arrRequest[5]);
            int categoryId = Integer.parseInt(arrRequest[6]);
            Product product = new Product(arrRequest[2],arrRequest[3],price,quantity,categoryId);
            if(service.Add(product)){
                List<Product> productList = service.getAll();
                writer.writeObject(productList);
                writer.flush();
            }
        }else if(arrRequest[0].equals("Update")){
            //String request = "Update-Product-"+name+"-"+des+"-"+price+"-"+quantity+"-"+categoryId;
            int id = Integer.parseInt(arrRequest[7]);
            String cleanedPrice = arrRequest[4].replace(".", "").replace(",", ".");
            double price = Double.parseDouble(cleanedPrice);
            int quantity = Integer.parseInt(arrRequest[5]);
            int categoryId = Integer.parseInt(arrRequest[6]);
            Product product = new Product(id,arrRequest[2],arrRequest[3],price,quantity,categoryId,false);
            if(service.Update(product)){
                List<Product> productList = service.getAll();
                writer.writeObject(productList);
                writer.flush();
            }
        }else if(arrRequest[0].equals("Delete")){
            if(service.Delete(Integer.parseInt(arrRequest[2]))){
                List<Product> productList = service.getAll();
                writer.writeObject(productList);
                writer.flush();
            }
        }else if(arrRequest[0].equals("GetProduct")){
            Product model = service.getProductById(Integer.parseInt(arrRequest[2]));
            if(model!=null){
                writer.writeObject(model);
                writer.flush();
            }
        }else if(arrRequest[0].equals("Search")){
            List<Product> categoryList = service.Search(arrRequest[2]);
            if(!categoryList.isEmpty()){
                writer.writeObject(categoryList);
                writer.flush();
            }  
        }
    }

    private void handleCustommerRequests(String[] arrRequest) throws IOException {
        CustommerService service = new CustommerService();
        if (arrRequest[0].equals("GetAll")) {
            List<Custommer> custommerList = service.getAllCustomers();
            writer.writeObject(custommerList);
            writer.flush();
        }else if(arrRequest[0].equals("Create")){
            //String request = "Create-Custommer-"+name+"-"+email+"-"+phone+"-"+address;
            Custommer model = new Custommer(arrRequest[2],arrRequest[3],arrRequest[4],arrRequest[5]);
            if(service.addCustomer(model)){
                List<Custommer> categoryList = service.getAllCustomers();
                writer.writeObject(categoryList);
                writer.flush();
            }
        }else if(arrRequest[0].equals("Update")){
            //String request = "Create-Custommer-"+name+"-"+email+"-"+phone+"-"+address;
            int id = Integer.parseInt(arrRequest[6]);
            Custommer model = new Custommer(id,arrRequest[2],arrRequest[3],arrRequest[4],arrRequest[5],false);
            if(service.updateCustomer(model)){
                List<Custommer> categoryList = service.getAllCustomers();
                writer.writeObject(categoryList);
                writer.flush();
            }
        }
        else if(arrRequest[0].equals("Delete")){
            //String request = "Create-Custommer-"+name+"-"+email+"-"+phone+"-"+address;
            if(service.deleteCustomer(Integer.parseInt(arrRequest[2]))){
                List<Custommer> categoryList = service.getAllCustomers();
                writer.writeObject(categoryList);
                writer.flush();
            }
        }
        else if(arrRequest[0].equals("GetCustommer")){
            Custommer model = service.GetCustommer(Integer.parseInt(arrRequest[2]));
            if(model !=null){
                writer.writeObject(model);
                writer.flush();
            }
        }
    }
    private void closeResources() {
        try {
            if (in != null) {
                in.close();
            }
            if (writer != null) {
                writer.close();
            }
            if (clientSocket != null) {
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleOderRequests(String[] arrRequest) throws IOException {
        OrderService service = new OrderService();
        if (arrRequest[0].equals("GetAll")) {
            List<Order> Orderlist = service.getAllOrders();
            for(Order item: Orderlist){
                System.out.println(item.getId());
            }
            writer.writeObject(Orderlist);
            writer.flush();
        }
        else if (arrRequest[0].equals("Create")) {
            Order order = new Order();
            if(service.addOrder(order)){
                writer.writeObject(order);
                writer.flush();
            }
        }else if (arrRequest[0].equals("UpdateCustommer")) {
            Order order = service.getOrderByid(Integer.parseInt(arrRequest[2]));
            order.setCustomerId(Integer.parseInt(arrRequest[3]));
            if(service.updateOrder(order)){
                writer.writeObject(order);
                writer.flush();
            }
        }else if (arrRequest[0].equals("GetOrder")) {
            Order order = service.getOrderByid(Integer.parseInt(arrRequest[2]));
            if(order!=null){
                writer.writeObject(order);
                writer.flush();
            }
        }else if (arrRequest[0].equals("UpdateTotalAmount")) {
            Order order = service.getOrderByid(Integer.parseInt(arrRequest[2]));
            double total = Double.parseDouble(arrRequest[3]);
            order.setTotalAmount(total);
            if(service.updateOrder(order)){
                writer.writeObject(order);
                writer.flush();
            }
        }
    }

    private void handleOderDetailRequests(String[] arrRequest) throws IOException {
        OrderDetailService service = new OrderDetailService();
        if (arrRequest[0].equals("getAllOrderDetail")) {
            List<OrderDetail> OrderDetailslist = service.getAllOrderDetailsByOrderId(Integer.parseInt(arrRequest[2]));
            writer.writeObject(OrderDetailslist);
            writer.flush();
        } else if (arrRequest[0].equals("Update")) {
            int orderId = Integer.parseInt( arrRequest[2]);
            int productId = Integer.parseInt( arrRequest[3]);
            int quantity = Integer.parseInt( arrRequest[4]);
            OrderDetail model = new OrderDetail(orderId, productId, quantity);
            List<OrderDetail> OrderDetailslist = new ArrayList<>();
            if(service.Update(model)){
                OrderDetailslist = service.getAllOrderDetailsByOrderId(orderId);
            }
            writer.writeObject(OrderDetailslist);
            writer.flush();
        }
        else if (arrRequest[0].equals("Create")) {
            int orderId = Integer.parseInt( arrRequest[2]);
            int productId = Integer.parseInt( arrRequest[3]);
            int quantity = Integer.parseInt( arrRequest[4]);
            OrderDetail model = new OrderDetail(orderId, productId, quantity);
            List<OrderDetail> OrderDetailslist = new ArrayList<>();
            if(service.Create(model)){
                OrderDetailslist = service.getAllOrderDetailsByOrderId(orderId);
            }
            writer.writeObject(OrderDetailslist);
            writer.flush();
        }else if (arrRequest[0].equals("Delete")) {
            int orderId = Integer.parseInt( arrRequest[2]);
            int productId = Integer.parseInt( arrRequest[3]);
            List<OrderDetail> OrderDetailslist = new ArrayList<>();
            if(service.Delete(productId,orderId)){
                OrderDetailslist = service.getAllOrderDetailsByOrderId(orderId);
            }
            writer.writeObject(OrderDetailslist);
            writer.flush();
        }
    }
}
