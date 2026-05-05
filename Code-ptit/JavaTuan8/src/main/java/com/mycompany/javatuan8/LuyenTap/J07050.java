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
public class J07050 {
    
    private static MatHang readMatHang(Scanner sc) {
        return new MatHang(
                sc.nextLine(),
                sc.nextLine(),
                Double.valueOf(sc.nextLine()),
                Double.valueOf(sc.nextLine())
        );
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("MATHANG.in"));
        
        Integer n = Integer.valueOf(sc.nextLine());
        
        ArrayList<MatHang> list1 = new ArrayList<>();
        for(int i=0; i<n; i++){
            list1.add(readMatHang(sc));
        }
        
        Collections.sort(list1, new MatHangComparator());
        
        for(MatHang t : list1){
            System.out.println(t);
        }
    }


    
    static class MatHang{
        private String ma;
        private String ten;
        private String nhom;
        private Double giaMua;
        private Double giaBan;
        
        private static Integer count = 0;

        public MatHang(String ten, String nhom, Double giaMua, Double giaBan) {
            count++;
            this.ma = String.format("MH%02d", count);
            this.ten = ten;
            this.nhom = nhom;
            this.giaMua = giaMua;
            this.giaBan = giaBan;
        }

        public String getMa() {
            return ma;
        }

        public String getTen() {
            return ten;
        }

        public String getNhom() {
            return nhom;
        }

        public Double getGiaMua() {
            return giaMua;
        }

        public Double getGiaBan() {
            return giaBan;
        }
        
        

        public Double getLoiNhuan(){
            return giaBan-giaMua;
        }
        @Override
        public String toString() {
            return this.ma + " " + this.ten + " " + this.nhom + " " + String.format(" %.2f", this.getLoiNhuan());
        }
        
    }

    static class MatHangComparator implements Comparator<MatHang> {

        @Override
        public int compare(MatHang o1, MatHang o2) {
            Double loiNhuan1 = o1.getLoiNhuan();
            Double loiNhuan2 = o2.getLoiNhuan();
            Integer soSanhLoiNhuan = loiNhuan1.compareTo(loiNhuan2);
            
            if(soSanhLoiNhuan>0){
                return -1;
            }
            else if (soSanhLoiNhuan<0){
                return 1;
            }
            else {
                return 0;
            }
        }
        
    }
}

