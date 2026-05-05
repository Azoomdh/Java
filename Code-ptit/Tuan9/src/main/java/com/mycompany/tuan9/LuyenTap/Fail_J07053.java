/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tuan9.LuyenTap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author azoom
 */
public class Fail_J07053 {
    
    public static ThiSinh readThiSinh(Scanner sc){
        return new ThiSinh(
                sc.nextLine(),
                sc.nextLine(),
                Double.valueOf(sc.nextLine()),
                Double.valueOf(sc.nextLine())
        );
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("XETTUYEN.in"));
        
        Integer n = Integer.valueOf(sc.nextLine());
        
        ArrayList<ThiSinh> listThiSinh = new ArrayList<>();
        for(int i=0; i<n; i++){
            listThiSinh.add(readThiSinh(sc));
        }
        
        for(ThiSinh a : listThiSinh){
            System.out.println(a.toString());
        }
    }
    
    
    static class ThiSinh {
        private String ma;
        private String hoTen;
        private LocalDate ngaySinh;
        private Double diemLyThuyet;
        private Double diemThucHanh;
        
        private static Integer count=0;
        private static DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("d/M/yyyy");
        private static DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        public ThiSinh(String hoTen, String ngaySinh, Double diemLyThuyet, Double diemThucHanh) {
            count++;
            this.ma = String.format("PH%02d", count);
            this.hoTen = ChuanHoaHoTenUtil.chuanHoaHoTen(hoTen);
            this.ngaySinh = LocalDate.parse(ngaySinh, dateTimeFormatter1);
            this.diemLyThuyet = diemLyThuyet;
            this.diemThucHanh = diemThucHanh;
        }
        
        public Integer getTuoi(){
            Integer namSinh = this.ngaySinh.getYear();
            Integer namNay = LocalDate.now().getYear();
            return namNay-namSinh;
//            Integer namSinh = this.ngaySinh.getYear();
//            return 2021-namSinh;
        }
        
        public Double getDiemThuong(){
            Double diemThuong = Double.valueOf("0");
            
            if(this.diemLyThuyet>=8 && this.diemThucHanh>=8){
                diemThuong = diemThuong+1;
            }
            
            if(this.diemLyThuyet>=7.5 && this.diemThucHanh>=7.5){
                diemThuong = diemThuong+0.5;
            }
            
            return diemThuong;
        }
        
        public Double getDiemTrungBinh(){
            Double diemTrungBinh = (this.diemLyThuyet+this.diemThucHanh)/2 + this.getDiemThuong();
            
            if(diemTrungBinh>=10){
                return Double.valueOf("10");
            }
            else{
                return diemTrungBinh;
            }
        }
        
        public String getXepLoai() {
            Double dTB = this.getDiemTrungBinh();
            
            if(dTB<5){
                return "Truot";
            }
            else if(5<=dTB && dTB<7){
                return "Trung binh";
            }
            else if(7<=dTB && dTB<8){
                return "Kha";
            }
            else if(8<=dTB && dTB<9){
                return "Gioi";
            }
            else if(9<=dTB || dTB<=10 ){
                return "Xuat sac";
            }
            else{
                return null;
            }
        }

        public String getNgaySinh() {
            return ngaySinh.format(dateTimeFormatter2);
        }

        @Override
        public String toString() {
            return this.ma + " " + this.hoTen + " " + this.getTuoi() + " " + String.format("%.0f", this.getDiemTrungBinh()) + " " + this.getXepLoai();
        }
        
    }
    
    static class ChuanHoaHoTenUtil{
        public static String chuanHoaHoTen(String hoTen){
            hoTen = hoTen.trim();
            hoTen = hoTen.toLowerCase();
            
            StringTokenizer sTokener = new StringTokenizer(hoTen, " ");
            
            ArrayList<String> listTu = new ArrayList<>();
            while(sTokener.hasMoreTokens()==true ){
                String motTu = sTokener.nextToken();
                
                motTu = motTu.trim();
                motTu = motTu.substring(0, 1).toUpperCase() + motTu.substring(1, motTu.length()).toLowerCase();
                
                listTu.add(motTu);
            }
            
            String hoTenDaChuanHoa = "";
            for(String motTu : listTu){
                hoTenDaChuanHoa = hoTenDaChuanHoa + motTu + " ";
            }
            
            hoTenDaChuanHoa = hoTenDaChuanHoa.trim();
            
            return hoTenDaChuanHoa;
        }
    }
    
}
