/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.raven.form;

import com.raven.main.sendToServer;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Custommer;
import model.Order;
import model.OrderDetail;
import model.Product;

/**
 *
 * @author Binh Diep
 */
public final class frmOrderDetails extends javax.swing.JFrame {

    /**
     * Creates new form frmOrderDetails
     */
    Order order;
    List<OrderDetail> listOrderDetail = new ArrayList<>();
    sendToServer sts = new sendToServer();
    int productId;
    List<Custommer> custommerList = new ArrayList<>();
    List<Integer> productIdList = new ArrayList<>();
    public frmOrderDetails() {
        initComponents();
        LoadCBX();
    }
    
    public void LoadForm(){
        String request = "getAllOrderDetail-OrderDetail-" + this.order.getId();
        listOrderDetail = ( List<OrderDetail>) sts.Action(request);
        tableOD.getColumnModel().getColumn(4).setMinWidth(0);
        tableOD.getColumnModel().getColumn(4).setMaxWidth(0);
        tableOD.getColumnModel().getColumn(4).setWidth(0);
        bingdingTableOD(listOrderDetail);
        request = "GetAll-Product";
        List<Product> listPro = (List<Product>) sts.Action(request);
        bingDingTablePro(listPro);
        LoadCBX();
    }
    
    public void LoadCBX() {
        if (this.order != null) {
            String request = "GetAll-Custommer";
            custommerList = (List<Custommer>) sts.Action(request);
            DefaultComboBoxModel model = (DefaultComboBoxModel) cbxCustommer.getModel();
            // removing old data
            model.removeAllElements();

            for (Custommer item : custommerList) {
                model.addElement(item);
            }
            Custommer a = findCustommer(this.order.getCustomerId());
            cbxCustommer.setSelectedItem(a);
        }
    }

    
    public Custommer findCustommer(int custommerId){
        for(Custommer item: custommerList){
            if(item.getId() == custommerId)
                return item;
        }
        return null;
    }
    
    Product getProduct(int ProductId){
        String request = "GetProduct-Product-"+ProductId;
        Product model = (Product) sts.Action(request);
        return model;
    }
    
    public frmOrderDetails(Order order) {
        initComponents();
        this.order = order;
        LoadForm();
        
    }
    
    public void bingDingTablePro(List<Product> listProduct){
        DefaultTableModel tblModel = (DefaultTableModel)tablePro.getModel();
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        while(tblModel.getRowCount() > 0)
        {
            tblModel.removeRow(0);
        }
        if (listProduct != null) {
            for (Product item : listProduct) {
                String tbData[] = { String.valueOf(item.getId()),
                                    item.getProductName(),
                                    String.valueOf(decimalFormat.format( item.getPrice()))};
                tblModel.addRow(tbData);
            }
        }
    }
    
    public void bingdingTableOD( List<OrderDetail> listData){
        DefaultTableModel tblModel = (DefaultTableModel)tableOD.getModel();
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        double totalAmount = 0;
        while(tblModel.getRowCount() > 0)
        {
            tblModel.removeRow(0);
        }
        if (listData != null) {
            for (OrderDetail item : listData) {
                Product product = getProduct(item.getProductId());
                double total = product.getPrice()*item.getQuantity();
                totalAmount += total;
                String tbData[] = { product.getProductName(),
                                    String.valueOf(item.getQuantity()),
                                    String.valueOf(decimalFormat.format( product.getPrice())),
                                    String.valueOf(decimalFormat.format(total )),
                                    String.valueOf(item.getProductId())};
                this.productIdList.add(item.getProductId());
                tblModel.addRow(tbData);
            }
        }
        String tbData[] = { "Total Amount",
                                    "",
                                    "",
                                    String.valueOf(decimalFormat.format(totalAmount)),
                                    ""};
                tblModel.addRow(tbData);
                String request = "UpdateTotalAmount-Order-"+this.order.getId()+"-"+totalAmount;
                var a = sts.Action(request);
                if(a==null){
                    JOptionPane.showMessageDialog(null, "abc");
                }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableOD = new com.raven.swing.table.Table();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePro = new com.raven.swing.table.Table();
        txtSearch = new javax.swing.JTextField();
        txtProduct = new javax.swing.JTextField();
        txtQuantity = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        cbxCustommer = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tableOD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Product name", "Quantity", "Price", "Total", "ProductId"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableOD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableODMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableOD);
        if (tableOD.getColumnModel().getColumnCount() > 0) {
            tableOD.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel1.setText("Order Details");

        tablePro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Product", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablePro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablePro);

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
        });

        txtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityActionPerformed(evt);
            }
        });

        jLabel2.setText("Product");

        jLabel3.setText("Quantity");

        jLabel4.setText("Price");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnClear.setText("CLEAR");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        cbxCustommer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                            .addComponent(cbxCustommer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 79, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbxCustommer, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        txtPrice.setText("");
        txtProduct.setText("");
        txtQuantity.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    boolean checkProdustHas(int id){
        for(int item : productIdList){
            if(item==id)
                return true;
        }
        return false;
    }
    
    private void tableODMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableODMouseClicked
        // TODO add your handling code here:
        int index = tableOD.getSelectedRow();
        TableModel model = tableOD.getModel();
        this.productId = Integer.parseInt(model.getValueAt(index,4).toString());
        txtProduct.setText(String.valueOf(model.getValueAt(index,0).toString()));
        txtQuantity.setText(model.getValueAt(index,1).toString());
        txtPrice.setText(model.getValueAt(index,2).toString());
    }//GEN-LAST:event_tableODMouseClicked

    private void tableProMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProMouseClicked
        int index = tablePro.getSelectedRow();
        TableModel model = tablePro.getModel();
        if(checkProdustHas(Integer.parseInt(model.getValueAt(index,0).toString()))){
            JOptionPane.showMessageDialog(null, "Đã có sản phẩm này rồi");
        }else{
                    this.productId = Integer.parseInt(model.getValueAt(index,0).toString());
            txtProduct.setText(String.valueOf(model.getValueAt(index,1).toString()));
            txtQuantity.setText(String.valueOf(1));
            txtPrice.setText(model.getValueAt(index,2).toString());
        }
    }//GEN-LAST:event_tableProMouseClicked

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        // TODO add your handling code here:
        if(txtSearch.getText().equals("")){
            String request = "GetAll-Product";
            List<Product> listPro = (List<Product>) sts.Action(request);
            bingDingTablePro(listPro);
        }else{
            sendToServer sts = new sendToServer();
            String id = txtSearch.getText();
            String request = "Search-Product-"+id;
            List<Product> listData = (List<Product>) sts.Action(request);
            bingDingTablePro(listData);
        }
    }//GEN-LAST:event_txtSearchKeyPressed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
//        int productId = this.productId;
//        int quantity = Integer.parseInt(txtQuantity.getText());
//        int orderId = this.order.getId();
//        String request = "Update-OrderDetail-"+orderId+"-"+productId+"-"+quantity;
//        List<OrderDetail> odList = (List<OrderDetail>) sts.Action(request);
//        bingdingTableOD(odList);
        Custommer model = (Custommer) cbxCustommer.getSelectedItem();
        if (model != null) {
            if(this.order.getCustomerId()!=model.getId()){
                String request = "UpdateCustommer-Order-" + this.order.getId() + "-" + model.getId();
                List<Order> orderList = (List<Order>) sts.Action(request);
                if (orderList != null) {
                    JOptionPane.showMessageDialog(null, "Thành công");
                }
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
       int productId = this.productId;
       int quantity = Integer.parseInt(txtQuantity.getText());
       int orderId = this.order.getId();
       String request = "Create-OrderDetail-"+orderId+"-"+productId+"-"+quantity;
       List<OrderDetail> odList = (List<OrderDetail>) sts.Action(request);
       bingdingTableOD(odList);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
       int productId = this.productId;
       int quantity = Integer.parseInt(txtQuantity.getText());
       int orderId = this.order.getId();
       String request = "Delete-OrderDetail-"+orderId+"-"+productId;
       List<OrderDetail> odList = (List<OrderDetail>) sts.Action(request);
       bingdingTableOD(odList);
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbxCustommer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.raven.swing.table.Table tableOD;
    private com.raven.swing.table.Table tablePro;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtProduct;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
