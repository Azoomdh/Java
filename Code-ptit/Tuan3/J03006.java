package Tuan3;

import java.util.Scanner;

public class J03006 {
    
    private static Scanner sc = new Scanner(System.in);

    public static Boolean checkOk1(String s){
        for(int i=0; i<=(s.length()-1)/2 ; i++){
            Character char1 = s.charAt(i);
            Character char2 = s.charAt(s.length()-1-i);
            if(char1!=char2){
                return false;
            }
        }
        return true;
    }

    public static Boolean checkOk2(String s){
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)!='0' && s.charAt(i)!='2' && s.charAt(i)!='4' && s.charAt(i)!='6' && s.charAt(i)!='8' ){
                return false;
            }
        }
        return true;
    }

    public static void xuLy(){
        String s = sc.next();
        if(checkOk1(s)== true && checkOk2(s)==true ){
            System.out.println("YES");
            return;
        }
        else {
            System.out.println("NO");
            return;
        }
    }

    public static void main(String[] args) {
        Integer sobotest = sc.nextInt();

        while(sobotest-- >0){
            xuLy();
        }
    }
}
