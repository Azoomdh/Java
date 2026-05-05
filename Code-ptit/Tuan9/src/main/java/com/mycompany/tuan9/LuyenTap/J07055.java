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
public class J07055 {
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("BANGDIEM.in"));
        
        Integer n = Integer.valueOf(sc.nextLine().trim());
        
        ArrayList<ThiSinh> listA1 = new ArrayList<>();
        for(int i=0; i<n; i++){
            ThiSinh a = readThiSinh(sc);
            listA1.add(a);
        }
        
        Collections.sort(listA1, new ThiSinh_Comparator());
        
        for(ThiSinh a : listA1){
            System.out.println(a.toString());
        }
    }
    
    public static ThiSinh readThiSinh(Scanner sc){
        return new ThiSinh(
                sc.nextLine(),
                Integer.valueOf(sc.nextLine().trim()),
                Integer.valueOf(sc.nextLine().trim()),
                Integer.valueOf(sc.nextLine().trim())
        );
    }
    
    static class Util_ChuanHoaHoTen{
        public static String chuanHoaHoTen(String hoTen){
            hoTen = hoTen.trim();
            hoTen = hoTen.toLowerCase();
            
            StringTokenizer sTokener = new StringTokenizer(hoTen, " ");
            
            ArrayList<String> listA1 = new ArrayList<>();
            while(sTokener.hasMoreTokens()==true ){
                String motTu = sTokener.nextToken();
                
                motTu = motTu.trim();
                motTu = motTu.toLowerCase();
                
                Integer motTuLength = motTu.length();
                if(motTuLength==0){
                    continue;
                }
                else if(motTuLength==1){
                    motTu = motTu.toUpperCase();
                    listA1.add(motTu);
                }
                else{
                    motTu = motTu.substring(0, 1).toUpperCase() + motTu.substring(1, motTuLength).toLowerCase();
                    listA1.add(motTu);
                }
            }
            
            String hoTenDaChuanHoa = "";
            for(String a : listA1){
                hoTenDaChuanHoa = hoTenDaChuanHoa + a + " ";
            }
            
            hoTenDaChuanHoa = hoTenDaChuanHoa.trim();
            
            return hoTenDaChuanHoa;
        }
    }
    
    static class Util_Compare{
        public static Integer compare(Double o1, Double o2){
            Double epsilon = 0.0001;
            Double hieu = o1 - o2;
            
            if(Math.abs(hieu)<epsilon ){
                return 0;
            }
            else if(hieu>0){
                return 1;
            }
            else{
                return -1;
            }
        }
    }

    static class ThiSinh {
        private String ma;
        private String hoTen;
        private Integer diemLT;
        private Integer diemTH;
        private Integer diemThi;
        
        private static Integer count = 0;

        public ThiSinh(String hoTen, Integer diemLT, Integer diemTH, Integer diemThi) {
            initMaThiSinh();
            this.hoTen = Util_ChuanHoaHoTen.chuanHoaHoTen(hoTen);
            this.diemLT = diemLT;
            this.diemTH = diemTH;
            this.diemThi = diemThi;
        }
        
        private void initMaThiSinh(){
            count++;
            this.ma = String.format("SV%02d", count);
        }
        
        public Double getTongDiem(){
            Double tongDiem = (double) diemLT*25/100;
            tongDiem = tongDiem + (double) diemTH*35/100;
            tongDiem = tongDiem + (double) diemThi*40/100;
            
            return tongDiem;
        }
        
        public String getTongDiem_String(){
            return String.format("%.2f", this.getTongDiem());
        }
        
        public String getXepHang(){
            Double tongDiem = this.getTongDiem();
            
            if(tongDiem>=8){
                return "GIOI";
            }
            else if(tongDiem<8 && tongDiem>=6.5){
                return "KHA";
            }
            else if(tongDiem<6.5 && tongDiem>=5){
                return "TRUNG BINH";
            }
            else{
                return "KEM";
            }
        }

        @Override
        public String toString() {
            return this.ma + " " + this.hoTen + " " + this.getTongDiem_String() + " " + this.getXepHang();
        }
        
        
    }
    
    static class ThiSinh_Comparator implements Comparator<ThiSinh>{

        @Override
        public int compare(ThiSinh o1, ThiSinh o2) {
            Double tongDiem1 = o1.getTongDiem();
            Double tongDiem2 = o2.getTongDiem();
            Integer soSanhTongDiem = Util_Compare.compare(tongDiem1, tongDiem2);
            
            if(soSanhTongDiem>0){
                return -1;
            }
            else if(soSanhTongDiem<0){
                return 1;
            }
            else {
                return 0;
            }
        }
        
    }
}
