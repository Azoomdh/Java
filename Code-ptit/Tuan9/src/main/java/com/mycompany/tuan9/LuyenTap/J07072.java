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
public class J07072 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("DANHSACH.in"));
        
        ArrayList<TenDayDu> listA1 = new ArrayList<>();
        while(sc.hasNextLine()==true ){
            TenDayDu aTemp = new TenDayDu(sc.nextLine().trim());
            listA1.add(aTemp);
        }
        
        Collections.sort(listA1, new Comparator_TenDayDu());
        
        for(TenDayDu a : listA1){
            System.out.println(a.toString());
        }
    }

    static class ChuanHoaHoTen{
        public static String chuanHoaHoTen(String hoTen){
            hoTen = hoTen.trim();
            hoTen = hoTen.toLowerCase();
            
            StringTokenizer sTokenizer = new StringTokenizer(hoTen, " ");
            
            String hoTenDaChuanHoa = "";
            while(sTokenizer.hasMoreTokens()==true ){
                String motTu = sTokenizer.nextToken();
                
                motTu = motTu.trim();
                motTu = motTu.toLowerCase();
                motTu = motTu.substring(0, 1).toUpperCase() + motTu.substring(1, motTu.length()).toLowerCase();
                
                hoTenDaChuanHoa = hoTenDaChuanHoa + motTu + " ";
            }
            
            hoTenDaChuanHoa = hoTenDaChuanHoa.trim();
            
            return hoTenDaChuanHoa;
        }
    }
    
    static class TenDayDu{
        private String ho;
        private String tenDem;
        private String ten;

        public TenDayDu(String tenDayDu) {
            this.ho = "";
            this.tenDem = "";
            this.ten = "";
            
            tenDayDu = ChuanHoaHoTen.chuanHoaHoTen(tenDayDu);
            
            StringTokenizer sTokenizer = new StringTokenizer(tenDayDu, " ");
            
            ArrayList<String> listA1 = new ArrayList<>();
            while(sTokenizer.hasMoreTokens()==true ){
                listA1.add(sTokenizer.nextToken());
            }
            
            this.ho = listA1.get(0);
            
            for(int i=1; i<=listA1.size()-2; i++){
                this.tenDem = this.tenDem + listA1.get(i) + " ";
            }
            this.tenDem = this.tenDem.trim();
            
            this.ten = listA1.get(listA1.size()-1);
        }

        @Override
        public String toString() {
            return this.ho + " " + this.tenDem + " " + this.ten;
        }

        public String getHo() {
            return ho;
        }

        public String getTenDem() {
            return tenDem;
        }

        public String getTen() {
            return ten;
        }
        
        
    }
    
    static class Comparator_TenDayDu implements Comparator<TenDayDu> {

        @Override
        public int compare(TenDayDu o1, TenDayDu o2) {
            String ho1 = o1.getHo();
            String ho2 = o2.getHo();
            Integer soSanhHo = ho1.compareTo(ho2);
            
            String tenDem1 = o1.getTenDem();
            String tenDem2 = o2.getTenDem();
            Integer soSanhTenDem = tenDem1.compareTo(tenDem2);
            
            String ten1 = o1.getTen();
            String ten2 = o2.getTen();
            Integer soSanhTen = ten1.compareTo(ten2);
            
            if(soSanhTen>0){
                return 1;
            }
            else if(soSanhTen<0){
                return -1;
            }
            else if(soSanhHo>0){
                return 1;
            }
            else if(soSanhHo<0){
                return -1;
            }
            else if(soSanhTenDem>0){
                return 1;
            }
            else if(soSanhTenDem<0){
                return -1;
            }
            else{
                return 0;
            }
        }
        
    }
}
