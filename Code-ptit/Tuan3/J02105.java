package Tuan3;

import java.util.ArrayList;
import java.util.Scanner;

public class J02105 {
    
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

        for(int i=0; i<a.size(); i++){
            System.out.print("List("+ (i+1) +") = " );
            for(int j=0; j<a.get(i).size(); j++){
                if(a.get(i).get(j)==1){
                    System.out.print( (j+1)+ " ");
                }
            }
            System.out.println("");
        }
    }
}
