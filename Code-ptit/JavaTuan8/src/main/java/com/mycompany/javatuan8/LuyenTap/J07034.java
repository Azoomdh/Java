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
public class J07034 {
    
    public static MonHoc readMonHoc(Scanner sc){
        return new MonHoc(
                sc.nextLine(),
                sc.nextLine(),
                Integer.valueOf(sc.nextLine())
        );
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("MONHOC.in"));
        
        Integer n = Integer.valueOf(sc.nextLine());
        
        ArrayList<MonHoc> listMonHocA = new ArrayList<>();
        for(int i=0; i<n; i++){
            listMonHocA.add(readMonHoc(sc));
        }
        
        Collections.sort(listMonHocA, new MonHocComparator());
        
        for(MonHoc t : listMonHocA){
            System.out.println(t.toString());
        }
    }
    
    static class MonHoc {
        private String maMon;
        private String tenMon;
        private Integer soTinChi;

        public MonHoc(String maMon, String tenMon, Integer soTinChi) {
            this.maMon = maMon;
            this.tenMon = tenMon;
            this.soTinChi = soTinChi;
        }

        public String getMaMon() {
            return maMon;
        }

        public String getTenMon() {
            return tenMon;
        }

        public Integer getSoTinChi() {
            return soTinChi;
        }

        @Override
        public String toString() {
            return this.maMon + " " + this.tenMon + " " + this.soTinChi;
        }
        
        
    }
    
    static class MonHocComparator implements Comparator<MonHoc> {

        @Override
        public int compare(MonHoc o1, MonHoc o2) {
            String tenMon1 = o1.getTenMon();
            String tenMon2 = o2.getTenMon();
            Integer soSanhTenMon = tenMon1.compareTo(tenMon2);
            
            if(soSanhTenMon>0){
                return 1;
            }
            else if(soSanhTenMon<0){
                return -1;
            }
            else{
                return 0;
            }
        }
        
    }
}
