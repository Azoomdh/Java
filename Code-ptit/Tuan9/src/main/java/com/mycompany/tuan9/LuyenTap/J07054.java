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
public class J07054 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("BANGDIEM.in"));
        
        Integer n = Integer.valueOf(sc.nextLine());
        
        ArrayList<BangDiemSinhVien> listA1 = new ArrayList<>();
        for(int i=0; i<n; i++){
            BangDiemSinhVien a = readBangDiemSinhVien(sc);
            listA1.add(a);
        }
        
        Collections.sort(listA1, new BangDiemSinhVien_Comparator());
        
        // xep hang
        Double diemCu = listA1.get(0).getDiemTrungBinh();
        listA1.get(0).setThuHang(1);
        Integer hang=1;
        for(int i=1; i<listA1.size(); i++){
            BangDiemSinhVien svHienTai = listA1.get(i);
            Double diemHienTai = svHienTai.getDiemTrungBinh();
            
            if(CompareUtils.compare(diemCu, diemHienTai)==0 ){
                svHienTai.setThuHang(hang);
            }
            else{
                svHienTai.setThuHang(i+1);
                hang=i+1;
                diemCu = diemHienTai;
            }
        }
        
        // in ra
        for(BangDiemSinhVien a : listA1){
            System.out.println(a.toString());
        }
    }
    
    public static BangDiemSinhVien readBangDiemSinhVien(Scanner sc){
        return new BangDiemSinhVien(
                sc.nextLine(),
                Integer.valueOf(sc.nextLine().trim()),
                Integer.valueOf(sc.nextLine().trim()),
                Integer.valueOf(sc.nextLine().trim())
        );
    }
    
    static class BangDiemSinhVien {
        private String ma;
        private String hoTen;
        private Integer diem1;
        private Integer diem2;
        private Integer diem3;
        private Integer thuHang;
        
        private static Integer count=0;
        
        public Double getDiemTrungBinh(){
            Double diemTB= (double)(diem1*3+diem2*3+diem3*2)/(3+3+2);
            return diemTB;
        }
        
        public String getDiemTrungBinh_String(){
            return String.format("%.2f", this.getDiemTrungBinh());
        }
        
        private void initMaSv(){
            count++;
            this.ma = String.format("SV%02d", count);
        }

        public void setThuHang(Integer thuHang) {
            this.thuHang = thuHang;
        }

        public BangDiemSinhVien(String hoTen, Integer diem1, Integer diem2, Integer diem3) {
            this.initMaSv();
            this.hoTen = ChuanHoaHoTenUtil.chuanHoa(hoTen);
            this.diem1 = diem1;
            this.diem2 = diem2;
            this.diem3 = diem3;
            this.thuHang = 0;
        }

        @Override
        public String toString() {
            return this.ma + " " + this.hoTen + " " + this.getDiemTrungBinh_String() + " " + this.thuHang;
        }

        public String getMa() {
            return ma;
        }
        
        
    }
    
    static class BangDiemSinhVien_Comparator implements Comparator<BangDiemSinhVien>{

        @Override
        public int compare(BangDiemSinhVien o1, BangDiemSinhVien o2) {
            Double diemTB1 = o1.getDiemTrungBinh();
            Double diemTB2 = o2.getDiemTrungBinh();
            Integer soSanhDiemTB = CompareUtils.compare(diemTB1, diemTB2);
            
            String maSv1 = o1.getMa();
            String maSv2 = o2.getMa();
            Integer soSanhMaSv = maSv1.compareTo(maSv2);
            
            if(soSanhDiemTB>0){
                return -1;
            }
            else if(soSanhDiemTB<0){
                return 1;
            }
            else if(soSanhMaSv>0){
                return 1;
            }
            else if(soSanhMaSv<0){
                return -1;
            }
            else{
                return 0;
            }
        }
        
    }
    
    static class ChuanHoaHoTenUtil{
        public static String chuanHoa(String hoTen){
            hoTen = hoTen.trim();
            hoTen = hoTen.toLowerCase();
            
            StringTokenizer sTokener = new StringTokenizer(hoTen, " ");
            
            ArrayList<String> listA1 = new ArrayList<>();
            while(sTokener.hasMoreTokens()==true ){
                String motTu = sTokener.nextToken();
                
                motTu = motTu.trim();
                motTu = motTu.toLowerCase();
                
                if(motTu.length()== 0 ){
                    continue;
                }
                else if(motTu.length()==1 ){
                    motTu = motTu.toUpperCase();
                    listA1.add(motTu);
                }
                else{
                    motTu = motTu.substring(0, 1).toUpperCase() + motTu.substring(1, motTu.length()).toLowerCase();
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
    
    static class CompareUtils{
        public static Integer compare(Double o1, Double o2){
            Double epsilon = 0.0001;
            Double hieu = o1-o2;
            
            if(Math.abs(hieu)<epsilon){
                return 0;
            }
            else if(hieu>0){
                return 1;
            }
            else {
                return -1;
            }
        }
    }
}
