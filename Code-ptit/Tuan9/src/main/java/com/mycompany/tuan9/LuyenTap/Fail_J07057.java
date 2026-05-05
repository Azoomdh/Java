package com.mycompany.tuan9.LuyenTap;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author azoom
 */
public class Fail_J07057 {
    
    private static ThiSinh readThiSinh(Scanner sc) {
        return new ThiSinh(
                sc.nextLine(),
                Double.valueOf(sc.nextLine()),
                sc.nextLine(),
                Integer.valueOf(sc.nextLine().trim())
        );
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("THISINH.in"));

        Integer n = Integer.valueOf(sc.nextLine().trim());

        ArrayList<ThiSinh> listA1 = new ArrayList<>();
        for(int i=0; i<n; i++){
            listA1.add(readThiSinh(sc));
        }

        Collections.sort(listA1, new ThiSinh_Comparator());

        for(ThiSinh a : listA1){
            System.out.println(a);
        }
    }
    
    static class Util_ChuanHoaHoTen{
        public static String chuanHoaHoTen(String hoTen){
            hoTen = hoTen.trim();
            hoTen = hoTen.toLowerCase();
            
            StringTokenizer sTokener = new StringTokenizer(hoTen, " ");
            
            String hoTenDaChuanHoa = "";
            while(sTokener.hasMoreTokens()==true ){
                String motTu = sTokener.nextToken();
                
                motTu = motTu.trim();
                motTu = motTu.toLowerCase();
                motTu = motTu.substring(0, 1).toUpperCase()+ motTu.substring(1, motTu.length()).toLowerCase();
                
                hoTenDaChuanHoa = hoTenDaChuanHoa + motTu + " ";
            }
            
            hoTenDaChuanHoa = hoTenDaChuanHoa.trim();
            
            return hoTenDaChuanHoa;
        }
    }
    
    static class Util_Compare{
        public static Integer compare(Double o1, Double o2){
            Double epsilon = 0.0001;
            Double hieu = o1-o2;
            
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
        private String maTS;
        private String hoTen;
        private Double diemThi;
        private String danToc;
        private Integer khuVuc;
        
        private static Integer count=0;

        public ThiSinh(String hoTen, Double diemThi, String danToc, Integer khuVuc) {
            initMaTS();
            this.hoTen = Util_ChuanHoaHoTen.chuanHoaHoTen(hoTen);
            this.diemThi = diemThi;
            this.danToc = danToc.trim();
            this.khuVuc = khuVuc;
        }

        private void initMaTS() {
            count++;
            this.maTS = String.format("TS%02d", count);
        }

        public String getMaTS() {
            return maTS;
        }
        
        public Double getDiemCong(){
            Double totalDiemCong= Double.valueOf("0");
            
            if(this.khuVuc==1){
                totalDiemCong = totalDiemCong + 1.5;
            }
            else if(this.khuVuc==2){
                totalDiemCong = totalDiemCong + 1;
            }
            else if(this.khuVuc==3){
                // doesnt do
            }
            
            if(this.danToc.toLowerCase().equals("kinh")==false ){
                totalDiemCong = totalDiemCong + 1.5;
            }
            
            return totalDiemCong;
        }
        
        public Double getTongDiem(){
            return this.diemThi + this.getDiemCong();
        }
        
        public String getTongDiem_String(){
            return String.format("%.1f", this.getTongDiem());
        }
        
        public String getTrungTuyen(){
            Double tongDiem = this.getTongDiem();
            Double diemChuan = Double.valueOf("20.5");
            Integer soSanhDiem = Util_Compare.compare(tongDiem, diemChuan);
            
            if(soSanhDiem>=0){
                return "Do";
            }
            else{
                return "Truot";
            }
        }

        @Override
        public String toString() {
            return this.maTS + " " + this.hoTen + " " + this.getTongDiem_String() + " " + this.getTrungTuyen();
        }
        
        
    }
    
    static class ThiSinh_Comparator implements Comparator<ThiSinh> {

        @Override
        public int compare(ThiSinh o1, ThiSinh o2) {
            Double tongDiem1 = o1.getTongDiem();
            Double tongDiem2 = o2.getTongDiem();
            Integer soSanhTongDiem = Util_Compare.compare(tongDiem1, tongDiem2);
            
            String maTS1 = o1.getMaTS();
            String maTS2 = o2.getMaTS();
            Integer soSanhMaTS = maTS1.compareTo(maTS2);
            
            if(soSanhTongDiem>0){
                return -1;
            }
            else if(soSanhTongDiem<0){
                return 1;
            }
            else if(soSanhMaTS>0){
                return 1;
            }
            else if(soSanhMaTS<0){
                return -1;
            }
            else{
                return 0;
            }
        }
        
    }
}
