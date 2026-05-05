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
public class J07056 {
    
    private static KhachHang readKhachHang(Scanner sc) {
        String hoten = sc.nextLine();
        Scanner scTemp = new Scanner(sc.nextLine());
        
        return new KhachHang(
                hoten,
                scTemp.next(),
                scTemp.nextInt(),
                scTemp.nextInt()
        );
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("KHACHHANG.in"));
        
        Integer n = Integer.valueOf(sc.nextLine().trim());
        
        ArrayList<KhachHang> listA1 = new ArrayList<>();
        for(int i=0; i<n; i++){
            listA1.add(readKhachHang(sc));
        }
        
        Collections.sort(listA1, new KhachHang_Comparator());
        
        for(KhachHang a : listA1){
            System.out.println(a.toString());
        }
    }


    
    static class Util_HoTen {
        public static String chuanHoaHoTen(String hoten){
            hoten = hoten.trim();
            hoten = hoten.toLowerCase();
            
            StringTokenizer sTokener = new StringTokenizer(hoten, " ");
            
            ArrayList<String> listA1 = new ArrayList<>();
            while(sTokener.hasMoreTokens()==true ){
                String motTu = sTokener.nextToken();
                
                motTu = motTu.trim();
                motTu = motTu.toLowerCase();
                
                motTu = motTu.substring(0, 1).toUpperCase() + motTu.substring(1, motTu.length());
                
                listA1.add(motTu);
            }
            
            String hotenDaChuanHoa = "";
            for(String a : listA1){
                hotenDaChuanHoa = hotenDaChuanHoa + a + " ";
            }
            
            hotenDaChuanHoa = hotenDaChuanHoa.trim();
            
            return hotenDaChuanHoa;
        }
    }
    
    static class KhachHang{
        private String maKH;
        private String hoTen;
        private String dinhMuc;
        private Integer soDau;
        private Integer soCuoi;
        
        private static Integer count = 0;

        public KhachHang(String hoTen, String dinhMuc, Integer soDau, Integer soCuoi) {
            this.initMaKH();
            this.hoTen = Util_HoTen.chuanHoaHoTen(hoTen);
            this.dinhMuc = dinhMuc;
            this.soDau = soDau;
            this.soCuoi = soCuoi;
        }
        
        private void initMaKH(){
            count++;
            this.maKH = String.format("KH%02d", count);
        }
        
        public Integer getSoDien(){
            return this.soCuoi-this.soDau;
        }
        
        public Integer getSoDienDinhMuc(){
            String soDienDinhMuc = this.dinhMuc;
            
            if(soDienDinhMuc.equals("A")==true ){
                return 100;
            }
            else if(soDienDinhMuc.equals("B")==true ){
                return 500;
            }
            else if(soDienDinhMuc.equals("C")==true ){
                return 200;
            }
            else{
                return null;
            }
        }
        
        public Integer getTienTrongDinhMuc(){
            Integer soDien = this.getSoDien();
            Integer soDienDinhMuc = this.getSoDienDinhMuc();
            
            if(soDien<=soDienDinhMuc){
                return soDien*450;
            }
            else{
                return soDienDinhMuc*450;
            }
        }
        
        public Integer getTienVuotDinhMuc(){
            Integer soDien = this.getSoDien();
            Integer soDienDinhMuc = this.getSoDienDinhMuc();
            
            if(soDien>soDienDinhMuc){
                return (soDien-soDienDinhMuc)*1000;
            }
            else{
                return 0;
            }
        }
        
        public Integer getTienVat(){
            return this.getTienVuotDinhMuc()/20;
        }
        
        public Integer getTienPhaiNop(){
            return this.getTienTrongDinhMuc() + this.getTienVuotDinhMuc() + this.getTienVat();
        }

        @Override
        public String toString() {
            return this.maKH + " " + this.hoTen + " " + this.getTienTrongDinhMuc() + " " + this.getTienVuotDinhMuc() + " " + this.getTienVat() + " " + this.getTienPhaiNop();
        }
        
        
    }
    
    static class KhachHang_Comparator implements Comparator<KhachHang>{

        @Override
        public int compare(KhachHang o1, KhachHang o2) {
            Integer tienPhaiNop1 = o1.getTienPhaiNop();
            Integer tienPhaiNop2 = o2.getTienPhaiNop();
            Integer soSanhTienPhaiNop = tienPhaiNop1.compareTo(tienPhaiNop2);
            
            if(soSanhTienPhaiNop>0){
                return -1;
            }
            else if(soSanhTienPhaiNop<0){
                return 1;
            }
            else{
                return 0;
            }
        }
        
    }
}
