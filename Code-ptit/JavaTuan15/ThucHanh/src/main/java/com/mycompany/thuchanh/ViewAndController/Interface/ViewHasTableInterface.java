/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.thuchanh.ViewAndController.Interface;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author azoom
 * @param <DoiTuong>
 * @param <ContainerOfDoiTuong> // chat gpt goi y dung cach nay
 */
public interface ViewHasTableInterface<DoiTuong, ContainerOfDoiTuong>
{
    public void deleteTableContent();
    
    public DefaultTableModel getTableModel();
    
    public DoiTuong getDoiTuongFromRow(Integer sttHang);
    
    public Object[] getRowFromDoiTuong(DoiTuong doiTuong);
    
//    public ContainerOfDoiTuong getListObject();
//    
//    public void setListObject(ContainerOfDoiTuong dsT);
}
