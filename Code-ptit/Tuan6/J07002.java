package Tuan6;

import java.util.Scanner;
import java.io.*;

public class J07002 {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc2 = new Scanner(new File("DATA.in"));

        Long sum =0L;
        while(sc2.hasNext()==true){
            String s = sc2.next();

            try {
                int x = Integer.parseInt(s);
                sum = sum + x;
            }
            catch (NumberFormatException e) {
                // e.printStackTrace();
            }
        }

        System.out.println(sum);
    }
}
