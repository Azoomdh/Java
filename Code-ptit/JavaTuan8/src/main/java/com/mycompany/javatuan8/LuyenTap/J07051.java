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
import java.util.StringTokenizer;

/**
 *
 * @author azoom
 */
public class J07051 {

    private static KhachHang readKhachHang(Scanner sc) {
        return new KhachHang(
                sc.nextLine().trim(),
                Integer.valueOf(sc.nextLine().trim()),
                sc.nextLine().trim(),
                sc.nextLine().trim(),
                Integer.valueOf(sc.nextLine().trim())
        );
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("KHACHHANG.in"));
        
        Integer n = Integer.valueOf(sc.nextLine());
        
        ArrayList<KhachHang> list1 = new ArrayList<>();
        for(int i=0; i<n; i++){
            list1.add(readKhachHang(sc));
        }
        
        Collections.sort(list1, new KhachHangComparator());
        
        for(KhachHang t : list1){
            System.out.println(t.toString());
        }
    }


    
    static class KhachHang{
        private String ma;
        
        private String ten;
        private Integer soPhong;
        private LocalDate ngayNhanPhong;
        private LocalDate ngayTraPhong;
        private Integer tienDichVuPhatSinh;

        private static Integer count=0;
        private DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("d/M/yyyy");
        private DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        public KhachHang(String ten, Integer soPhong, String ngayNhanPhong, String ngayTraPhong, Integer tienDichVuPhatSinh) {
            count++;
            this.ma = String.format("KH%02d", count);
            this.ten = xuLyHoTen(ten);
            this.soPhong = soPhong;
            this.ngayNhanPhong = LocalDate.parse(ngayNhanPhong, dateTimeFormatter1);
            this.ngayTraPhong = LocalDate.parse(ngayTraPhong, dateTimeFormatter1);
            this.tienDichVuPhatSinh = tienDichVuPhatSinh;
            
        }
        
        private String xuLyHoTen(String ten) {
            ten = ten.trim();
            
            StringTokenizer sTokener = new StringTokenizer(ten, " ");
            StringBuilder tenDaChuanHoa = new StringBuilder();
            
            while(sTokener.hasMoreTokens()==true ){
                String s = sTokener.nextToken();
                
                s = s.toLowerCase();
                
                s = s.substring(0, 1).toUpperCase() + s.substring(1, s.length()).toLowerCase();
                
                tenDaChuanHoa.append(s);
                tenDaChuanHoa.append(" ");
            }
            
            return tenDaChuanHoa.toString().trim();
        }
        
        public Integer getGiaThueTheoTang(){
            switch (this.getSoTang()) {
                case 1:
                    return 25;
                case 2:
                    return 34;
                case 3:
                    return 50;
                case 4:
                    return 80;
                default:
                    return 0;
            }
        }

        public Long getSoNgayO() {
            return ChronoUnit.DAYS.between(this.ngayNhanPhong, this.ngayTraPhong)+1;
        }

        public Integer getSoTang() {
            return Integer.valueOf( this.soPhong.toString().substring(0, 1));
        }

        public Long getThanhTien() {
            return this.getSoNgayO()*this.getGiaThueTheoTang() + this.tienDichVuPhatSinh;
        }
        
        @Override
        public String toString() {
            return this.ma + " " + this.ten + " " + this.soPhong + " " + this.getSoNgayO() + " " + this.getThanhTien();
        }


        
    }
    
    static class KhachHangComparator implements Comparator<KhachHang> {

        @Override
        public int compare(KhachHang o1, KhachHang o2) {
            Long thanhTien1 = o1.getThanhTien();
            Long thanhTien2 = o2.getThanhTien();
            Integer soSanhThanhTien = thanhTien1.compareTo(thanhTien2);
            
            if(soSanhThanhTien>0){
                return -1;
            }
            else if(soSanhThanhTien<0){
                return 1;
            }
            else{
                return 0;
            }
        }
        
    }
}
