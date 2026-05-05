/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tuan10.ThucHanh;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author azoom
 */
public class Bai7 {
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("MUAHANG.in"));
        
        Integer soSP = Integer.valueOf(sc.nextLine());
        
        TreeMap<String, SanPham> listSp = new TreeMap<>();
        
        for(int i=0; i<soSP; i++){
            SanPham t = readSanPham(sc);
            listSp.put(t.getMa(), t);
        }
        
        MuaHang.setListSanPham(listSp);
        
        Integer soMuaHang = Integer.valueOf(sc.nextLine());
        
        ArrayList<MuaHang> listMuaHang = new ArrayList<>();
        
        for(int i=0; i<soMuaHang; i++){
            MuaHang t = readMuaHang(sc);
            listMuaHang.add(t);
        }
    }

    private static SanPham readSanPham(Scanner sc) {
        return new SanPham(
                sc.nextLine(),
                sc.nextLine(),
                Integer.valueOf(sc.nextLine()),
                Integer.valueOf(sc.nextLine())
        );
    }

    private static MuaHang readMuaHang(Scanner sc) {
        return new MuaHang(
                sc.nextLine(),
                sc.nextLine(),
                sc.nextLine(),
                Integer.valueOf(sc.nextLine()),
                sc.nextLine()
        );
    }
    
    static class SanPham {
        private String ma;
        private String ten;
        private Integer gia;
        private Integer soThangBaoHanh;

        public SanPham(String ma, String ten, Integer gia, Integer soThangBaoHanh) {
            this.ma = ma;
            this.ten = ten;
            this.gia = gia;
            this.soThangBaoHanh = soThangBaoHanh;
        }

        public Integer getSoThangBaoHanh() {
            return soThangBaoHanh;
        }

        public String getMa() {
            return ma;
        }

        public String getTen() {
            return ten;
        }

        public Integer getGia() {
            return gia;
        }
        
        
    }
    
    static class MuaHang {
        private String maKH;
        private String tenKH;
        private String diaChiKH;
        private SanPham sanPham;
        private Integer soLuongMua;
        private LocalDate ngayMua;
        
        private static Integer count = 0;
        private static TreeMap<String, SanPham> listSanPham;

        public MuaHang(String tenKH, String diaChiKH, String maSP, Integer soLuongMua, String ngayMua) {
            count++;
            this.maKH = String.format("KH%02d", count);
            
            this.tenKH = tenKH;
            this.diaChiKH = diaChiKH;
            this.sanPham = listSanPham.get(maSP);
            this.soLuongMua = soLuongMua;
            this.ngayMua = LocalDate.parse(ngayMua, DateTimeFormatter.ofPattern("d/M/yyyy"));
        }
        
        public LocalDate getNgayHetHanBaoHanh(){
            return this.ngayMua.plusMonths(this.sanPham.getSoThangBaoHanh());
        }

        public static void setListSanPham(TreeMap<String, SanPham> listSanPham) {
            MuaHang.listSanPham = listSanPham;
        }
        
        public Integer getTongTien(){
            return this.soLuongMua*this.sanPham.getGia();
        }

        public SanPham getSanPham() {
            return sanPham;
        }
        
        
    }
    static class Comparator_MuaHang implements Comparator<MuaHang> {
        @Override
        public int compare(MuaHang o1, MuaHang o2) {
            LocalDate thoiGianHetBaoHanh1 = o1.getNgayHetHanBaoHanh();
            LocalDate thoiGianHetBaoHanh2 = o2.getNgayHetHanBaoHanh();
            Integer compareThoiGianHetBaoHanh = thoiGianHetBaoHanh1.compareTo(thoiGianHetBaoHanh2);
            
            String maKh1 = o1.getSanPham().getMa();
            String maKh2 = o2.getSanPham().getMa();
            Integer soSanhMaKh = maKh1.compareTo(maKh2);
            
            if(compareThoiGianHetBaoHanh!=0){
                return compareThoiGianHetBaoHanh*1;
            }
            else if(soSanhMaKh!=0){
                return soSanhMaKh*1;
            }
            else{
                return 0;
            }
        }
    }
}
