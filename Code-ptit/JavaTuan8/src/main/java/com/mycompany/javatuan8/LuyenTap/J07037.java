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
public class J07037 {
    
    public static DoanhNghiep readDoanhNghiep(Scanner sc){
        return new DoanhNghiep(
                sc.nextLine(),
                sc.nextLine(),
                Integer.valueOf(sc.nextLine())
        );
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("DN.in"));
        
        Integer n = Integer.valueOf(sc.nextLine());
        
        ArrayList<DoanhNghiep> listDoanhNghiepA = new ArrayList<>();
        for(int i=0; i<n; i++){
            listDoanhNghiepA.add(readDoanhNghiep(sc));
        }
        
        Collections.sort(listDoanhNghiepA, new DoanhNghiepComparator());
        
        for(DoanhNghiep t : listDoanhNghiepA){
            System.out.println(t.toString());
        }
    }
    
    static class DoanhNghiep {
        private String ma;
        private String ten;
        private Integer soSv;

        public DoanhNghiep(String ma, String ten, Integer soSv) {
            this.ma = ma;
            this.ten = ten;
            this.soSv = soSv;
        }

        public String getMa() {
            return ma;
        }

        public String getTen() {
            return ten;
        }

        public Integer getSoSv() {
            return soSv;
        }

        @Override
        public String toString() {
            return this.ma + " " + this.ten + " " + this.soSv;
        }
        
        
    }

    static class DoanhNghiepComparator implements Comparator<DoanhNghiep> {

        @Override
        public int compare(DoanhNghiep o1, DoanhNghiep o2) {
            String ma1 = o1.getMa();
            String ma2 = o2.getMa();
            Integer soSanhMa = ma1.compareTo(ma2);
            
            if(soSanhMa>0){
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
