package Tuan6.J04015;

import java.util.Scanner;

public class J04015 {

    private static Scanner sc = new Scanner(System.in);

    public static GiaoVien readGiaoVien(){
        return new GiaoVien(
            sc.nextLine(),
            sc.nextLine(),
            sc.nextLong()
        );
    }

    public static void main(String[] args) {
        GiaoVien gv1 = readGiaoVien();

        System.out.println(gv1.toString());
    }
}

class GiaoVien{
    private String maNgach;
    private String ten;
    private Long luongCoBan;
    public GiaoVien() {
    }
    public GiaoVien(String maNgach, String ten, Long luongCoBan) {
        this.maNgach = maNgach;
        this.ten = ten;
        this.luongCoBan = luongCoBan;
    }

    public String getChucVu(){
        String s = maNgach.substring(0, 2);
        if(s.equals("HT")==true ){
            return "HT";
        }
        else if(s.equals("HP")==true ){
            return "HP";
        }
        else if(s.equals("GV")==true ){
            return "GV";
        }
        return null;
    }
    public Long getPhuCap(){
        String chucVu = this.getChucVu();

        if(chucVu.equals("HT")==true ){
            return 2_000_000L;
        }
        else if(chucVu.equals("HP")==true ){
            return 900_000L;
        }
        else if(chucVu.equals("GV")==true ){
            return 500_000L;
        }

        return null;
    }

    public Long getHeSo(){
        String s = this.maNgach.substring(2, 4);
        Long heSo = Long.valueOf(s);
        return heSo;
    }

    public Long getLuong(){
        return this.luongCoBan*this.getHeSo();
    }

    public Long getThuNhap(){
        return  this.getLuong()+ this.getPhuCap();
    }

    @Override
    public String toString() {
        return this.maNgach + " " + this.ten + " " +  this.getHeSo() + " " + this.getPhuCap() + " " + this.getThuNhap();
    }    
}

/*
HP04
Tran Quoc Huy
1578000
*/