/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baitap1.ViewAndController;

import com.mycompany.baitap1.Db.SinhVien;
import com.mycompany.baitap1.Db.SinhVienRepo;
import com.mycompany.baitap1.ViewAndController.Interface.ControllerInterface;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author azoom
 */
public class TrangChuController implements  ControllerInterface {
    
    private TrangChuView trangChuView;
    
    private SinhVienRepo sinhVienRepo;

    @Override
    public void showMainView() {
        this.trangChuView.showView();
    }

    @Override
    public void hideMainView() {
        this.trangChuView.hideView();
    }

    
    
    public static void main(String[] args) {
        TrangChuController trangChuController = new TrangChuController();
        trangChuController.showMainView();
    }
    
    
    
    
    
    
public TrangChuController() {

this.sinhVienRepo = new SinhVienRepo();

this.trangChuView = new TrangChuView();

this.trangChuView.addListener_GetList(
        new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<SinhVien> dsT = (ArrayList<SinhVien>) TrangChuController.this.sinhVienRepo.getList();
                
                TrangChuController.this.trangChuView.setListDoiTuong(dsT);
            }
        }
);

this.trangChuView.addListener_GetDetails(
        new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SinhVien t = TrangChuController.this.trangChuView.getDoiTuongDuocChon();
                
                TrangChuController.this.trangChuView.deleteFormContent();
                TrangChuController.this.trangChuView.setFormContent(t);
            }
        }
);

this.trangChuView.addListener_CreateNew(
        new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TrangChuController.this.trangChuView.deleteFormContent();
            }
        }
);

this.trangChuView.addListener_Update(
        new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SinhVien t = TrangChuController.this.trangChuView.getFormContent();
                
                TrangChuController.this.sinhVienRepo.update(t.getMasv(), t);
            }
        }
);

}
}
