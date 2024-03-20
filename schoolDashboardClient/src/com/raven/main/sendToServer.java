/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.main;

import ManagementProductClient.BaseClass;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Binh Diep
 */
public class sendToServer {
    BaseClass baseClass = new BaseClass();
    private ObjectInputStream in = null;
    private PrintWriter out = null;
    private ObjectOutputStream oo = null;
    private Socket socket = null;
    
    public Object Action(String request){
        try {
            socket = new Socket(baseClass.SERVER_IP,baseClass.SERVER_PORT);
            this.out = new PrintWriter(this.socket.getOutputStream(),true);
            in = new ObjectInputStream(this.socket.getInputStream());
            System.out.println("Connected to the server.");
            request = request.trim();
            
           // Gửi đối tượng qua mạng
            out.println(request);
            
            // Receive the object from the server
            return in.readObject();         
       } catch (IOException e) {
           e.printStackTrace();
       } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
       } finally{
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close(); // Close the ObjectInputStream
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
    }
        return null;
    }
    
}
