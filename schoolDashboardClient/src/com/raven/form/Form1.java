package com.raven.form;

import com.raven.main.sendToServer;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Category;

public class Form1 extends javax.swing.JPanel {

    public Form1() {
        initComponents();
        setOpaque(false);
        loadForm();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new com.raven.swing.table.Table();
        txtCategoryName = new javax.swing.JTextField();
        txtDes = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnCreateCategory = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnCreateCategory1 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 117));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 51, 255), 3), null));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setPreferredSize(new java.awt.Dimension(1058, 741));

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
        });

        table1.setBackground(new java.awt.Color(255, 255, 255));
        table1.setForeground(new java.awt.Color(255, 255, 255));
        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên", "Mô tả"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table1);

        txtDes.setToolTipText("");

        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("iCiel Pony", 0, 18)); // NOI18N
        jLabel2.setText("Category Name");

        jLabel3.setFont(new java.awt.Font("iCiel Pony", 0, 18)); // NOI18N
        jLabel3.setText("ID");

        jLabel4.setFont(new java.awt.Font("iCiel Pony", 0, 18)); // NOI18N
        jLabel4.setText("Description");

        btnCreateCategory.setBackground(new java.awt.Color(0, 255, 51));
        btnCreateCategory.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCreateCategory.setForeground(new java.awt.Color(51, 51, 51));
        btnCreateCategory.setText("Create");
        btnCreateCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateCategoryActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(255, 255, 0));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(51, 51, 51));
        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnCreateCategory1.setBackground(new java.awt.Color(255, 51, 51));
        btnCreateCategory1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCreateCategory1.setForeground(new java.awt.Color(255, 255, 255));
        btnCreateCategory1.setText("Delete");
        btnCreateCategory1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateCategory1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtSearch, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDes, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                    .addComponent(txtCategoryName)
                    .addComponent(txtID)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCreateCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCreateCategory1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCategoryName, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDes, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCreateCategory, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btnCreateCategory1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void loadForm(){
        String request = "GetAll-Category";
        sendToServer sts = new sendToServer();
        List<Category> listData = (List<Category>) sts.Action(request);
        bingdingTable(listData);
    }
    
    public void bingdingTable( List<Category> listData){
        DefaultTableModel tblModel = (DefaultTableModel)table1.getModel();
        while(tblModel.getRowCount() > 0)
        {
            tblModel.removeRow(0);
        }
        if (listData != null) {
            for (Category category : listData) {
                String tbData[] = { String.valueOf(category.getId()), category.getCategoryName(), category.getDescription()};
                tblModel.addRow(tbData);
            }
        }
    }
    
    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        // TODO add your handling code here:
        if(txtSearch.getText().equals("")){
            loadForm();
        }else{
            sendToServer sts = new sendToServer();
            String id = txtSearch.getText();
            String request = "Search-Category-"+id;
            List<Category> listData = (List<Category>) sts.Action(request);
            bingdingTable(listData);
        }
    }//GEN-LAST:event_txtSearchKeyPressed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        // TODO add your handling code here:
        int index = table1.getSelectedRow();
        TableModel model = table1.getModel();
        txtID.setText(String.valueOf(model.getValueAt(index,0).toString()));
        txtCategoryName.setText(model.getValueAt(index,1).toString());
        txtDes.setText(model.getValueAt(index,2).toString());
    }//GEN-LAST:event_table1MouseClicked

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void btnCreateCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateCategoryActionPerformed
        // TODO add your handling code here:
        sendToServer sts = new sendToServer();
        String Categoryname = txtCategoryName.getText();
        String Des = txtDes.getText();
        String request = "Create-Category-"+Categoryname+"-"+Des;
        List<Category> listData = (List<Category>) sts.Action(request);
        if(listData != null){
            JOptionPane.showMessageDialog(null, "Đã thêm thành công");
        }
        else{
            JOptionPane.showMessageDialog(null, "Thêm không được");
        }
        bingdingTable(listData);
    }//GEN-LAST:event_btnCreateCategoryActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        sendToServer sts = new sendToServer();
        String Categoryname = txtCategoryName.getText();
        String Des = txtDes.getText();
        String id = txtID.getText();
        String request = "Update-Category-"+Categoryname+"-"+Des+"-"+id;
        List<Category> listData = (List<Category>) sts.Action(request);
        if(listData != null){
            JOptionPane.showMessageDialog(null, "sửa thành công");
        }
        else{
            JOptionPane.showMessageDialog(null, "Thêm không được");
        }
        bingdingTable(listData);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnCreateCategory1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateCategory1ActionPerformed
        // TODO add your handling code here:
        sendToServer sts = new sendToServer();
        String id = txtID.getText();
        String request = "Delete-Category-"+id;
        List<Category> listData = (List<Category>) sts.Action(request);
        if(listData != null){
            JOptionPane.showMessageDialog(null, "Xóa thành công");
        }
        else{
            JOptionPane.showMessageDialog(null, "Xóa không được");
        }
        bingdingTable(listData);
    }//GEN-LAST:event_btnCreateCategory1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateCategory;
    private javax.swing.JButton btnCreateCategory1;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.raven.swing.table.Table table1;
    private javax.swing.JTextField txtCategoryName;
    private javax.swing.JTextField txtDes;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
