/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tuan10.ThucHanh;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 *
 * @author azoom
 */
public class Bai2 {
    
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        String string_nm = sc.nextLine();
        
        StringTokenizer stringTokenizer = new StringTokenizer(string_nm, " ");
        
        Integer n = Integer.valueOf(stringTokenizer.nextToken());
        Integer m = Integer.valueOf(stringTokenizer.nextToken());
        
        Phim.InitTreeMapMaTheLoai(n, sc);
        Phim.InitTreeMapMaPhim1(m);
        
        ArrayList<Phim> listA1 = new ArrayList<>();
        for(int i=0; i<m; i++){
            listA1.add(readPhim(sc));
        }
        
        Collections.sort(listA1, new Comparator_Phim());
        
        for(Phim a : listA1){
            System.out.println(a.toString());
        }
    }

    private static Phim readPhim(Scanner sc) {
        return new Phim(
                sc.nextLine(),
                sc.nextLine(),
                sc.nextLine(),
                Integer.valueOf(sc.nextLine())
        );
    }
    
    static class Phim {
        private String maTheLoai;
        private LocalDate ngayKhoiChieu;
        private String maPhim1;
        private Integer soTap;

        private static TreeMap<String, String> treeMapMaPhim = new TreeMap<>();
        private static TreeMap<String, String> treeMapMaTheLoai = new TreeMap<>();
        
        private static void InitTreeMapMaPhim1(Integer m){
            for(int i=1; i<=m; i++){
                String maPhim1 = String.format("Phim so %d", i);
                String maPhim2 = String.format("P%03d", i);
                treeMapMaPhim.put(maPhim1, maPhim2);
            }
        }
        
        private static void InitTreeMapMaTheLoai(Integer n, Scanner sc){
            for(int i=1; i<=n; i++){
                String maTheLoai = String.format("TL%03d", i);
                String tenTheLoai = sc.nextLine();
                treeMapMaTheLoai.put(maTheLoai, tenTheLoai);
            }
        }

        public Phim(String maTheLoai, String ngayKhoiChieu, String maPhim1, Integer soTap) {
            this.maTheLoai = maTheLoai;
            this.ngayKhoiChieu = LocalDate.parse(ngayKhoiChieu, DateTimeFormatter.ofPattern("d/M/yyyy"));
            this.maPhim1 = maPhim1;
            this.soTap = soTap;
        }
        
        public String getTenTheLoai(){
            return treeMapMaTheLoai.get(this.maTheLoai);
        }
        
        public String getMaPhim2(){
            return treeMapMaPhim.get(this.maPhim1);
        }
        
        public String getNgayKhoiChieu_Str(){
            return this.ngayKhoiChieu.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }

        public LocalDate getNgayKhoiChieu() {
            return ngayKhoiChieu;
        }

        public Integer getSoTap() {
            return soTap;
        }

        
        
        @Override
        public String toString() {
            return this.getMaPhim2() + " " + this.getTenTheLoai() + " " + this.getNgayKhoiChieu_Str() + " " + this.maPhim1 + " " + this.soTap;
        }
        
    }
    
    static class Comparator_Phim implements Comparator<Phim> {

        @Override
        public int compare(Phim o1, Phim o2) {
            LocalDate ngayKhoiChieu1 = o1.getNgayKhoiChieu();
            LocalDate ngayKhoiChieu2 = o2.getNgayKhoiChieu();
            Integer compareNgayKhoiChieu = ngayKhoiChieu1.compareTo(ngayKhoiChieu2);
            
            String tenPhim1 = o1.getMaPhim2();
            String tenPhim2 = o2.getMaPhim2();
            Integer compareTenPhim = tenPhim1.compareTo(tenPhim2);
            
            Integer soTapPhim1 = o1.getSoTap();
            Integer soTapPhim2 = o2.getSoTap();
            Integer compareSoTapPhim = soTapPhim1.compareTo(soTapPhim2);
            
            if(compareNgayKhoiChieu>0){
                return 1;
            }
            else if(compareNgayKhoiChieu<0){
                return -1;
            }
            else if(compareTenPhim>0){
                return 1;
            }
            else if(compareTenPhim<0){
                return -1;
            }
            else if(compareSoTapPhim>0){
                return -1;
            }
            else if(compareSoTapPhim<0){
                return 1;
            }
            else{
                return 0;
            }
        }
        
    }

    
}
/*
2 3
Hai huoc
Tinh cam
TL001
25/11/2021
Phim so 1
10
TL001
04/12/2021
Phim so 2
15
TL002
25/11/2021
Phim so 3
5
*/