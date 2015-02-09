/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.basicApp.swing;

import br.com.basicApp.dao.SellDAO;
import br.com.basicApp.dao.UserDAO;
import br.com.basicApp.model.Sell;
import br.com.basicApp.model.SellItem;
import br.com.basicApp.model.User;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Eliel
 */
public class frmUpdateSell extends javax.swing.JDialog {

    /**
     * Creates new form frmAddSell
     */
    private List<SellItem> itens = new LinkedList<SellItem>();
    private final SellDAO dao;
    private final UserDAO userDAO = new UserDAO();
    private final frmSells control;
    private final Sell selectedSell;
    
    public frmUpdateSell(java.awt.Frame parent, boolean modal,SellDAO dao,frmSells control,Sell selectedSell) {
        super(parent, modal);
        this.dao = dao;
        this.control = control;
        this.selectedSell = selectedSell;
        initComponents();
        loadInitialData();
        updateInfromationOnSite();
        refreshItens();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDateOfSale = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        comboVendor = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableItensUpdate = new javax.swing.JTable();
        btnRemoveItem = new javax.swing.JButton();
        btnAddItem = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnUpdateSell = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Sells"));

        jLabel1.setText("Vendor");

        jLabel2.setText("Date of Sale");

        jLabel3.setText("Total");

        txtDateOfSale.setEditable(false);

        txtTotal.setEditable(false);

        comboVendor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtDateOfSale, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(comboVendor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboVendor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtDateOfSale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Itens"));

        jTableItensUpdate.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableItensUpdate);

        btnRemoveItem.setText("Remove Item");
        btnRemoveItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveItemActionPerformed(evt);
            }
        });

        btnAddItem.setText("Add Item");
        btnAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemoveItem))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemoveItem)
                    .addComponent(btnAddItem))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnUpdateSell.setText("Update");
        btnUpdateSell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateSellActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnUpdateSell)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnUpdateSell))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(572, 464));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddItemActionPerformed
        frmAddItemSale dialog = new frmAddItemSale(new javax.swing.JFrame(), true,itens , this);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnAddItemActionPerformed

    private void btnRemoveItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveItemActionPerformed
      
        if(jTableItensUpdate.getSelectedRow() == -1){
           JOptionPane.showMessageDialog(this,"You must select one before remove","Error",JOptionPane.ERROR_MESSAGE);
           return;
       }
       int resp = JOptionPane.showConfirmDialog(this,"Are you sure ?","Confim Delete",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
       if(resp == 0){
       itens.remove(jTableItensUpdate.getSelectedRow());
       refreshItens();
       }
    }//GEN-LAST:event_btnRemoveItemActionPerformed

    private void btnUpdateSellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateSellActionPerformed
       
        if(itens.size() == 0) {
            JOptionPane.showMessageDialog(this,"The item list is empty !","Error",JOptionPane.ERROR_MESSAGE);
            return;
      }
        int resp = JOptionPane.showConfirmDialog(this,"Are you sure ?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if (resp == 0 ){
            
            selectedSell.setTotal(Float.parseFloat(txtTotal.getText().substring(2)));
            selectedSell.setItens(itens);
            for(SellItem sellItem : itens){
                sellItem.setSell(selectedSell);
            }
            selectedSell.setVendor((User)comboVendor.getSelectedItem());
            try {
                dao.removeSell(selectedSell.getId());
                dao.addSell(selectedSell,true);
                control.loadInitialData();
                setVisible(false);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this,"Error saving sell"+ex ,"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnUpdateSellActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddItem;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnRemoveItem;
    private javax.swing.JButton btnUpdateSell;
    private javax.swing.JComboBox comboVendor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableItensUpdate;
    private javax.swing.JTextField txtDateOfSale;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

    private void loadInitialData() {
        try {
            Vector<User> users = new Vector(userDAO.getAllUsers());
            DefaultComboBoxModel combousr = new DefaultComboBoxModel(users);
            comboVendor.setModel(combousr);
            
            txtTotal.setText("R$ 0,00");
            txtDateOfSale.setText(new SimpleDateFormat("dd/mm/yyyy").format(new Date()));
        } catch (SQLException ex) {
            Logger.getLogger(frmUpdateSell.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,"Erro loading efault data","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void refreshItens() {
        jTableItensUpdate.setModel(new MyTableModel(SellItem.class, itens, jTableItensUpdate));
        float value = 0;
        for (SellItem sellItem : itens) {
            value += sellItem.getPorduct().getPrice() * sellItem.getQnt();
            sellItem.setTotalOfItem(value);
        }
        txtTotal.setText("R$"+value);
    }

    private void updateInfromationOnSite() {
        txtDateOfSale.setText(new SimpleDateFormat("dd/mm/yyyy").format(selectedSell.getDataOfSale()));
        itens = selectedSell.getItens();
        comboVendor.setSelectedItem(selectedSell.getVendor());
    }
}
