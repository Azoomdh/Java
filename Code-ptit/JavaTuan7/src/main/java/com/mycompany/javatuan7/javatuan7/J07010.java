/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javatuan7.javatuan7;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author azoom
 */
public class J07010 {
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("SV.in"));
//        Scanner sc = new Scanner(System.in);
        
        Integer n = Integer.valueOf(sc.nextLine());
        for(int i=0; i<n; i++){
            SinhVien t = new SinhVien(
                    sc.nextLine(),
                    sc.nextLine(),
                    sc.nextLine(),
                    Float.valueOf(sc.nextLine())
            );
            System.out.println(t.toString());
        }
    }
    
    static class SinhVien{
        private String maSV;
        private String ten;
        private String lop;
        private LocalDate ngay;
        private Float gpa;
        
        private static Integer count=0;
        private DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("d/M/yyyy");
        private DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        public SinhVien(String ten, String lop, String ngay, Float gpa) {
            count++;
            this.maSV= String.format("B20DCCN%03d", count);
            this.ten = ten;
            this.lop = lop;
            this.ngay = LocalDate.parse(ngay, dateTimeFormatter1);
            this.gpa = gpa;
        }

        public String getMaSV() {
            return maSV;
        }

        public String getTen() {
            return ten;
        }

        public String getLop() {
            return lop;
        }

        public String getNgay() {
            return this.ngay.format(dateTimeFormatter2);
        }

        public Float getGpa() {
            return gpa;
        }

        @Override
        public String toString() {
            return this.maSV + " " + this.ten + " " + this.lop + " " + this.getNgay() + " " + String.format("%.2f", this.gpa);
        }
        
    }
}
