package Tuan6.J04007;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class J04007 {

    private static Scanner sc = new Scanner(System.in);

    public static NhanVien readNhanVien(){
        return new NhanVien(
            sc.nextLine(),
            sc.nextLine(),
            sc.nextLine(),
            sc.nextLine(),
            sc.nextLine(),
            sc.nextLine()
        );
    }

    public static void main(String[] args) {
        NhanVien nv1 = readNhanVien();

        System.out.println(nv1.toString());
    }
}

class NhanVien {
    private String id;
    private String hoten;
    private String gioiTinh;
    private Date ngaysinh;
    private String diachi;
    private String masothue;
    private Date ngayKyHopDong;

    private static SimpleDateFormat dateFormartter = new SimpleDateFormat("dd/mm/yyyy");

    public NhanVien() {
    }
    public NhanVien(String hoten, String gioiTinh, String ngaysinh, String diachi, String masothue, String ngayKyHopDong) {
        this.id = "00001";
        this.hoten = hoten;
        this.gioiTinh = gioiTinh;

        try {
            this.ngaysinh = NhanVien.dateFormartter.parse(ngaysinh);
        }
        catch (ParseException e) {
            this.ngaysinh = null;
            e.printStackTrace();
        }
        
        this.diachi = diachi;
        this.masothue = masothue;

        try {
            this.ngayKyHopDong = NhanVien.dateFormartter.parse(ngayKyHopDong);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getString_ngaySinh(){
        return dateFormartter.format(this.ngaysinh);
    }

    public String getString_ngayKyHopDong(){
        return dateFormartter.format(this.ngayKyHopDong);
    }

    public String toString(){
        return this.id + " " + this.hoten + " " + this.gioiTinh + " " + this.getString_ngaySinh() + " " + this.diachi + " " + this.masothue + " " + this.getString_ngayKyHopDong();
    }
    
}

/*
Nguyen Van Hoa
Nam
22/11/1982
Mo Lao-Ha Dong-Ha Noi
8333123456
31/12/2013
*/