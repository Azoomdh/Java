/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thuchanh.BaiTapNhom;

/**
 *
 * @author azoom
 */
public class BaiTapNhom {
    private Integer mabaitap;
    private String tenbaitap;
    private Integer kieubaitap;
    private Integer tongthoigian;

    public BaiTapNhom(Integer mabaitap, String tenbaitap, Integer kieubaitap, Integer tongthoigian) {
        this.mabaitap = mabaitap;
        this.tenbaitap = tenbaitap;
        this.kieubaitap = kieubaitap;
        this.tongthoigian = tongthoigian;
    }
    
    public static class ListTenThuocTinh {
        public static final String mabaitap = "mabaitap";
        public static final String tenbaitap = "tenbaitap";
        public static final String kieubaitap = "kieubaitap";
        public static final String tongthoigian = "tongthoigian";
    }

    public Integer getMabaitap() {
        return mabaitap;
    }

    public String getTenbaitap() {
        return tenbaitap;
    }

    public Integer getKieubaitap() {
        return kieubaitap;
    }

    public Integer getTongthoigian() {
        return tongthoigian;
    }

    public void setMabaitap(Integer mabaitap) {
        this.mabaitap = mabaitap;
    }
    
    
    
}
