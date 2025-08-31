package Tuan3;

import java.util.ArrayList;
import java.util.Scanner;

public class J02104 {
    
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Integer n = sc.nextInt();

        ArrayList< ArrayList<Integer> > a= new ArrayList<>();

        for(int i=0; i<n; i++){
            ArrayList<Integer> motHang = new ArrayList<>();

            for(int j=0; j<n; j++){
                Integer temp1 = sc.nextInt();
                motHang.add(temp1);
            }
            a.add(motHang);
        }

        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(a.get(i).get(j)== 1){
                    System.out.println( "("+ (i+1) + ","+ (j+1)+ ")" );
                }
            }
        }
    }
}
