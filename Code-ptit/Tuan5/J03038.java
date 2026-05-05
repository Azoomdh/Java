package Tuan5;

import java.util.ArrayList;
import java.util.Scanner;

public class J03038 {

    private static Scanner sc= new Scanner(System.in);

    public static void main(String[] args) {
        String s = sc.next();

        ArrayList<Integer> a = new ArrayList<>();
        for(int i=0; i<26; i++){
            a.add(0);
        }

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            int vitri = (int)(c-'a');
            a.set(vitri, (a.get(vitri)+1) );
        }

        Integer sum = 0;
        for(int i=0; i<26; i++){
            if(a.get(i)!=0){
                sum++;
            }
        }
        System.out.println(sum);
    }
}

/*
banana
*/