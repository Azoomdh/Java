package Tuan1;

import java.util.Scanner;

public class J01009 {
    public static Scanner sc1 = new Scanner(System.in);

    public static void main(String[] args) {
        Long n = sc1.nextLong();

        Long s =n;

        for(Long i=n-1;i>=1L; i--){
            s= s*i+i;
        }
        System.out.println(s);
    }
}
