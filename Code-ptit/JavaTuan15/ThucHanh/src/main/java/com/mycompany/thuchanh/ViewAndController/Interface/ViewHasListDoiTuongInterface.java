/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.thuchanh.ViewAndController.Interface;


/**
 *
 * @author azoom
 * @param <DoiTuong>
 * @param <ContainerOfDoiTuong>
 */
public interface ViewHasListDoiTuongInterface <DoiTuong, ContainerOfDoiTuong> {
    
    public ContainerOfDoiTuong getListDoiTuong();
    
    public void setListDoiTuong(ContainerOfDoiTuong dsT);
}
