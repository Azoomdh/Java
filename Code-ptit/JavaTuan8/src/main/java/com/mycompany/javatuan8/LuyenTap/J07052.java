/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javatuan8.LuyenTap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author azoom
 */
public class J07052 {
    
    private static ThiSinh readThiSinh(Scanner sc) {
        return new ThiSinh(
                sc.nextLine().trim(),
                sc.nextLine().trim(),
                Double.valueOf(sc.nextLine().trim()),
                Double.valueOf(sc.nextLine().trim()),
                Double.valueOf(sc.nextLine().trim())
        );
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("THISINH.in"));
        
        Integer n = Integer.valueOf(sc.nextLine().trim());
        
        ArrayList<ThiSinh> listThiSinhA = new ArrayList<>();
        for(int i=0; i<n; i++){
            listThiSinhA.add(readThiSinh(sc));
        }
        
        Integer chiTieu = Integer.valueOf(sc.nextLine().trim());
        
        Collections.sort(listThiSinhA, new ThiSinhComparator());
        
//        Integer dem=0;
//        Double diemChuan = listThiSinhA.get(0).getTongDiem();
//        for(ThiSinh t : listThiSinhA){
//            dem++;
//            
//            Double diemChuanT = t.getTongDiem();
//            
//            if(dem>=chiTieu && diemChuanT.equals(diemChuan)==false ){
//                break;
//            }
//            
//            diemChuan = diemChuanT;
//        }

        Double diemChuan = listThiSinhA.get(chiTieu-1).getTongDiem();
        
        System.out.println(diemChuan);
        
        for(ThiSinh t : listThiSinhA){
            if(t.getTongDiem()>=diemChuan){
                System.out.println(t.toString() + " " + "TRUNG TUYEN");
            }
            else {
                System.out.println(t.toString() + " " + "TRUOT");
            }
        }
    }


    
    static class ThiSinh {
        private String ma;
        private String hoten;
        private Double diemToan;
        private Double diemLy;
        private Double diemHoa;

        public ThiSinh(String ma, String hoten, Double diemToan, Double diemLy, Double diemHoa) {
            this.ma = ma;
            this.hoten = xuLyHoTen(hoten);
            this.diemToan = diemToan;
            this.diemLy = diemLy;
            this.diemHoa = diemHoa;
        }

        public String getMa() {
            return ma;
        }
        
        public String getKhuVuc(){
            return this.ma.substring(0, 3);
        }
        
        public Double getDiemUuTien(){
            String khuVuc = this.getKhuVuc();
            switch (khuVuc) {
                case "KV1":
                    return 0.5;
                case "KV2":
                    return 1.0;
                case "KV3":
                    return 2.5;
                default:
                    return 0.0;
            }
        }
        
        public Double getTongDiem(){
            return this.diemToan*2 + this.diemLy + this.diemHoa + this.getDiemUuTien();
        }

        @Override
        public String toString() {
            return this.ma + " " + this.hoten + " " + this.loaiBoSoZero(this.getDiemUuTien()) + " " + this.loaiBoSoZero(this.getTongDiem());
        }

        
        private String xuLyHoTen(String hoten2) {
            hoten2 = hoten2.trim();
            hoten2 = hoten2.toLowerCase();
            
            StringTokenizer sTokener = new StringTokenizer(hoten2, " ");
            StringBuilder hoTenDaChuanHoa = new StringBuilder();
            
            while(sTokener.hasMoreTokens()==true ){
                String s = sTokener.nextToken();
                s = s.trim();
                
                s = s.substring(0, 1).toUpperCase() + s.substring(1, s.length()).toLowerCase();
                
                hoTenDaChuanHoa.append(s);
                hoTenDaChuanHoa.append(" ");
            }
            
            return hoTenDaChuanHoa.toString().trim();
        }
        
        public String loaiBoSoZero(Double n){
            return new DecimalFormat("#.#").format(n);
        }
        
    }
    
    static class ThiSinhComparator implements Comparator<ThiSinh> {

        @Override
        public int compare(ThiSinh o1, ThiSinh o2) {
            Double diemChuan1 = o1.getTongDiem();
            Double diemChuan2 = o2.getTongDiem();
            Integer soSanhDiemChuan = diemChuan1.compareTo(diemChuan2);
            
            String ma1 = o1.getMa();
            String ma2 = o2.getMa();
            Integer soSanhMa = ma1.compareTo(ma2);
            
            if(soSanhDiemChuan>0){
                return -1;
            }
            else if(soSanhDiemChuan<0){
                return 1;
            }
            else if(soSanhMa>0){
                return 1;
            }
            else if(soSanhMa<0){
                return -1;
            }
            else{
                return 0;
            }
        }
        
    }
}
