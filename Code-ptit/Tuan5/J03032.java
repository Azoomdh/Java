package Tuan5;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class J03032 {

    private static Scanner sc = new Scanner(System.in);
    
    public static void xuLy(){
        String s = sc.nextLine();
        
        ArrayList<String> dsT = new ArrayList<>();

        StringTokenizer stk1 = new StringTokenizer(s);
        while(stk1.hasMoreTokens()==true){
            dsT.add(stk1.nextToken());
        }

        for(int i=0; i<dsT.size(); i++){
            String tempStr1 = new StringBuilder(dsT.get(i)).reverse().toString();
            dsT.set(i, tempStr1);
        }

        for(int i=0; i<dsT.size(); i++){
            System.out.print(dsT.get(i)+ " ");
        }
        System.out.println("");
    }
    
    public static void main(String[] args) {
        Integer sobotest = Integer.parseInt(sc.nextLine());
        
        while(sobotest-- >0){
            xuLy();
        }
    }
}

/*
2
ABC DEF
123 456
*/
