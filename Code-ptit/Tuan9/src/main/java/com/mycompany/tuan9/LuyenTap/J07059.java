package com.mycompany.tuan9.LuyenTap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author azoom
 */
public class J07059 {
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("CATHI.in"));
        
        Integer n = Integer.valueOf(sc.nextLine().trim());
        
        ArrayList<CaThi> listA1 = new ArrayList<>();
        for(int i=0; i<n; i++){
            CaThi aTemp = readCaThi(sc);
            listA1.add(aTemp);
        }
        
        Collections.sort(listA1, new Comparator_CaThi());
        
        for(CaThi a : listA1){
            System.out.println(a.toString());
        }
    }

    private static CaThi readCaThi(Scanner sc) {
        return new CaThi(
                sc.nextLine().trim(),
                sc.nextLine().trim(),
                sc.nextLine().trim()
        );
    }
    
    static class CaThi{
        private String ma;
        private LocalDate ngayThi;
        private LocalTime gioThi;
        private String phongThi;
        
        private static Integer count=0;
        private static DateTimeFormatter ngayThi_Formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        private static DateTimeFormatter gioThi_Formatter = DateTimeFormatter.ofPattern("HH:mm");

        public CaThi(String ngayThi, String gioThi, String phongThi) {
            initMaCaThi();
            this.ngayThi = LocalDate.parse(ngayThi, ngayThi_Formatter);
            this.gioThi = LocalTime.parse(gioThi, gioThi_Formatter);
            this.phongThi = phongThi;
        }

        private void initMaCaThi() {
            count++;
            this.ma = String.format("C%03d", count);
        }

        private String getNgayThi_String() {
            return ngayThi.format(ngayThi_Formatter);
        }

        private String getGioThi_String() {
            return gioThi.format(gioThi_Formatter);
        }

        @Override
        public String toString() {
            return this.ma + " " + this.getNgayThi_String() + " " + this.getGioThi_String() + " " + this.phongThi;
        }

        public LocalDate getNgayThi() {
            return ngayThi;
        }

        public LocalTime getGioThi() {
            return gioThi;
        }

        public String getMa() {
            return ma;
        }
        
    }
    
    static class Comparator_CaThi implements Comparator<CaThi> {

        @Override
        public int compare(CaThi o1, CaThi o2) {
            LocalDate ngayThi1 = o1.getNgayThi();
            LocalDate ngayThi2 = o2.getNgayThi();
            Integer soSanhNgayThi = ngayThi1.compareTo(ngayThi2);
            
            LocalTime gioThi1 = o1.getGioThi();
            LocalTime gioThi2 = o2.getGioThi();
            Integer soSanhGioThi = gioThi1.compareTo(gioThi2);
            
            String maCaThi1 = o1.getMa();
            String maCaThi2 = o2.getMa();
            Integer soSanhMaCaThi = maCaThi1.compareTo(maCaThi2);
            
            if(soSanhNgayThi>0){
                return 1;
            }
            else if(soSanhNgayThi<0){
                return -1;
            }
            else if(soSanhGioThi>0){
                return 1;
            }
            else if(soSanhGioThi<0){
                return -1;
            }
            else if(soSanhMaCaThi>0){
                return 1;
            }
            else if(soSanhMaCaThi<0){
                return -1;
            }
            else{
                return 0;
            }
        }
        
    }
}
