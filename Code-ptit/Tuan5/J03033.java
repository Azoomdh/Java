package Tuan5;

import java.math.BigInteger;
import java.util.Scanner;

public class J03033 {

    private static Scanner sc = new Scanner(System.in);

    public static void xuLy() {
        BigInteger a = sc.nextBigInteger();
        BigInteger b = sc.nextBigInteger();

        BigInteger ucln = a.gcd(b);
        BigInteger bcnn = (a.divide(ucln) ).multiply(b);

        System.out.println(bcnn);
    }

    public static void main(String[] args) {
        Integer sobotest = Integer.parseInt(sc.nextLine());

        while(sobotest-- >0){
            xuLy();
        }
    }
}

/*
3
12
100
1212
8888
121212121212121212
45678978
*/
