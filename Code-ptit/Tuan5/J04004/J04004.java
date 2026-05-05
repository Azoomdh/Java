package Tuan5.J04004;

import java.math.BigInteger;
import java.util.Scanner;

public class J04004 {

    private static Scanner sc = new Scanner(System.in);

    public static PhanSo readPhanSo(){
        BigInteger tuso = sc.nextBigInteger();
        BigInteger mauso = sc.nextBigInteger();

        return new PhanSo(tuso, mauso);
    }

    public static void main(String[] args) {
        PhanSo phanSo1 = readPhanSo();
        PhanSo phanSo2 = readPhanSo();

        PhanSo phanSoTong = phanSo1.add(phanSo2);

        System.out.println(phanSoTong.toString());
    }
}

class PhanSo {
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

    public BigInteger getTuso() {
        return tuso;
    }
    public BigInteger getMauso() {
        return mauso;
    }

    public PhanSo add(PhanSo phanSo2){
        BigInteger tusoMoi1 = this.tuso.multiply(phanSo2.mauso);
        BigInteger tusoMoi2 = this.mauso.multiply(phanSo2.tuso);

        BigInteger tusoMoi = tusoMoi1.add(tusoMoi2);

        BigInteger mausoMoi = this.mauso.multiply(phanSo2.getMauso());

        return new PhanSo(tusoMoi, mausoMoi);
    }

}
