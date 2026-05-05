/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baitap1.Db;

/**
 *
 * @author azoom
 */
public class SinhVien {
    private String masv;
    private String hoten;
    private String tenlop;
    private Double gpa;
    
    static class ListTenThuocTinh {
        public static final String masv = "masv";
        public static final String hoten = "hoten";
        public static final String tenlop = "tenlop";
        public static final String gpa = "gpa";
    }

    public SinhVien() {
    }

    public SinhVien(String masv, String hoten, String tenlop, Double gpa) {
        this.masv = masv;
        this.hoten = hoten;
        this.tenlop = tenlop;
        this.gpa = gpa;
    }

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getTenlop() {
        return tenlop;
    }

    public void setTenlop(String tenlop) {
        this.tenlop = tenlop;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }
    
    
}
