package Tuan3;

import java.util.ArrayList;
import java.util.Scanner;

public class J02106 {
    
    private static Scanner sc= new Scanner(System.in);

    public static void main(String[] args) {
        Integer n = sc.nextInt();

        Integer soHangOk =0;

        for(int i=0; i<n; i++){
            Integer temp1 = sc.nextInt();
            Integer temp2 = sc.nextInt();
            Integer temp3 = sc.nextInt();

            if( (temp1+temp2+temp3) >=2 ){
                soHangOk++;
            }
        }
        System.out.println(soHangOk);
    }
}
