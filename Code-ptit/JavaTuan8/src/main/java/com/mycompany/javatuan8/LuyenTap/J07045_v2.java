/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javatuan8.LuyenTap;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author azoom
 */
public class J07045_v2 {
    
    public static void main(String[] args) throws IOException {
        ArrayList<LoaiPhong> ds = new ArrayList<>();
        Scanner in = new Scanner(new File("PHONG.in"));
        int n = Integer.parseInt(in.nextLine());
        while(n-->0){
            ds.add(new LoaiPhong(in.nextLine()));
        }
        Collections.sort(ds);
        for(LoaiPhong tmp : ds){
            System.out.println(tmp);
        }
    }
    
    static class LoaiPhong implements Comparable<LoaiPhong>{
        private Character loaiPhong;
        private String tenLoaiPhong;
        private Integer donGiaNgay;
        private Float phiPhucVu;
        
        public LoaiPhong(String line){
            Scanner sc2 = new Scanner(line);
            
            this.loaiPhong = sc2.next().charAt(0);
            this.tenLoaiPhong = sc2.next();
            this.donGiaNgay = sc2.nextInt();
            this.phiPhucVu = sc2.nextFloat();
        }

        public LoaiPhong(Character loaiPhong, String tenLoaiPhong, Integer donGiaNgay, Float phiPhucVu) {
            this.loaiPhong = loaiPhong;
            this.tenLoaiPhong = tenLoaiPhong;
            this.donGiaNgay = donGiaNgay;
            this.phiPhucVu = phiPhucVu;
        }

        public Character getLoaiPhong() {
            return loaiPhong;
        }

        public String getTenLoaiPhong() {
            return tenLoaiPhong;
        }

        public Integer getDonGiaNgay() {
            return donGiaNgay;
        }

        public Float getPhiPhucVu() {
            return phiPhucVu;
        }

        @Override
        public String toString() {
            return this.loaiPhong + " " + this.tenLoaiPhong + " " + this.donGiaNgay + " " + this.phiPhucVu;
        }

        @Override
        public int compareTo(LoaiPhong o) {
            String ten1 = this.getTenLoaiPhong();
            String ten2 = o.getTenLoaiPhong();
            Integer soSanhTen = ten1.compareTo(ten2);
            
            if(soSanhTen>0){
                return 1;
            }
            else if(soSanhTen<0){
                return -1;
            }
            else{
                return 0;
            }
        }
        
    }
    

}
