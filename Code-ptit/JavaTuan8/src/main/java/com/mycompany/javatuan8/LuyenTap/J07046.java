/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javatuan8.LuyenTap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author azoom
 */
public class J07046 {
    
    public static KhachHang readKhachHang(Scanner sc){
        return new KhachHang(
                sc.nextLine(),
                sc.nextLine(),
                sc.nextLine(),
                sc.nextLine()
        );
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("KHACH.in"));
        
        Integer n = Integer.valueOf(sc.nextLine());
        
        ArrayList<KhachHang> listKhachHang1 = new ArrayList<>();
        for(int i=0; i<n; i++){
            listKhachHang1.add(readKhachHang(sc));
        }
        
        Collections.sort(listKhachHang1, new KhachHangComparator());
        
        for(KhachHang t : listKhachHang1){
            System.out.println(t.toString());
        }
    }
    
    static class KhachHang{
        private String ma;
        private String hoten;
        private String maphong;
        private LocalDate ngayDen;
        private LocalDate ngayDi;
        private Long soNgayLuuTru;
        
        private static Integer count=0;
        private DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("d/M/yyyy");
        private DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        public KhachHang(String hoten, String maphong, String ngayDen, String ngayDi) {
            count++;
            this.ma = String.format("KH%02d", count);
            this.hoten = hoten;
            this.maphong = maphong;
            this.ngayDen = LocalDate.parse(ngayDen, dateTimeFormatter1);
            this.ngayDi = LocalDate.parse(ngayDi, dateTimeFormatter1);
            this.soNgayLuuTru = ChronoUnit.DAYS.between(this.ngayDen, this.ngayDi);
        }

        public String getMa() {
            return ma;
        }

        public String getHoten() {
            return hoten;
        }

        public String getMaphong() {
            return maphong;
        }

        public String getNgayDen() {
            return this.ngayDen.format(dateTimeFormatter2);
        }

        public String getNgayDi() {
            return this.ngayDi.format(dateTimeFormatter2);
        }

        public Long getSoNgayLuuTru() {
            return soNgayLuuTru;
        }

        @Override
        public String toString() {
            return this.ma + " " + this.hoten + " " + this.maphong + " " + this.soNgayLuuTru;
        }
        
    }
    
    static class KhachHangComparator implements Comparator<KhachHang> {

        @Override
        public int compare(KhachHang o1, KhachHang o2) {
            Long soNgayLuuTru1 = o1.getSoNgayLuuTru();
            Long soNgayLuuTru2 = o2.getSoNgayLuuTru();
            Integer soSanhSoNgayLuuTru = soNgayLuuTru1.compareTo(soNgayLuuTru2);
            
            if(soSanhSoNgayLuuTru>0){
                return -1;
            }
            else if(soSanhSoNgayLuuTru<0){
                return 1;
            }
            else{
                return 0;
            }
        }
        
    }
}
