/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.thuchanh.ViewAndController;

import com.mycompany.thuchanh.BaiTapNhom.BaiTapNhom;
import com.mycompany.thuchanh.ViewAndController.Interface.ViewHasDetailFormInterface;
import com.mycompany.thuchanh.ViewAndController.Interface.ViewHasDoiTuongDuocChon;
import com.mycompany.thuchanh.ViewAndController.Interface.ViewHasListDoiTuongInterface;
import com.mycompany.thuchanh.ViewAndController.Interface.ViewHasTableInterface;
import com.mycompany.thuchanh.ViewAndController.Interface.ViewInterface;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author azoom
 */
public class BaiTapNhomView 
extends javax.swing.JFrame 
implements 
        ViewInterface,
        ViewHasDetailFormInterface<BaiTapNhom>,
        ViewHasListDoiTuongInterface<BaiTapNhom, ArrayList<BaiTapNhom> >,
        ViewHasTableInterface<BaiTapNhom, Integer>,
        ViewHasDoiTuongDuocChon<BaiTapNhom>
{

    @Override
    public void showView() {
        this.setVisible(true);
    }

    @Override
    public void hideView() {
        this.setVisible(false);
    }

    @Override
    public void deleteContent() {
        this.deleteFormContent();
        this.deleteTableContent();
    }

    @Override
    public void deleteFormContent() {
        this.mabaitap.setText("0");
        this.tenbaitap.setText("");
        this.kieubaitap.setText("");
        this.tongthoigian.setText("");
    }

    @Override
    public BaiTapNhom getFormContent() {

        return new BaiTapNhom(
                Integer.valueOf(mabaitap.getText()),
                String.valueOf(this.tenbaitap.getText()),
                Integer.valueOf(kieubaitap.getText()),
                Integer.valueOf(tongthoigian.getText())
        );
    }

    @Override
    public void setFormContent(BaiTapNhom t) {
        this.mabaitap.setText(t.getMabaitap().toString());
        this.tenbaitap.setText(t.getTenbaitap().toString());
        this.kieubaitap.setText(t.getKieubaitap().toString());
        this.tongthoigian.setText(t.getTongthoigian().toString());
    }

    @Override
    public ArrayList<BaiTapNhom> getListDoiTuong() {
        DefaultTableModel model = this.getTableModel();
        
        Integer soHang = model.getRowCount();
        
        ArrayList<BaiTapNhom> dsT = new ArrayList<>();
        for(int i=0; i<soHang; i++){
            dsT.add(this.getDoiTuongFromRow(i));
        }
        
        return dsT;
    }

    @Override
    public void setListDoiTuong(ArrayList<BaiTapNhom> dsT) {
        DefaultTableModel model = this.getTableModel();
        model.setRowCount(0);
        
        for(BaiTapNhom t : dsT){
            model.addRow(this.getRowFromDoiTuong(t));
        }
        
        this.repaint();
    }

    @Override
    public void deleteTableContent() {
        this.getTableModel().setRowCount(0);
    }

    @Override
    public DefaultTableModel getTableModel() {
        return (DefaultTableModel) this.table.getModel();
    }

    @Override
    public BaiTapNhom getDoiTuongFromRow(Integer sttHang) {
        DefaultTableModel model = this.getTableModel();
        
        return new BaiTapNhom(
                Integer.valueOf(model.getValueAt(sttHang, 0).toString()),
                String.valueOf(model.getValueAt(sttHang, 1).toString()),
                Integer.valueOf(model.getValueAt(sttHang, 2).toString()),
                Integer.valueOf(model.getValueAt(sttHang, 3).toString())
        );
    }

    @Override
    public Object[] getRowFromDoiTuong(BaiTapNhom doiTuong) {
        return new Object[]{
            doiTuong.getMabaitap(),
            doiTuong.getTenbaitap(),
            doiTuong.getKieubaitap(),
            doiTuong.getTongthoigian()
        };
    }

    @Override
    public BaiTapNhom getDoiTuongDuocChon() {
        Integer sttHangDaChon = this.table.getSelectedRow();
        
        if(sttHangDaChon!=-1){
            DefaultTableModel model = this.getTableModel();
            
            BaiTapNhom t = this.getDoiTuongFromRow(sttHangDaChon);
            
            return t;
        }
        
        return null;
    }
    
    
    
    public void addListener_GetList(ActionListener e){
        this.getList.addActionListener(e);
    }
    
    public void addListener_Create(ActionListener e){
        this.create.addActionListener(e);
    }
    
    public void addListener_Delete(ActionListener e){
        this.delete.addActionListener(e);
    }
    

    /**
     * Creates new form BaiTapNhomView
     */
    public BaiTapNhomView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        getList = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tenbaitap = new javax.swing.JTextField();
        mabaitap = new javax.swing.JTextField();
        kieubaitap = new javax.swing.JTextField();
        tongthoigian = new javax.swing.JTextField();
        create = new javax.swing.JButton();
        delete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        getList.setText("getList");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "mabaitap", "tenbaitap", "kieubaitap", "tongthoigian"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        jLabel1.setText("mabaitap");

        jLabel2.setText("tenbaitap");

        jLabel3.setText("kieubaitap");

        jLabel4.setText("tongthoigian");

        mabaitap.setText("0");
        mabaitap.setEnabled(false);
        mabaitap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mabaitapActionPerformed(evt);
            }
        });

        kieubaitap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kieubaitapActionPerformed(evt);
            }
        });

        tongthoigian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tongthoigianActionPerformed(evt);
            }
        });

        create.setText("create");

        delete.setText("delete");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(getList)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(kieubaitap, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mabaitap, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tenbaitap, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(tongthoigian, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(create)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(delete)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(getList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mabaitap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tenbaitap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(kieubaitap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tongthoigian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(create)
                    .addComponent(delete))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mabaitapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mabaitapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mabaitapActionPerformed

    private void kieubaitapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kieubaitapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kieubaitapActionPerformed

    private void tongthoigianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tongthoigianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tongthoigianActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BaiTapNhomView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BaiTapNhomView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BaiTapNhomView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BaiTapNhomView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BaiTapNhomView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton create;
    private javax.swing.JButton delete;
    private javax.swing.JButton getList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField kieubaitap;
    private javax.swing.JTextField mabaitap;
    private javax.swing.JTable table;
    private javax.swing.JTextField tenbaitap;
    private javax.swing.JTextField tongthoigian;
    // End of variables declaration//GEN-END:variables
}
