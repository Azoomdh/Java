/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.baitap1.ViewAndController;

import com.mycompany.baitap1.Db.SinhVien;
import com.mycompany.baitap1.ViewAndController.Interface.ViewHasDetailFormInterface;
import com.mycompany.baitap1.ViewAndController.Interface.ViewHasDoiTuongDuocChon;
import com.mycompany.baitap1.ViewAndController.Interface.ViewHasListDoiTuongInterface;
import com.mycompany.baitap1.ViewAndController.Interface.ViewHasTableInterface;
import com.mycompany.baitap1.ViewAndController.Interface.ViewInterface;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author azoom
 */
public class TrangChuView 
extends 
        javax.swing.JFrame 
implements 
        ViewHasDetailFormInterface<SinhVien>,
        ViewHasDoiTuongDuocChon<SinhVien>,
        ViewHasListDoiTuongInterface<SinhVien, ArrayList<SinhVien> >,
        ViewHasTableInterface<SinhVien, ArrayList<SinhVien> >,
        ViewInterface
{

    @Override
    public void deleteFormContent() {
        this.formMasv.setText("");
        this.formHoten.setText("");
        this.formTenlop.setText("");
        this.formGpa.setText("");
    }

    @Override
    public SinhVien getFormContent() {
        return new SinhVien(
                String.valueOf(this.formMasv.getText()), 
                String.valueOf(this.formHoten.getText()), 
                String.valueOf(this.formTenlop.getText()), 
                Double.valueOf(this.formGpa.getText())
        );
    }

    @Override
    public void setFormContent(SinhVien t) {
        this.formMasv.setText(t.getMasv().toString());
        this.formHoten.setText(t.getHoten().toString());
        this.formTenlop.setText(t.getTenlop().toString());
        this.formGpa.setText(t.getGpa().toString());
    }

    @Override
    public SinhVien getDoiTuongDuocChon() {
        Integer sttHangDaChon = this.table.getSelectedRow();
        
        if(sttHangDaChon!=-1){
            DefaultTableModel model = this.getTableModel();
            
            SinhVien t = this.getDoiTuongFromRow(sttHangDaChon);
            
            return t;
        }
        
        return null;
    }

    @Override
    public ArrayList<SinhVien> getListDoiTuong() {
        DefaultTableModel model = this.getTableModel();
        
        Integer soHang = model.getRowCount();
        
        ArrayList<SinhVien> dsT = new ArrayList<>();
        for(int i=0; i<soHang; i++){
            dsT.add(this.getDoiTuongFromRow(i));
        }
        
        return dsT;
    }

    @Override
    public void setListDoiTuong(ArrayList<SinhVien> dsT) {
        DefaultTableModel model = this.getTableModel();
        model.setRowCount(0);
        
        for(SinhVien t : dsT){
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
    public SinhVien getDoiTuongFromRow(Integer sttHang) {
        DefaultTableModel model = this.getTableModel();
        
        return new SinhVien(
                String.valueOf(model.getValueAt(sttHang, 0).toString()), 
                String.valueOf(model.getValueAt(sttHang, 1).toString()),
                String.valueOf(model.getValueAt(sttHang, 2).toString()),
                Double.valueOf(model.getValueAt(sttHang, 2).toString())
        );
    }

    @Override
    public Object[] getRowFromDoiTuong(SinhVien doiTuong) {
        return new Object[]{
            doiTuong.getMasv(),
            doiTuong.getHoten(),
            doiTuong.getTenlop(),
            doiTuong.getGpa()
        };
    }

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
        this.deleteTableContent();
        this.deleteFormContent();
    }
    
    public void addListener_GetList(ActionListener e){
        this.getList.addActionListener(e);
    }
    public void addListener_GetDetails(ActionListener e){
        this.getDetail.addActionListener(e);
    }
    public void addListener_CreateNew(ActionListener e){
        this.createNew.addActionListener(e);
    }
    public void addListener_Update(ActionListener e){
        this.update.addActionListener(e);
    }
    public void addListener_Remove(ActionListener e){
        this.remove.addActionListener(e);
    }

    /**
     * Creates new form TrangChu
     */
    public TrangChuView() {
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
        getDetail = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        formMasv = new javax.swing.JTextField();
        formHoten = new javax.swing.JTextField();
        formTenlop = new javax.swing.JTextField();
        formGpa = new javax.swing.JTextField();
        update = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        createNew = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        getList.setText("get list");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "masv", "hoten", "tenlop", "gpa"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
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

        getDetail.setText("GetDetail");

        jLabel1.setText("masv : ");

        jLabel2.setText("hoten : ");

        jLabel3.setText("tenlop : ");

        jLabel4.setText("gpa : ");

        formMasv.setEditable(false);

        update.setText("update");

        remove.setText("remove");

        createNew.setText("CreateNew");

        jButton1.setText("create");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(getList)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(getDetail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(createNew))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(formMasv, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(update)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(remove)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(formTenlop, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(formHoten, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(formGpa, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 89, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(getList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(getDetail)
                    .addComponent(createNew))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(formMasv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(formHoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(formTenlop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(formGpa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(update)
                    .addComponent(remove)
                    .addComponent(jButton1))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(TrangChuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrangChuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrangChuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrangChuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrangChuView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createNew;
    private javax.swing.JTextField formGpa;
    private javax.swing.JTextField formHoten;
    private javax.swing.JTextField formMasv;
    private javax.swing.JTextField formTenlop;
    private javax.swing.JButton getDetail;
    private javax.swing.JButton getList;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton remove;
    private javax.swing.JTable table;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
