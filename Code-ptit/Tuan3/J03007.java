package Tuan3;

import java.util.Scanner;

/* day la test case
4
123456787654321
8644281154664511824468
8006000444400000000000044440006008
82123400000000000000000000000432128
*/
public class J03007 {
    
    private static Scanner sc = new Scanner(System.in);

    public static Boolean checkOk1(String s){
        Integer n = s.length();
        for(int i=0; i<=(n-1)/2; i++){
            Character char1 = s.charAt(i);
            Character char2 = s.charAt(n-1-i);

            if(char1 != char2){
                return false;
            }
        }
        return true;
    }

    public static Boolean checkOk2(String s){
        if(s.charAt(0)!='8' || s.charAt(s.length()-1)!='8'){
            return false;
        }
        else{
            return true;
        }
    }

    public static Boolean checkOk3(String s){
        int sum=0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            sum = sum+ c-'0';
        }

        if(sum%10==0){
            return true;
        }
        else {
            return false;
        }
    }

    public static void xuLy(){
        String s = sc.nextLine();
        if(checkOk1(s)==true && checkOk2(s)==true && checkOk3(s)==true ){
            System.out.println("YES");
            return;
        }
        else {
            System.out.println("NO");
            return;
        }
    }

    public static void main(String[] args) {
        // char c= 'B'-'A'+'a';
        // System.out.println(c);

        Integer sobotest = Integer.parseInt(sc.nextLine());

        while(sobotest-- >0){
            xuLy();
        }
    }
}
