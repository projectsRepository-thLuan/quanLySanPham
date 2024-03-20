/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package managementproductserver;

import java.net.ServerSocket;
import java.net.Socket;
import managementproductserver.Services.OrderDetailService;
import model.OrderDetail;


/**
 *
 * @author Binh Diep
 */
public class ManagementProductServer {

    /**
     * @param args the command line arguments
     */
     private static final int PORT = 12345;
     private ServerSocket server = null;
     private LoginClientHandler login = null;

    private ManagementProductServer(){
        try {
            server = new ServerSocket(PORT);
        } catch (Exception e) {e.printStackTrace();
        }  
    }
    
    public void action() {
        Socket socket = null;
        int i = 0;
        System.out.println("Serverlistening...");
        try {
            while ((socket = server.accept()) != null) {
                login =  new LoginClientHandler(socket);
                System.out.printf("Thread for Client #ed generating...%s\n", i++);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        var a = new OrderDetailService().getAllOrderDetailsByOrderId(1);
        for(OrderDetail od : a){
            System.out.println(od.getProductId());
        }
        new ManagementProductServer().action();
    }
}
