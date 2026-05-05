package Tuan5;

import java.math.BigInteger;
import java.util.Scanner;

public class J04003 {

    private static Scanner sc = new Scanner(System.in);

    public static PhanSo readPhanSo(){
        BigInteger tuso = sc.nextBigInteger();
        BigInteger mauso = sc.nextBigInteger();

        return new PhanSo(tuso, mauso);
    }

    public static void main(String[] args) {
        PhanSo phanSo1 = readPhanSo();

        System.out.println(phanSo1.toString());
    }
}

class PhanSo{
    private BigInteger tuso;
    private BigInteger mauso;
    public PhanSo(BigInteger tuso, BigInteger mauso) {
        BigInteger ucln = tuso.gcd(mauso);

        this.tuso = tuso.divide(ucln);
        this.mauso = mauso.divide(ucln);
    }
    @Override
    public String toString() {
        return this.tuso + "/" + this.mauso;
    }

    
}