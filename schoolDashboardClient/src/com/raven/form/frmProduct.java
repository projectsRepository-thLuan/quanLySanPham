/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form;

import com.raven.component.Card;
import com.raven.main.sendToServer;
import com.raven.model.ModelCard;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Category;
import model.Product;

/**
 *
 * @author Binh Diep
 */
public class frmProduct extends javax.swing.JPanel {

    /**
     * Creates new form frmProduct
     */
    
    List<Category> listCategory = new ArrayList<>();
    sendToServer sts = new sendToServer();
    int sizeList = 0;
    public frmProduct() {
        initComponents();
        setOpaque(false);
        loadForm();
    }
    
    public void loadForm() {

        LoadCBX();
        
        sizeList = LoadProducts();
    }
    
  
    public void  LoadCBX(){
        String requestCategory = "GetAll-Category";
        listCategory = (List<Category>) sts.Action(requestCategory);
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbxCategory.getModel();
        // removing old data
        model.removeAllElements();

        for (Category item : listCategory) {
            model.addElement(item);
        }
    }
    
    public int LoadProducts(){
        String request = "GetAll-Product";
        List<Product> listData = (List<Product>) sts.Action(request);
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        JPanel cardsPanel = new JPanel(new GridLayout(0, 2));
        for (Product item : listData) {
            Card card = new Card();
            ModelCard model = new ModelCard(item.getProductName(), item.getPrice(), 100);
            card.setData(model);

            card.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    txtId.setText(String.valueOf(item.getId()));
                    txtName.setText(item.getProductName());
                    txtDescription.setText(item.getDescription());
                    double price = item.getPrice();
                    txtPrice.setText(decimalFormat.format(price));
                    txtStockQuantity.setText(String.valueOf(item.getStockQuantity()));
                    Category a = findCategory(item.getCategoryId());
                    cbxCategory.setSelectedItem(a);
                }
            });

            JPanel cardContainer = new JPanel(new GridBagLayout());
            cardContainer.add(card);
            cardsPanel.add(cardContainer);
        }

        panel2.setViewportView(cardsPanel);
        panel2.revalidate();
        panel2.repaint();
        return listData.size();
    }

    public Category findCategory(int CategoryId){
        for(Category item: listCategory){
            if(item.getId() == CategoryId)
                return item;
        }
        return null;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new javax.swing.JPanel();
        panel2 = new javax.swing.JScrollPane();
        panel3 = new javax.swing.JPanel();
        txtName = new javax.swing.JTextField();
        txtStockQuantity = new javax.swing.JTextField();
        txtDescription = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        cbxCategory = new javax.swing.JComboBox<>();
        txtId = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1058, 741));

        panel1.setBackground(new java.awt.Color(255, 255, 255));

        panel2.setBackground(new java.awt.Color(255, 255, 255));

        panel3.setBackground(new java.awt.Color(255, 255, 255));

        txtDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescriptionActionPerformed(evt);
            }
        });

        txtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceActionPerformed(evt);
            }
        });

        cbxCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxCategory.setSelectedItem(getUI());
        cbxCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCategoryActionPerformed(evt);
            }
        });

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtId)
                    .addComponent(txtName)
                    .addComponent(txtDescription)
                    .addComponent(txtPrice)
                    .addComponent(txtStockQuantity)
                    .addComponent(cbxCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(btnCreate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtStockQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(141, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 50, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 105, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 78, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtDescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescriptionActionPerformed

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:
        String name = txtName.getText();
        String des = txtDescription.getText();
        String price = txtPrice.getText();
        String quantity = txtStockQuantity.getText();
        Category category = (Category) cbxCategory.getSelectedItem();
        String categoryId = String.valueOf( category.getId());
        String request = "Create-Product-"+name+"-"+des+"-"+price+"-"+quantity+"-"+categoryId;
        List<Product> listDatanew = (List<Product>) sts.Action(request);
        if(sizeList < listDatanew.size())
        {
            JOptionPane.showMessageDialog(null, "Đã thêm sản phẩm thành công");
            loadForm();
        }else JOptionPane.showMessageDialog(null, "Đã thêm sản phẩm thất bại");
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String id = txtId.getText();
        String name = txtName.getText();
        String des = txtDescription.getText();
        String price = txtPrice.getText();
        String quantity = txtStockQuantity.getText();
        Category category = (Category) cbxCategory.getSelectedItem();
        String categoryId = String.valueOf( category.getId());
        String request = "Update-Product-"+name+"-"+des+"-"+price+"-"+quantity+"-"+categoryId+"-"+id;
        if(sts.Action(request)!=null)
        {
            JOptionPane.showMessageDialog(null, "Cập nhật sản phẩm thành công");
            loadForm();
        }else JOptionPane.showMessageDialog(null, "Cập nhật sản phẩm thất bại");
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        String id = txtId.getText();
        String request = "Delete-Product-"+id;
        List<Product> listDatanew = (List<Product>) sts.Action(request);
        if(sizeList > listDatanew.size())
        {
            JOptionPane.showMessageDialog(null, "Xóa sản phẩm thành công");
            loadForm();
        }else JOptionPane.showMessageDialog(null, "Xóa sản phẩm thất bại");
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void cbxCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCategoryActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbxCategory;
    private javax.swing.JPanel panel1;
    private javax.swing.JScrollPane panel2;
    private javax.swing.JPanel panel3;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtStockQuantity;
    // End of variables declaration//GEN-END:variables
}
