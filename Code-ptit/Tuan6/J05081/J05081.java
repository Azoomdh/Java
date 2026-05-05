package Tuan6.J05081;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class J05081 {
    private static Scanner sc = new Scanner(System.in);

    public static MatHang readMatHang(){
        return new MatHang(
            sc.nextLine(),
            sc.nextLine(),
            Integer.valueOf(sc.nextLine()),
            Integer.valueOf(sc.nextLine())
        );
    }
    public static void main(String[] args) {
        Integer sobotest = Integer.valueOf(sc.nextLine()) ;
        
        List<MatHang> dsT = new ArrayList<>();
        for(int i=0; i<sobotest; i++){
            MatHang t = readMatHang();
            dsT.add(t);
        }

        Collections.sort(dsT, new MatHangComparator());

        for(MatHang t : dsT){
            System.out.println(t.toString());
        }
    }
}

class MatHang {
    private static Integer counter=0;

    private Integer id;
    private String ten;
    private String donvi;
    private Integer giaMua;
    private Integer giaBan;

    public MatHang() {
    }
    public MatHang(String ten, String donvi, Integer giaMua, Integer giaBan) {
        counter++;
        this.id = counter;
        this.ten = ten;
        this.donvi = donvi;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
    }

    public Integer getId() {
        return id;
    }
    public String getTen() {
        return ten;
    }
    public String getDonvi() {
        return donvi;
    }
    public Integer getGiaMua() {
        return giaMua;
    }
    public Integer getGiaBan() {
        return giaBan;
    }

    public Integer getLoiNhuan(){
        return (this.giaBan-this.giaMua);
    }

    public String getIdString(){
        return "MH" + String.format("%03d", this.id);
    }

    public String toString(){
        return this.getIdString() + " " + this.ten + " " + this.donvi + " " + this.giaMua + " " + this.giaBan + " " + this.getLoiNhuan();
    }
    
}

// tăng dần = lớn dương, bé âm
// giảm dần = lớn âm, bé dương

class MatHangComparator implements Comparator<MatHang> {

    @Override
    public int compare(MatHang o1, MatHang o2) {
        // lợi nhuận giảm dần = lớn âm - bé dương
        if(o1.getLoiNhuan() > o2.getLoiNhuan()){
            return -1;
        }
        else if(o1.getLoiNhuan() < o2.getLoiNhuan()){
            return 1;
        }
        // id tăng dần = lớn dương- bé âm
        else if (o1.getId() > o2.getId()){
            return 1;
        }
        else if(o1.getId() < o2.getId()){
            return -1;
        }
        else {
            return 0;
        }
    }
    
}

/*
2
Ao phong tre em
Cai
25000
41000
Ao khoac nam
Cai
240000
515000
*/