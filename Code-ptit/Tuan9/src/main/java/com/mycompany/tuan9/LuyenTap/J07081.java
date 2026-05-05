/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tuan9.LuyenTap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author azoom
 */
public class J07081 {
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("SINHVIEN.in"));
        
        Integer n = Integer.valueOf(sc.nextLine());
        
        ArrayList<SinhVien> listA1= new ArrayList<>();
        for(int i=0; i<n; i++){
            SinhVien aTemp = new SinhVien(
                    sc.nextLine(),
                    sc.nextLine(),
                    sc.nextLine(),
                    sc.nextLine()
            );
            
            listA1.add(aTemp);
        }
        
        Collections.sort(listA1, new Comparator_SinhVien());
        
        for(SinhVien a : listA1){
            System.out.println(a.toString());
        }
    }
    
    static class TenDayDu {
        private String ho;
        private String tenDem;
        private String tenChinh;

        public TenDayDu(String tenDayDu){
            tenDayDu = tenDayDu.trim();
            
            this.ho = "";
            this.tenDem = "";
            this.tenChinh = "";
            
            StringTokenizer sTokenizer = new StringTokenizer(tenDayDu, " ");
            
            ArrayList<String> listA1 = new ArrayList<>();
            while(sTokenizer.hasMoreTokens()==true ){
                listA1.add(sTokenizer.nextToken());
            }
            
            this.ho = listA1.get(0);
            for(int i=1; i<=listA1.size()-2; i++){
                this.tenDem = this.tenDem + listA1.get(i) + " ";
            }
            this.tenChinh = listA1.get(listA1.size()-1);
            
            this.ho = this.ho.trim();
            this.tenDem = this.tenDem.trim();
            this.tenChinh = this.tenChinh.trim();
        }

        public String getHo() {
            return ho;
        }

        public String getTenDem() {
            return tenDem;
        }

        public String getTenChinh() {
            return tenChinh;
        }

        @Override
        public String toString() {
            return this.ho + " " + this.tenDem + " " + this.tenChinh;
        }
        
        
    }
    
    static class SinhVien {
        private String ma;
        private TenDayDu tenDayDu;
        private String soDienThoai;
        private String email;

        public SinhVien(String ma, String tenDayDu, String soDienThoai, String email) {
            this.ma = ma;
            this.tenDayDu = new TenDayDu(tenDayDu);
            this.soDienThoai = soDienThoai;
            this.email = email;
        }

        public TenDayDu getTenDayDu() {
            return tenDayDu;
        }

        public String getMa() {
            return ma;
        }

        @Override
        public String toString() {
            return this.ma + " " + this.tenDayDu.toString() + " " + this.soDienThoai + " " + this.email;
        }
        
        
        
    }
    
    static class Comparator_SinhVien implements Comparator<SinhVien> {

        @Override
        public int compare(SinhVien o1, SinhVien o2) {
            String tenChinh1 = o1.getTenDayDu().getTenChinh();
            String tenChinh2 = o2.getTenDayDu().getTenChinh();
            Integer soSanhTenChinh = tenChinh1.compareTo(tenChinh2);

            String ho1 = o1.getTenDayDu().getHo();
            String ho2 = o2.getTenDayDu().getHo();
            Integer soSanhHo = ho1.compareTo(ho2);
            
            String tenDem1 = o1.getTenDayDu().getTenDem();
            String tenDem2 = o2.getTenDayDu().getTenDem();
            Integer soSanhTenDem = tenDem1.compareTo(tenDem2);
            
            String ma1 = o1.getMa();
            String ma2 = o2.getMa();
            Integer soSanhMa = ma1.compareTo(ma2);
            
            if(soSanhTenChinh>0){
                return 1;
            }
            else if(soSanhTenChinh<0){
                return -1;
            }
            else if(soSanhHo>0){
                return 1;
            }
            else if(soSanhHo<0){
                return -1;
            }
            else if(soSanhTenDem>0){
                return 1;
            }
            else if(soSanhTenDem<0){
                return -1;
            }
            else if(soSanhMa>0){
                return 1;
            }
            else if(soSanhMa<0){
                return -1;
            }
            else{
                return 0;
            }
        }
        
    }
}
