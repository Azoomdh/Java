package Tuan6;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

// 200 chữ số nên phải dùng big integer như trong đáp án

public class J07003 {

    public static void transform(String s){
        if(s.length()==1){
            System.out.println(s);
            return;
        }
        while(s.length()>1){
            Integer n = s.length();
            Integer n_chia_2 = (int) n/2;

            BigInteger a = new BigInteger(s.substring(0, n_chia_2));
            BigInteger b = new BigInteger(s.substring(n_chia_2, n));

            s = a.add(b).toString();
            System.out.println(s);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));
        String s = sc.nextLine();
        transform(s);
    }
}
