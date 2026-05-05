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

/**
 *
 * @author azoom
 */
public class J07058 {
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("MONHOC.in"));
        
        Integer n = Integer.valueOf(sc.nextLine().trim());
        
        ArrayList<MonThi> listA1 = new ArrayList<>();
        for(int i=0; i<n; i++){
            MonThi aTemp = new MonThi(
                    sc.nextLine().trim(),
                    sc.nextLine().trim(),
                    sc.nextLine().trim()
            );
            listA1.add(aTemp);
        }
        
        Collections.sort(listA1, new Comparator_MonThi());
        
        for(MonThi a : listA1){
            System.out.println(a.toString());
        }
    }
    static class MonThi{
        private String maMon;
        private String tenMon;
        private String hinhThucThi;

        public MonThi(String maMon, String tenMon, String hinhThucThi) {
            this.maMon = maMon;
            this.tenMon = tenMon;
            this.hinhThucThi = hinhThucThi;
        }

        public String getMaMon() {
            return maMon;
        }
        
        @Override
        public String toString() {
            return this.maMon + " " + this.tenMon + " " + this.hinhThucThi;
        }
        
    }
    
    static class Comparator_MonThi implements Comparator<MonThi> {

        @Override
        public int compare(MonThi o1, MonThi o2) {
            String maMon1 = o1.getMaMon();
            String maMon2 = o2.getMaMon();
            Integer soSanhMaMon = maMon1.compareTo(maMon2);
            
            if(soSanhMaMon>0){
                return 1;
            }
            else if(soSanhMaMon<0){
                return -1;
            }
            else{
                return 0;
            }
        }
        
    }
}
