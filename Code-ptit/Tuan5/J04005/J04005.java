package Tuan5.J04005;

import java.util.Scanner;

public class J04005 {

    private static Scanner sc = new Scanner(System.in);

    public static ThiSinh readThiSinh(){
        String name = sc.nextLine();
        String ngaysinh = sc.nextLine();
        Float diem1 = Float.parseFloat(sc.nextLine());
        Float diem2 = Float.parseFloat(sc.nextLine());
        Float diem3 = Float.parseFloat(sc.nextLine());

        return new ThiSinh(name, ngaysinh, diem1, diem2, diem3);
    }

    public static void main(String[] args) {
        ThiSinh thiSinh1 = readThiSinh();

        System.out.println(thiSinh1.toString());
    }
}

class ThiSinh {
    private String name;
    private String ngaysinh;
    private Float diem1;
    private Float diem2;
    private Float diem3;
    
    public ThiSinh(String name, String ngaysinh, Float diem1, Float diem2, Float diem3) {
        this.name = name;
        this.ngaysinh = ngaysinh;
        this.diem1 = diem1;
        this.diem2 = diem2;
        this.diem3 = diem3;
    }

    @Override
    public String toString() {
        Float tongdiem = diem1+ diem2+ diem3;
        String tongdiemStr = String.format("%.1f", tongdiem);
        return this.name + " " + this.ngaysinh + " " + tongdiemStr;
    }

    
}

/*
Nguyen Hoang Ha
11/10/2001
4.5
10.0
5.5
*/