/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javatuan8.LuyenTap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author azoom
 */
public class J07048 {
    
    public static SanPham readSanPham(Scanner sc){
        return new SanPham(
                sc.nextLine(),
                sc.nextLine(),
                Integer.valueOf(sc.nextLine()),
                Integer.valueOf(sc.nextLine())
        );
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("SANPHAM.in"));
        
        Integer n = Integer.valueOf(sc.nextLine());
        
        ArrayList<SanPham> listSanPhamA1 = new ArrayList<>();
        for(int i=0; i<n; i++){
            listSanPhamA1.add(readSanPham(sc));
        }
        
        Collections.sort(listSanPhamA1, new SanPhamComparator());
        
        for(SanPham t : listSanPhamA1){
            System.out.println(t.toString());
        }
    }
    
    static class SanPham {
        private String ma;
        private String ten;
        private Integer gia;
        private Integer soThangBaoHanh;

        public SanPham(String ma, String ten, Integer gia, Integer soThangBaoHanh) {
            this.ma = ma;
            this.ten = ten;
            this.gia = gia;
            this.soThangBaoHanh = soThangBaoHanh;
        }

        public String getMa() {
            return ma;
        }

        public String getTen() {
            return ten;
        }

        public Integer getGia() {
            return gia;
        }

        public Integer getSoThangBaoHanh() {
            return soThangBaoHanh;
        }

        @Override
        public String toString() {
            return this.ma + " " + this.ten + " " + this.gia + " " + this.soThangBaoHanh;
        }
        
        
    }

    static class SanPhamComparator implements Comparator<SanPham> {

        @Override
        public int compare(SanPham o1, SanPham o2) {
            Integer gia1 = o1.getGia();
            Integer gia2 = o2.getGia();
            Integer soSanhGia = gia1.compareTo(gia2);
            
            String ma1 = o1.getMa();
            String ma2 = o2.getMa();
            Integer soSanhMa = ma1.compareTo(ma2);
            
            if(soSanhGia>0){
                return -1;
            }
            else if(soSanhGia<0){
                return 1;
            }
            else if(soSanhMa>0){
                return 1;
            }
            else if(soSanhMa<0){
                return -1;
            }
            else {
                return 0;
            }
        }
        
    }
}
