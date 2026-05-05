package Tuan6.J04006;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class J04006 {
    
    private static Scanner sc = new Scanner(System.in);

    public static SinhVien readObject(){
        return new SinhVien(
            sc.nextLine(),
            sc.nextLine(),
            sc.nextLine(),
            sc.nextFloat()
        );
    }

    public static void main(String[] args) {
        SinhVien sv1 = readObject();

        System.out.println(sv1.toString());
    }
}

class SinhVien {
    private String masv;
    private String hoten;
    private String lop;
    private Date ngaysinh;
    private Float gpa;
    private static SimpleDateFormat dateFormatter= new SimpleDateFormat("dd/mm/yyyy");

    public SinhVien() {
    }

    public SinhVien(String hoten, String lop, String ngaysinh, Float gpa) {
        this.masv = "B20DCCN001";
        this.hoten = hoten;
        this.lop = lop;
        
        try {
            this.ngaysinh = dateFormatter.parse(ngaysinh);
        }
        catch (ParseException e) {
            this.ngaysinh = null;
            e.printStackTrace();
        }

        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %.2f", this.masv, this.hoten, this.lop, dateFormatter.format(this.ngaysinh), this.gpa );
    }

    
}

/*
Nguyen Hoa Binh
D20CQCN04-B
2/2/2002
2
*/