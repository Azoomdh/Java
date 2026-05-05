/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thuchanh.ViewAndController;

import com.mycompany.thuchanh.BaiTapNhom.BaiTapNhom;
import com.mycompany.thuchanh.BaiTapNhom.BaiTapNhomRepo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author azoom
 */
public class BaiTapNhomController {
    private BaiTapNhomView baiTapNhomView;
    private BaiTapNhomRepo baiTapNhomRepo;

    public BaiTapNhomController() {
    //
    this.baiTapNhomView = new BaiTapNhomView();
    this.baiTapNhomRepo = new BaiTapNhomRepo();
    
    this.baiTapNhomView.addListener_GetList(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ArrayList<BaiTapNhom> dsT = (ArrayList<BaiTapNhom>) baiTapNhomRepo.getList();
                    
                    baiTapNhomView.setListDoiTuong(dsT);
                    
                    baiTapNhomView.showView();
                }
            }
    );
    
    this.baiTapNhomView.addListener_Create(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    BaiTapNhom t = baiTapNhomView.getFormContent();
                    
                    t= baiTapNhomRepo.create(t);
                    
                    baiTapNhomView.deleteFormContent();
                }
            }
    );
    
    this.baiTapNhomView.addListener_Delete(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    BaiTapNhom t = baiTapNhomView.getDoiTuongDuocChon();
                    
                    baiTapNhomRepo.delete(t.getMabaitap());
                }
            }
    );
    
    this.baiTapNhomView.showView();
    
    }
    
    public static void main(String[] args) {
        BaiTapNhomController baiTapNhomController = new BaiTapNhomController();
        
    }
}
