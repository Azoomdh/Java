package Tuan5;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class J03040 {

    private static Scanner sc = new Scanner(System.in);

    public static String tachString(String s){
        StringTokenizer strTokenizer1 = new StringTokenizer(s, "-.");

        ArrayList<String> dsT= new ArrayList<>();
        while(strTokenizer1.hasMoreTokens()== true){
            dsT.add(strTokenizer1.nextToken().toString());
        }

        // System.out.println(dsT);

        String s2 = dsT.get(1)+dsT.get(2);

        return s2;
    }

    public static Boolean isOK1(String s) {
        for(int i=0; i<s.length()-1; i++){
            Character char1 = s.charAt(i);
            Character char2 = s.charAt(i+1);
            if(char1.compareTo(char2) <0 ){
                // doesnt do
            }
            else{
                return false;
            }
        }
        return true;
    }

    public static Boolean isOK2(String s) {
        for(int i=0; i<s.length()-1; i++){
            Character char1 = s.charAt(i);
            Character char2 = s.charAt(i+1);
            if(char1.equals(char2)==true ){
                // doesnt do
            }
            else{
                return false;
            }
        }
        return true;
    }

    public static Boolean isOK3(String s) {
        // ...
        // String s2 = "12345";
        // System.out.println(s2.substring(0, 5));
        String subStr1 = s.substring(0, 3);
        String subStr2 = s.substring(3, 5);
        
        if(isOK2(subStr1)==true && isOK2(subStr2)==true ) {
            return true;
        }

        return false;
    }

    public static Boolean isOK4(String s) {
        // ...
        for(int i=0; i<s.length(); i++){
            Character char1 = s.charAt(i);
            if(char1.equals('6')==true || char1.equals('8')==true ) {
                // doesnt do
            }
            else {
                return false;
            }
        }
        return true;
    }

    public static void xuLy() {
        String s = tachString(sc.nextLine());

        if(isOK1(s)==true || isOK2(s)==true || isOK3(s)==true || isOK4(s)==true ){
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args) {

        Integer sobotest = Integer.parseInt(sc.nextLine());

        while(sobotest-- >0){
            xuLy();
        }
    }
}

/* 
# dấu "–" của đề bài code ptit (dùng cái này bị lỗi IR)
# dấu "-" của đáp án code ptit (dùng cái này AC)
# 2 dấu gạch trên khác nhau
*/

/*
7
29T1-123.45
29T1-555.55
29T1-222.33
29T1-686.88
29T1-123.33
29T1-555.54
29T1-606.88
*/