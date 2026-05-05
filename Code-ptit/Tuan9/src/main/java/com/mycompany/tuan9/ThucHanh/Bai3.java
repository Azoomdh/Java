/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tuan9.ThucHanh;

import java.time.LocalTime;
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
public class Bai3 {
    
    private static Scanner sc = new Scanner(System.in);
    
    public static ChamCong readChamCong(){
        return new ChamCong(
                sc.nextLine(),
                sc.nextLine(),
                sc.nextLine(),
                sc.nextLine()
        );
    }
    

    
    public static void main(String[] args) {
        Integer soCongNhan = Integer.valueOf(sc.nextLine());
        
        ArrayList<ChamCong> listA1 = new ArrayList<>();
        for(int i=0; i<soCongNhan; i++){
            ChamCong temp = readChamCong();
            listA1.add(temp);
        }
        
        Collections.sort(listA1, new ChamCongComparator());
        
        for(ChamCong a : listA1){
            System.out.println(a.toString());
        }
    }
    
    static class ChamCong {
        private String ma;
        private String ten;
        private LocalTime gioVao;
        private LocalTime gioRa;

        private static DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("HH:mm");
        
        public ChamCong(String ma, String ten, String gioVao, String gioRa) {
            this.ma = ma;
            this.ten = ten;
            this.gioVao = LocalTime.parse(gioVao, dateTimeFormatter1);
            this.gioRa = LocalTime.parse(gioRa, dateTimeFormatter1);
        }

        public String getMa() {
            return ma;
        }

        public String getTen() {
            return ten;
        }

        public String getGioVao() {
            return gioVao.format(dateTimeFormatter1);
        }

        public String getGioRa() {
            return gioRa.format(dateTimeFormatter1);
        }
        
        public ThoiGian getThoiGianLamViec(){
            Long soGioLamViec = Math.abs(ChronoUnit.HOURS.between(gioVao, gioRa));
            Long soPhutLamViec = Math.abs(ChronoUnit.MINUTES.between(gioVao, gioRa));
            
            soPhutLamViec = soPhutLamViec - soGioLamViec*60;
            
            return new ThoiGian(soGioLamViec, soPhutLamViec);
        }
        
        public String getDaDuThoiGianLamViec(){
            Long soGioLamViec = Math.abs(ChronoUnit.HOURS.between(gioVao, gioRa));
            
            if(soGioLamViec>=8){
                return "DU";
            }
            else{
                return "THIEU";
            }
        }

        @Override
        public String toString() {
            return this.ma + " " + this.ten + " " + this.getThoiGianLamViec().toString() + " " + this.getDaDuThoiGianLamViec();
        }
        
    }
    
    private static class ThoiGian{
        private Long soGio;
        private Long soPhut;

        public ThoiGian(Long soGio, Long soPhut) {
            this.soGio = soGio;
            this.soPhut = soPhut;
        }

        public Long getSoGio() {
            return soGio;
        }

        public Long getSoPhut() {
            return soPhut;
        }

        @Override
        public String toString() {
            return this.soGio + " gio " + this.soPhut + " phut";
        }
        
    }
    
    static class ChamCongComparator implements Comparator<ChamCong> {

        @Override
        public int compare(ChamCong o1, ChamCong o2) {
            ThoiGian thoiGianLamViec1 = o1.getThoiGianLamViec();
            ThoiGian thoiGianLamViec2 = o2.getThoiGianLamViec();
            
            Long soGio1 = thoiGianLamViec1.getSoGio();
            Long soGio2 = thoiGianLamViec2.getSoGio();
            Integer soSanhSoGio = soGio1.compareTo(soGio2);

            Long soPhut1 = thoiGianLamViec1.getSoPhut();
            Long soPhut2 = thoiGianLamViec2.getSoPhut();
            Integer soSanhSoPhut = soPhut1.compareTo(soPhut2);
            
            String ten1 = o1.getTen();
            String ten2 = o2.getTen();
            Integer soSanhTen = ten1.compareTo(ten2);
            
            if(soSanhSoGio>0){
                return -1;
            }
            else if(soSanhSoGio<0){
                return 1;
            }
            else if(soSanhSoPhut>0){
                return -1;
            }
            else if(soSanhSoPhut<0){
                return 1;
            }
            else if(soSanhTen>0){
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

/*
2
01T
Nguyen Van An
08:00
17:30
06T
Tran Hoa Binh
09:05
17:00
*/