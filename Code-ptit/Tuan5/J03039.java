package Tuan5;

import java.math.BigInteger;
import java.util.Scanner;

public class J03039 {

    private static Scanner sc = new Scanner(System.in);

    public static void xuLy() {
        BigInteger a = sc.nextBigInteger();
        BigInteger b = sc.nextBigInteger();

        BigInteger m = null;
        
        if(a.compareTo(b)>0){
            m = a.mod(b);
        }
        else{
            m = b.mod(a);
        }

        BigInteger ZERO = new BigInteger("0");
        if(m.equals(ZERO)==true){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }

    public static void main(String[] args) {
        Integer sobotest = sc.nextInt();

        while(sobotest-- >0){
            xuLy();
        }
    }
}

/*
2
18 7
3 123
*/