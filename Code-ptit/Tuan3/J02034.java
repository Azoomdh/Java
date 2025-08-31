package Tuan3;

import java.util.ArrayList;
import java.util.Scanner;

public class J02034 {
    private static Scanner sc1= new Scanner(System.in);

    public static void main(String[] args) {
        Integer n = sc1.nextInt();

        ArrayList<Integer> a = new ArrayList<>();

        for(int i=0; i<201; i++){
            a.add(0);
        }

        Integer max =0;
        for(int i=0; i<n; i++){
            Integer temp1 = sc1.nextInt();
            max = Math.max(max, temp1);

            a.set(temp1, 1);
        }

        Boolean isOk = false;
        for(int i=1; i<max+1; i++){
            if(a.get(i)==0){
                System.out.println(i);
                isOk = true;
            }
            else{
                continue;
            }
        }

        if(isOk == false){
            System.out.println("Excellent!");
        }

    }
}
