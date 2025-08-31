package Tuan3;

import java.util.Scanner;

public class J03008 {
    
    private static Scanner sc= new Scanner(System.in);

    public static Boolean checkOk1(String s) {
        Integer n = s.length();

        for(int i=0; i<(n-1)/2; i++){
            Character char1 = s.charAt(i);
            Character char2 = s.charAt(n-1-i);

            if(char1 != char2 ){
                return false;
            }
        }
        return true;
    }

    public static Boolean checkOk2(String s){
        for(int i=0; i<s.length(); i++){
            Character char1 = s.charAt(i);
            if(char1 !='2' && char1 !='3' && char1 !='5' && char1 !='7' ){
                return false;
            }
        }
        return true;
    }

    public static void xuLy() {
        String s = sc.nextLine();

        if(checkOk1(s)==true && checkOk2(s)==true ){
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

/* test case
3
123456787654321
235755557532
2222333355557777235775327777555533332222
 */